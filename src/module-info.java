import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;
import java.time.LocalDate;  


class account{
    String name;
    String address;
    int mobNum;
    int accountNum;
    double balance;
    LocalDate date;

    account()
    {}

    account(String n, String add, int mobile, int accNum, int bal, LocalDate d){
        name = n;
        address = add;
        mobNum = mobile;
        accountNum = accNum;
        balance = bal;
        date = d;
    }

    public int randomNum() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public void createAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your name");
        name = sc.nextLine();

        System.out.println("enter your address");
        address =  sc.nextLine();

        System.out.println("enter your mobile number");
        mobNum = sc.nextInt();

        accountNum = randomNum();   //saves random account number
        balance = 0;
        date = java.time.LocalDate.now();  //current date

        System.out.println("account created!");
        System.out.println("your acount number is: " + accountNum);

    }

    public double checkBalance(){  
        return balance;
    }

    public void makeDeposit(double amount){
        balance += amount;
    }

    public double makeWithdrawal(double amount){
        balance -= amount;
        return amount;
    }

    public void printStatemant(){
        System.out.println("Account owner: " + name);
        System.out.println("Address: "  + address);
        System.out.println("Mobile number: " + mobNum);
        System.out.println("Account number: " + accountNum);
        System.out.println("Date of transaction: " + date);
        //time
    }
}


class management{
    /*public void transferAmount(double amount, int accNum){
        
    }*/
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;     //recording users choice
        LinkedList<account> list = new LinkedList<account>();
        
        do {
        	System.out.println("enter 1 to create an account");
            System.out.println("enter 2 to login into an existing account");
            System.out.println("enter 0 to exit");
            choice = sc.nextInt();

            if(choice == 0){
            	System.exit(0);
            }
        }while(choice != 0);
                 
    }
}

