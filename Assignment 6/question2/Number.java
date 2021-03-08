package assignment6.question2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Number {
    public static void count() throws NumberFormatException, ArithmeticException {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number x of type int");
            int x = Integer.parseInt(scanner.next());
            System.out.println("Enter a number y of type int");
            int y = Integer.parseInt(scanner.next());
            System.out.println("Quotient : " + x + "/" + y + " = " + x / y);
        }
        catch (NumberFormatException n){
            System.out.println("Exception : Enter a valid input of type integer");
        }
        catch (ArithmeticException a){
            System.out.println("Exception : Division by zero error");
        }
        catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public static void main(String[] args){
        count();
    }
}
