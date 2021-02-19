package assignment4.part2;

public class SadObject extends MoodyObject {

    @Override
    protected String getMood() {
        return "sad";
    }

    @Override
    public void expressFeelings() {
        System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
    }

    public String toString(){
        return "Subject cries a lot";
    }
}
