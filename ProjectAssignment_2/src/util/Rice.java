package util;

public abstract class Rice extends Item{
    private double weight;
    private int costInCents;

    public Rice(String name, double weight, int costInCents){
        super(name);
        this.weight = weight;
        this.costInCents = costInCents;
    }
}
