package Base;

import java.util.Random;

/**
 * ClassName Servlet
 *
 * @Author Administrator
 * @Date 2020/3/19  17:22
 * Version 1.0
 **/
public class ServletTest {


    public void fun1(Person person) {

        int age = person.getAge();

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        age++;
        System.out.println(Thread.currentThread().getName() + "============" + age);

        System.out.println(Thread.currentThread().getName() + "============" + person.getName());

    }


}
