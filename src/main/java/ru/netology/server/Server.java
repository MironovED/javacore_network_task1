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
        try(ServerSocket serverSocket = new ServerSocket(8800)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) { // ожидаем подключения
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                ); // входящий поток
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true
                ); // исходящий поток

                log.info("Новое соединение установлено");
                String name = in.readLine();
                out.println(String.format("Привет %s, твой порт: %d", name, clientSocket.getPort()));
                log.info("Отправлено сообщение клиенту");
            }
        }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
