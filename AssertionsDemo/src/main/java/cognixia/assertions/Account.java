package cognixia.assertions;

public class Account {
	
	private int balance;
	
	
	Account(int balance){
		if (balance > 0) {
			this.balance = balance;
		} else {
			this.balance = 0;
		}
		assert this.balance >= 0: "Account should be created with a positive balance";
	}

	public int getBalance() {
		return this.balance;
	}
	
	public String deposit(int amount) {
		if (amount <= 0) {
			return "Deposit Failed: Deposit amount should be greater than Zero";
		}
		assert amount > 0: "The deposit amount should be greater than 0";
		this.balance += amount;
		return "Deposit Successful";
	}
	
	public String withdraw(int amount) {
		if (amount <= 0) {
			return "Withdraw Failed: Withdraw amount should be greater than Zero";
		}
		
		if (amount > balance) {
			return "Withdraw Failed: Withdraw amount must be less than current balance";
		}
		assert amount > 0: "The withdraw amount should be greater than 0";
		assert balance >= amount: "The withdraw amount should be less than the current balance";
		
		int oldBalance = this.balance;
		this.balance -= amount;
		
		assert oldBalance > balance: "The withdraw should lower the value of the balance";
		
		return "Withdraw Successful";
	}
}
