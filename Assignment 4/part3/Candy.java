package assignment4.part3;

public class Candy extends DessertItem{

    private double weight;
    private double pricePerPound;

    public Candy(String name, double weight, double pricePerPound) {
        super(name);
        setWeight(weight);
        setPricePerPound(pricePerPound);
    }

    @Override
    public int getCost() {
        return (int) Math.round(weight * pricePerPound);
    }

    @Override
    public String getName(){
        return weight + " lbs. @ " + pricePerPound/100.0 + " / lb. " + name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }
}