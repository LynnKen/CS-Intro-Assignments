
public class FilterByAccountNumber implements Filter<BankAccount> {
    private int minAccNum;
    private int maxAccNum;

    public FilterByAccountNumber(int minAccountNum, int maxAccountNum) {
        minAccNum=minAccountNum;
        maxAccNum=maxAccountNum;
    }

    public boolean accept(BankAccount element) {
        if (element==null)
            throw new IllegalArgumentException("Bank Account is null");
        boolean checkLowBar = (element.getAccountNumber() - minAccNum) >= 0;
        boolean checkHighBar = (maxAccNum - element.getAccountNumber()) >= 0;
        return checkLowBar && checkHighBar;
    }
}
