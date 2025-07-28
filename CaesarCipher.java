import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt the text
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(c); // Keep spaces, punctuation, numbers unchanged
            }
        }

        return result.toString();
    }

    // Method to decrypt the text
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // Decryption is reverse shift
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        System.out.println("\n1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Choose an option (1/2): ");
        int choice = scanner.nextInt();

        String result;
        if (choice == 1) {
            result = encrypt(message, shift);
            System.out.println("Encrypted Message: " + result);
        } else if (choice == 2) {
            result = decrypt(message, shift);
            System.out.println("Decrypted Message: " + result);
        } else {
            System.out.println("Invalid option selected.");
        }

        scanner.close();
    }
}
