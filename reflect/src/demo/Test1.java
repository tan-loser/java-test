package demo;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    @Test
    public void f1() throws Exception {
        //向一个泛型中添加其它元素
        List<Integer> l = new ArrayList<>();
        l.add(11);
        l.add(22);
//        l.add("李明");
        System.out.println(l);

        //方法一：通过反射
        Method m = List.class.getDeclaredMethod("add",Object.class);
        m.invoke(l,"李明");
        System.out.println(l.toString());

        //方法二：
        List l2 = l;
        l2.add("张三");
        System.out.println(l.toString());

    }
}
