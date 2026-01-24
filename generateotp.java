import java.security.SecureRandom; // Higher entropy for security
import java.util.stream.Collectors; // For fancy modern syntax

public class PasswordPro {

    // Grouping constants makes the code cleaner
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALLS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMS = "0123456789";
    private static final String SYMS = "!@#$%^&*_=+-/";
    private static final String ALL_ALLOWED = CAPS + SMALLS + NUMS + SYMS;

    // SecureRandom is much harder to "guess" than regular Random
    private static final SecureRandom SECURE_RAND = new SecureRandom();

    public static void main(String[] args) {
        int length = 12;
        System.out.println("🛡️ Generated Secure Password: " + generatePassword(length));
    }

    public static String generatePassword(int len) {
        // We use StringBuilder for better performance when building strings
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            // Pick a random index from 0 to the length of our allowed chars
            int randomIndex = SECURE_RAND.nextInt(ALL_ALLOWED.length());
            sb.append(ALL_ALLOWED.charAt(randomIndex));
        }

        return sb.toString();
    }
}
