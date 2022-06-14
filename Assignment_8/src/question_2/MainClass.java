package question_2;


interface Eatable{
    void eat(String tool);
}
interface Drinkable{
    void drink(String tool);
}
class MilkShake implements Eatable, Drinkable{
    String name;
    public MilkShake(String aName) {
        name = aName;
    }
    public void eat(String tool){
        System.out.println("Eating "+name+" with "+tool);
    }
    public void drink(String tool){
        System.out.println("Drinking "+name+" with "+tool);
    }
}
class MainClass
{
    public static void main(String[] args){
        Drinkable[]items = new Drinkable[] {new MilkShake("KFC's shake"),new MilkShake("Grandma's shake")};
        items[0].drink("straw");
        ((Eatable)items[1]).eat("spoon");
    }
}