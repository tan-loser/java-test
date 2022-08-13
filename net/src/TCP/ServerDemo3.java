package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * 通过线程池优化
 */
public class ServerDemo3 {

    public static ExecutorService pool = new ThreadPoolExecutor(
            300,1500,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        try {
            System.out.println("=========线程次优化接受多个用户端消息（服务端）============");
            ServerSocket serverSocket = new ServerSocket(6666);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "它来了，上线了！");

                //创建获得的新连接对象的线程
                Runnable target = new ServerReaderRunnable(socket);
                //加入到线程池
                pool.execute(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
