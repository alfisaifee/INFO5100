package assignment4.part3;

public class DessertShop {

    public static final double TAX_RATE = 0.065;
    public static final String STORE_NAME = "M & M Dessert Shop";
    public static final int MAX_ITEM_NAME_SIZE = 25;
    public static final int WIDTH = 35;

    public static String cents2dollarsAndCents(int numberOfCents){
        return numberOfCents / 100.0 + "";
    }

}
