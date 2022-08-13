package TCP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过 TCP 接受一个用户发送的消息
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception{
        ServerSocket ssocket = new ServerSocket(7777);

        Socket socket = ssocket.accept();

        InputStream is = socket.getInputStream();

        //把字符输入流转换成缓冲字符输入流进行消息传递
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str;
        while((str=br.readLine()) != null){
            System.out.println("说了：" + str);
        }

    }

}
