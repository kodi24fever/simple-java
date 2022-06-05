package util;

public abstract class Egg extends Item{
    private int amount;
    private int costInCents;
    public Egg(String typeOfEgg, int amount, int costInCents){
        super(typeOfEgg);
        this.amount = amount;
        this.costInCents = costInCents;
    }
}
