import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class acc {
	String name;
	String address;
	long mobNum;
	int accountNum;
	double balance;
	LocalDate date;
	String time;
	double withdraw;
	double deposit;

	acc() {
		name = "";
		address = "";
		mobNum = 0;
		accountNum = 0;
		balance = 0;
	}

	acc(String n, String add, long mobile, int accNum, int bal, LocalDate d) {
		name = n;
		address = add;
		mobNum = mobile;
		accountNum = accNum;
		balance = bal;
		date = d;
	}

	public int randomNum() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	public void setName(String n) {
		name = n;
	}

	public void setAddress(String a) {
		address = a;
	}

	public void setMob(long m) {
		mobNum = m;
	}

	public void setAccount() {
		accountNum = randomNum();
	}

	public void setDate() {
		date = java.time.LocalDate.now();
	}

	public String getName() {
		return name;
	}

	public double checkBalance() {
		return balance;
	}

	public String getAddress() {
		return address;
	}

	public long getMobileNumber() {
		return mobNum;
	}

	public void setWithdrawal(double d) {
		withdraw = d;
	}

	public void setDeposit(double d) {
		deposit = d;
	}

	public void makeDeposit(double amount) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		time = formatter.format(date);
		balance += amount;
		deposit = amount;
	}

	public double makeWithdrawal(double amount) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		time = formatter.format(date);
		balance -= amount;
		withdraw = amount;
		return amount;

	}

	public void printStatemant() {
		System.out.println("Account owner: " + name);
		System.out.println("Address: " + address);
		System.out.println("Mobile number: 0" + mobNum);
		System.out.println("Account number: " + accountNum);
		System.out.println("account creation date: " + date);
		System.out.println("current balance: " + balance);
		// time
	}

	public void printTransactions() {
		System.out.println("Account owner: " + name);
		System.out.println("Address: " + address);
		System.out.println("Mobile number: 0" + mobNum);
		System.out.println("Account number: " + accountNum);
		System.out.println("balance = " + balance);
		System.out.println("Deposited = " + deposit);
		System.out.println("withdrawn = " + withdraw);
		// System.out.println("")
		System.out.println("transaction date and time: " + time + "\n");

	}

	public void displayDeductions() {

	}

}
