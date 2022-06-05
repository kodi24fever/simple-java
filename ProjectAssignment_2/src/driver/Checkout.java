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

    public int totalCost(){
        double total = 0;
        for(Item item: itemList)
            total += item.getCost();

        return (int) (total + (total * totalTax()/100));
    }

    public double totalTax(){
        return groceryStore.TAX_RATE;
    }

    // Here I put like the receipt type of output
    @Override
    public String toString(){
        String receipt = "\t\t" + GroceryStore.STORE_NAME + "\n"+ "-------------------------------------------\n";
        String itemsAndCost = "";

        for(Item item: itemList)
            itemsAndCost += item.toString() + "\n\n";

        return (receipt + itemsAndCost + "\n" +
                "Tax \t\t" + groceryStore.TAX_RATE + " % \n\n" +
                "Total \t\t " + groceryStore.cents2dollarsAndCents(this.totalCost()));
    }


    public Checkout(){
        this.itemList = new ArrayList<Item>();
    }
}
