package util;

public abstract class FlavoredBaguette extends Baguette{

    private String flavor;

    public FlavoredBaguette(String name,int cosInCents, String flavor){
        super(name, cosInCents);
        this.flavor = flavor;

    }
}
