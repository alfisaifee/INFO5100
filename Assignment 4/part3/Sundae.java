package assignment4.part3;

public class Sundae extends IceCream{

    private String nameOfTopping;
    private int costOfTopping;

    public Sundae(String name, int costOfIceCream, String nameOfTopping, int costOfTopping) {
        super(name, costOfIceCream);
        setNameOfTopping(nameOfTopping);
        setCostOfTopping(costOfTopping);
    }

    @Override
    public int getCost() {
        return super.getCost() + costOfTopping;
    }

    @Override
    public String getName(){
        return nameOfTopping + " Sundae with " + super.name;
    }

    public String getNameOfTopping() {
        return nameOfTopping;
    }

    public void setNameOfTopping(String nameOfTopping) {
        this.nameOfTopping = nameOfTopping;
    }

    public int getCostOfTopping() {
        return costOfTopping;
    }

    public void setCostOfTopping(int costOfTopping) {
        this.costOfTopping = costOfTopping;
    }
}