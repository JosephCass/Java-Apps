package bankAccountApp;

public class Saving extends Account {

	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	public Saving(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
		showInfo();
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("ACCOUNT TYPE: Saving");
		System.out.println(" Your Savings Account Features");
		System.out.println(" Safety Deposit Box ID: " + safetyDepositBoxID);
		System.out.println(" Safety Deposit Box Key: " + safetyDepositBoxKey);
		System.out.println("---------------------");
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
	
}
