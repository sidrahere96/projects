import java.io.*;
import java.util.*;

public class expense_manager {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Item: ");
        String item = sc.nextLine();

        System.out.print("Cost: ");
        double cost = sc.nextDouble();

        File file = new File("expenses.csv");
        FileWriter fw = new FileWriter(file, true);
        fw.write(item + "," + cost + "\n");
        fw.close();

        double total = 0;
        Scanner fr = new Scanner(file);
        while (fr.hasNextLine()) {
            String[] parts = fr.nextLine().split(",");
            total += Double.parseDouble(parts[1]);
        }

        System.out.println("Total spent: " + total);
    }
}
