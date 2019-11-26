public class Item {
    public boolean imported;
    public double price;
    public boolean taxExempt;
    public String name;
    public double tax;

    public void create(String item){
        isImported(item);
        taxExempt(item);
        name(item, this.imported);
        price(item);
    }



    public boolean isImported(String list){  // Check to see if it's imported      
       this.imported = list.indexOf("import") != -1 ? true : false;
       return this.imported;
    }

    public String name(String list, boolean imported){  // Extract the name of the item;
        String name = "";
        int count = 1;
        String[] elements = new String[(list.length() / 2) +1];
        elements = list.split(" ");
        
            for(int i = count; i < elements.length -2; i++){
                name += elements[i];
                if (i + 1 >= elements.length -2){
                    name += ":";
                } else {
                    name += " ";
                }
            }
            this.name = name;
        return name;
    }

    public boolean taxExempt(String list){ //Check to see basic sales type
        
        boolean type = false;
        if (list.indexOf("headache") != -1 || list.indexOf("pill") != -1 || list.indexOf("chocolate") != -1 ||
           list.indexOf("book") != -1 || list.indexOf("food") != -1){
               type = true;
        }
        this.taxExempt = type;
        return this.taxExempt;
    }

    

    public Double price(String list){  // Get the price of the element and convert it to a double
        String[] elements = new String[(list.length() / 2) +1];
        elements = list.split(" ");
        
        String strPrice = list.split(" ")[elements.length-1];
        this.price = Double.valueOf(strPrice);
        return this.price;
    }

    public Double tax(double basicTax, double importTax){
        this.tax = basicTax + importTax;
        return this.tax;
    }
}