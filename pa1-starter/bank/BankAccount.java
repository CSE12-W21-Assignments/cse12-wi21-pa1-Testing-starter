
public class bankAccount {
    public static final int NUM_ACCOUNTS = 2;

    static int accountID;
    double[] accountBalance;

    public BankAccount(int num) { 
        this.accountID = num;
        for (int i = 0; i <= NUM_ACCOUNTS; i++) {
            accountBalance[i] = 0;
        }
    }

    public int getAccountID() {
        return this.accountID
    }

    public double getBalance(double account) {
        return this.accountBalance[account];
    }

    public void deposit(double amount, int account){
        this.accountBalance[account] = this.accountBalance[account] - amount;
    }

    public void withdraw(double amount, int account){
        double shortfall = amount - this.accountBalance[account];
        if (this.accountBalance[account] < shortfall) {        
            System.out.printf("Insufficient funds. You need: $%.2f%n", shortfall);
        }else if (this.accountBalance[account] >= amount) {
            this.accountBalance[account] = this.accountBalance[account] - amount;
        }
    }
    
    private static void printBalance(BankAccount b) {
        // Displaying only 2 places after decimal, since it's dollars & cents
        System.out.printf("Account %d balance: Checking = $%.2f, Savings = $%.2f%n",
                b.getAccountID(), b.getBalance(0), b.getBalance(1));
    }


    public static void main(String[] args) {

        double depositAmountChecking = 50.00;
        double depositAmountSavings = 125.00;

        BankAccount b1 = new BankAccount(101);

        // Put some money in the account 101
        b1.deposit(depositAmountChecking, 0);
        b1.deposit(depositAmountSavings, 1);
        printBalance(b1);

        // Make a second account to test for inappropriate sharing
        final double testAmount = 100;
        BankAccount b2 = new BankAccount(42);
        b2.deposit(testAmount, 0);
        b2.deposit(testAmount, 1);

        if(b1.getAccountID() != 101 || b2.getAccountID() != 42) {
            System.out.println("Something isn't right with the account numbers!");
        }


        // Take 3 payments of $19.95, Let's take out money from our checking.
        double amount = 19.95;
        for(int i = 1; i<=3; ++i) {
            System.out.println("Withdraw payment " + i + " of $" + amount);
            b1.withdraw(amount, 0);
            printBalance(b1);
        }


        // Make sure messing with b1 didn't change b2 balance.
        // This shouldn't happen if you implemented BankAccount properly.
        if(b2.getBalance(0) != testAmount || b2.getBalance(1) != testAmount) {
            System.out.println("Unexpected change in second account!");
            printBalance(b2);
        }   
    }
}
