package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(){};
    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(msg);
            }

        } catch (IOException e) {
            System.out.println("服务器把你踢出去了--");
        }

    }
}
