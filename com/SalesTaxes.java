import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.regex.Pattern;
// import java.util.regex;
// import java.util.regex.Matchter;

public class SalesTaxes {

    
    public static void main(String[] args) throws Exception{ //Main function
        // Read data file
        File file = new File("/Users/danielball/Desktop/SalesTaxes/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        ArrayList<String> arlist = new ArrayList<String>();
        Tax taxes = new Tax(); // Create new Tax instance...now functions accessible through this variable
        Value values = new Value(); // Create new Value instance...now functions accessible through this variable
        while ((st = br.readLine()) != null) arlist.add(st); // Read first line and append to an array
        
        for (int i = 0; i < arlist.size(); i++) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        double salesTaxes = 0.0;
        double total = 0.0;
        int count = values.howMany(arlist.get(i));
        double price = values.actualPrice(arlist.get(i));
        boolean imported = values.isImported(arlist.get(i));
        String taxType = values.taxType(arlist.get(i));
        double basicTax = taxes.basicTaxAmount(price, taxType);
        double importTax = taxes.importTaxAmount(price, imported);
        String output = values.output(arlist.get(i), imported);
        double d = importTax + basicTax + price;
        String formattedPrice = String.format("%.02f", d);
        System.out.println(count + " " + output + " " + formattedPrice);
        }
        

        
    }   
    
} 


// System.out.println(arlist.get(3).indexOf("chocolate") != -1 ? true : false ); // check to see if a string has a word  