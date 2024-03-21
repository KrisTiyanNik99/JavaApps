import java.util.Scanner;

public class DecriptingMess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bonusCharIndex = Integer.parseInt(scanner.nextLine());
        int numLines = Integer.parseInt(scanner.nextLine());

        String decodedWord = "";
        for (int i = 0; i < numLines; i++) {

            char letter = scanner.nextLine().charAt(0);
            int num = letter + bonusCharIndex;
            char decodedLetter = (char) num;

            decodedWord += decodedLetter;
        }

        System.out.println(decodedWord);
    }
}