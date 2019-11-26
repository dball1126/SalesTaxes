
import java.util.ArrayList;

public class Receipt {
    public double salesTaxes;
    public double total;
    public ArrayList<String> receipt = new ArrayList<String>();;
    
    public Integer howMany(String list){ // Check to see how many items of a specific type in a basket
        String strCount = list.split(" ")[0];
        return Integer.valueOf(strCount);
    }
    
    public void create(ArrayList<String> basket){ // Most important function in the app.
   
    for (int i = 0; i < basket.size(); i++) { // Iterate over the basket line by line
        String currentItem = basket.get(i);
        Item item = new Item();  // Create a new Item.
        SalesTax salesTax = new SalesTax(); // Create new Tax instance
        salesTax.basicRate = .10;           // Set the tax rates
        salesTax.importRate = .05;

        int count = howMany(currentItem);
        item.create(currentItem);
        
        salesTax.basicTaxAmount(item.price * count, item.taxExempt);
        salesTax.importTaxAmount(item.price * count, item.imported);
        item.tax(salesTax.basicTax, salesTax.importTax);

        this.total += (item.tax + (item.price * count));
        this.salesTaxes += item.tax;
        String formattedPrice = String.format("%.02f", item.tax + item.price);
        String lineItem = (count + " " + item.name + " " + formattedPrice);
        this.receipt.add(lineItem);    // Add line item output in string format to the receipt.
        }

        String formattedSalesTaxes = String.format("%.02f", this.salesTaxes);  // Add total and salestax to receipt
        String formattedTotal = String.format("%.02f", this.total);
        this.receipt.add("Sales Taxes: " + formattedSalesTaxes);
        this.receipt.add("Total: " + formattedTotal);
    }

    public void print(){
        for (int i = 0; i < this.receipt.size(); i++) {
            System.out.println(this.receipt.get(i));
        }
    }
}