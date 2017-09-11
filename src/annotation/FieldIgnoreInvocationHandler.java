package annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FieldIgnoreInvocationHandler implements InvocationHandler {
    private Object target;

    public FieldIgnoreInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocationHandler............before.........");
        Object result = method.invoke(target, args);
        System.out.println("invocationHandler+++++++++++after++++++++++");
        return result;
    }

}
