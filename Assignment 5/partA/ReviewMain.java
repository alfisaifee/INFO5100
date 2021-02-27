package assignment5.partA;

public class ReviewMain {
    public static void main(String[] args){
        Mreview mreview = new Mreview("Kill Bill", 3);
        mreview.addRating(4);
        mreview.addRating(5);
        System.out.println(mreview.toString());

    }
}
