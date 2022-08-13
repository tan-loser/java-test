package annotation;

@MyBook(auther = {"我是谁","我在哪","发生了什么事"})
public class Demo {
//    @MyBook(auther = {"我是谁","我在哪","发生了什么事"})
    Demo(){
        System.out.println("这是构造器上的注解");
    }

    @MyBook(auther = {"我是谁","我在哪","发生了什么事"})
    public void d(){
        System.out.println("这是方法上的注解");
    }

}


