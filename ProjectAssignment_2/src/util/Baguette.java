package util;

public class Baguette extends Item{

    protected int costInCents;

    GroceryStore groceryStore = new GroceryStore();

    public int getCost(){
        return this.costInCents;
    }

    public String toString() {
        return (super.name + "\t\t\t\t" + groceryStore.cents2dollarsAndCents(this.getCost())
        );
    }

    public Baguette(String name, int costInCents){
        super(name);
        this.costInCents = costInCents;
    }
}
