package TCP;

import java.io.*;
import java.net.Socket;

/**
 * 模拟BS系统的线程
 */
public class ServerReaderRunnable3 implements Runnable {
    private Socket socket;

    public ServerReaderRunnable3(){};
    public ServerReaderRunnable3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //用输出管道向浏览器发送数据
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);

            //必须响应HTTP协议格式数据，否者浏览器不认识
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();

            ps.println("<span style='color:res;font-size:90px;'>《这是一次试炼》</span>");
            ps.flush();
        }catch (Exception e){
            System.out.println(socket.getRemoteSocketAddress() + "下线了");
        }
    }
}
