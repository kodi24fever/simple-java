package util;

public abstract class Item {
    protected String name;

    public final String getName() {
	return name;
    }

    public abstract int getCost();

    public Item(String name) {
	if (name.length() <= GroceryStore.MAX_ITEM_NAME_SIZE)
	    this.name = name;
	else
	    this.name = name.substring(0, GroceryStore.MAX_ITEM_NAME_SIZE);
    }
}
