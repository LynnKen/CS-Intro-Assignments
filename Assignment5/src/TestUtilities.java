
import java.util.Comparator;
import java.util.Random;

// static utilities for bankAccount
public class TestUtilities {
    public static final Random RAND = new Random();

    // Creates bankAccountsArray with random  and uniuqe names and account numbers
    public static BankAccount[] createBankAccountsArray(int[] balnces) {
        LinkedList<String> names = getNameLinkedList();
        LinkedList<Integer> accountNumbers = getAccountNumbersLinkedList();
        BankAccount[] BankAccountArray = new BankAccount[balnces.length];
        for (int i = 0; i < balnces.length; i++) {
            BankAccount bankAccount = createNewBankAccount(balnces[i], accountNumbers, names);
            BankAccountArray[i] = bankAccount;
        }
        return BankAccountArray;
    }

    public static BankAccount[] createBankAccountsArray(int[] balnces, int[] accountNumbers) {
        LinkedList<String> names = getNameLinkedList();
        BankAccount[] BankAccountArray = new BankAccount[balnces.length];
        for (int i = 0; i < balnces.length; i++) {
            BankAccount bankAccount = createNewBankAccount(balnces[i], accountNumbers[i], names);
            BankAccountArray[i] = bankAccount;
        }
        return BankAccountArray;
    }

    public static BankAccount[] CopyByBalanceBankAccountsArray(int[] balances, BankAccount[] toBeCopied) {
        DynamicArray<BankAccount> tempCopyList = new DynamicArray<BankAccount>();
        for (int j = 0; j < balances.length; j++) {
            for (int i = 0; i < toBeCopied.length; i++) {
                if (toBeCopied[i].getBalance() == balances[j]) {
                    tempCopyList.add(toBeCopied[i]);
                }
            }
        }
        BankAccount[] finalArray = new BankAccount[tempCopyList.size()];
        for (int i = 0; i < tempCopyList.size(); i++) {
            finalArray[i] = tempCopyList.get(i);
        }

        return finalArray;

    }

    public static BankAccount[] CopyByAccountNumbersBankAccountsArray(int[] accountNumbers, BankAccount[] toBeCopied) {
        DynamicArray<BankAccount> tempCopyList = new DynamicArray<BankAccount>();
        for (int j = 0; j < accountNumbers.length; j++) {
            for (int i = 0; i < toBeCopied.length; i++) {
                if (toBeCopied[i].getAccountNumber() == accountNumbers[j]) {
                    tempCopyList.add(toBeCopied[i]);
                }
            }
        }


        BankAccount[] finalArray = new BankAccount[tempCopyList.size()];
        for (int i = 0; i < tempCopyList.size(); i++) {
            finalArray[i] = tempCopyList.get(i);
        }

        return finalArray;
    }


    //Create a new Bank acoount with rendom account number and name
    public static BankAccount createNewBankAccount(int balance, LinkedList<Integer> accountNumbers, LinkedList<String> names) {
        String name = getRandomName(names);
        int accountNumber = getRandomAccountNumber(accountNumbers);
        return new BankAccount(name, accountNumber, balance);
    }

    public static BankAccount createNewBankAccount(int balance, int accountNumber, LinkedList<String> names) {
        String name = getRandomName(names);
        return new BankAccount(name, accountNumber, balance);
    }

    //create a hard copy of the bank account 
    //Assume: tobecopy not null
    public static BankAccount hardCopyBankAccount(BankAccount tobeCopy) {
        if (tobeCopy == null) {
            throw new IllegalArgumentException("to be copy cannot be null");
        }
        return new BankAccount(tobeCopy.getName(), tobeCopy.getAccountNumber(), tobeCopy.getBalance());
    }

    //Intiilize names from people in Wall street movie
    public static LinkedList<String> getNameLinkedList() {
        final LinkedList<String> NAMES = new LinkedList<>();
        NAMES.add("Gordon Gekko");
        NAMES.add("Bud Fox");
        NAMES.add("Darien Taylor");
        NAMES.add("Carl Fox");
        NAMES.add("Lou Mannheim");
        NAMES.add("Sir Larry Wildman");
        NAMES.add("Kate Gekko");
        NAMES.add("Roger Barnes");
        NAMES.add("Marvin");
        NAMES.add("Harold Salt");
        return NAMES;
    }

