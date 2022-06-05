package driver;

import util.*;
import java.util.*;


public class Checkout {
    // Initialize itemList variable
    ArrayList<Item> itemList;

    GroceryStore groceryStore = new GroceryStore();


    public void enterItem(Object item){
        itemList.add((Item) item);
    }

    public void clear(){
        itemList.removeAll(itemList);
    }

    public int numberOfItems(){
        return itemList.size();
    }

    public double totalCost(){
        double numberOfItems = 0;
        for(Item item: itemList)
            numberOfItems += item.getCost();

        return numberOfItems + (numberOfItems * totalTax());
    }

    public double totalTax(){
        return groceryStore.TAX_RATE;
    }

    // Here I put like the receipt type of output
    public String toString(){
        String receipt = "\t\t" + GroceryStore.STORE_NAME + "\n"+ "-------------------------------------------\n";
        String itemsAndCost = "";

        for(Item item: itemList)
            itemsAndCost += item;

        return (receipt + itemsAndCost + "\n" +
                "Tax \t\t" + groceryStore.TAX_RATE + " % \n\n" +
                "Total \t\t " + this.totalCost());
    }


    public Checkout(){
        this.itemList = new ArrayList<Item>();
    }
}
