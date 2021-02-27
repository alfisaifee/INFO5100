package assignment5.partC;

import java.time.LocalDate;

public class Cat extends Pet implements Boardable{

    private String hairLength;
    private LocalDate boardStartDate;
    private LocalDate boardEndDate;


    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        setHairLength(hairLength);
    }

    public String getHairLength(){
        return hairLength;
    }

    public void setHairLength(String hairLength){ this.hairLength = hairLength; }

    //@Override
    public String toString(){
        return this.getClass().getSimpleName() + "\n" + super.toString() + "\nHair: " + hairLength;
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
        Cat cat = new Cat("Tom","Bob","Black","Short");
        cat.setSex(SPAYED);
        System.out.println(cat.toString());

        cat.setBoardStart(1,15,2021);
        cat.setBoardEnd(1,25,2021);

        System.out.println(cat.boarding(1,20,2021));
        System.out.println(cat.boarding(2,28,2021));
    }

}
