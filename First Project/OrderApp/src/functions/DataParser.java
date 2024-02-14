package functions;

import custom.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataParser {

    // Create empty constructor
    public DataParser() {
    }

    // Set method to extract data from our text file
    public List<Product> setDataProduct() {

        // Init List with products
        List<Product> data = new ArrayList<>();

        try {
            // Set file reader to read our file with products
            FileReader productFile = new FileReader("ProductsStore.txt");

            // Init scanner who will scan our file
            Scanner scanner = new Scanner(productFile);

            // Create while loop because we don't know how much lines will have our file
            while (scanner.hasNextLine()) {
                // Get the row from our text file and separate data in String array
                String[] fullInfo = scanner.nextLine().split(" : ");

                // Parse second element in our array to Double, because it's always price
                double priceProduct = Double.parseDouble(fullInfo[1]);

                // Init new Product object and add it to the List
                Product currentProduct = new Product(fullInfo[0], priceProduct);
                data.add(currentProduct);
            }

            // Close our scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File 'productsStore' is not found!");
        }

        return data;
    }
}
