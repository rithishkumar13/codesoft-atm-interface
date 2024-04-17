import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double check_balance() {
        return balance;
    }

    public void deposit(double deposit_amt) {
        balance += deposit_amt;
    }

    public boolean withdrawl(double withdraw_amt) {
        if (balance >= withdraw_amt) {
            balance -= withdraw_amt;
            return true;
        }
        return false;
    }
}

class ATM {
    Scanner sc = new Scanner(System.in);
    private BankAccount account;
    private int pin;

    public ATM(BankAccount account, int pin) {
        this.account = account;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("Welcome to Atm");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        while (true) {
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            System.out.print("Enter your PIN:");
            int enteredPIN = sc.nextInt();
            if (enteredPIN == pin) {
                switch (choice) {
                    case 1:
                        System.out.println("Enter the amount to withdraw:");
                        double withdraw_amt = sc.nextDouble();
                        if (account.withdrawl(withdraw_amt)) {
                            System.out.println("Withdraw successful");
                        } else
                            System.out.println("Insufficent Balance");
                        break;
                    case 2:
                        System.out.println("Enter deposit amount");
                        double deposit_amt = sc.nextDouble();
                        account.deposit(deposit_amt);
                        System.out.println("deposit successful");
                        break;
                    case 3:
                        System.out
                                .println("Remaining balance in your acount is " + account.check_balance() + " " + "Rs");
                        break;
                    case 4:
                        System.out.println("Thank you for visiting ATM");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } else
                System.out.println("Incorrect pin code!.Try again");
        }
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        int userPIN = 8430;
        ATM atm = new ATM(userAccount, userPIN);
        atm.displayMenu();
    }
}