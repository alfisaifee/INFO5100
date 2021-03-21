package assignment7.part1;

import java.util.*;
import java.util.regex.Pattern;

public class Atm {
    private double availableAmountInMachine;
    private double transactionFee;
    private HashMap<String, AtmUser> atmUserMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);


    public Atm(double availableAmountInMachine, double transactionFee){
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
    }

    public Atm(double availableAmountInMachine, double transactionFee, HashMap<String, AtmUser> atmUserMap) {
        this(availableAmountInMachine, transactionFee);
        this.atmUserMap = atmUserMap;
    }

    public boolean createUser(){
        String name = enterName();
        int age = enterAge();
        String phoneNumber = enterPhoneNumber();
        String bankAccountNumber = enterAccountNumber();
        String password = enterPassword();
        User user = new User(name, age, phoneNumber, bankAccountNumber);
        if(!atmUserMap.containsKey(bankAccountNumber)) {
            atmUserMap.put(bankAccountNumber, new AtmUser(name, age, phoneNumber, bankAccountNumber,
                    password));
            return true;
        }
        else{
            System.out.println();
            return false;
        }
    }

    private String enterName() {
        System.out.println("Full Name");
        String name = scanner.nextLine();
        if(name.isEmpty() || Pattern.compile("[^a-zA-Z\s]").matcher(name).find()) {
            throw new BadInputException("full name");
        }
        return name;
    }

    private int enterAge() {
        System.out.println("Age");
        int age = scanner.nextInt();
        if(age < 18 || age > 120)
            throw new BadInputException("age");
        return age;
    }

    private String enterPhoneNumber() {
        System.out.println("Phone Number");
        String phoneNumber =  scanner.next().trim();
        if(phoneNumber.isEmpty() || Pattern.compile("[^0-9]").matcher(phoneNumber).find()
         || phoneNumber.length() != 10)
            throw new BadInputException("phone number");
        return phoneNumber;
    }

    private String enterAccountNumber(){
        System.out.println("Account Number");
        String accountNumber = scanner.next();
        if(accountNumber.isEmpty() || Pattern.compile("[^0-9]").matcher(accountNumber).find()
                || accountNumber.length() != 10)
            throw new BadInputException("account number");
        return accountNumber;
    }

    private String enterPassword(){
        System.out.println("Password");
        String password = scanner.next().trim();
        if(password.trim().isEmpty() || password.length() < 6)
            throw new BadInputException("password");
        return password;
    }

    public AtmUser login(){
        String accountNumber = enterAccountNumber();
        String password = enterPassword();
        if(atmUserMap.containsKey(accountNumber) &&
                atmUserMap.get(accountNumber).getPassword().equals(password))
            return atmUserMap.get(accountNumber);
        return null;
    }

    public boolean resetPassword(){
        AtmUser atmUser = validateUser();
        if(atmUser != null){
            System.out.println("Provide your new password below.\n");
            String newPassword = enterPassword();
            atmUser.setPassword(newPassword);
            return true;
        }
        else{
            System.out.println("User does not exist. Check the details entered.\n");
            return false;
        }
    }

    private AtmUser validateUser(){
        System.out.println("Provide below details to validate user.\n");
        String name = enterName();
        int age = enterAge();
        String phoneNumber = enterPhoneNumber();
        String bankAccountNumber = enterAccountNumber();

        if(atmUserMap.containsKey(bankAccountNumber)){
            AtmUser user = atmUserMap.get(bankAccountNumber);
            if(user.getName().equals(name) && user.getAge() == age && user.getPhoneNumber().equals(phoneNumber))
                return user;
        }
        return null;
    }

    public double checkAvailableBalance(AtmUser user){
        return user.getAvailableBalance();
    }

    public boolean withdrawal(AtmUser user, double withdrawalAmount){
        if(user.getAvailableBalance() < withdrawalAmount || withdrawalAmount > availableAmountInMachine)
            return false;
        else{
            double balance = user.getAvailableBalance()-withdrawalAmount-transactionFee;
            user.setAvailableBalance(balance);
            availableAmountInMachine = availableAmountInMachine - withdrawalAmount;
            user.addRecentTransaction("Withdrawal - " + withdrawalAmount);
            return true;
        }
    }

    public void deposit(AtmUser user, double depositAmount){
        double balance = user.getAvailableBalance() + depositAmount - transactionFee;
        user.setAvailableBalance(balance);
        availableAmountInMachine += depositAmount;
        user.addRecentTransaction("Deposit - " + depositAmount);
    }

    public void printLast10Transactions(AtmUser user){
        List<String> transactionLog = user.getTransactionLog();
        int n = transactionLog.size()-1;
        int count = 1;
        while(count <= 10){
            System.out.println(count + ") "+ transactionLog.get(n--));
            count++;
            if(n < 0)
                break;
        }
    }

    public void changePassword(AtmUser user){
        String password = enterPassword();
        user.setPassword(password);
    }

    private void afterLogInMenu(){
        System.out.println("""
                        
                        Enter digit to select option\s
                        
                        1) Check Balance\s
                        2) Withdrawal\s
                        3) Deposit\s
                        4) Recent Transactions\s
                        5) Change Password\s
        
                        EXIT : 0\s
                        """);
    }

    private void loginUserSteps(AtmUser user){
        int y = -1;
        while(y != 0) {
            afterLogInMenu();
            y = scanner.nextInt();
            if (y == 1) {
                System.out.println("Available Balance : " + checkAvailableBalance(user));
            }
            else if(y == 2){
                System.out.println("Enter Withdrawal Amount\n");
                double withdrawalAmount = scanner.nextDouble();
                if(withdrawal(user,withdrawalAmount))
                    System.out.println("Amount Withdrawn\n");
                else
                    System.out.println("Withdrawal Error. Contact Helpline\n");
            }
            else if(y == 3){
                System.out.println("Enter Deposit Amount\n");
                double depositAmount = scanner.nextDouble();
                deposit(user,depositAmount);
                    System.out.println("Amount Deposited\n");
            }
            else if(y == 4){
                System.out.println("Below are the recent transactions :\n");
                printLast10Transactions(user);
            }
            else if(y == 5){
                System.out.println("Enter your new password below.\n");
                changePassword(user);
                System.out.println("New password set\n");
            }
            else if(y > 5)
                System.out.println("Invalid option selection\n");
        }
    }

    public static void main(String[] args){
        //1) Create new user
        //2) Login
        //   1) Check Balance
        //   2) Withdrawal
        //   3) Deposit
        //   4) Recent Transactions
        //   5) Change Password
        //   0) Exit
        //3) Forgot Password
        //0) Exit

        Atm atm = new Atm(950_000_000, 2.5);
        int x = -1;
        try {
            while (x != 0) {
                System.out.println("""
                        
                        Enter digit to select option\s
                        
                        1) New User\s
                        2) Current User Login\s   
                        3) Forgot Password\s
                        
                        EXIT : 0\s
                        
                        """);
                x = scanner.nextInt();
                scanner.nextLine();
                if (x == 1) {
                    System.out.println("To create new new user enter below information\n");
                    if(atm.createUser())
                        System.out.println("\nNew User added. Login for other options.\n");
                    else{
                        System.out.println("\nUser already registered for given bank account number.");
                    }
                } else if (x == 2) {
                    AtmUser user = atm.login();
                    if (user != null) {
                        System.out.println("Logged In\n");
                        atm.loginUserSteps(user);
                    } else {
                        System.out.println("User does not exist. Register as new user or check the details entered.\n");
                    }
                } if(x == 3){

                    if(atm.resetPassword())
                        System.out.println("New Password set. Login for other options.");
                }
            }
        }
        catch(BadInputException b){
            System.out.println(b.toString());
        }catch(InputMismatchException i){
            System.out.println("Error : Enter a valid input. Try Again.");
        }catch(Exception e){
            System.out.println("Unhandled Exception.");
        }finally {
            scanner.close();
        }
    }
}
