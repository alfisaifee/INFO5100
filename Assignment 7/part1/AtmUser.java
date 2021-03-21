package assignment7.part1;

import java.util.ArrayList;
import java.util.List;

public class AtmUser extends User{

    private String password;
    private double availableBalance;
    private List<String> transactionLog = new ArrayList<>();

    public AtmUser(String name, int age, String phoneNumber,String bankAccountNumber, String password) {
        super(name, age, phoneNumber, password);
        this.password = password;
    }

    String getPassword(){
        return password;
    }

    void setPassword(String password){
        this.password = password;
    }

    double getAvailableBalance(){
        return availableBalance;
    }

    void setAvailableBalance(double availableBalance){
        this.availableBalance = availableBalance;
    }

    void addRecentTransaction(String log){
        transactionLog.add(log);
    }

    List<String> getTransactionLog(){
        return transactionLog;
    }
}
