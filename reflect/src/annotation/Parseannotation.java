package annotation;

import java.util.Arrays;

//解析注解
public class Parseannotation {
    public static void main(String[] args) {
        Class c = Demo.class;
        if(c.isAnnotationPresent(MyBook.class)){
            MyBook m = (MyBook) c.getDeclaredAnnotation(MyBook.class);
            System.out.println(m.name());
            System.out.println(Arrays.toString(m.auther()));
        }
    }
}