    //Intiilize AccountNumbers List
    public static LinkedList<Integer> getAccountNumbersLinkedList() {
        final LinkedList<Integer> ACCOUNTNUMBERS = new LinkedList<>();;
        ACCOUNTNUMBERS.add(1); // Gordon Gekko
        ACCOUNTNUMBERS.add(2); // Bud Fox
        ACCOUNTNUMBERS.add(3); // Darien Taylor
        ACCOUNTNUMBERS.add(4); // Carl Fox
        ACCOUNTNUMBERS.add(5); // Lou Mannheim
        ACCOUNTNUMBERS.add(6); // Sir Larry Wildman
        ACCOUNTNUMBERS.add(7); // Kate Gekko
        ACCOUNTNUMBERS.add(8); // Roger Barnes
        ACCOUNTNUMBERS.add(9); // Marvin
        ACCOUNTNUMBERS.add(10); // Harold Salt
        return ACCOUNTNUMBERS;
    }

    //remove and return Random name from NamesList 
    //Assume Names.size > 0
    public static String getRandomName(LinkedList<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("Must intiiles NAMES list");
        }
        return names.remove(RAND.nextInt(names.size()));
    }

    //remove and return Random Account number from NamesList 
    //Assume Names.size > 0
    public static int getRandomAccountNumber(LinkedList<Integer> acccountNumbers) {
        if (acccountNumbers.size() == 0) {
            throw new IllegalArgumentException("Must intiiles NAMES list");
        }
        return acccountNumbers.remove(RAND.nextInt(acccountNumbers.size()));
    }

    //create a hard copy of the bank account array (deepy copy, creats a copy of the bank accounts to) 
    //Assume: tobecopy not null
    public BankAccount[] copyBankAccountsArray(BankAccount[] toBeCopied) {
        if (toBeCopied == null) {
            throw new IllegalArgumentException("to be copy cannot be null");
        }
        BankAccount[] hardCopy = new BankAccount[toBeCopied.length];
        for (int i = 0; i < toBeCopied.length; i++) {
            hardCopy[i] = hardCopyBankAccount(toBeCopied[i]);
        }
        return hardCopy;
    }

    //Marge sort bank accounts array
    //Assume bankAccounts!= null and myComparator not null
    public void mergaSortByBalance(BankAccount[] bankAccounts, int left, int right, Comparator<BankAccount> myComparator) {
        if (bankAccounts == null || myComparator == null) {
            throw new IllegalArgumentException("to be copy cannot be null");
        }
        if (bankAccounts.length <= 1 || left >= right) {
            return;
        }
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergaSortByBalance(bankAccounts, left, mid, myComparator);
            mergaSortByBalance(bankAccounts, mid + 1, right, myComparator);
            merge(bankAccounts, left, mid, right, myComparator);
        }
    }

    //do the merge sort algoritim O(nlog(n))
    public void merge(BankAccount[] bankAccounts, int left, int mid, int right, Comparator<BankAccount> myComparator) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        BankAccount[] leftAccounts = new BankAccount[sizeLeft];
        BankAccount[] rightAccounts = new BankAccount[sizeRight];


        for (int i = 0; i < sizeLeft; i++)
            leftAccounts[i] = bankAccounts[left + i];
        for (int i = 0; i < sizeRight; i++)
            rightAccounts[i] = bankAccounts[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (myComparator.compare(leftAccounts[i], rightAccounts[j]) < 0) {
                bankAccounts[k++] = leftAccounts[i++];
            } else {
                bankAccounts[k++] = rightAccounts[j++];
            }
        }

        while (i < sizeLeft) {
            bankAccounts[k++] = leftAccounts[i++];
        }

        while (j < sizeRight) {
            bankAccounts[k++] = rightAccounts[j++];
        }
    }
}
