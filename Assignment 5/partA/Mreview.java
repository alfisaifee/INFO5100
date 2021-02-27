package assignment5.partA;

import java.util.ArrayList;
import java.util.Locale;

public class Mreview implements Comparable<Mreview>{

    private String title;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Mreview(){}

    public Mreview(String ttl){
        setTitle(ttl);
    }

    public Mreview(String ttl, int firstRating){
        setTitle(ttl);
        addRating(firstRating);
    }

    public String getTitle(){
        return title;
    }

    public void addRating(int r){
        ratings.add(r);
    }

    public double aveRating(){
        double sum = 0;
        for(int r : ratings)
            sum += r;
        return Math.round((sum / numRatings()) * 10.0) / 10.0;
    }

    public int numRatings(){
        return ratings.size();
    }

    @Override
    public int compareTo(Mreview mreview) {
        return title.compareTo(mreview.title);
    }

    @Override
    public boolean equals(Object obj){
       if(obj instanceof Mreview)
           return  ((Mreview) obj).getTitle().equals(this.title);
       else
           throw new IllegalArgumentException("The argument object must be an instance of Mreview");
    }

    @Override
    public String toString(){
        return title + ", average " + aveRating() + " out of " + numRatings() + " ratings";
    }

    public void setTitle(String title){
        this.title = title;
    }
}
