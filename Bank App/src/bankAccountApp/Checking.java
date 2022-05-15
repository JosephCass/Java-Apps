package bankAccountApp;

public class Checking extends Account{

	private int debitCardNumber;
	private int debitCardPin;
	
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
		showInfo();
	}
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 16));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	} 
	
	public void showInfo() {
		super.showInfo();
		System.out.println("ACCOUNT TYPE: Checking");
		System.out.println(" Your Checkings Account Features\n"
				+ " Debit Card Number: " + debitCardNumber + "\n"
				+ " Debit Card PIN: " + debitCardPin);
		System.out.println("---------------------");
	}

	@Override
	public void setRate() {
		rate = getBaseRate() * .15;	
	}
}
