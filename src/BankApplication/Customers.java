package BankApplication;
import java.util.ArrayList;

public class Customers {
    private String accountName;
    private String accountNumber;
    private String emailAddress;
    private double balance;
    private ArrayList<Double> transactions;

    public Customers(String accountName, String accountNumber, String emailAddress, double balance){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.emailAddress = emailAddress;
        transactions = new ArrayList<Double>();
        if(balance < 0){
            System.out.println("INVALID DEPOSIT AMOUNT");
        }else{
            addTransaction(balance);
        }
    }

    public String getAccountName(){
        return accountName;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public ArrayList<Double> getTransactions(){
        return transactions;
    }

    public void addTransaction(double balance){
        transactions.add(balance);
    }
}
