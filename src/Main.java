import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice; // recording users choice
		LinkedList<saving> SavingsList = new LinkedList<saving>();
		LinkedList<checking> CheckingsList = new LinkedList<checking>();
		boolean check3 = false, check4 = false;
		double interestRate = 0;

		do {
			System.out.println("--------------------------------------------");
			System.out.println("enter 1 to create a savings account");
			System.out.println("enter 2 to create a checkings account");
			System.out.println("enter 3 to login into an existing account");
			System.out.println("enter 4 to set an interest rate %");
			System.out.println("enter 5 to delete an account");
			System.out.println("enter 6 to see all savings accounts");
			System.out.println("enter 7 to see al checkings accounts");
			System.out.println("enter 0 to exit");
			System.out.println("--------------------------------------------");
			choice = sc.nextInt();

			if (choice == 0) {
				System.exit(0);

			} else if (choice == 1) {
				saving obj = new saving();
				System.out.println("enter your name");
				String n = sc.next();
				sc.nextLine();
				obj.setName(n);

				System.out.println("enter your address");
				String a = sc.nextLine();
				obj.setAddress(a);

				System.out.println("enter your mobile number");
				long mob = sc.nextLong();
				obj.setMob(mob);

				obj.setAccount();
				obj.setDate();

				if (SavingsList.isEmpty()) {
					SavingsList.add(obj);
					System.out.println("\n");
					System.out.println("your saving account has been created!!\n");
					// System.out.println(a);
					obj.printStatemant();
					System.out.println("\n\n");
				}

				else if (SavingsList.isEmpty() == false) {
					for (int i = 0; i < SavingsList.size(); i++) {
						if (SavingsList.get(i).name != obj.getName() && SavingsList.get(i).address != obj.getAddress()
								&& SavingsList.get(i).mobNum != obj.getMobileNumber()) {

							check3 = true;
							SavingsList.add(obj);
							System.out.println("\n");
							System.out.println("your saving account has been created!!\n");
							// System.out.println(a);
							obj.printStatemant();
							System.out.println("\n\n");
						}

						else if (check3 == false) {
							System.out.println("saving account limit is one per person\n");
						}
					}
				}
				check3 = false;

			}

			else if (choice == 2) {
				checking obj = new checking();
				System.out.println("enter your name");
				String n = sc.next();
				sc.nextLine();
				obj.setName(n);

				System.out.println("enter your address");
				String a = sc.nextLine();
				obj.setAddress(a);

				System.out.println("enter your mobile number");
				long mob = sc.nextLong();
				obj.setMob(mob);

				obj.setAccount();
				obj.setDate();

				if (CheckingsList.isEmpty()) {
					CheckingsList.add(obj);
					System.out.println("\n");
					System.out.println("your checkings account has been created!!\n");
					// System.out.println(a);
					obj.printStatemant();
					System.out.println("\n\n");
				}

				else if (CheckingsList.isEmpty() == false) {
					for (int i = 0; i < CheckingsList.size(); i++) {
						if (CheckingsList.get(i).name != obj.getName()
								&& CheckingsList.get(i).address != obj.getAddress()
								&& CheckingsList.get(i).mobNum != obj.getMobileNumber()) {

							check4 = true;
							CheckingsList.add(obj);
							System.out.println("\n");
							System.out.println("your checkings account has been created!!\n");
							// System.out.println(a);
							obj.printStatemant();
							System.out.println("\n\n");
						}

						else if (check4 == false) {
							System.out.println("saving account limit is one per person\n");
						}
					}
				}
				check4 = false;

			} else if (choice == 3) {
				System.out.println("enter 1 to login into savings account");
				System.out.println("enter 2 to login into checkings account");
				int ch = sc.nextInt();
				if (ch == 1) { // for logging into savings account
					System.out.println("enter your account number (5 digits)");
					int n1 = sc.nextInt();
					boolean check = false;
					int count = 0;
					for (int i = 0; i < SavingsList.size(); i++) {
						if (SavingsList.get(i).accountNum == n1) {
							count = i;
							System.out.println("savings account found!");
							SavingsList.get(i).setInterestRate(interestRate);
							check = true; // if account found in system
							break;
						}
					}
					if (check == false) { // if account not found in system
						System.out.println("account not found\n\n");
					}

					else { // account logged in if account entered matches
						int ch2;
						do {
							System.out.println("---------------------------------------");
							System.out.println("enter 1 to see bank acount details");
							System.out.println("enter 2 to check your balance");
							System.out.println("enter 3 to deposit an amount");
							System.out.println("enter 4 to withdraw an amount");
							System.out.println("enter 5 to calculate zakaath");
							System.out.println("enter 6 to calculate interest");
							System.out.println("enter 7 to transfer an amount");
							System.out.println("enter 0 to return to login screen");
							System.out.println("---------------------------------------");
							ch2 = sc.nextInt();

							if (ch2 == 1) { // printing back statement
								SavingsList.get(count).printStatemant();
								System.out.println("\n");
							}

							else if (ch2 == 2) { // printing current balance
								System.out.println("balance = " + SavingsList.get(count).checkBalance() + "\n");
							}

							else if (ch2 == 3) { // for depositing
								System.out.println("enter the amount you wish to deposit");
								double am = sc.nextDouble();
								SavingsList.get(count).makeDeposit(am);

								System.out.println("deposit successfull");
								System.out.println(
										"your new balance is = " + SavingsList.get(count).checkBalance() + "\n");

								int recChoice;
								System.out.println(
										"enter 1 if you wish for a reciept od the transaction, press 2 if not");
								recChoice = sc.nextInt();
								if (recChoice == 1) {
									SavingsList.get(count).setWithdrawal(0);
									SavingsList.get(count).printTransactions();
								}
							}

							else if (ch2 == 4) { // for withdrawing cash
								System.out.println("enter the amount you wish to withdraw");
								double am = sc.nextDouble();
								if (am > SavingsList.get(count).checkBalance()) {
									System.out.print(
											"you cannot withdraw more than your balance available in savings account\n");
								}

								else {
									SavingsList.get(count).makeWithdrawal(am);
									System.out.println("withdrawal successfull");
									System.out.println(
											"your new balance is = " + SavingsList.get(count).checkBalance() + "\n");

									int recChoice;
									System.out.println(
											"enter 1 if you wish for a reciept od the transaction, press 2 if not");
									recChoice = sc.nextInt();
									if (recChoice == 1) {
										SavingsList.get(count).setDeposit(0);
										SavingsList.get(count).printTransactions();
									}
								}

							}

							else if (ch2 == 5) {
								SavingsList.get(count).calculateZakaat();
							}

							else if (ch2 == 6) {
								SavingsList.get(count).calculateInterest();
							}

							else if (ch2 == 7) {
								if (SavingsList.get(count).balance <= 0) {
									System.out.println("you have no balance to transfer");
								} else {
									System.out.println("enter the account you wish to transfer money too");
									int acc = sc.nextInt();
									int transfer = 0;
									boolean flag1 = false, flag2 = false;
									for (int i = 0; i < SavingsList.size(); i++) {
										if (acc == SavingsList.get(i).accountNum) {
											flag1 = true;
											transfer = i;
											break;
										}
									}
									for (int i = 0; i < CheckingsList.size(); i++) {
										if (acc == CheckingsList.get(i).accountNum) {
											flag2 = true;
											transfer = i;
											break;
										}
									}

									if (flag1 == false && flag2 == false) {
										System.out.println("account not found");
									}

									else if (flag1 == true) {
										System.out.println("enter the amount you wish to tranfer");
										double amount = sc.nextInt();
										SavingsList.get(transfer).balance += amount;
										System.out.println("money transfer successful!");
									}

									else if (flag2 == true) {
										System.out.println("enter the amount you wish to tranfer");
										double amount = sc.nextInt();
										CheckingsList.get(transfer).balance += amount;
										System.out.println("money transfer successful!");
									}

								}

							}

						} while (ch2 != 0);
					}
				}

				if (ch == 2) { // if checking account logged in
					System.out.println("enter your account number (5 digits)");
					int n1 = sc.nextInt();
					boolean check2 = false;
					int count2 = 0;
					for (int i = 0; i < CheckingsList.size(); i++) {
						if (CheckingsList.get(i).accountNum == n1) {
							count2 = i;
							System.out.println("checkings account found!");
							check2 = true; // if account found in system
							break;
						}
					}
					if (check2 == false) { // if account not found in system
						System.out.println("account not found\n\n");
					}

					else { // account logged in if account entered matches
						int ch2;
						do {
							System.out.println("---------------------------------------");
							System.out.println("enter 1 to see bank acount details");
							System.out.println("enter 2 to check your balance");
							System.out.println("enter 3 to deposit an amount");
							System.out.println("enter 4 to withdraw an amount");
							System.out.println("enter 5 to transfer money to another account");
							System.out.println("enter 0 to return to login screen");
							System.out.println("---------------------------------------");
							ch2 = sc.nextInt();

							if (ch2 == 1) {
								CheckingsList.get(count2).printStatemant();
								System.out.println("\n");
							}

							else if (ch2 == 2) {
								System.out.println("balance = " + CheckingsList.get(count2).checkBalance() + "\n");
							}

							else if (ch2 == 3) {
								System.out.println("enter the amount you wish to deposit");
								double am = sc.nextDouble();
								CheckingsList.get(count2).makeDeposit(am);
								CheckingsList.get(count2).incLoginCount(); // counting number of transactions on
								// counting
								System.out.println("deposit successfull");

								if (CheckingsList.get(count2).getLoginCount() > 2) {
									System.out.println(
											"as your two free transactions have been used 10 ruppes have been deducted\n");
									CheckingsList.get(count2).balance -= 10;
								}
								System.out.println("your new balance is = " + CheckingsList.get(count2).checkBalance());
								CheckingsList.get(count2).setWithdrawal(0);

								int recChoice;
								System.out.println(
										"enter 1 if you wish for a reciept od the transaction, press 2 if not");
								recChoice = sc.nextInt();
								if (recChoice == 1) {
									CheckingsList.get(count2).printTransactions();
								}
							}

							else if (ch2 == 4) {
								System.out.println("enter the amount you wish to withdraw");
								double am = sc.nextDouble();
								if (CheckingsList.get(count2).balance - am < -5000) {
									System.out.println(
											"you cannot exceed withdrawing more than 5000 of your balance in checkings account\n");
								}

								else {
									CheckingsList.get(count2).makeWithdrawal(am);
									CheckingsList.get(count2).incLoginCount(); // counting number of transactions on
									// counting
									System.out.println("withdrawal successfull");

									if (CheckingsList.get(count2).getLoginCount() > 2) {
										System.out.println(
												"as your two free transactions have been used 10 ruppees have been deducted\n");
										CheckingsList.get(count2).balance -= 10;
									}
									System.out.println(
											"your new balance is = " + CheckingsList.get(count2).checkBalance());

									int recChoice;
									System.out.println(
											"enter 1 if you wish for a reciept of the transaction, press 2 if not");
									recChoice = sc.nextInt();
									if (recChoice == 1) {
										CheckingsList.get(count2).setDeposit(0);
										CheckingsList.get(count2).printTransactions();
									}
								}
							}

							else if (ch2 == 5) {
								if (CheckingsList.get(count2).balance <= 0) {
									System.out.println("you have no balance to transfer");
								} else {
									System.out.println("enter the account you wish to transfer money too");
									int acc = sc.nextInt();
									int transfer = 0;
									boolean flag1 = false, flag2 = false;
									for (int i = 0; i < SavingsList.size(); i++) {
										if (acc == SavingsList.get(i).accountNum) {
											flag1 = true;
											transfer = i;
											break;
										}
									}
									for (int i = 0; i < CheckingsList.size(); i++) {
										if (acc == CheckingsList.get(i).accountNum) {
											flag2 = true;
											transfer = i;
											break;
										}
									}

									if (flag1 == false && flag2 == false) {
										System.out.println("account not found");
									}

									else if (flag1 == true) {
										System.out.println("enter the amount you wish to tranfer");
										double amount = sc.nextInt();
										SavingsList.get(transfer).balance += amount;
										System.out.println("money transfer successful!");
									}

									else if (flag2 == true) {
										System.out.println("enter the amount you wish to tranfer");
										double amount = sc.nextInt();
										CheckingsList.get(transfer).balance += amount;
										System.out.println("money transfer successful");
									}

								}
							}

						} while (ch2 != 0);
					}
				}
			}

			else if (choice == 4) {
				System.out.println("enter the interest rate that will be applied for all accounts");
				interestRate = sc.nextDouble();
			}

			else if (choice == 5) {
				System.out.println("enter the account number of the account you wish to remove");
				int num = sc.nextInt();
				boolean flag = false;
				for (int i = 0; i < SavingsList.size(); i++) {
					if (num == SavingsList.get(i).accountNum) {
						flag = true;
						SavingsList.remove(i);
						break;
					}
				}

				for (int i = 0; i < CheckingsList.size(); i++) {
					if (num == CheckingsList.get(i).accountNum) {
						flag = true;
						CheckingsList.remove(i);
						break;
					}
				}

				if (flag == true) {
					System.out.println("account successfully deleted\n");
				}

				else {
					System.out.println("account not found\n");
				}
			}

			else if (choice == 6) {
				for (int i = 0; i < SavingsList.size(); i++) {
					System.out.println("(" + (i + 1) + ")" + " name = " + SavingsList.get(i).name);
				}
			}

			else if (choice == 7) {
				for (int i = 0; i < CheckingsList.size(); i++) {
					System.out.println("(" + (i + 1) + ")" + " name = " + CheckingsList.get(i).name);
				}
			}
		} while (choice != 0);

	}

}