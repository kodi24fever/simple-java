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
        int numberOfItems = 0;
        for(Item item: itemList)
            numberOfItems += item.getCost();

        return numberOfItems;
    }

    public double totalCost(){
        double numberOfItems = 0;
        for(Item item: itemList)
            numberOfItems += item.getCost();

        return numberOfItems;
    }





    public Checkout(){
        this.itemList = new ArrayList<Item>();
    }
}
