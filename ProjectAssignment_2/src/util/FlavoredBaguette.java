package util;

public class FlavoredBaguette extends Baguette{

    private String flavor;
    private double costOFFlavor;

    public double getCost(){
        return this.costOFFlavor + super.costInCents;
    }

    public FlavoredBaguette(String name,double cosInCents, String flavor, double costOfFlavor){
        super(name, cosInCents);
        this.flavor = flavor;
        this. costOFFlavor = costOfFlavor;

    }
}
