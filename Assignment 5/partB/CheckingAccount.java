package assignment5.partB;

public class CheckingAccount extends Account{

    // static data members
    static private double MinBalance = 100;
    static private double Fee = 10;

    public CheckingAccount(String fname, String lname, double cb){
        super(fname, lname, cb);
    }

    @Override
    public double DebitTransaction(double debitAmount){
        super.DebitTransaction(debitAmount);
        chargeFee();
        return CurBalance;
    }

    @Override
    public double CreditTransaction(double creditAmount) {
        super.CreditTransaction(creditAmount);
        chargeFee();
        return CurBalance;
    }

    private void chargeFee(){
        if(CurBalance < MinBalance)
            CurBalance -= Fee;
    }


    // Simple Unit Test
    public static void main(String[] args)
    {
        CheckingAccount ch1 = new CheckingAccount("Steve", "Jobs", 50); // he was poor once before
        System.out.println(ch1);

        ch1.DebitTransaction(0.25); // he was cheap back then too
        System.out.println(ch1);    // should be $39.75 (= $49.75 - $10 fee)

        ch1.CreditTransaction(7.00); // small expense check
        System.out.println(ch1);     // should be $36.75 (= $39.75 + $7.00 - $10 fee)

        ch1.CreditTransaction(1000000); // a huge bonus!!
        System.out.println(ch1); // should be $1000036.75
    }

}
