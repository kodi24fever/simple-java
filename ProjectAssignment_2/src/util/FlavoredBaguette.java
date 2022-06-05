package util;

public class FlavoredBaguette extends Baguette{

    private String flavor;
    private int costOFFlavor;

    public int getCost(){
        return this.costOFFlavor + super.costInCents;
    }

    @Override
    public String toString() {
        return( super.name + " with\n" + this.flavor + "\t\t\t\t\t" + groceryStore.cents2dollarsAndCents(this.getCost())
        );
    }

    public FlavoredBaguette(String name,int cosInCents, String flavor, int costOfFlavor){
        super(name, cosInCents);
        this.flavor = flavor;
        this. costOFFlavor = costOfFlavor;

    }
}
