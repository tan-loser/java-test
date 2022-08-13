package demo;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Student s = new Student("张三",19);
        f2(s);
    }

    public static void f2(Object o) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("D:\\桌面文件\\java基础\\test\\reflect\\src\\demo\\data.text",true));

        Class c = o.getClass();
        ps.println("===========" + c.getName() + "==========");

        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            ps.println(f.getName() + " = " + f.get(o));
        }

        ps.close();
    }

}
