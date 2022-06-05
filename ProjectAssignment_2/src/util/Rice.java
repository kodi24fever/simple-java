package util;

public class Rice extends Item{
    private double weight;
    private double costInCents;

    @Override
    public double getCost(){
        return this.weight * this.costInCents;
    }

    public Rice(String name, double weight, double costInCents){
        super(name);
        this.weight = weight;
        this.costInCents = costInCents;
    }
}
