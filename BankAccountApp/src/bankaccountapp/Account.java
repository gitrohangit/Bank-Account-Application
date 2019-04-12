package bankaccountapp;

public abstract class Account implements IBaseRate{

	private String name;
	private String sSN;
	private double balance;	
	 
	static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		
		//set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		printBalance();
	}
	
	//Generate Account number:is savings,then 1 else 2 + last two digit of SSN + 5 digit unique ID + 3 digit random number
	private String setAccountNumber() {
		String lastTwoofSS = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber =(int)(Math.random() * Math.pow(10, 3));
		
		return lastTwoofSS + uniqueID + randomNumber;
	}
	
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing Rs: " + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing Rs: " + amount);
		printBalance();
	}
	
	public void transfer(String toWhere,double amount) {
		balance -= amount;
		System.out.println("Transferring Rs: " + amount + "to" + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is Rs: " + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"Name: " + name +
				"\nAccount Number: " + accountNumber +
				"\nBalance: " + balance + 
				"\nRate: " + rate + "%"
				);
	}
}
