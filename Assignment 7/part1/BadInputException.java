package assignment7.part1;

public class BadInputException extends RuntimeException{

    private String fieldType;

    public BadInputException(String fieldType){
        this.fieldType = fieldType;
    }

    @Override
    public String toString(){
        return "Error: Bad Input Entered. Enter a valid " + fieldType + ". Try Again.\n";
    }

}
