package com.srf.demo;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            // 创建服务器端Socket对象，并指定要使用的端口号
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("等待客户端连接...");

            // 接受连接请求，返回一个新的Socket对象和客户端地址信息
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接：" + socket.getInetAddress().getHostAddress());

            while (true) {
                // 接收客户端发送的数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String data = reader.readLine();
                System.out.println("收到客户端数据：" + data);

                if ("CLOSE".equalsIgnoreCase(data)) {
                    // 关闭连接
                    socket.close();
                    serverSocket.close();
                    break;
                }

                // 向客户端发送数据
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println("Hello, client!");
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}