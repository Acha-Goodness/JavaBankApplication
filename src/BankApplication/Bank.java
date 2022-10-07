package BankApplication;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branchList;

    public Bank(){
        branchList = new ArrayList<Branch>();
    }

//    TO ADD A NEW BRANCH
    public void addNewBranch(String branchName, String branchAddress){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch == null){
            branchList.add(new Branch(branchName, branchAddress));
            System.out.println(branchName + " branch has been created");
        }else{
            System.out.println(branchName + " branch already exist");
        }
    }

//    TO ADD CUSTOMER TO BRANCH WITH INITIAL TRANSACTION
    public void addNewCustomerToBranchWithInitialTransaction(String branchName, String customerName, String acctNumber, String emailAddress, double initialAmount){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null){
            boolean result = existingBranch.addNewCustomerAndInitialTransactionAmount(customerName, acctNumber, emailAddress, initialAmount);
            System.out.println( result ? "New customer has been added to " + existingBranch.getBranchName() + " branch" : "Customer " + customerName + " already exists");
        }else{
            System.out.println(branchName + " does not exist");
        }
    }

//    TO ADD A TRANSACTION FOR AN EXISTING CUSTOMER FOR THE BRANCH
    public void addTransactionForAnExistingCustomer(String branchName, String customerName, double amount){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null){
            boolean result = existingBranch.addAdditionalTransactionForCustomerAndBranch(customerName, amount);
            System.out.println( (result ? "Transaction was successful" : "This customer " + customerName + " does not exist in " + branchName + " branch"));
        }else{
            System.out.println(branchName + " does not exist, transaction failed");
        }
    }

//    TO SHOW A LIST OF CUSTOMER FOR A PARTICULAR BRANCH AND OPTIONALLY A LIST OF THEIR TRANSACTION
    public void displayListOfCustomersForParticularBranch(String branchName, boolean showTrans){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null){
            System.out.println("Customer details for " + existingBranch.getBranchName() + " Branch");
            ArrayList<Customers> holdCustomers = existingBranch.getCustomers();
            for(int x = 0; x < holdCustomers.size(); x++){
                System.out.println("Customer: " + holdCustomers.get(x).getAccountName());
                if(showTrans){
                    System.out.println("Transactions");
                    ArrayList<Double> holdTransactions = holdCustomers.get(x).getTransactions();
                    for(int j = 0; j < holdTransactions.size(); j++){
                        System.out.println((j + 1) + " Amount -> " + holdTransactions.get(j));
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }else{
            System.out.println(existingBranch.getBranchName() + " does not exist");
        }
    }

    private Branch findBranch(String name){
        for(int x = 0; x < branchList.size(); x++){
            Branch branch = branchList.get(x);
            if(branch.getBranchName().equals(name)){
                return branch;
            }
        }
        return null;
    }

}
