package assignment6.question1;

public class MyIndexOutOfBoundException extends RuntimeException{
    public static int lowerBound = 0;
    public static int upperBound = 9;
    private int index;

    public MyIndexOutOfBoundException(int index) {
        setIndex(index);
    }

    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public String toString() {
        return "Error Message: Index: " + index + ", " +
                "but Lower Bound: " + lowerBound + ", Upper Bound: " + upperBound;
    }
}
