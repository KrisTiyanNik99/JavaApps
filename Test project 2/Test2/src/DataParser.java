import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataParser {
    public DataParser() {
    }

        /*try {
            FileReader reader = new FileReader("art.txt");
            int data = reader.read();
            //pravim while loop s -1 zashtoto ako nqma poveche charove vuv faila ]e dade -1 i loopa shte svurshi
            while (data != -1){
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nema takuv fail");
        } catch (IOException e) {
            System.out.println("Oburkal si neshto");
        } */

    public List<NewTest> setValuesFromDataNote() {

        List<NewTest> products = new ArrayList<>();

        try {
            //ot tuk vzimame faila
            File myTest = new File("productData.txt");
            //chetem faila sys skenera
            Scanner myReader = new Scanner(myTest);
            while (myReader.hasNextLine()) {
                //ot tuk vzimame tekushtiq red i go pravim na string array sys zadaden regex
                String[] currentData = myReader.nextLine().split("\\s{2}");
                String nameProduct = currentData[0];
                //tuk vzimame samo sumata i fiksiranata stoinost
                String[] otherInfo = currentData[1].split(" ");
                //suzdavame promenlivi za cenata i fiksiranoto kolichestvo
                double price = Double.parseDouble(otherInfo[0]);
                int fixValue = Integer.parseInt(otherInfo[1]);
                //dobavqme vsichki tezi promenlivi kym NewTest obekt, koito puk go dobavqme kym Lista
                products.add(new NewTest(nameProduct, price, fixValue));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File data not found!");
        }

        return products;
    }

    //Drugi nachini da se chetat danni ot failove
    /*try {
            FileWriter myNewTest = new FileWriter("productData.txt");
            reader = new Scanner(System.in);
            String data = reader.nextLine();
            myNewTest.write(data);
            myNewTest.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
        }*/
}
