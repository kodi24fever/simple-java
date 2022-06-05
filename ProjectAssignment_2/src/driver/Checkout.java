package driver;

import util.*;
import java.util.*;


public class Checkout {
    // Initialize itemList variable
    ArrayList<Item> itemList;


    public void enterItem(Object item){
        itemList.add((Item) item);
    }




    public Checkout(){
        this.itemList = new ArrayList<Item>();
    }
}
