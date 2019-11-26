import java.io.*;
import java.util.*;

public class SalesTaxes {

    
    public static void main(String[] args) throws Exception{ //Main function
        // Read data file
        String file = "";
        file = (args.length == 0) ? "data.txt" : args[0]; // if no file is loaded via command line default to data.txt
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String st = "";
        ArrayList<String> basket = new ArrayList<String>();
        Tax taxes = new Tax(); // Create new Tax instance...now functions accessible through this variable
        Value values = new Value(); // Create new Value instance...now functions accessible through this variable
        while ((st = br.readLine()) != null) basket.add(st); // Read first line and append to an array
        double salesTaxes = 0.0;
        double total = 0.0;

        for (int i = 0; i < basket.size(); i++) { // Iterate over the basket line by line

        int count = values.howMany(basket.get(i));
        double price = values.actualPrice(basket.get(i), count);
        boolean imported = values.isImported(basket.get(i));
        String taxType = values.taxType(basket.get(i));
        double basicTax = taxes.basicTaxAmount(price, taxType);
        double importTax = taxes.importTaxAmount(price, imported);
        String output = values.output(basket.get(i), imported);
        total += (importTax + basicTax + price);
        salesTaxes += (importTax + basicTax);
        String formattedPrice = String.format("%.02f", importTax + basicTax + price);
        System.out.println(count + " " + output + " " + formattedPrice);

        }


        String formattedSalesTaxes = String.format("%.02f", salesTaxes);
        String formattedTotal = String.format("%.02f", total);

        if (basket.size() > 1){ // If there is input data print out the total amounts
            System.out.println("Sales Taxes: " + formattedSalesTaxes);
            System.out.println("Total: " + formattedTotal);
        } else {
            System.out.println("NO INPUT DATA");
        }
    }   
} 


// System.out.println(arlist.get(3).indexOf("chocolate") != -1 ? true : false ); // check to see if a string has a word  