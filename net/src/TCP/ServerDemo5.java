package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 模拟BS（浏览器-服务端）系统
 * 不需要开发客户端，直接在浏览器输入 127.0.0.1:8080
 * 需要按照浏览器的协议规则响应数据
 */
public class ServerDemo5 {
    public static ExecutorService pool = new ThreadPoolExecutor(
            300,1500,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        try {
            System.out.println("=========即时通信（服务端）============");
            ServerSocket serverSocket = new ServerSocket(8080);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "它来了，上线了！");

                Runnable target = new ServerReaderRunnable3(socket);
                pool.execute(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
