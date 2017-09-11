package dynamicproxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

/**
 * Try the Exercise: http://blog.csdn.net/zhangerqing/article/details/42504281/
 */

public class DynamicProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();

        // try to generate proxy class byte file by my self
        String path = "C:\\Users\\i324167\\uiworkspace\\self-learning\\src\\dynamicproxy\\$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", UserServiceImpl.class.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
