package demo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Tests {

    @Test
    public void testField() throws Exception{
        Class c = Student.class;

        Field[] f = c.getDeclaredFields();
        for (Field f1 : f) {
            System.out.println("name:" + f1.getName() + "\t type:" + f1.getType());
        }

        Field f2 = c.getDeclaredField("age");
        f2.setAccessible(true); //暴力打开权限

        Student s = new Student("张三",18);
        //获取属性
        System.out.println(s);
        //设置属性
        f2.set(s,55);
        System.out.println(f2.get(s));
        System.out.println(s);
    }

    @Test
    public void testConstructor() throws Exception {
        Class c = Student.class;
//        Constructor[] c1 = c.getConstructors();
        Constructor[] c1 = c.getDeclaredConstructors();
        for (Constructor constructor : c1) {
            System.out.println("name:" + constructor.getName()
                    + "\t parameters" + constructor.getParameters()
                    + "\t count:" + constructor.getParameterCount());
        }

        Constructor c2 = c.getDeclaredConstructor(String.class,int.class);
        Student s =(Student) c2.newInstance("张三",19);
        System.out.println(s);

    }

    @Test
    public void testMethod() throws Exception {
        Class c = Student.class;
        Method[] m = c.getDeclaredMethods();
        for (Method m1 : m) {
            System.out.println("name: " + m1.getName() + " count: " + m1.getParameterCount());
        }

        Method m2 = c.getDeclaredMethod("eat");
        m2.setAccessible(true);
        Student s = new Student("战士",90);
        m2.invoke(s);

    }

}
