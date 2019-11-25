import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

public class Tax {

    public  Double basicTaxAmount(Double price, String type){ // calculate basic tax amount which is 10%
       
        return type == "No basic sales tax" ? 0.0 : Math.ceil((price / 10) * 20) / 20.0; // round up to nearest 0.05
    }

    public  Double importTaxAmount(Double price, boolean imported){ // calculate import tax which is 5%
      
       return imported ? Math.ceil((price / 20) * 20) / 20.0 : 0.0; // round up to nearest 0.05
    }
}
