package util;

public abstract class Baguette extends Item{

    protected double costInCents;

    public double getCost(){
        return this.costInCents;
    }

    public Baguette(String name, double costInCents){
        super(name);
        this.costInCents = costInCents;
    }
}
