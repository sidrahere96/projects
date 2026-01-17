import java.io.*;
import java.util.*;

public class pomodoro {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Work session: 25 minutes");
        Thread.sleep(1500);

        FileWriter fw = new FileWriter("sessions.txt", true);
        fw.write("Completed session at " + new Date() + "\n");
        fw.close();

        System.out.println("Session logged.");
    }
}
