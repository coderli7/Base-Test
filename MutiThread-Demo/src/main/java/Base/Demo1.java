package Base;


/**
 * ClassName Demo1
 *
 * @Author Administrator
 * @Date 2020/3/19  16:12
 * Version 1.0
 **/
public class Demo1 {


    private static Object resource1 = new Object();
    private static Object resource2 = new Object();


    public static void main(String[] args) {

        //死锁测试
        new Thread(() -> {
            
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "得到了resource1的锁!");
                //先锁住1,后等待，是为了让出cpu
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + "waiting esource2的锁。。。。");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "得到了resource2的锁。。。。");
                }
            }
        }, "线程1").start();


        new Thread(() -> {


            synchronized (resource2) {

                System.out.println(Thread.currentThread() + "得到了resource2的锁！");
                //这里必须让出CPU,否则可能造不成死锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting  resource1的锁！");
                synchronized (resource1) {

                    System.out.println(Thread.currentThread() + "获取到了resource1的锁！");

                }
            }
        }, "线程2").start();

    }
}
