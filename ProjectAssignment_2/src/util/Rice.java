package util;

public abstract class Rice extends Item{
    private double weight;
    private int costInCents;

    @Override
    public double getCost(){
        return this.weight * this.costInCents;
    }

    public Rice(String name, double weight, int costInCents){
        super(name);
        this.weight = weight;
        this.costInCents = costInCents;
    }
}
