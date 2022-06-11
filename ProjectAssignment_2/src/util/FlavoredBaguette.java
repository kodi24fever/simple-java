package util;

public class FlavoredBaguette extends Baguette{

    private String flavor;
    private int costOfflavor;

    public int getCost(){
        return this.costOfflavor + super.costInCents;
    }

    @Override
    public String toString() {
        return( super.name + "\t\t\t\t" + groceryStore.cents2dollarsAndCents(this.getCost()) +  "\nwith " + this.flavor
        );
    }

    public FlavoredBaguette(String name,int cosInCents, String flavor, int costOfFlavor){
        super(name, cosInCents);
        this.flavor = flavor;
        this. costOfflavor = costOfFlavor;

    }
}
