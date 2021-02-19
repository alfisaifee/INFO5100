package assignment4.part2;

public class MoodTesterMain {
    public static void main(String[] args){
        PsychiatristObject psych = new PsychiatristObject();
        MoodyObject happy = new HappyObject();
        MoodyObject sad = new SadObject();

        psych.examine(happy);
        happy.queryMood();

        System.out.println();

        happy.expressFeelings();
        psych.observe(happy);

        System.out.println();

        psych.examine(sad);
        sad.queryMood();

        System.out.println();

        sad.expressFeelings();
        psych.observe(sad);

    }
}