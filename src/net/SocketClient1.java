package net;

import java.io.*;
import java.net.Socket;

public class SocketClient1 {

    public static void main(String[] args) throws IOException {

        for (int i = 1; i<= 20; i++){

            //1、创建客户端Socket，指定服务器地址和端口
            Socket socket =new Socket("localhost",10086);
            //2、获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
            if (i == 20) {
                pw.write("-1");
            }else {
                pw.write("i am client " + i);
            }
            pw.flush();
            socket.shutdownOutput();
            //3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info=br.readLine())!= null){
                System.out.println("[client" + i + "] receive : "+info);
            }

            //4、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        }


    }

}
