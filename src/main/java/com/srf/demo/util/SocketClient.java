package com.srf.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    private static final String SERVER_HOSTNAME="192.168.1.21";
    private static final int SERVER_PORT=8080;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) { // 读取用户输入
                out.println(userInput); // 将用户输入发送到服务器
                System.out.println("Server response: " + in.readLine()); // 显示服务器返回的消息
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + SERVER_HOSTNAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + SERVER_HOSTNAME);
            System.exit(1);
        }
    }

}
