import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class EyalTest {

        public interface BooleanTest {
                boolean run();
        }

        public static class EvenNumberFilter implements Filter<Integer> {
                public EvenNumberFilter() {
                        super();
                }

                public boolean accept(Integer number) {
                        return number % 2 == 0;
                }
        }

        public static class OddNumberFilter implements Filter<Integer> {
                public OddNumberFilter() {
                        super();
                }

                public boolean accept(Integer number) {
                        return number % 2 == 1;
                }
        }

        private static int totalTests = 0;
        private static int passedTests = 0;

        private static Random rand = new Random();

        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String RESET_COLOR = "\u001B[0m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String YELLOW = "\u001B[33m";
        public static String passedColor;

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                handleUserInput(scanner);
                printTestSummary();
                scanner.close();
        }

        private static void logicTestsPart1() {
                // Test 1: depositMoney - basic addition
                runTest("depositMoney", "5 + 3", "8",
                                () -> testDepositMoney(5, 3, 8));

                // Test 2: depositMoney - deposit to empty account
                runTest("depositMoney", "0 + 3", "8",
                                () -> testDepositMoney(0, 3, 3));

                // Test 3: depositMoney - negative deposit
                runTest("depositMoney", "0 - 5", "false",
                                () -> testDepositMoney(0, -5, 3));

                // Test 4: depositMoney - zero deposit
                runTest("depositMoney", "0 + 0", "0",
                                () -> testDepositMoney(0, 0, 0));

                // Test 5: withdrawMoney - basic withdrawal
                runTest("withdrawMoney", "10 - 3", "7",
                                () -> testWithdrawMoney(10, 3, 7));

                // Test 6: withdrawMoney - withdraw all money
                runTest("withdrawMoney", "5 - 5", "0",
                                () -> testWithdrawMoney(5, 5, 0));

                // Test 7: withdrawMoney - withdraw more than balance
                runTest("withdrawMoney", "3 - 5", "false",
                                () -> testWithdrawMoney(3, 5, 3));

                // Test 8: withdrawMoney - negative withdrawal
                runTest("withdrawMoney", "5 - (-3)", "false",
                                () -> testWithdrawMoney(5, -3, 5));

                // Test 9: withdrawMoney - zero withdrawal
                runTest("withdrawMoney", "0 - 0", "0",
                                () -> testWithdrawMoney(0, 0, 0));

                // Test 10: AccountComparatorByName - names in alphabetical order
                runTest("AccountComparatorByName", "Alice,Bob", "<0",
                                () -> testAccountComparatorByAccountName("Alice", "Bob"));

                // Test 11: AccountComparatorByName - names in reverse order
                runTest("AccountComparatorByName", "Charlie,Bob", ">0",
                                () -> testAccountComparatorByAccountName("Charlie", "Bob"));

                // Test 12: AccountComparatorByName - identical names
                runTest("AccountComparatorByName", "Same,Same", "=0",
                                () -> testAccountComparatorByAccountName("Same", "Same"));

                // Test 13: AccountComparatorByName - extreme alphabetical comparison
                runTest("AccountComparatorByName", "Zebra,Alpha", ">0",
                                () -> testAccountComparatorByAccountName("Zebra", "Alpha"));

                // Test 14: AccountComparatorByNumber - numbers in ascending order
                runTest("AccountComparatorByNumber", "1,2", "<0",
                                () -> testAccountComparatorByAccountNumber(1, 2));

                // Test 15: AccountComparatorByNumber - numbers in descending order
                runTest("AccountComparatorByNumber", "100,50", ">0",
                                () -> testAccountComparatorByAccountNumber(100, 50));

                // Test 16: AccountComparatorByNumber - identical numbers
                runTest("AccountComparatorByNumber", "42,42", "=0",
                                () -> testAccountComparatorByAccountNumber(42, 42));

                // Test 17: AccountComparatorByNumber - large number difference
                runTest("AccountComparatorByNumber", "1000,1", ">0",
                                () -> testAccountComparatorByAccountNumber(1000, 1));
        }

        private static void logicTestsPart2() {
                // Test 1: Basic three-node tree
                runTest("ToStringBinaryNode", "[1,2,3]", "tree((1),2,(3))",
                                () -> testToStringBinaryNode(new Integer[] {1, 2, 3}, "tree((1),2,(3))"));

                // Test 2: Four-node tree with right subtree
                runTest("ToStringBinaryNode", "[1,2,3,4]", "tree((1),2,(3,(4)))",
                                () -> testToStringBinaryNode(new Integer[] {1, 2, 3, 4}, "tree((1),2,(3,(4)))"));

                // Test 3: Two-node tree
                runTest("ToStringBinaryNode", "[1,2]", "tree(1,(2))",
                                () -> testToStringBinaryNode(new Integer[] {1, 2}, "tree(1,(2))"));

                // Test 4: Two-node tree with different values
                runTest("ToStringBinaryNode", "[1,3]", "tree(1,(3))",
                                () -> testToStringBinaryNode(new Integer[] {1, 3}, "tree(1,(3))"));

                // Test 5: Empty tree
                runTest("ToStringBinaryNode", "[]", "Empty Tree",
                                () -> testToStringBinaryNode(new Integer[] {}, "Empty Tree"));

                // Test 6: Single-node tree
                runTest("ToStringBinaryNode", "[5]", "tree(5)",
                                () -> testToStringBinaryNode(new Integer[] {5}, "tree(5)"));

                // Test 7: Complete balanced tree with seven nodes
                runTest("ToStringBinaryNode", "[1,2,3,4,5,6,7]", "tree(((1),2,(3)),4,((5),6,(7)))",
                                () -> testToStringBinaryNode(new Integer[] {1, 2, 3, 4, 5, 6, 7},
                                                "tree(((1),2,(3)),4,((5),6,(7)))"));
        }

        public static void logicTestsPart3() {
                System.out.println(BLUE + "test balance is on you (3.3)" + RESET_COLOR);

                // Tests 1-2: FilterByBalance tests
                runTest("Filter by balance accept", "bank account with balance -4 and balanceThreshold -100", "true",
                                () -> filterByBalanceAccept(createBankAcount(-1), -100, true));
                runTest("Filter by balance accept", "bank account with balance 100 and balanceThreshold 50000", "false",
                                () -> filterByBalanceAccept(createBankAcount(100), 50000, false));

                // Tests 3-5: FilterByAccountNumber tests
                runTest("Filter By Account Number", "bank account number:2020 min = 2020, max = 20200", "true",
                                () -> testFilterByAccountNumber(createBankAcount((Integer) 2020), 2020, 2020, true));
                runTest("Filter By Account Number", "bank account number:2 min = -5, max = 300", "true",
                                () -> testFilterByAccountNumber(createBankAcount((Integer) 2), -5, 300, true));
                runTest("Filter By Account Number", "bank account number:2 min = 100, max = 300", "false",
                                () -> testFilterByAccountNumber(createBankAcount((Integer) 2), 100, 300, false));

                // Tests 6-8: FilterIterator tests with even/odd numbers
                List<Filter<Integer>> filters = new ArrayList<Filter<Integer>>();
                filters.add(new EvenNumberFilter());
                runTest("Filter Iterator", "filter even numbers in 0-6", "0, 2, 4, 6",
                                () -> testFilterIterator(new Integer[] {0, 1, 2, 3, 4, 5, 6}, filters, new Integer[] {0, 2, 4, 6}));
                filters.removeAll(filters);
                filters.add(new OddNumberFilter());
                runTest("Filter Iterator", "filter odd numbers in 0-6", "1, 3, 5",
                                () -> testFilterIterator(new Integer[] {0, 1, 2, 3, 4, 5, 6}, filters, new Integer[] {1, 3, 5}));
                filters.add(new EvenNumberFilter());
                runTest("Filter Iterator", "filter all numbers in 0-6", "",
                                () -> testFilterIterator(new Integer[] {0, 1, 2, 3, 4, 5, 6}, filters, new Integer[] {}));

                // Tests 9-12: getAllValidAccounts tests with different filters
                int[] balances = new int[] {0, -5, 100, 50000, 6, 32, -5637};
                int[] accountNumbers = new int[] {100, 50, 333, 2, 5, 6, 51};
                BankAccount[] bankAccounts = TestUtilities.createBankAccountsArray(balances, accountNumbers);
                String accountsDescription = buildDescriptionStringForFilter(bankAccounts);

                // Test 9: All accounts within range
                runTest("get All Valid Accounts", PURPLE + "\nFilters: min 0, max 500 ,balance -60000\n" + "input accounts:" + accountsDescription,
                                PURPLE + accountsDescription,
                                () -> testGetAllValidAccounts(bankAccounts, 0, 500, -60000, bankAccounts));

                // Test 10: Positive balance accounts
                int[] expectedBalances = new int[] {100, 50000, 6, 32};
                BankAccount[] positiveBankAccounts = TestUtilities.CopyByBalanceBankAccountsArray(expectedBalances, bankAccounts);
                String expectedBankAccountsDescription = buildDescriptionStringForFilter(bankAccounts);
                runTest("get All Valid Accounts", PURPLE + "\nFilters: All accounts with positive balance\n" + "input accounts:" + accountsDescription,
                                PURPLE + expectedBankAccountsDescription,
                                () -> testGetAllValidAccounts(bankAccounts, 0, 500, 1, positiveBankAccounts));

                // Test 11: Negative balance accounts
                int[] negativeAccountBalances = new int[] {50, 9};
                BankAccount[] negativeBankAccounts = TestUtilities.CopyByAccountNumbersBankAccountsArray(negativeAccountBalances, bankAccounts);
                expectedBankAccountsDescription = buildDescriptionStringForFilter(bankAccounts);
                runTest("get All Valid Accounts", PURPLE + "\nFilters: All accounts with negative balance\n" + "input accounts:" + accountsDescription,
                                PURPLE + expectedBankAccountsDescription,
                                () -> testGetAllValidAccounts(bankAccounts, 50, 51, -100, negativeBankAccounts));

                // Test 12: No matching accounts
                runTest("get All Valid Accounts", PURPLE + "\nFilters:none of the accounts\n" + "input accounts:" + accountsDescription,
                                PURPLE + "none of the accounts",
                                () -> testGetAllValidAccounts(bankAccounts, 50, 51, 500011, new BankAccount[] {}));
        }

        public static void logicTestsPart4() {
                Bank bank1 = new Bank();
                int[] balances = {100, 99, 98, 50, 4, 0, 500, -100};
                BankAccount[] bankAccounts = TestUtilities.createBankAccountsArray(balances);

                // Tests 1-8: Add bank accounts without duplications
                for (BankAccount bankAccount : bankAccounts) {
                        runTest("AddBankAccount", "add Bank Account without duplications:\n" + PURPLE + bankAccount.toString(), "true",
                                        () -> testAddBankAccount(bank1, bankAccount, true));
                }

                // Test 9: Add duplicate general account
                runTest("AddBankAccount", "add general account duplications:\n" + PURPLE + bankAccounts[7].toString(), "false",
                                () -> testAddBankAccount(bank1, bankAccounts[7], false));

                // Test 10: Add account with duplicate name
                runTest("AddBankAccount", "add account name duplications: " + PURPLE + bankAccounts[7].getName(), "false",
                                () -> testAddBankAccount(bank1, new BankAccount(bankAccounts[7].getName(), 6, 100), false));

                // Test 11: Add account with duplicate account number
                runTest("AddBankAccount", "add account number duplications: " + PURPLE + String.valueOf(bankAccounts[7].getAccountNumber()), "false",
                                () -> testAddBankAccount(bank1, new BankAccount("dummy", bankAccounts[7].getAccountNumber(), 100), false));

                // Test 12: Delete existing account by name
                runTest("Delete By Name Bank Account", "delete existing account:\n" + PURPLE + bankAccounts[7], "true",
                                () -> testDeleteByNameBankAccount(bank1, bankAccounts[7], true));

                // Test 13: Delete non-existing account by name
                runTest("Delete By NameBank Account", "delete non existing account:\n" + PURPLE + bankAccounts[7], "false",
                                () -> testDeleteByNameBankAccount(bank1, bankAccounts[7], false));

                // Test 14: Delete existing account by account number
                runTest("Delete By Account Number Bank Account", "delete existing account:\n" + PURPLE + bankAccounts[6], "true",
                                () -> testDeleteByAccountNumberBankAccount(bank1, bankAccounts[6], true));
                runTest("Delete By Account Number Bank Account", "delete non existing account:\n" + PURPLE + bankAccounts[6], "false",
                                () -> testDeleteByAccountNumberBankAccount(bank1, bankAccounts[6], false));

                // Test 16: Deposit valid amount to existing account
                runTest("Deposit Money", "Deposit 100 to existing account:\n" + PURPLE + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance() + 100) + " true",
                                () -> testDepositMoneyFromBank(bank1, bankAccounts[5], 100, true));

                // Test 17: Deposit negative amount to existing account
                runTest("Deposit Money", "Deposit -100 to existing account:\n" + PURPLE + bankAccounts[5] + "balance: " + bankAccounts[5].getBalance(),
                                bankAccounts[5] + " balance: " + bankAccounts[5].getBalance() + " true",
                                () -> testDepositMoneyFromBank(bank1, bankAccounts[5], -100, false));

                // Test 18: Deposit to non-existing account
                runTest("Deposit Money", "Deposit 100 to non existing account:\n" + PURPLE + bankAccounts[6], "false",
                                () -> testDepositMoneyFromBank(bank1, bankAccounts[6], 100, false));

                // Test 19: Withdraw valid amount from account with sufficient balance
                runTest("withdraw Money", "withdraw  50 from existing account with enough balance:\n" + PURPLE + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance() - 50) + " true",
                                () -> testWithdrawMoneyFromBank(bank1, bankAccounts[5], 50, true));

                // Test 20: Withdraw amount exceeding balance
                runTest("withdraw Money", "withdraw  55 from existing account without enough balance:\n" + PURPLE + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance()) + " false",
                                () -> testWithdrawMoneyFromBank(bank1, bankAccounts[5], 55, false));

                // Test 21: Withdraw negative amount
                runTest("withdraw Money", "withdraw -40 from existing account without enough balance:\n" + PURPLE + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance()) + " false",
                                () -> testWithdrawMoneyFromBank(bank1, bankAccounts[5], -40, false));

                // Test 22: Withdraw valid amount again
                runTest("withdraw Money", "withdraw  50 from existing account with enough balance:\n" + PURPLE + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance() - 50) + " true",
                                () -> testWithdrawMoneyFromBank(bank1, bankAccounts[5], 50, true));

                // Test 23: Withdraw from non-existing account
                runTest("withdraw Money", "withdraw 40 from non existing account without enough balance:\n" + PURPLE + bankAccounts[6] + " balance: " + bankAccounts[6].getBalance(),
                                bankAccounts[6] + " false",
                                () -> testWithdrawMoneyFromBank(bank1, bankAccounts[6], 40, false));

                // Test 24: Transfer money between existing accounts with sufficient balance
                runTest("transfer Money",
                                "transfer 50 from:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                "\n" + bankAccounts[1] + " balance: " + (bankAccounts[1].getBalance() - 50) + "\n" + bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance() + 50) + " true",
                                () -> testTransferMoney(bank1, bankAccounts[1], bankAccounts[5], 50, true));

                // Test 25: Transfer money with insufficient balance  
                runTest("transfer Money",
                                "transfer 50 from:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance() + " false",
                                () -> testTransferMoney(bank1, bankAccounts[1], bankAccounts[5], 50, false));

                // Test 26: Transfer negative amount
                runTest("transfer Money",
                                "transfer -50 from:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance() + " false",
                                () -> testTransferMoney(bank1, bankAccounts[1], bankAccounts[5], -50, false));

                // Test 27: Transfer from non-existing to existing account
                runTest("transfer Money",
                                "transfer from none existing bank to existing bank:\n" + PURPLE + bankAccounts[6] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[6],
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[6] + " false",
                                () -> testTransferMoney(bank1, bankAccounts[6], bankAccounts[1], 50, false));

                // Test 28: Transfer from existing to non-existing account
                runTest("transfer Money",
                                "transfer from existing bank to non existing bank:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[6],
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[6] + " false",
                                () -> testTransferMoney(bank1, bankAccounts[1], bankAccounts[6], 50, false));

                // Test 29: Transfer between non-existing accounts
                runTest("transfer Money",
                                "transfer from non existing bank to non existing bank:\n" + PURPLE + bankAccounts[7] +
                                                " To:\n" + bankAccounts[6],
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[6] + " false",
                                () -> testTransferMoney(bank1, bankAccounts[7], bankAccounts[6], 50, false));

                // Test 30: Transfer money by name - valid transfer
                runTest("transfer Money By Name",
                                "transfer 50 from:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                "\n" + bankAccounts[1] + " balance: " + (bankAccounts[1].getBalance() - 1) + "\n" + bankAccounts[5] + " balance: " + (bankAccounts[5].getBalance() + 1) + " true",
                                () -> testTransferMoneyByName(bank1, bankAccounts[1], bankAccounts[5], 1, true));

                // Test 31: Transfer money by name - insufficient funds
                runTest("transfer Money By Name",
                                "transfer 50 from:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance() + " false",
                                () -> testTransferMoneyByName(bank1, bankAccounts[1], bankAccounts[5], 50, false));

                // Test 32: Transfer money by name - negative amount
                runTest("transfer Money By Name",
                                "transfer -50 from:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance(),
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[5] + " balance: " + bankAccounts[5].getBalance() + " false",
                                () -> testTransferMoneyByName(bank1, bankAccounts[1], bankAccounts[5], -50, false));

                // Test 33: Transfer by name - from non-existing account
                runTest("transfer Money By Name",
                                "transfer from none existing bank to existing bank:\n" + PURPLE + bankAccounts[6] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[6],
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[6] + " false",
                                () -> testTransferMoneyByName(bank1, bankAccounts[6], bankAccounts[1], 50, false));

                // Test 34: Transfer by name - to non-existing account
                runTest("transfer Money By Name",
                                "transfer from existing bank to non existing bank:\n" + PURPLE + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() +
                                                " To:\n" + bankAccounts[6],
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[6] + " false",
                                () -> testTransferMoneyByName(bank1, bankAccounts[1], bankAccounts[6], 50, false));

                // Test 35: Transfer by name - between non-existing accounts
                runTest("transfer Money By Name",
                                "transfer from non existing bank to non existing bank:\n" + PURPLE + bankAccounts[7] +
                                                " To:\n" + bankAccounts[6],
                                "\n" + bankAccounts[1] + " balance: " + bankAccounts[1].getBalance() + "\n" + bankAccounts[6] + " false",
                                () -> testTransferMoneyByName(bank1, bankAccounts[7], bankAccounts[6], 50, false));
        }

        private static void exceptionTestsPart3() {
                // Test 1: Testing null object in filterByBalance
                testException("Object cannot be null ",
                                () -> filterByBalanceAccept(null, 50000, false));

                // Test 2: Testing invalid range in FilterByAccountNumber constructor
                testException("max cannot be smaller then min ",
                                () -> testConstructorFilterByAccountNumber(100, 3));

                // Test 3: Testing null bank account in FilterByAccountNumber
                testException("bank account cannot be null",
                                () -> testFilterByAccountNumber(null, 100, 3, true));
        }

        private static void exceptionTestsPart4() {
                Bank bank1 = new Bank();
                int[] balances = {100};
                BankAccount[] bankAccounts = TestUtilities.createBankAccountsArray(balances);
                for (BankAccount bankAccount : bankAccounts) {
                        testAddBankAccount(bank1, bankAccount, true);
                }
                testException("bankAccount cannot be null ",
                                () -> testAddBankAccount(bank1, null, false));
                testException("bankAccount cannot be null ",
                                () -> testDeleteByNameBankAccount(bank1, null, false));
        }

        private static boolean testTransferMoneyByName(Bank bank, BankAccount bankAccountToWithdraw, BankAccount bankAccountToDeposit, int amount, boolean expectedResult) {
                int balanceAccountToWithdraw = bankAccountToWithdraw.getBalance();
                int balanceBankAccountToDeposit = bankAccountToDeposit.getBalance();
                return bank.transferMoney(amount, bankAccountToWithdraw.getAccountNumber(), bankAccountToDeposit.getName()) == expectedResult &&
                                (expectedResult == false ? balanceBankAccountToDeposit == bankAccountToDeposit.getBalance() && balanceAccountToWithdraw == bankAccountToWithdraw.getBalance() : balanceAccountToWithdraw - amount == bankAccountToWithdraw.getBalance() && balanceBankAccountToDeposit + amount == bankAccountToDeposit.getBalance());
        }

        private static boolean testTransferMoney(Bank bank, BankAccount bankAccountToWithdraw, BankAccount bankAccountToDeposit, int amount, boolean expectedResult) {
                int balanceAccountToWithdraw = bankAccountToWithdraw.getBalance();
                int balanceBankAccountToDeposit = bankAccountToDeposit.getBalance();
                return bank.transferMoney(amount, bankAccountToWithdraw.getAccountNumber(), bankAccountToDeposit.getAccountNumber()) == expectedResult &&
                                (expectedResult == false ? balanceBankAccountToDeposit == bankAccountToDeposit.getBalance() && balanceAccountToWithdraw == bankAccountToWithdraw.getBalance() : balanceAccountToWithdraw - amount == bankAccountToWithdraw.getBalance() && balanceBankAccountToDeposit + amount == bankAccountToDeposit.getBalance());
        }

        private static boolean testWithdrawMoneyFromBank(Bank bank, BankAccount bankAccountToWithdraw, int amount, boolean expectedResult) {
                int before = bankAccountToWithdraw.getBalance();
                return bank.withdrawMoney(amount, bankAccountToWithdraw.getAccountNumber()) == expectedResult &&
                                (expectedResult == false ? before == bankAccountToWithdraw.getBalance() : before - amount == bankAccountToWithdraw.getBalance());
        }

        private static boolean testDepositMoneyFromBank(Bank bank, BankAccount bankAccountToDeposit, int amount, boolean expectedResult) {
                int before = bankAccountToDeposit.getBalance();
                return bank.depositMoney(amount, bankAccountToDeposit.getAccountNumber()) == expectedResult &&
                                (expectedResult == false ? before == bankAccountToDeposit.getBalance() : before + amount == bankAccountToDeposit.getBalance());
        }

        private static boolean testDeleteByAccountNumberBankAccount(Bank bank, BankAccount bankAccountToDelete, boolean expectedResult) {
                boolean resultOfDelete = bank.delete(bankAccountToDelete.getAccountNumber()) == expectedResult;
                return resultOfDelete && bank.getAccountNumbersTree().findData(bankAccountToDelete) == null && bank.getNamesTree().findData(bankAccountToDelete) == null;
        }

        private static boolean testDeleteByNameBankAccount(Bank bank, BankAccount bankAccountToDelete, boolean expectedResult) {
                if (bankAccountToDelete == null) {
                        bank.delete(null);
                }
                boolean resultOfDelete = bank.delete(bankAccountToDelete.getName()) == expectedResult;
                return resultOfDelete && bank.getAccountNumbersTree().findData(bankAccountToDelete) == null && bank.getNamesTree().findData(bankAccountToDelete) == null;
        }

        private static boolean testAddBankAccount(Bank bank, BankAccount bankAccountToAdd, boolean expectedResult) {
                if (bankAccountToAdd == null) {
                        bank.delete(null);
                }
                boolean addResult = bank.add(bankAccountToAdd) == expectedResult;
                BankAccount findDatabyAccountNumber = bank.getAccountNumbersTree().findData(bankAccountToAdd);
                BankAccount findDatabyname = bank.getNamesTree().findData(bankAccountToAdd);
                bankAccountToAdd = null;
                if (findDatabyAccountNumber != null) {
                        bankAccountToAdd = findDatabyAccountNumber;
                }
                if (findDatabyname != null) {
                        bankAccountToAdd = findDatabyname;
                }
                if (bankAccountToAdd == null) {
                        return false;
                }
                return addResult;
        }

        private static String buildDescriptionStringForFilter(BankAccount[] bankAccounts) {
                String accountsDescription = "";
                for (BankAccount bankAccount : bankAccounts) {
                        accountsDescription = accountsDescription.concat("\n" + bankAccount.toString());
                }
                return accountsDescription;
        }

        private static boolean testFilterIterator(Integer numbers[], List<Filter<Integer>> filters, Integer[] expectedResult) {
                List<Integer> numberList = Arrays.asList(numbers);

                FilterIterator<Integer> iterator = new FilterIterator<Integer>(numberList, filters);
                Integer[] result = new Integer[expectedResult.length];
                for (int i = 0; iterator.hasNext(); i++) {
                        result[i] = iterator.next();
                }
                return Arrays.equals(result, expectedResult);
        }

        private static boolean testGetAllValidAccounts(BankAccount bankAccounts[], int min, int max, int balance,
                        BankAccount[] expectedResult) {
                List<BankAccount> bankAccountsList = Arrays.asList(bankAccounts);

                List<Filter<BankAccount>> filters = new ArrayList<Filter<BankAccount>>();
                FilterByAccountNumber filterByAccountNumber = new FilterByAccountNumber(min, max);
                FilterByBalance filterByBalance = new FilterByBalance(balance);

                filters.add(filterByAccountNumber);
                filters.add(filterByBalance);

                FilterIterator<BankAccount> iterator = new FilterIterator<BankAccount>(bankAccountsList, filters);
                BankAccount[] result = new BankAccount[expectedResult.length];
                for (int i = 0; iterator.hasNext(); i++) {
                        result[i] = iterator.next();
                }
                if (iterator.hasNext()) {
                        return false;
                }
                return Arrays.equals(result, expectedResult);

        }

        private static void testConstructorFilterByAccountNumber(int min, int max) {
                FilterByAccountNumber filter = new FilterByAccountNumber(min, max);
        }

        private static boolean testFilterByAccountNumber(BankAccount bankAccount, int min, int max, boolean expectedResult) {
                FilterByAccountNumber filter = new FilterByAccountNumber(min, max);
                return filter.accept(bankAccount) == expectedResult;
        }

        private static boolean filterByBalanceAccept(BankAccount bankAccount, int balanceThreshold, boolean expected) {
                FilterByBalance filter = new FilterByBalance(balanceThreshold);
                return filter.accept(bankAccount) == (expected);
        }

        private static <T extends Comparable<T>> boolean testToStringBinaryNode(T[] array, String expectedResult) {
                BinaryTree<T> inputTree = buildBTSTree(array);
                String result = inputTree.toString();
                return result.equals(expectedResult);
        }

        private static <T extends Comparable<T>> BinaryTree<T> buildBTSTree(T[] array) {
                BalancedBinaryTreeTest<T> balancedBinaryTree = new BalancedBinaryTreeTest<>();
                balancedBinaryTree.createBalancedTree(array);
                BinaryTree<T> myBinaryTree = new BinaryTree<>(balancedBinaryTree.getRoot());
                return myBinaryTree;
        }

        private static int AccountComparator(BankAccount account1, BankAccount account2, Comparator<BankAccount> compare) {
                return compare.compare(account1, account2);
        }

        private static boolean testAccountComparatorByAccountName(String accountName1, String accountName2) {
                BankAccount account1 = createBankAcount(accountName1);
                BankAccount account2 = createBankAcount(accountName2);
                AccountComparatorByName comparatorByName = new AccountComparatorByName();
                int result = AccountComparator(account1, account2, comparatorByName);
                if (accountName1.equals(accountName2)) {
                        return result == 0;
                }
                if (accountName1.compareTo(accountName2) < 0) {
                        return result < 0;
                }
                return result > 0;
        }

        private static boolean testAccountComparatorByAccountNumber(int accountNumber1, int accountNumber2) {
                BankAccount account1 = createBankAcount((Integer) accountNumber1);
                BankAccount account2 = createBankAcount((Integer) accountNumber2);
                AccountComparatorByNumber comparatorByNumber = new AccountComparatorByNumber();
                int result = AccountComparator(account1, account2, comparatorByNumber);
                if (accountNumber1 == accountNumber2) {
                        return result == 0;
                }
                if (accountNumber1 < accountNumber2) {
                        return result < 0;
                }
                return result > 0;
        }

        private static boolean testDepositMoney(int balance, int deposit, int expectedResult) {
                BankAccount inputBankAccount = createBankAcount(balance);
                if (deposit < 0) {
                        return false == inputBankAccount.depositMoney(deposit);
                }
                inputBankAccount.depositMoney(deposit);
                return expectedResult == inputBankAccount.getBalance();
        }

        private static boolean testWithdrawMoney(int balance, int withdraw, int expectedResult) {
                BankAccount inputBankAccount = createBankAcount(balance);
                if (withdraw < 0 || withdraw > balance) {
                        return false == inputBankAccount.withdrawMoney(withdraw);
                }
                inputBankAccount.withdrawMoney(withdraw);
                return expectedResult == inputBankAccount.getBalance();
        }

        private static BankAccount createBankAcount(String name) {
                int balance = rand.nextInt(50);
                int accountNumber = rand.nextInt(88) + 1;
                return new BankAccount(name, accountNumber, balance);
        }

        private static BankAccount createBankAcount(int balance) {
                String name = randomString();
                int accountNumber = rand.nextInt(500) + 1;
                return new BankAccount(name, accountNumber, balance);
        }

        private static BankAccount createBankAcount(Integer accountNumber) {
                String name = randomString();
                int balance = rand.nextInt(500);
                return new BankAccount(name, accountNumber, balance);
        }

        private static String randomString() {
                byte[] array = new byte[7];
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));
                return generatedString;
        }

        private static void handleUserInput(Scanner scanner) {
                System.out.println("1 for Part 1\n2 for Part 2\n3 for part 3\n4 for part 4\n6 for all tests" + RED + "\n7 for more info" + RESET_COLOR);
                String part = scanner.nextLine();

                switch (part) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                                runTests(part, scanner);
                                break;
                        case "6":
                                System.out.println("\n--------------------- Part 1 -----------------------------------------");
                                logicTestsPart1();
                                System.out.println("\n--------------------- Part 2 -----------------------------------------");
                                logicTestsPart2();
                                System.out.println("\n--------------------- Part 3 -----------------------------------------");
                                logicTestsPart3();
                                System.out.println("\n--------------------- Part 3 Exceptions ------------------------------");
                                exceptionTestsPart3();
                                System.out.println("\n--------------------- Part 4 -----------------------------------------");
                                logicTestsPart4();
                                System.out.println("\n--------------------- Part 4 Exceptions ------------------------------");
                                exceptionTestsPart4();
                                break;
                        case "7":
                                showInfo();
                                break;
                        default:
                                System.out.println("nope");
                }
        }

        private static void showInfo() {
                System.out.println("this test was created by eyal jacoby");
                System.out.println("© 2025 Eyal Jacoby. Licensed under the MIT License.");
        }

        private static void runTests(String part, Scanner scanner) {
                if (part.equals("1")) {
                        logicTestsPart1();
                } else if (part.equals("2")) {
                        logicTestsPart2();
                } else {
                        System.out.println("\n1 for Logic tests\n2 for for exception testing");
                        String testType = scanner.nextLine();
                        switch (testType) {
                                case "1":
                                        if (part.equals("3"))
                                                logicTestsPart3();
                                        if (part.equals("4")) {
                                                logicTestsPart4();
                                        }
                                        break;
                                case "2":
                                        if (part.equals("3"))
                                                exceptionTestsPart3();
                                        if (part.equals("4")) {
                                                exceptionTestsPart4();
                                        }
                                        break;
                                default:
                                        System.out.println("nope");
                        }
                }

        }

        private static void testException(String description, Runnable test) {
                totalTests++;
                try {
                        test.run();
                        System.out.println(RED + "test failed: Expected exception for " + description + RESET_COLOR);
                } catch (IllegalArgumentException e) {
                        System.out.println(GREEN + "test passed: Caught expected exception for " + description
                                        + RESET_COLOR);
                        passedTests++;
                } catch (Exception e) {
                        System.out.println(RED + "test failed: Unexpected exception for " + description + RESET_COLOR);
                }
        }

        public static void runTest(String testName, String input, String expectedOutput, BooleanTest test) {
                totalTests++;
                boolean result = test.run();
                if (result)
                        passedTests++;

                String passedColor = result ? GREEN : RED;
                String resultString = result ? "Passed" : "Failed";
                String description = String.format("Test %d: %s: input = %s",
                                totalTests, testName, input, resultString);
                description = description + YELLOW + " expected = " + expectedOutput;
                description = description + passedColor + " --> " + resultString;
                System.out.println(passedColor + description + RESET_COLOR + "\n-----------------------------");
        }

        public static void printTestSummary() {
                System.out.println(BLUE + "\nTest Summary:");
                System.out.println(String.format("Total Tests: %d", totalTests));
                int result;
                try {
                        result = (passedTests * 100) / totalTests;
                } catch (ArithmeticException e) {
                        result = 0;
                }

                System.out.println(String.format("Passed: %d (%d%%)", passedTests, result) + RESET_COLOR);
        }

}


