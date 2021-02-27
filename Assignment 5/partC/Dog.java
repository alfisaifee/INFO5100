package assignment5.partC;

import java.time.LocalDate;

public class Dog extends Pet implements Boardable{

    private String size;
    private LocalDate boardStartDate;
    private LocalDate boardEndDate;

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){ this.size = size; }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "\n" + super.toString() + "\nSize: " + size;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        boardStartDate = LocalDate.of(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        boardEndDate = LocalDate.of(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.compareTo(boardStartDate) >= 0 && date.compareTo(boardEndDate) <= 0;
    }

    public static void main(String[] args){
        Dog dog = new Dog("Spot","Susan","White","Medium");
        dog.setSex(SPAYED);
        System.out.println(dog.toString());

        dog.setBoardStart(5,10,2020);
        dog.setBoardEnd(5,27,2020);

        System.out.println(dog.boarding(1,29,2020));
        System.out.println(dog.boarding(5,16,2020));

    }
}
