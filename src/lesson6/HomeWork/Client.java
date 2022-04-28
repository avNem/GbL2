package lesson6.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static final int PORT = 8189;
    public static final String HOST = "127.0.0.1";
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public Client() {
        try {
            Socket socket = new Socket(HOST, PORT);
            Scanner scanner = new Scanner(System.in);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Подключился к серверу");
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        messageFromServer(scanner.nextLine());
                    }
                }
            });
            thread1.setDaemon(true);
            thread1.start();

            while (true) {
                String message = inputStream.readUTF();
                if (message.startsWith("/end")) {
                    messageFromServer("/end");
                    break;
                }
                System.out.println("Server: " + message);
            }
        } catch (IOException e) {
        System.err.println("Невозможно установить соединение");
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    public void messageFromServer(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Не удалось отправить сообщение");
        }
    }

}
