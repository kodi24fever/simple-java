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
        int total = 0;

        for(Item item: itemList)
            total += item.getCost();

        return total;
    }

    public int totalTax(){
        return (int) Math.round(totalCost() * groceryStore.TAX_RATE/100.0);
    }

    // Here I put like the receipt type of output
    @Override
    public String toString(){
        String openReceipt = "-------------------------------------------\n";
        String receipt = "\t\t" + GroceryStore.STORE_NAME + "\n"+ "-------------------------------------------\n\n";
        String itemsAndCost = "";
        String closeReceipt = "\n\n-------------------------------------------";

        for(Item item: itemList)
            itemsAndCost += item.toString() + "\n\n";

        return (openReceipt + receipt + itemsAndCost + "\n" +
                "Tax \t\t" + groceryStore.cents2dollarsAndCents(totalTax()) + "\n\n" +
                "Total \t\t " + groceryStore.cents2dollarsAndCents(this.totalCost() + totalTax()) +
                closeReceipt
        );
    }


    public Checkout(){
        this.itemList = new ArrayList<Item>();
    }
}
