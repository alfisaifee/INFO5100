package assignment5.partB;

public class Account {
    // instance data members
    protected String FirstName, LastName; // two String members
    protected double CurBalance;

    // methods
    public Account(String fname, String lname, double cb) {
        FirstName = fname;
        LastName = lname;
        CurBalance = cb;
    }

    public String getAcctType() {
        // returns the string of the class name
        return this.getClass().getSimpleName();
    }

    public double DebitTransaction(double debitAmount) {
        return CurBalance -= debitAmount;
    }

    public double CreditTransaction(double creditAmount) {
        return CurBalance += creditAmount;
    }

    public String toString() {
        return "Account name: " + FirstName + " " + LastName + ", Account Type: " + getAcctType() + ", Balance: " + String.format("$%.2f", CurBalance);
    }

    // Simple Unit Test
    public static void main(String[] args) {
        Account ac1 = new Account("John", "Smith", 100);
        System.out.println(ac1);

        ac1.DebitTransaction(30.25); // should be $69.75
        System.out.println(ac1);

        ac1.CreditTransaction(10.10);
        System.out.println(ac1); // should be $79.85
    }

}
