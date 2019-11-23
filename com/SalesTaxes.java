import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class SalesTaxes {

    public static boolean isImported(String list){  // Check to see if it's imported      
       return list.indexOf("import") != -1 ? true : false;
    }

    public static String taxType(String list){
        
        String type = "";
        if (list.indexOf("headache") != -1 || list.indexOf("pill") != -1 || list.indexOf("chocolate") != -1 ||
           list.indexOf("book") != -1 || list.indexOf("food") != -1){
               type = "No basic sales tax";
        } else {
            type = "Yes basic sales tax";
        }
        return type;
    }

    public static void main(String[] args) throws Exception{ //Main function
        // Read data file
        File file = new File("/Users/danielball/Desktop/SalesTaxes/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        ArrayList<String> arlist = new ArrayList<String>();

        while ((st = br.readLine()) != null) arlist.add(st); // Read first line


        int count = 0;
        double price = 0.0;
        boolean imported = isImported(arlist.get(1));
        String taxType = taxType(arlist.get(2));

        double num = 4.1985;
        double rounded = Math.ceil(7.63 * 20) / 20.0; // round up to nearest 0.05
        
        System.out.println(rounded);
        System.out.println(arlist.get(3)); // get element from array list
        // this even works if chocolate is plural
        System.out.println(taxType);
    }
    
} 


// System.out.println(arlist.get(3).indexOf("chocolate") != -1 ? true : false ); // check to see if a string has a word  