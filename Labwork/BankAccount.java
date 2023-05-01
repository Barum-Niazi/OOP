import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {

    public String Account_Title;
    public int balance;
    public ArrayList transactionAmount = new ArrayList<Double>();
    public ArrayList creditTransaction = new ArrayList<Double>();

    BankAccount(String gettitle) {
        Account_Title = gettitle;
        ArrayList emptyList = new ArrayList<String>();
        System.out.println("Account Title is :" + Account_Title);

    }

    BankAccount(String gettitle, int getbalance) {
        Account_Title = gettitle;
        balance = getbalance;
        ArrayList emptyList = new ArrayList<String>();
        System.out.println("Now Account Title is :" + Account_Title +
                "Now Your balance is: " + balance);

    }

    public int printbalance() {
        System.out.println("Your Balance is " + this.balance);
        return balance;
    }

    public int deposit(int getdeposit) {
        System.out.println("The amount to be added is: " + getdeposit);

        balance += getdeposit;
        System.out.println("Your New balance is: " + balance);
        if (transactionAmount.size() == 5)
            transactionAmount.remove(0);
        if (getdeposit < 0)
            creditTransaction.add(getdeposit);

        transactionAmount.add(getdeposit);
        return 0;

    }

    public int withdraw(int getamount) {
        System.out.println("The Requested amount is " + getamount);
        balance -= getamount;
        System.out.println("Your remeaining balance is: " + balance);
        if (transactionAmount.size() == 5)
            transactionAmount.remove(0);
        if (getamount < 0)
            creditTransaction.add(getamount);

        transactionAmount.add(getamount);
        return 0;
    }

    public void printCreditTransactions() {
        System.out.println("Your credit transactions are: ");
        for (int i = 0; i < creditTransaction.size(); i++) {
            System.out.println(creditTransaction.get(i));
        }
    }

    public void computeTransactionBalance() {
        int[] arr = new int[5];
        int total = 0;
        for (int i = 0; i < transactionAmount.size(); i++) {
            arr[i] = (int) transactionAmount.get(i);
        }

        for (int a : arr) {
            total = total + a;
        }
        System.out.println("Transaction balance is: " + total);
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("Enter Account title:  ");
        BankAccount b = new BankAccount(c.nextLine());
        System.out.println("Enter New Account Title");
        BankAccount ab = new BankAccount(c.nextLine(), 500);
        ab.printbalance();
        System.out.println("Enter the amount of transactions you want to perform: ");
        int n = c.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Desired amount to deposit (use - sign if ur transaction is credit): ");
            ab.deposit(c.nextInt());
            System.out.println("Enter the amount to withdraw: ");
            ab.withdraw(c.nextInt());
        }

        System.out.println("The last 5 transactions are: ");
        for (int i = 0; i < ab.transactionAmount.size(); i++) {
            System.out.println(ab.transactionAmount.get(i));
        }

        System.out.println("The last credit transactions are: ");
        for (int i = 0; i < ab.creditTransaction.size(); i++) {
            System.out.println(ab.creditTransaction.get(i));
        }
        ab.computeTransactionBalance();
    }

}
