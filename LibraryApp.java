import java.io.*;
import java.util.*;

public class LibraryApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        File file = new File("books.txt");

        System.out.print("Enter book name: ");
        String book = sc.nextLine();

        FileWriter fw = new FileWriter(file, true);
        fw.write(book + "\n");
        fw.close();

        System.out.println("Current books:");
        Scanner fr = new Scanner(file);
        while (fr.hasNextLine()) {
            System.out.println("- " + fr.nextLine());
        }
    }
}