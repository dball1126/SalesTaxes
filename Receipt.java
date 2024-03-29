
import java.util.ArrayList;

public class Receipt {
    public double salesTaxes;
    public double total;
    public ArrayList<String> receiptList = new ArrayList<String>();;
    
    public Receipt(ArrayList<String> basket, Tax tax){

    for (int i = 0; i < basket.size(); i++) { // Iterate over the basket line by line
        String currentItem = basket.get(i);
        Item item = new Item(currentItem);  // Create a new Item.
        SalesTax salesTax = new SalesTax(tax.importRate, tax.basicRate); // Create new Tax instance

        int count = howMany(currentItem);  // How many of a specific item.       
        
        salesTax.basicTaxAmount(item.price, item.taxExempt);
        salesTax.importTaxAmount(item.price, item.imported);
        item.tax(salesTax.basicTax, salesTax.importTax);    // Update the tax of the item.

        addItem(item, count);  // add item to the receipt
        }
    }

    public Integer howMany(String list){ // Check to see how many items of a specific type in a basket
        String strCount = list.split(" ")[0];
        return Integer.valueOf(strCount);
    }

    public void addItem(Item item, Integer count){  // Add item to the receipt multiplied by how many of them
        
        this.total += (item.tax * count) + (item.price * count);  // Update Receipt total and salesTax
        this.salesTaxes += item.tax;
        String formattedPrice = String.format("%.02f", (item.tax + item.price) * count);
        String lineItem = (count + " " + item.name + " " + formattedPrice);
        this.receiptList.add(lineItem);    // Add line item output in string format to the receipt.
    }

    public void computeTotal(){ // Add total and salestax to receipt
        String formattedSalesTaxes = String.format("%.02f", this.salesTaxes); 
        String formattedTotal = String.format("%.02f", this.total);
        this.receiptList.add("Sales Taxes: " + formattedSalesTaxes);
        this.receiptList.add("Total: " + formattedTotal);
    }

    public void print(){  // Print out the receipt.
        computeTotal();  // Compute total amount and sales tax

        for (int i = 0; i < this.receiptList.size(); i++) {
            System.out.println(this.receiptList.get(i));
        }
    }
}