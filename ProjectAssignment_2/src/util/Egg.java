package util;

public class Egg extends Item{
    private int amount;
    private int costInCents;

    GroceryStore groceryStore = new GroceryStore();


    @Override
    public int getCost(){
        int dozen = 12;
        return (this.amount * costInCents) / dozen;
    }

    public String toString() {
        return( this.amount + " @ " + groceryStore.cents2dollarsAndCents(this.costInCents) + " / dz\n" +
                super.name + "\t\t\t\t" + groceryStore.cents2dollarsAndCents(this.getCost())
        );
    }

    public Egg(String typeOfEgg, int amount, int costInCents){
        super(typeOfEgg);
        this.amount = amount;
        this.costInCents = costInCents;
    }
}
