import java.io.*;
import java.util.*;

public class ShoppingBasket {
    
    public static void main(String[] args) throws Exception{ //Main function
        // Read data file
        String file = "";
        file = (args.length == 0) ? "data1.txt" : args[0]; // if no file is loaded via command line default to data1.txt
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        ArrayList<String> basket = new ArrayList<String>();
        double basicTaxRate = .10;   // Set the tax rates 
        double importTaxRate = .05;
        Tax tax = new Tax(importTaxRate, basicTaxRate);

        while ((st = br.readLine()) != null) basket.add(st); // Read line by line and append to an ArrayList

        Receipt receipt = new Receipt(basket, tax);    // Create the receipt  
                
       
        if (basket.size() > 0){ // If there is input data print out the receipt.
            receipt.print();
        } else {
            System.out.println("NO INPUT DATA"); // If file is empty......
        }
    }   
} 