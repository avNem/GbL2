package lesson6.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private final String HOST;
    private final int PORT;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Client(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
    }

    public void connectToServer(String message) {
        try(Socket socket = new Socket(HOST, PORT)) {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(message);
            System.out.println("Echo: " + message);
        }catch (UnknownHostException e) {
            System.err.println("Не известный хост");
        }catch (IOException e) {
            System.err.println("Невозможно установить соединение");
        }
    }

}
