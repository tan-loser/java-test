package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable{
    private Socket socket;

    ServerReaderRunnable(){};
    ServerReaderRunnable(Socket socket){
        this.socket = socket;
    };

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }

        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress() + "下线了！");
        }
    }
}
