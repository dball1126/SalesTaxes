import java.util.Scanner;
import java.io.*;
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


        int count = values.howMany(arlist.get(1));
        double price = values.actualPrice(arlist.get(1));
        boolean imported = values.isImported(arlist.get(1));
        String taxType = values.taxType(arlist.get(1));
        double basicTax = taxes.basicTaxAmount(price, taxType);
        double importTax = taxes.importTaxAmount(price, imported);
        String output = values.output(arlist.get(1), imported);

        double d = importTax + basicTax + price;
        
        System.out.println(arlist.get(1)); // get element from array list
        System.out.println(count + " " + output + " " + d);
       
    }   
    
} 


// System.out.println(arlist.get(3).indexOf("chocolate") != -1 ? true : false ); // check to see if a string has a word  