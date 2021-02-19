package assignment4.part3;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private List<DessertItem> dessertItems = new ArrayList<>();

    public Checkout(){}

    public int numberOfItems(){
        return dessertItems.size();
    }

    public void enterItem(DessertItem item){
        dessertItems.add(item);
    }

    public void clear(){
        dessertItems.clear();
    }

    public int totalCost(){
        int cost = 0;
        for(DessertItem item : dessertItems)
            cost += item.getCost();
        return cost;
    }

    public int totalTax(){
        return (int) (Math.round(totalCost() * (DessertShop.TAX_RATE)));
    }

    @Override
    public String toString(){
        StringBuilder receipt = new StringBuilder("\n");

        int width = DessertShop.WIDTH;
        String storeName = DessertShop.STORE_NAME;
        int space = (width/2)+(storeName.length()/2);

        //to add dessert shop name
        receipt.append(String.format("%"+space+"s", storeName)).append("\n");
        receipt.append(String.format("%"+space+"s","-".repeat(storeName.length()))).append("\n");

        //to add dessert items and cost
        int maxSize = DessertShop.MAX_ITEM_NAME_SIZE;
        receipt.append(printDetails(receipt, width, maxSize));

        //to add tax and total cost
        receipt.append("\nTax").append(String.format("%"+(width-3)+"s",totalTax()/100.0)).append("\n");
        receipt.append("\nTotal Cost").append(String.format("%"+(width-10)+"s",(totalCost()+totalTax())/100.0));

        return receipt.toString();
    }

    private String printDetails(StringBuilder receipt, int width, int maxSize) {
        StringBuilder temp = new StringBuilder();
        for(DessertItem item : dessertItems){
            String itemName = item.getName();
            int length = itemName.length();
            int currLength = 0;
            while(length > maxSize) {
                temp.append("\n").append(itemName.substring(currLength,
                        Math.min(itemName.length(), currLength + maxSize)));
                currLength += maxSize;
                length -= maxSize;
            }
            temp.append("\n").append(itemName.substring(currLength));
            temp.append(String.format("%1$"+ (width -length)+"s",
                    DessertShop.cents2dollarsAndCents(item.getCost()))).append("\n");
        }
        return temp.toString();
    }

    public List<DessertItem> getDessertItems() {
        return dessertItems;
    }

    public void setDessertItems(List<DessertItem> dessertItems) {
        this.dessertItems = dessertItems;
    }
}
