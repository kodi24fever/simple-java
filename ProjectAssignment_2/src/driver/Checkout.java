package driver;

import util.*;
import java.util.*;


public class Checkout {
    // Initialize itemList variable
    ArrayList<Item> itemList;


    public void enterItem(Object item){
        itemList.add((Item) item);
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
        GroceryStore groceryStore = new GroceryStore();

        return groceryStore.TAX_RATE;
    }





    public Checkout(){
        this.itemList = new ArrayList<Item>();
    }
}
