package BankApplication;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private String branchAddress;
    private ArrayList<Customers> customers;
    public Branch(String branchName, String branchAddress){
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        customers = new ArrayList<Customers>();
    }

    public String getBranchName(){
        return branchName;
    }

    public String getBranchAddress(){
        return branchAddress;
    }
    public ArrayList<Customers> getCustomers(){
        return customers;
    };

//    TO ADD A NEW CUSTOMER AND INITIALS TRANSACTION AMOUNT
    public boolean addNewCustomerAndInitialTransactionAmount(String name, String acctNumber, String emailAddress, double initialAmount){
        if(findCustomer(name) == null){
            customers.add(new Customers(name, acctNumber, emailAddress, initialAmount ));
            return true;
        }else{
            return false;
        }
    }

//    TO ADD ADDITIONAL TRANSACTIONS FOR CUSTOMER & BRANCH
    public boolean addAdditionalTransactionForCustomerAndBranch(String name, double amount){
        Customers existingCustomer = findCustomer(name);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }else{
            return false;
        }
    }


    public Customers findCustomer(String name){
        for(int x = 0; x < customers.size(); x++){
            Customers customer = customers.get(x);
            if(customer.getAccountName().equals(name)){
                return customer;
            }
        }
        return null;
    }
}
