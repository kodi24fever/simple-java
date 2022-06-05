package util;

public abstract class Egg extends Item{
    private int amount;
    private int costInCents;


    @Override
    public double getCost(){
        int dozen = 12;
        return (this.amount * costInCents) / dozen;
    }



    public Egg(String typeOfEgg, int amount, int costInCents){
        super(typeOfEgg);
        this.amount = amount;
        this.costInCents = costInCents;
    }
}
