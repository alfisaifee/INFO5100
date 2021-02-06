import java.util.Locale;

public class Assignment2Part1 {

    /*1) Write a java function that adds all the digits of an integer until it is single digit.
    (You may assume that input is a positive number)
    i. function takes an integer as input and returns its sum of digits.
    ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.*/

    public int addDigits (int input){
        while (input >= 10) {
            int res = 0;
            while (input > 0) {
                res += input % 10;
                input /= 10;
            }
            input = res;
        }
        return input;
    }

    /*2) Write a method to find the maximum and minimum number in an array of numbers
    Example:
    Input : [3, 5, 7, 1, 4, 32, 15]
    Output : Max is 32 and Min is 1*/

    public void findMaxAndMin(int[] array){
        if(array.length == 0)
            return;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int a : array){
            if(a > max)
                max = a;
            if(a < min)
                min = a;
        }
        System.out.println("Min : " + min);
        System.out.println("Max : " + max);
    }

    /*3) Write a method that takes a String and character as input and find how many
    characters are in the String
    Example #1
    Input : "North", 'r'
    Output : 1      //Explanation: "North" has 1 'r'*/

    public int characterCountInString(String s,char c){
        if(s == null)
            return 0;
        int count = 0;
        for(char ch : s.toLowerCase().toCharArray()){
            if(ch == c)
                count++;
        }
        return count;
    }
}
