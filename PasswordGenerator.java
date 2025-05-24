import java.security.SecureRandom;

public class PasswordGenerator {
    public static String generatePassword(int length) {
        if (length < 6) {
            throw new IllegalArgumentException("Password length must be more than 6");
        }

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{}<>?/";

        String all = upper + lower + digits + symbols;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(symbols.charAt(random.nextInt(symbols.length())));

        for (int i = 4; i < length; i++) {
            password.append(all.charAt(random.nextInt(all.length())));
        }

        return shuffle(password.toString());
    }

    private static String shuffle(String input) {
        char[] chars = input.toCharArray();
        SecureRandom random = new SecureRandom();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String password = generatePassword(20); // Password length
        System.out.println("Strong Password: " + password);
    }
}
