package bankAccountApp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) throws InterruptedException {
		
		Account first1 = openAccount();
		performAction(first1);
		
		
/* This code reads the csv file and displays all bank accounts */
//		List<Account> accounts = new LinkedList<Account>();		
//		
//		List<String[]> newAccountHolder = utilities.CSV.read("NewBankAccounts.csv");
//		for(String[] account : newAccountHolder){
//			String name = account[0];
//			String sSN = account[1];
//			String accountType = account[2];
//			double initDeposit = Double.parseDouble(account[3]);
//			
//			if(accountType.equals("Savings")) {
//				accounts.add(new Saving(name, sSN, initDeposit));
//			} else if(accountType.equals("Checking")) {
//				accounts.add(new Checking(name, sSN, initDeposit));
//			} else {
//				System.out.println("Error Reading Account Type");
//			}
//			
//		}
//		
//		for(Account acc : accounts) {
//			acc.showInfo();
//		}
	}
	
	//Data entered must be precise
	
	public static Account openAccount() {
		do {
			System.out.println("Choose An Account Type To Open (Checkings) or (Savings) ->");
			Scanner scan = new Scanner(System.in);
			String account = scan.nextLine();
			if(account.toLowerCase().equals("checkings")) {
				return new Checking(setName(), setSSN(), initDeposit());
				
			} else if(account.toLowerCase().equals("savings")) {
				return new Saving(setName(), setSSN(), initDeposit());
			} else {
				System.out.println("Error Not A Choice");
				System.out.println("Enter Precisely \"Checkings\" or \"Savings\"");
			}
		} while(true);
	}
	
	private static String setName() {
		System.out.println("Enter Your Name");
		Scanner scan1 = new Scanner(System.in);
		String name = scan1.nextLine();
		return name;
	}
	
	private static String setSSN() {
		do {
			System.out.println("Enter Your SSN (Integers Only)");
			Scanner scan1 = new Scanner(System.in);
			String sSN = scan1.nextLine();
			try {
				Integer.parseInt(sSN);
				return sSN;
			} catch(NumberFormatException e) {
				System.out.println("Integers Only!");
			}
		} while (true);
	}
	
	private static double initDeposit() {
		System.out.println("Initial Deposit Amount");
		Scanner scan1 = new Scanner(System.in);
		Double deposit = (double) scan1.nextInt();
		return deposit;
	}
	
	private static void performAction(Account account) throws InterruptedException {
		do {
			System.out.println("1 - Deposit\n"
					+ "2 - Withdraw\n"
					+ "3 - Transfer\n"
					+ "4 - Check Balance\n"
					+ "5 - Check Accrued Intrest\n"
					+ "6 - Display Account Info\n"
					+ "X - To Log Out");
			Scanner scan = new Scanner(System.in);
			String action = scan.nextLine().toLowerCase();
			switch(action) {
				case "1":
					account.deposit();
					break;
				case "2":
					account.withdraw();
					break;
				case "3":
					account.transfer();
					break;
				case "4":
					account.printBalance();
					break;
				case "5":
					account.compound();;
					break;
				case "6":
					account.showInfo();;
					break;
				case "x":
					System.out.println("Logging Out...");
					Thread.sleep(2000);
					System.out.println("Bye Have A Nice Day!");
					System.exit(1);;
				default : System.out.println("Error Unknown Command!");
			}
		} while (true);
	}

}
