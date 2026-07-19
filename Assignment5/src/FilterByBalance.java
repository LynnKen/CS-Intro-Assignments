
public class FilterByBalance implements Filter<BankAccount>{
	private int balanceThreshold;

	public FilterByBalance(int balanceThreshold) {
	    this.balanceThreshold=balanceThreshold;
	}
	
	@Override
	public boolean accept(BankAccount element) {
		if (element==null)
			throw new IllegalArgumentException("Bank Account is null");
	    int elementBalance=element.getBalance();
		int dif=elementBalance-balanceThreshold;
		if (dif>=0)
			return true;
		return false;
	}
}
