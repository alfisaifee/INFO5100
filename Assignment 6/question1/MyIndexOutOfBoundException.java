package assignment6.question1;

public class MyIndexOutOfBoundException extends RuntimeException{
    private int lowerBound = 0;
    private int upperBound = 10;
    private int index;

    public MyIndexOutOfBoundException(int index) {
        this.index = index;
    }

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public String message() {
        return "Error Message: Index: " + index + ", " +
                "but Lower Bound: " + lowerBound + ", Upper Bound: " + upperBound;
    }


}
