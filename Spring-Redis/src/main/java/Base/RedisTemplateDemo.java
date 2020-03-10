package Base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName RedisTemplateDemo
 *
 * @Author Administrator
 * @Date 2020/3/10  14:33
 * Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class RedisTemplateDemo {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void fun1() throws InterruptedException {

        List clientList = redisTemplate.getClientList();
        try {
            redisTemplate.boundValueOps("TXKJ").set("111111", 60,
                    TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        String redisVal = (String) redisTemplate.boundValueOps("TXKJ").get();
        System.out.println(redisVal);


    }

    @Test
    public void fun2() {

        String redisVal = (String) redisTemplate.boundValueOps("TXKJ").get();

        System.out.println(redisVal);


    }


}
