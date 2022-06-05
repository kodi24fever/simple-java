package util;

public class Egg extends Item{
    private int amount;
    private double costInCents;


    @Override
    public double getCost(){
        int dozen = 12;
        return (this.amount * costInCents) / dozen;
    }

    public Egg(String typeOfEgg, int amount, double costInCents){
        super(typeOfEgg);
        this.amount = amount;
        this.costInCents = costInCents;
    }
}
