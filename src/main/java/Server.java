import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8091);) {
            String currentTown = null;
            String newTown = null;
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    if (currentTown == null) {
                        out.println("???");
                        newTown = in.readLine();
                        out.println("OK");
                        System.out.println("OK");
                        currentTown = newTown;
                        System.out.println("Текущее название города: " + currentTown);
                    } else {
                        out.println(currentTown);
                        newTown = in.readLine();
                        if (currentTown.toLowerCase().charAt(currentTown.length() - 1) == newTown.toLowerCase().charAt(0)) {
                            currentTown = newTown;
                            out.println("OK");
                            System.out.println("OK");
                            out.println(currentTown);
                            System.out.println("Текущее название города: " + currentTown);
                        } else {
                            out.println("NOT OK");
                            System.out.println("NOT OK");
                            System.out.println("Текущее название города: " + currentTown);
                        }
                    }
                }
            }
        }
    }
}
