package assignment4.part2;

public class HappyObject extends MoodyObject {

    @Override
    protected String getMood() {
        return "happy";
    }

    @Override
    public void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString(){
        return "Subject laughs a lot";
    }
}