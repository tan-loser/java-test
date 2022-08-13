package annotation;

import java.lang.reflect.Method;

public class Test {
    public void test1(){
        System.out.println("======test1======");
    }

    @MyTest
    @MyBook(auther = {"我是谁","我在哪","发生了什么事"})
    public void test2(){
        System.out.println("======test2======");
    }

    @MyTest
    public void test3(){
        System.out.println("======test3======");
    }

    public static void main(String[] args) throws Exception {
        Test t = new Test();
        Class c = Test.class;
        Method[] ms = c.getDeclaredMethods();

        for (Method m : ms) {
            if(m.isAnnotationPresent(MyTest.class)){
                m.invoke(t);
            }
        }

    }

}
