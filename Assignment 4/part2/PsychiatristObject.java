package assignment4.part2;

public class PsychiatristObject {

    public void examine(MoodyObject moodyObject){
        System.out.println("How are you feeling today?");
    }

    public void observe(MoodyObject moodyObject){
        System.out.println("Observation: " + moodyObject.toString());
    }
}

