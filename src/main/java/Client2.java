import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException, NullPointerException {
        Socket client2 = new Socket("localhost", 8091);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client2.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(client2.getOutputStream()), true);
             Scanner scan = new Scanner(System.in)) {
            String answerServ = in.readLine();
            if (answerServ.equals("???")) {
                System.out.println("Напишите название города");
            } else {
                System.out.println("Текущее название города: " + answerServ);
                System.out.println("Напишите название города, начинающееся на букву: " + answerServ.toLowerCase().charAt(answerServ.length() - 1));
            }
            String client1Town = scan.nextLine();
            out.println(client1Town);
            answerServ = in.readLine();
            if (answerServ.equals("OK")) {
                System.out.println("Ваше название принято");
            }
            if (answerServ.equals("NOT OK")) {
                System.out.println("Вы ввели неверное название");
            }
        } catch (Exception e) {
            System.out.println("Повторите операцию");
        }
    }
}