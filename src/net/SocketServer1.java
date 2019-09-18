package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer1 {

    public static void main(String[] args) throws IOException {

        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(10086);//1024-65535的某个端口
        //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
        ExecutorService threadPool = Executors.newFixedThreadPool(8);

        while (true) {
            //2、调用accept()方法开始监听，等待客户端的连接
            Socket socket = serverSocket.accept();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //3、获取输入流，并读取客户端信息
                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String info = null;
                        while ((info = br.readLine()) != null) {
                            System.out.println("[server] receive : " + info);
                        }

                        //4、获取输出流，响应客户端的请求
                        OutputStream os = socket.getOutputStream();
                        PrintWriter pw = new PrintWriter(os);
                        pw.write("response from server");
                        pw.flush();

                        br.close();
                        isr.close();
                        is.close();
                        socket.close();

                        //5、关闭资源
                        pw.close();
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.submit(runnable);

        }


    }

}
