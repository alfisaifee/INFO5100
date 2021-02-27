package assignment5.partC;

public class Pet {
    private String petName;
    private String ownerName;
    private String color;
    protected int sex;

    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static final int SPAYED = 3;
    public static final int NEUTERED = 4;

    public Pet(String name, String ownerName, String color){
        setPetName(name);
        setOwnerName(ownerName);
        setColor(color);
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getSex(){
        if(sex == MALE)
            return "Male";
        else if(sex == FEMALE)
            return "Female";
        else if(sex == SPAYED)
            return "Spayed";
        else if(sex == NEUTERED)
            return "Neutered";
        return "";
    }

    public void setSex(int sexId){
        if(sexId != MALE && sexId != FEMALE && sexId != SPAYED && sexId != NEUTERED)
            throw new IllegalArgumentException("Enter a valid Sex Id");
        sex = sexId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex();
    }


    //Testing
    public static void main(String[] args){
        Pet pet = new Pet("Spot", "Mary", "Black and White");
        pet.setSex(MALE);
        System.out.println(pet.toString());
    }
}
