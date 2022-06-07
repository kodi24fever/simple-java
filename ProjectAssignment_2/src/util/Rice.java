package util;

public class Rice extends Item{
    private double weight;
    private int costInCents;

    GroceryStore groceryStore = new GroceryStore();

    @Override
    public int getCost(){
        return (int) (this.weight * this.costInCents);
    }

    @Override
    public String toString() {
        return (this.weight + " lbs. @ " + groceryStore.cents2dollarsAndCents(this.costInCents) + " /lb. \n" +
                super.name + "\t\t\t\t" + groceryStore.cents2dollarsAndCents(this.getCost())
        );
    }

    public Rice(String name, double weight, int costInCents){
        super(name);
        this.weight = weight;
        this.costInCents = costInCents;
    }
}
