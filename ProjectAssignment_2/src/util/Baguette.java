package util;

public class Baguette extends Item{

    protected double costInCents;

    public double getCost(){
        return this.costInCents;
    }

    public String toString() {
        return("\n" + super.name + "\t\t" + this.getCost() + "\n");
    }

    public Baguette(String name, double costInCents){
        super(name);
        this.costInCents = costInCents;
    }
}
