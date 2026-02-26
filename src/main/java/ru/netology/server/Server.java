package ru.netology.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    private static final Logger log = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8800)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    log.info("Новое соединение установлено");
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream())
                    );
                    PrintWriter out = new PrintWriter(
                            clientSocket.getOutputStream(), true
                    );
                    String response1 = in.readLine();
                    System.out.println("Клиент: " + response1);

                    String msg1 = "Привет! Твое имя?";
                    out.println(msg1);
                    System.out.println("Я: " + msg1);

                    String response2 = in.readLine();
                    System.out.println("Клиент: " + response2);

                    String msg2 = "Ты ребенок? (Да/Нет)";
                    out.println(msg2);
                    System.out.println("Я: " + msg2);

                    String response3 = in.readLine();
                    System.out.println("Клиент: " + response3);

                    String msg3 = String
                            .format("Добро пожаловать в дескую зону, %s! Начинаем игру!",
                                    response2);
                    String msg4 = String
                            .format("Добро пожаловать во взрослую зону, %s! Хорошего вам отдыха или удачного рабочего дня!!",
                                    response2);
                    if (response3.equals("Да")) {
                        out.println(msg3);
                        System.out.println("Я: " + msg3);
                    } else {
                        out.println(msg4);
                        System.out.println("Я: " + msg3);
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
