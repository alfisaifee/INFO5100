package assignment4.part3;

public class Cookie extends DessertItem{

    private int number;
    private double pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        setNumber(number);
        setPricePerDozen(pricePerDozen);
    }

    @Override
    public int getCost() {
        return (int) Math.round(number * (pricePerDozen / 12));
    }

    @Override
    public String getName(){
        return number + " @ " + pricePerDozen/100.0 + " / dz. " + name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }


}
