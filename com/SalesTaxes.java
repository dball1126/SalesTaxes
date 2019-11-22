import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class SalesTaxes {

    public static boolean isTrue(Map<Character, Map<Character, Integer>> graph, Character char1, Character char2){
        
        if (graph.containsKey(char1) && graph.get(char1).containsKey(char2)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception{ //Main function
        // Read data file
        File file = new File("/Users/danielball/Desktop/SalesTaxes/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        ArrayList<String> arlist = new ArrayList<String>();

        while ((st = br.readLine()) != null) arlist.add(st); // Read first line
      

        System.out.println(arlist);
    }
    
} 
    
 