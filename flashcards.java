import java.util.*;

public class flashcards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> cards = new HashMap<>();

        cards.put("Java is compiled?", "yes");
        cards.put("C++ is fast?", "yes");
        cards.put("Python is typed?", "no");

        for (String q : cards.keySet()) {
            System.out.print(q + " : ");
            String ans = sc.nextLine();

            if (ans.equalsIgnoreCase(cards.get(q))) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }
    }
}
