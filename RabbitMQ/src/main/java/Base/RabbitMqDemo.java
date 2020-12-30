package Base;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * ClassName RabbitMqDemo
 *
 * @Author Administrator
 * @Date 2020/3/26  11:28
 * Version 1.0
 **/
public class RabbitMqDemo {


    static String host = "192.168.80.129";

    static String queueName = "R1";

    static String userName = "guest";

    static String pwd = "guest";


    public static void main(String[] args) {
        getProductor();
        getConsumor();
    }

    /**
     * 消息生产者
     */
    static void getProductor() {

        // 获取工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        //connectionFactory.setVirtualHost("test");
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(pwd);
        // 获取链接 ;创建通道
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            // 声明使用队列
            // 参数说明  1 队列名称 2 是否持久化 3 消息是否独占队列 4 所有客户端断开后是否删除消息 5 其他参数
            channel.queueDeclare(queueName, false, false, false, null);
            // 消息体
            String message = "Hello RabbitMQ";


            for (int i = 0; i < 5; i++) {
                // 第一个参数为交换机名称、第二个参数为队列映射的路由key、第三个参数为消息的其他属性、第四个参数为发送信息的主体
                channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
            }
            System.out.println("Producer Send +'" + message + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 消息消费者
     */

    static void getConsumor() {
        // 获取工厂
        // 获取工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(AMQP.PROTOCOL.PORT);
        //connectionFactory.setVirtualHost("test");

        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(pwd);
        // 获取链接 , 创建通道
        try {
            Connection connection = connectionFactory.newConnection();
            final Channel channel = connection.createChannel();
            // 声明使用队列
            // 参数说明  1 队列名称 2 是否持久化 3 消息是否独占队列 4 所有客户端断开后是否删除消息 5 其他参数
            channel.queueDeclare(queueName, false, false, false, null);

            channel.basicQos(1);
            //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
            // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Customer Received '" + message + "' ：" + envelope.getDeliveryTag());
                    // 手动签收   1消息id   2 是否确认签收
                    channel.basicAck(envelope.getDeliveryTag(), true);
                    try {
                        // 模拟消费等待
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            //回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume("R1", false, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
