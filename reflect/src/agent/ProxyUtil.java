package agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class ProxyUtil {
    public static <T> T getProxy(T obj){
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader()
                , obj.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTimer = System.currentTimeMillis();
                        Object result = method.invoke(obj,args);
                        long endTimer = System.currentTimeMillis();
                        System.out.println(method.getName() + "耗时：" + (endTimer - startTimer)/1000 + "s");

                        return result;
                    }
                });
    }
}
