package TCP;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端代码，下面的服务端都 demo1-3 都可以用，需要改端口号
 */
public class ClientDemo1 {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",6666);
        OutputStream os = socket.getOutputStream();

        //包装为打印流
        PrintStream ps = new PrintStream(os);

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请说：");
            String str = sc.nextLine();
            ps.println(str);
            ps.flush();
        }

    }
}
