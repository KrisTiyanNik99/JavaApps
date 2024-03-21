import java.util.Scanner;

public class Refactoring {
    public static void main(String[] args) {
        Scanner chetec = new Scanner(System.in);

        int doing = Integer.parseInt(chetec.nextLine());
        for (int takoa = 2; takoa <= doing; takoa++) {
            boolean takovalie = true;
            for (int cepitel = 2; cepitel < takoa; cepitel++) {
                if (takoa % cepitel == 0) {
                    takovalie = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", takoa, takovalie);
        }
    }
}
