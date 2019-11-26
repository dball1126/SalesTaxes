
import java.util.ArrayList;

public class Receipt {
    public double salesTaxes;
    public double total;
    public ArrayList<String> receipt = new ArrayList<String>();;
    
    public Integer howMany(String list){ // Check to see how many items of a specific type in a basket
        String strCount = list.split(" ")[0];
        return Integer.valueOf(strCount);
    }

    public void addItem(Item item, Integer count){  // add item to the receipt multiplied by how many of them
        
        this.total += (item.tax * count) + (item.price * count);
        this.salesTaxes += item.tax;
        String formattedPrice = String.format("%.02f", (item.tax + item.price) * count);
        String lineItem = (count + " " + item.name + " " + formattedPrice);
        this.receipt.add(lineItem);    // Add line item output in string format to the receipt.
    }
    
    public void create(ArrayList<String> basket, Tax tax){ // Most important function in the app.
   
    for (int i = 0; i < basket.size(); i++) { // Iterate over the basket line by line
        String currentItem = basket.get(i);
        Item item = new Item();  // Create a new Item.
        SalesTax salesTax = new SalesTax(tax.importRate, tax.basicRate); // Create new Tax instance

        int count = howMany(currentItem);  // How many of a specific item.
        item.create(currentItem);          
        
        salesTax.basicTaxAmount(item.price, item.taxExempt);
        salesTax.importTaxAmount(item.price, item.imported);
        item.tax(salesTax.basicTax, salesTax.importTax);    // Update the tax of the item.

        addItem(item, count);  // add item to the receipt
        }
    }

    public void computeTotal(){ // Add total and salestax to receipt
        String formattedSalesTaxes = String.format("%.02f", this.salesTaxes); 
        String formattedTotal = String.format("%.02f", this.total);
        this.receipt.add("Sales Taxes: " + formattedSalesTaxes);
        this.receipt.add("Total: " + formattedTotal);
    }

    public void print(){
        computeTotal();  // Compute total amount and sales tax

        for (int i = 0; i < this.receipt.size(); i++) {
            System.out.println(this.receipt.get(i));
        }
    }
}