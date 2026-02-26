package ru.netology.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {
    private static final Logger log = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        String serverIp = "netology.homework";

        try (Socket socket = new Socket(serverIp, 8800)) {
            log.info("Подключились к серверу");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );
            String msg1 = "Тук-тук";
            out.println(msg1);
            System.out.println("Я: " + msg1);

            String response1 = in.readLine();
            System.out.println("Сервер: " + response1);

            String msg2 = "Женя";
            out.println(msg2);
            System.out.println("Я: " + msg2);

            String response2 = in.readLine();
            System.out.println("Сервер: " + response2);

            String msg3 = "Да";
            out.println(msg3);
            System.out.println("Я: " + msg3);

            String response3 = in.readLine();
            System.out.println("Сервер: " + response3);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
