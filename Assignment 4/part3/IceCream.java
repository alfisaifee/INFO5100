package assignment4.part3;

public class IceCream extends DessertItem{

    private int costOfIceCream;

    public IceCream(String name, int cost){
        super(name);
        setCostOfIceCream(cost);
    }

    @Override
    public int getCost() {
        return costOfIceCream;
    }

    @Override
    public String getName(){
        return name;
    }

    public void setCostOfIceCream(int costOfIceCream) {
        this.costOfIceCream = costOfIceCream;
    }

}

