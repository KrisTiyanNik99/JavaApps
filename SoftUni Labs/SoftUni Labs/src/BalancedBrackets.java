import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        String bracers = "";

        for (int i = 0; i < numLines; i++) {

            String input = scanner.nextLine();

            if (input.equals("(") || input.equals(")")){
                bracers += input;
            }
        }

        boolean isBalanced = true;
        String pairBracers = "";
        for (int i = 0; i < bracers.length(); i++) {

            char symbol = bracers.charAt(i);

            if(i % 2 == 0 && symbol == '('){
                pairBracers += symbol;
            } else if  (i % 2 != 0 && symbol == ')'){
                pairBracers += symbol;
            }else {
                isBalanced = false;
                break;
            }

            if (pairBracers.contains("()")){
                pairBracers = "";
                isBalanced = true;
            }else {
                isBalanced = false;
            }
        }

        if(isBalanced){
            System.out.println("BALANCED");
        }else {
            System.out.println("UNBALANCED");
        }
    }
}
