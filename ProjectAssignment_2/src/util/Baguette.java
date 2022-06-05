package util;

public abstract class Baguette extends Item{

    private int costInCents;

    public Baguette(String name, int costInCents){
        super(name);
        this.costInCents = costInCents;
    }
}
