public class Value {
    public boolean isImported(String list){  // Check to see if it's imported      
       return list.indexOf("import") != -1 ? true : false;
    }

    public String output(String list, boolean imported){  // line by line output for each item
        String partialString = "";
        int count = 1;
        String[] elements = new String[(list.length() / 2) +1];
        elements = list.split(" ");
        
            for(int i = count; i < elements.length -2; i++){
                partialString += elements[i];
                if (i + 1 >= elements.length -2){
                    partialString += ":";
                } else {
                    partialString += " ";
                }
            }
           
        return partialString;
    }

    public String taxType(String list){ //Check to see basic sales type
        
        String type = "";
        if (list.indexOf("headache") != -1 || list.indexOf("pill") != -1 || list.indexOf("chocolate") != -1 ||
           list.indexOf("book") != -1 || list.indexOf("food") != -1){
               type = "No basic sales tax";
        } else {
            type = "Yes basic sales tax";
        }
        return type;
    }

    public Integer howMany(String list){ // Check to see how many items of a specific type in basket
        String strCount = list.split(" ")[0];
        return Integer.valueOf(strCount);
    }

    public Double actualPrice(String list, Integer count){  // Get the price of the element and convert it to a double
        String[] elements = new String[(list.length() / 2) +1];
        elements = list.split(" ");
        
        String strPrice = list.split(" ")[elements.length-1];
        return Double.valueOf(strPrice) * count;
    }
}