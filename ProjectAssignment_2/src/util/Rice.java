package util;

public class Rice extends Item{
    private double weight;
    private double costInCents;

    @Override
    public double getCost(){
        return this.weight * this.costInCents;
    }

    public String toString() {
        return("\n" + super.name + "\t\t" + this.getCost() + "\n" +
                this.weight + " lbs." + " @ " + this.costInCents + " cents / lb\n");
    }

    public Rice(String name, double weight, double costInCents){
        super(name);
        this.weight = weight;
        this.costInCents = costInCents;
    }
}
