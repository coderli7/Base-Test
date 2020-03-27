package Base;

/**
 * ClassName Demo3
 *
 * @Author Administrator
 * @Date 2020/3/19  17:21
 * Version 1.0
 **/
public class Demo3 {


    public static void main(String[] args) {

        ServletTest servletTest = new ServletTest();
        Person person1 = new Person("bruce", 18, "football");
        Person person2 = new Person("jack", 28, "football");


        new Thread(() -> {
            servletTest.fun1(person1);
        }, "Person1").start();


        new Thread(() -> {
            servletTest.fun1(person2);
        }, "Person2").start();


    }


}
