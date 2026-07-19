import java.util.Iterator;

/**
 * This class represents a bank,
 * it has a database with all the clients represented by BankAccount.
 *
 * @author <Lynn  Kendler>
 *
 */

public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;


	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}
	// END OF Given code -----------------------------------

	/**
	 * This method tells if the Bank Account if found in the chosen tree database
	 *
	 * @param newAccount Bank Account
	 * @param toSearchIn the database to search in, assumes not null
	 * @return true if newAccount exist in toSearchIn and false otherwise
	 */

	private boolean isFound(BankAccount newAccount,
							BankAccountsBinarySearchTree toSearchIn){
		BankAccount found = toSearchIn.findData(newAccount);
		return found !=null;

	}

	/**
	 * This method adds bank account to the bank
	 *
	 * @param newAccount the account to add
	 * @return true if the account was added and false if there is existing account
	 * in the bank with the same name or number.
	 */
	public boolean add(BankAccount newAccount) {
	    if (!isFound(newAccount,namesTree) && !isFound(newAccount,accountNumbersTree)) {
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			return true;
		}
		return false;
	}

	/**
	 * This method deletes bank account from the bank by name
	 *
	 * @param name the name of the account to delete
	 * @return true if the account removed and false if the account name doesn't exist
	 */
	public boolean delete(String name){
		BankAccount toRemove=namesTree.findData(new BankAccount(name,1,0));
		if (toRemove==null)
			return false;
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		return true;
	}

	/**
	 * This method deletes bank account from the bank by account number
	 *
	 * @param accountNumber the number of the account to delete
	 * @return true if the account removed and false if the account number doesn't exist
	 */
	public boolean delete(int accountNumber){
		BankAccount toRemove=accountNumbersTree.findData(new BankAccount("dummy",accountNumber,0));
		if (toRemove==null)
			return false;
		return delete(toRemove.getName());
	}

	/**
	 * This method deposit money to a given bank account
	 *
	 * @param amount the amount to deposit
	 * @param accountNumber the account number to deposit in
	 * @return true if the money deposited to the account and false if the amount<0
	 * or account number doesn't exist
	 */
	public boolean depositMoney(int amount, int accountNumber){
		BankAccount toDepositIn=accountNumbersTree.findData(new BankAccount("dummy",accountNumber,0));
		if (toDepositIn==null)
			return false;
		return toDepositIn.depositMoney(amount);
	}

	/**
	 * This method withdraw money from a bank account
	 *
	 * @param amount the amount to withdraw
	 * @param accountNumber the account number to withdraw from
	 * @return true if the withdrawal succeeded and false if the amount is negative
	 * or turns the balance to negative after the withdraw or if the account number doesn't exist in bank.
	 */
	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount withdrawFrom=accountNumbersTree.findData(new BankAccount("dummy",accountNumber,0));
		if (withdrawFrom==null)
			return false;
		return withdrawFrom.withdrawMoney(amount);
	}

	/**
	 * This method transfer money from one bank account to the other
	 *
	 * @param amount the amount to transfer
	 * @param accountNumber1 the account to withdraw from
	 * @param accountNumber2 the account to deposit in
	 * @return true if the transfer been made and false if amount<0 or turns the balance
	 * of the first account to negative after the transfer.
	 * or if one of the account's doesn't exist.
	 */
	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		if (amount<0)
			return false;
		BankAccount account1 = accountNumbersTree.findData(new BankAccount("dummy1", accountNumber1, 0));
		BankAccount account2 = accountNumbersTree.findData(new BankAccount("dummy2", accountNumber2, 0));
		if (account1 != null && account2 != null && account1.getBalance() >= amount) {
			withdrawMoney(amount, accountNumber1);
			depositMoney(amount, accountNumber2);
			return true;
		}
		return false;
	}

	/**
	 * This method transfer money from one bank account to the other
	 * 	 *
	 * 	 * @param amount the amount to transfer
	 * 	 * @param accountNumber the account to withdraw from
	 * 	 * @param name the name of the account to deposit in
	 * 	 * @return true if the transfer been made and false if amount<0 or turns the balance
	 * 	 * of the first account to negative after the transfer.
	 * 	 * or if one of the account's doesn't exist.
	 */
    public boolean transferMoney(int amount, int accountNumber, String name) {
		BankAccount account2 = namesTree.findData(new BankAccount(name, 1, 0));
		if (account2 == null)
			return false;
		int accountNumber2 = account2.getAccountNumber();
		return transferMoney(amount, accountNumber, accountNumber2);
	}

}
