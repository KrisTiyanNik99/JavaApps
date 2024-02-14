import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizMain {
    public static void main(String[] args) {

        int [] questions = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        JFrame main = new JFrame();
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setSize(900,600);
        main.setTitle("Quiz Game");
        main.setLayout(null);

        JPanel mainQuizGui = new JPanel();
        mainQuizGui.setLayout(null);
        mainQuizGui.setSize(main.getWidth(), main.getHeight());
        mainQuizGui.setBackground(Color.yellow);

        JButton start = new JButton();
        start.setBounds(10,10, 70,70);
        start.setBackground(Color.BLACK);
        start.addActionListener(e->{

        });
        mainQuizGui.add(start);

        Random random = new Random();

        main.add(mainQuizGui);
        main.setVisible(true);
    }

    public static void startGame(int [] questions, Random random){

        List<Integer> used = new ArrayList<>();

        int mainNumber = random.nextInt(questions.length + 1);
        used.add(mainNumber);
        System.out.println("Our main number is: " + mainNumber);

        int positionOfMainNum = random.nextInt(4 + 1);
        System.out.println("Your answer is on the " + positionOfMainNum + "position!");

        int num1 = isUsedNum(used, questions.length , random);
        System.out.println("Some wrong answer is " + num1);
        used.add(num1);
        int num2 = isUsedNum(used, questions.length , random);
        System.out.println("Some wrong answer is " + num2);
        used.add(num2);
        int num3 = isUsedNum(used, questions.length , random);
        System.out.println("Some wrong answer is " + num3);

        int[] answers = new int[4];
    }

    public static int isUsedNum(List<Integer> used, int length, Random random){

        int number = random.nextInt(length + 1);
        while (used.contains(number)){
            number = random.nextInt(length + 1);
        }
        System.out.println("New number is : " + number);

        return number;
    }
}
