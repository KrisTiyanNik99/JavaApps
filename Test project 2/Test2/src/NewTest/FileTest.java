package NewTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) {
        StringBuilder dae = new StringBuilder();

        try{
            File myNewTest = new File("randomText.txt");
            FileWriter noviqFail = new FileWriter("noviqFail.txt");
            Scanner scanner = new Scanner(myNewTest);
            while (scanner.hasNextLine()){
                //s "\n" pravim nov red v string
                dae.append(scanner.nextLine()).append("\n");
            }
            //trqbva da parsnem StringBuildera kym String zashtoto inache ne moje da raboti korektno
            noviqFail.write(String.valueOf(dae));
            noviqFail.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Fail");
            e.printStackTrace();
        }

    }
}
