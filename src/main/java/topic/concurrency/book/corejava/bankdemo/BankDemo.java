package topic.concurrency.book.corejava.bankdemo;

import java.util.Arrays;

/**
 * demonstrates synchrnonization
 * also pgm should avoid deadlock situation, if NACCOUNTS = 10, and each
 * TransferRunnable requires say 2 or 3 times INITIAL_BALANCE then threads will soon
 * go into deadlock unless the run method checks for account balance in from accounts
 */
public class BankDemo {
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 10000;
	
	public static void main(String[] args) {
		System.out.println("Started ...");
		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for(int i=0; i< NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(bank, i,   INITIAL_BALANCE);
			Thread th = new Thread(r);
			th.start();
		}
	}
	
}

class Bank{
	private final double [] accounts;
	
	Bank(int nosOfAccounts, double initBalance) {
		accounts = new double[ nosOfAccounts ];
		for (int i = 0; i < accounts.length; i++) {
			accounts[ i ] = initBalance; // each account has 1000
		}
	}
	
//	public boolean hasFunds(int acct, double amt){
//		return accounts[acct] >= amt;
//	}
	
	public synchronized void transfer(int from, int to, double amount){
		// unsafe without sync
		try{
			while(accounts[from] < amount) {
				wait();
				System.out.printf("Waiting for Thread : %s, transfer between accounts[%s] and accounts[%s] " +
				"amount = %s%n",
				       Thread.currentThread(), from, to, amount);
			}
			System.out.print(Thread.currentThread());
			
			accounts[ from ] -= amount;
			
			System.out.printf(" transferring %10.2f from %d to %d", amount, from, to);
			accounts[ to ] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
			System.out.println(Arrays.toString(accounts));
			notifyAll();
			
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		
	}
	
	private double getTotalBalance(){
		double sum = 0.0;
		for(int i=0; i<accounts.length; i++){
			sum += accounts[i];
		}
		return sum;
	}
	
	public int size(){
		return accounts.length;
	}
}

class TransferRunnable implements Runnable {
	private Bank bank;
	private double maxAmount;
	private int fromAccount;
	private final static int DELAY = 1;
	
	
	TransferRunnable(Bank b, int from, double max){
		this.bank = b;
		this.fromAccount = from;
		this.maxAmount = max;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				//if(bank.hasFunds(fromAccount, amount))
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		}catch(InterruptedException ie){
				Thread.currentThread().interrupt();
		}
	}
}
