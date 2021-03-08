package assignment6.question1;

public class Main {
    public static void main(String[] args){

        int[] arr = {1,4,2,6,11,12,8,4,4,4,5,6};
        try{
            checkArr(arr);
        }catch (MyIndexOutOfBoundException me){
            System.out.println(me.toString());
        }
    }

    public static void checkArr(int[] arr) throws MyIndexOutOfBoundException {
        for(int i=0; i<arr.length; i++){
            if(i < MyIndexOutOfBoundException.lowerBound || i > MyIndexOutOfBoundException.upperBound)
                throw new MyIndexOutOfBoundException(i);
        }
    }

}
