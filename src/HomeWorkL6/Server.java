package HomeWorkL6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    public Server() {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер начал работу, ожидаем подключение");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true) {
                        messegeToClient(scanner.nextLine());
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true) {
                String message = inputStream.readUTF();
                if (message.startsWith("/end")) {
                    messegeToClient("/end");
                    break;
                }
                System.out.println("Client: " + message);
            }

        } catch (IOException e) {
            System.err.println("Ошибка подключения к порту " + PORT);
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Server();

    }
    public void messegeToClient(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Не удалось отправить сообщение");
        }
    }
}
