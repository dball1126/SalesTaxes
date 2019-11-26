
public class SalesTaxes {

    public  Double basicTaxAmount(Double price, String type){ // calculate basic tax amount which is 10%
       
        return type == "No basic sales tax" ? 0.0 : Math.ceil((price / 10) * 20) / 20.0; // round up to nearest 0.05
    }

    public  Double importTaxAmount(Double price, boolean imported){ // calculate import tax which is 5%
        
       return imported ? Math.ceil((price / 20) * 20) / 20.0 : 0.0; // round up to nearest 0.05
    }
}
