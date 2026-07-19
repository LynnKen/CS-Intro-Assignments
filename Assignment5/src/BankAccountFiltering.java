import java.util.Iterator;

public class BankAccountFiltering {
    public static List<BankAccount> getAllValidAccounts(Iterable<BankAccount> accounts, 
                                                        int requiredBalance, 
                                                        int minAccountNumber, 
                                                        int maxAccountNumber) {
        List<BankAccount> list=new LinkedList<>();
        Filter<BankAccount> byAccountNum=new FilterByAccountNumber(minAccountNumber,maxAccountNumber);
        Filter<BankAccount> byBalance=new FilterByBalance(requiredBalance);
        Iterable<Filter<BankAccount>> allFilters=new LinkedList<>();
        ((LinkedList)allFilters).add(byBalance);
        ((LinkedList)allFilters).add(byAccountNum);

        Iterator<BankAccount> filterITR=new FilterIterator<>(accounts,allFilters);
        while (filterITR.hasNext())
            list.add(filterITR.next());

        return list;
        //Filter<Filter<BankAccount>> filters=new Filter<Filter<BankAccount>>()
    }
}
