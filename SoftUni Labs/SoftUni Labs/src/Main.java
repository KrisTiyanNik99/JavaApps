import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Math.abs(Double.parseDouble(scanner.nextLine()));
        double num2 = Math.abs(Double.parseDouble(scanner.nextLine()));

        double diff = Math.abs(num1 - num2);
        if (diff >= 0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }

        int num3 = Integer.parseInt(scanner.nextLine());
        int count = num3 / 2;
        int secondCount = (num3 / 2) + 2;
        for (int i = count; i <= num3; i++) {

            if (i == secondCount) {
                System.out.println(i + " False");
                secondCount = i + 3;
            }else {
                System.out.println(i + " True");
            }
        }
    }
}