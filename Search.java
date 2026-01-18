import java.io.*;
import java.util.*;

public class Search {
    // Standard ANSI colors for a bit of flair in the console
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(YELLOW + "--- 🔍 Digital Detective Search Tool ---" + RESET);
        
        System.out.print("Enter file path to scan: ");
        String fileName = sc.nextLine();

        System.out.print("Enter target keyword to find: ");
        String target = sc.nextLine();

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println(RED + "❌ Error: File not found at " + fileName + RESET);
            return;
        }

        System.out.println("Scanning... [📂 " + file.getName() + "]");
        
        try (Scanner fileScanner = new Scanner(file)) {
            int lineNum = 0;
            int matches = 0;

            while (fileScanner.hasNextLine()) {
                lineNum++;
                String line = fileScanner.nextLine();
                
                if (line.toLowerCase().contains(target.toLowerCase())) {
                    System.out.printf("%s📍 Found on line %d: %s%s%n", GREEN, lineNum, RESET, line.trim());
                    matches++;
                }
            }

            System.out.println("---------------------------------------");
            if (matches > 0) {
                System.out.println(GREEN + "✅ Mission Complete: Found " + matches + " occurrences." + RESET);
            } else {
                System.out.println(RED + "❓ No matches found for '" + target + "'." + RESET);
            }

        } catch (FileNotFoundException e) {
            System.out.println(RED + "Read Error: " + e.getMessage() + RESET);
        }
    }
}