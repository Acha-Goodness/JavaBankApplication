package BankApplication;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Bank wellsFargo = new Bank();

    public static void main(String[] args) {
        System.out.println("STARTING BANK APPLICATION... ");
        displayMenu();
        boolean quit = false;

        while(!quit){
            System.out.println("Select Menu");
            int option = input.nextInt();
            input.nextLine();

            switch(option){
                case 0:
                    quit = true;
                    System.out.println("QUITING APPLICATION... ");
                break;
                case 1:
                    createNewBranch();
                break;
                case 2:
                    registerNewCustomer();
                break;
                case 3:
                    addTransForExistingCustomer();
                break;
                case 4:
                    displayAcctStatementForCustomers();
                break;
                case 5:
                    displayMenu();
            }
        }


    }

    private static void displayMenu(){
        System.out.println("0 -> QUIT APPLICATION..." + "\n" +
                           "2 -> CREATE NEW BRANCH " + "\n" +
                           "3 -> ADD TRANSACTION FOR EXISTING CUSTOMER " + "\n" +
                           "4 -> DISPLAY ACCOUNT STATEMENT FOR CUSTOMER IN A PARTICULAR BRANCH " + "\n" +
                           "5 -> DISPLAY APPLICATION MENU ");
    }

    private static void createNewBranch(){
        System.out.println("ENTER BRANCH NAME");
        String branchName = input.nextLine();

        System.out.println("ENTER BRANCH ADDRESS");
        String branchAddress = input.nextLine();

        wellsFargo.addNewBranch(branchName, branchAddress);
    }

    private static void registerNewCustomer(){
        System.out.println("ENTER BRANCH NAME");
        String branchName = input.nextLine();

        System.out.println("ENTER CUSTOMER NAME");
        String customerName = input.nextLine();

        System.out.println("ENTER ACCOUNT NUMBER");
        String acctNumber = input.nextLine();

        System.out.println("ENTER EMAIL ADDRESS");
        String emailAddress = input.nextLine();

        System.out.println("ENTER INITIAL DEPOSIT AMOUNT");
        double amount = input.nextInt();

        wellsFargo.addNewCustomerToBranchWithInitialTransaction(branchName, customerName, acctNumber, emailAddress, amount);
    }

    private static void addTransForExistingCustomer(){
        System.out.println("ENTER BRANCH NAME");
        String branchName = input.nextLine();

        System.out.println("ENTER CUSTOMER NAME");
        String customerName = input.nextLine();

        System.out.println("ENTER DEPOSIT AMOUNT");
        double amount = input.nextInt();

        wellsFargo.addTransactionForAnExistingCustomer(branchName, customerName, amount);
    }
    private static void displayAcctStatementForCustomers(){
        System.out.println("ENTER BRANCH NAME");
        String branchName = input.nextLine();

        System.out.println("ENTER TRUE TO SHOW TRANSACTION DETAILS & FALSE TO SKIP");
        boolean showTrans = input.nextBoolean();

        wellsFargo.displayListOfCustomersForParticularBranch(branchName, showTrans);
    }
}
