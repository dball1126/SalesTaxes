
public class SalesTax {

    public double basicTax;
    public double importTax;
    public double totalTax;
    public double importRate;
    public double basicRate;

    public  Double basicTaxAmount(Double price, boolean type){ // calculate basic tax amount which is 10%
       
        this.basicTax = (type == true ? 0.0 : Math.ceil((price * this.basicRate) * 20) / 20.0); // round up to nearest 0.05
        this.totalTax += this.basicTax;
        return this.basicTax;
    }

    public  Double importTaxAmount(Double price, boolean imported){ // calculate import tax which is 5%
        
       this.importTax = (imported ? Math.ceil((price * this.importRate) * 20) / 20.0 : 0.0); // round up to nearest 0.05
       this.totalTax += this.importTax;
       return this.importTax;
    }

}
