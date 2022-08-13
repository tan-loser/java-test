package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 即时通信服务端
 * 创建队列存储客户端管道
 * 通过接受消息的线程，遍历队列转发消息
 */
public class ServerDemo4 {
    public static ExecutorService pool = new ThreadPoolExecutor(
            300,1500,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    //创建储存各个客户端管道的队列
    public static List<Socket> onLineSockets = new ArrayList<>();

    public static void main(String[] args) {
        try {
            System.out.println("=========即时通信（服务端）============");
            ServerSocket serverSocket = new ServerSocket(6666);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "它来了，上线了！");

                //把当前客户端Scoket管道储存到队列中
                onLineSockets.add(socket);

                Runnable target = new ServerReaderRunnable2(socket);
                pool.execute(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
