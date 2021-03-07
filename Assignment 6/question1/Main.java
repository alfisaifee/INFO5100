package assignment6.question1;

public class Main {
    public static void main(String[] args){

        int[] arr = {1,4,2,6,11,12,8,4,4,4};
        try{
            checkArr(arr);
        }catch (MyIndexOutOfBoundException me){
            System.out.println(me.message());
        }

    }

    public static void checkArr(int[] arr) throws MyIndexOutOfBoundException{
        MyIndexOutOfBoundException ie = new MyIndexOutOfBoundException(0,9,arr.length);
        if(arr.length < ie.getLowerBound() || arr.length > ie.getUpperBound()){
            throw ie;
        }
    }

}
