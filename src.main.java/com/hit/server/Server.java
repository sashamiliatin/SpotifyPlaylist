package com.hit.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    private static boolean serverUp = true;

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is alive");
        Socket client;

        while (serverUp) {
            try {
                client = server.accept();
                pool.execute(new HandleRequest(client));

//                new Thread(new HandleRequest(client)).start();
            } catch (IOException e) {
                System.out.println("tiered of waiting for connection :( ");
            }
        }
        pool.shutdown();
        server.close();
    }
}