package bankAccountApp;

import java.util.Scanner;

public abstract class Account implements IBaseRate{

	private String name;
	private String sSN;
	private double balance;
	private static int index = 10000;
	
	protected String accountNumber;
	protected double rate;

	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		this.accountNumber = setAccountNumber();
		setRate();
		index++;
	}
	
	public abstract void setRate();	
	
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	public void deposit() {
		System.out.println("How Much Do You Want To Deposit");
		Scanner scan = new Scanner(System.in);
		double amount = scan.nextDouble();
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw() {
		System.out.println("How Much Do You Want To Withdraw");
		Scanner scan = new Scanner(System.in);
		double amount = scan.nextDouble();
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer() {
		System.out.println("Where Do You Want To Transfer?");
		Scanner scan = new Scanner(System.in);
		String toWhere = scan.nextLine();
		System.out.println("How Much Do You Want To Transfer");
		Scanner scan1 = new Scanner(System.in);
		double amount = scan.nextDouble();
		balance = balance - amount;
		System.out.println("Transfering $" + amount + "to" + toWhere);
		printBalance();
	}	
	
	public void printBalance() {
		System.out.println("Your Balance Is Now $" + balance);
	}
	
	public void compound() {
		double accruedIntrest = balance * (rate/100);
		balance = balance + accruedIntrest;
		System.out.println("Accrued Intrset $" + accruedIntrest);
		printBalance();
	}
	
	public void showInfo() {
		System.out.println("NAME: " + name + "\n" 
			+ "BALANCE: " + balance + "\n" 
			+ "ACCOUNT NUMBER: " + accountNumber + "\n" 
			+ "RATE: " + rate +"%");
	}
	
}










