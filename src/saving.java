
public class saving extends acc {
	double interestRate;

	public void calculateZakaat() {
		if (balance <= 20000) {
			System.out.println("zakaat cannot be calculated unless balance equal to or greater than 20,000");
		}

		else {
			double zakat = (balance * 2.5) / 100;
			System.out.println("zakaath amount = " + zakat + "\n");
		}
	}

	public void calculateInterest() {
		double intr = (interestRate / 100) * balance;
		System.out.println("interest = " + intr + "\n");
	}

	public void setInterestRate(double rate) {
		interestRate = rate;
	}
}
