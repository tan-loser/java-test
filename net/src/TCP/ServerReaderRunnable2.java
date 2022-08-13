package TCP;

import java.io.*;
import java.net.Socket;

/**
 * 即时通信 服务端线程类
 * 接受客户端发送的消息，并转发到其它客户端
 */
public class ServerReaderRunnable2 implements Runnable {
    private Socket socket;

    public ServerReaderRunnable2(){};
    public ServerReaderRunnable2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
                //把自己这个线程读取的数据，转发到其它所有在线的客户端
                sendMsgToAll(socket.getRemoteSocketAddress() + "说了：" +msg);
            }

        }catch (Exception e){
            System.out.println(socket.getRemoteSocketAddress() + "下线了");
            //接受相应客户端数据的连接失效，从队列中移除
            ServerDemo4.onLineSockets.remove(socket);
        }
    }

    //遍历所有在线用户，转发除自己端口外
    private void sendMsgToAll(String msg) {
        try {
            for (Socket onLineSocket : ServerDemo4.onLineSockets) {
                if(onLineSocket != socket){
                    PrintStream ps = new PrintStream(onLineSocket.getOutputStream());
                    ps.println(msg);
                    ps.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
