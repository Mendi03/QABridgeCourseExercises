package assertions;

public class Main {
	
	
	public static void main(String[] args) {
		
		Account account = new Account(1000);
		
		System.out.println("Balance: " + account.getBalance());
		System.out.println(account.deposit(100));
		System.out.println("Balance: " + account.getBalance());
		System.out.println(account.withdraw(200));
		System.out.println("Balance: " + account.getBalance());
		System.out.println(account.deposit(-100));
		System.out.println("Balance: " + account.getBalance());
		System.out.println(account.withdraw(-100));
		System.out.println("Balance: " + account.getBalance());
		System.out.println(account.withdraw(100000));
		System.out.println("Balance: " + account.getBalance());
	}


	
}
