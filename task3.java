import java.util.Scanner;
 class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        } else{
            return false;
        }
    }


 }

class atm{
    private BankAccount account;
    private Scanner scanner;

    public atm(BankAccount account){
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.println("Welcome to the ATM");
        System.out.println("1.withdraw");
        System.out.println("2.deposit");
        System.out.println("3.check balance");
        System.out.println("4.exit");
    }

    public void handleOption(int option){
        switch(option){
            case 1:
            withdraw();
            break;
            case 2:
            deposit();
            break;
            case 3:
            checkBalance();
            break;
            case 4:
            System.out.println("thenks for using the atm! byebyee");
            System.exit(0);
            default:
            System.out.println("invalid please choose again");
        }
    }

    public void withdraw(){
        System.out.println("enter the amount to withdraw:");
        double amount = scanner.nextDouble();
        if(amount <= 0){
            System.out.println("invalid");
            return;
        }
        if (account.withdraw(amount)){
            System.out.println("withdraw successful. remaining balance:"+ account.getBalance());

        }else{
            System.out.println("insufficient funds");
        }
    }

    public void deposit(){
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    } 

    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }
    
}

class Done {
    public static void main(String[] args) {
        // Initialize bank account with initial balance
        BankAccount account = new BankAccount(1000.0);
        
        // Initialize ATM with the bank account
        atm atm = new atm(account);
        
        // Main loop to display menu and handle user options
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            atm.handleOption(choice);
        }
    }
}
    

