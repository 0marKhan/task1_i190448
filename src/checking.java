
public class checking extends acc {
	int loginCount = 0;

	public int getLoginCount() {
		return loginCount;
	}

	public void incLoginCount() {
		loginCount++;
	}

	public void printTransactions() {
		System.out.println("Account owner: " + name);
		System.out.println("Address: " + address);
		System.out.println("Mobile number: 0" + mobNum);
		System.out.println("Account number: " + accountNum);
		System.out.println("balance = " + balance);
		System.out.println("Deposited = " + deposit);
		System.out.println("withdrawn = " + withdraw);
		if (loginCount > 2) {
			System.out.println("transaction fee = 10");
		}
		System.out.println("transaction date and time: " + time + "\n");

	}
}
