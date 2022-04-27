package lesson6.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8189;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Сервер начал работу, ожидаем подключение");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                String message = inputStream.readUTF();
                if (message.startsWith("/enf")) {
                    break;
                }
                outputStream.writeUTF("Echo: " + message);
            }

        } catch (IOException e) {
            System.err.println("Ошибка подключения к порту " + PORT);
            e.printStackTrace();
        }

    }
}
