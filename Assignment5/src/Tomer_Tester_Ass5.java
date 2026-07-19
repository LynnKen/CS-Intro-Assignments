import java.math.BigInteger;
import java.util.Comparator;
import java.util.Scanner;


public class Tomer_Tester_Ass5 {
    public static boolean CS(String s1, String s2) {
        return s1.equalsIgnoreCase(s2);
    }
    public static String matrixToString(boolean[][] M) {
        if (M == null) {
            return "null";
        }
        if(M.length==0)
            return "{}";
        String s = "{";
        int i=0;
        for (i = 0; i < M.length-1; i++)
            s+=arrayToString(M[i])+",";
        s+=arrayToString(M[i])+"}";
        return s;
    }
    public static String matrixToString(int[][] M) {
        if (M == null) {
            return "null";
        }
        if(M.length==0)
            return "{}";
        String s = "{";
        int i=0;
        for (i = 0; i < M.length-1; i++)
            s+=arrayToString(M[i])+",";
        s+=arrayToString(M[i])+"}";
        return s;
    }
    public static String matrixToString(String[][] M) {
        if (M == null) {
            return "null";
        }
        if(M.length==0)
            return "{}";
        String s = "{";
        int i=0;
        for (i = 0; i < M.length-1; i++)
            s+=arrayToString(M[i])+",";
        s+=arrayToString(M[i])+"}";
        return s;
    }
    public static String arrayToString(int[] a) {
        if (a == null) {
            return "null";
        }
        if(a.length==0)
            return "{}";
        String s = "{";
        for (int i = 0; i < a.length - 1; i++)
            s += a[i] + ",";
        s += a[a.length - 1] + "}";
        return s;
    }
    public static String arrayToString(boolean[] a) {
        if (a == null) {
            return "null";
        }
        if(a.length==0)
            return "{}";
        String s = "{";
        for (int i = 0; i < a.length - 1; i++)
            s += a[i] + ",";
        s += a[a.length - 1] + "}\n";
        return s;
    }
    public static String arrayToString(String[] a) {
        if (a == null) {
            return "null";
        }
        if(a.length==0)
            return "{}";
        String s = "{";
        for (int i = 0; i < a.length - 1; i++)
            s += a[i] + ",";
        s += a[a.length - 1] + "}";
        return s;
    }
    private static void fail() {
        System.out.println();
        System.out.print("fail: ");
    }
    private static void good() {
        System.out.println("good");
    }
    public static void println(String message) {
        ThePrinter(message, 25);
    }
    public static void space() {
        System.out.println();
    }
    public static void ThePrinter(String message, int speed) {//print at a reduced speed
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(speed); // Sleep 100= 100ms (0.1 seconds)
            } catch (InterruptedException ex) {
            }
        }
        space();
    }

    private static String cleanString(String s1) {
        String ans = "";
        for(int i =1;i<s1.length();i++)
        {
            char c = s1.charAt(i);
            if(s1.charAt(i-1)!= 'r')
            {
                if(isNumber(c))
                {
                    ans += c;
                }
            }
        }
        return ans;
    }
    private static boolean isNumber(char c) {
        if("0123456789(),".indexOf(c)!=-1)
            return true;
        return false;
    }

    private static boolean legalInput(String s) {
        boolean check1, check2, check1D, check2D, check3D, check4D, check3, check4;
        check1 = CS(s, "0") |CS(s, "1") | CS(s, "1.1") | CS(s, "1.2");
        check1D = CS(s, "0 -D") | CS(s, "1 -D") | CS(s, "1.1 -D") | CS(s, "1.2 -D");
        check2 =  CS(s, "2") | CS(s, "2.1");
        check2D =  CS(s, "2 -D") | CS(s, "2.1 -D");
        check3 =  CS(s, "3") | CS(s, "3.2") | CS(s, "3.4") | CS(s, "3.5") |  CS(s, "3.6") | CS(s, "3.7");
        check3D =  CS(s, "3 -D") | CS(s, "3.2 -D") | CS(s, "3.4 -D") | CS(s, "3.5 -D") |  CS(s, "3.6 -D") | CS(s, "3.7 -D");
        check4 =  CS(s, "4");
        check4D =  CS(s, "4 -D");


        return check1 || check2 || check1D || check2D || check3 || check3D || check4D || check4;
    }
    public static void main(String[] args) {
        space();
        println("created by: Tomer Cohen (aka Tomer The Tester)");
        println("for private tutoring: 0584477500");
        space();
        println("put a number (0,1,2 or 1.1,1.2, etc... ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!CS(input, "-1")) {
            while (!legalInput(input)) {
                println("Cant check that, its not a legal number for this Assignment.");
                println("Check out 'read me' file for more information.");
                space();
                println("anything else to check?");
                input = scanner.next();
            }
            whatToCheck(input);
            space();
            println("anything else to check?");
            input = scanner.next();
        }
    }
    private static void whatToCheck(String s) {
        boolean isDisplay =  CS(s, "0 -D") | CS(s, "1.1 -D") | CS(s, "1.2 -D") | CS(s, "1 -D") | CS(s, "2 -D") | CS(s, "2.1 -D") |
                CS(s, "3") | CS(s, "3.2") | CS(s, "3.4") | CS(s, "3.5") |  CS(s, "3.6") | CS(s, "3.7") | CS(s, "4");

        if (isDisplay)
            s = s.substring(0, s.length() - 3);

        if (CS(s, "1") | CS(s, "0") | CS(s, "1.1")) {t11(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.2")) {t12(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.1")) {t21(isDisplay);}
        if (CS(s, "3") | CS(s, "0") | CS(s, "3.2")) {t32(isDisplay);}
        if (CS(s, "3") | CS(s, "0") | CS(s, "3.4")) {t34(isDisplay);}
        if (CS(s, "3") | CS(s, "0") | CS(s, "3.5")) {t35(isDisplay);}
        if (CS(s, "3") | CS(s, "0") | CS(s, "3.6")) {t37(isDisplay);}
        if (CS(s, "3") | CS(s, "0") | CS(s, "3.7")) {t37(isDisplay);}
        if (CS(s, "4") | CS(s, "0")){t4(isDisplay);}
    }

    private static void t11(boolean isDisplay) {
        boolean good = true;
        System.out.println("checking 1.1\n depositMoney :");
        if (isDisplay) {
            System.out.println("test #1: depositing 100 from 0: ");
        }

        BankAccount BA = new BankAccount("BA",1,0);
        BA.depositMoney(100);
        if(isDisplay) System.out.println("depositing 100 from 0: ");
        if(BA.getBalance()!=100)
        {
            fail();
            System.out.println("deposit 100 from 0, should be now 100 but yours is: " + BA.getBalance());
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #2: deposit 10000 from 1000: ");
        BA = new BankAccount("BA",1,1000);
        BA.depositMoney(10000);
        if(BA.getBalance()!=11000)        {
            fail();
            System.out.println("trying to deposit 10000 from 1000, should be now 11000 but yours is: " + BA.getBalance());
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #3: depositing -500 from 1000");
        BA = new BankAccount("BA",1,1000);
        if(BA.depositMoney(-500))
        {
            fail();
            System.out.println("deposit -500 from 1000, should be false");
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        System.out.println("withdrawMoney : ");
        if(isDisplay) System.out.println("withdrawing 100 from 333: ");
        BA = new BankAccount("BA",1,333);
        BA.withdrawMoney(100);
        if(BA.getBalance()!=233)
        {
            fail();
            System.out.println("withdrawing 100 from 333, should be now 233 but yours is: " + BA.getBalance());
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("withdrawing 100 from 33: ");
        BA = new BankAccount("BA",1,33);
        BA.withdrawMoney(100);
        if(BA.withdrawMoney(100))
        {
            fail();
            System.out.println("withdrawing 100 from 33, should be false");
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(good)
            good();
    }
    private static void t12(boolean isDisplay) {
        boolean good = true;
        System.out.println("checking 1.2: by name");

        if(isDisplay) System.out.println("test #1: check acc name yuval vs acc name tomer :");

        BankAccount BA1,BA2;
        BA1= new BankAccount("yuval",1,1);
        BA2= new BankAccount("tomer",1,1);
        Comparator<BankAccount> comp= new AccountComparatorByName();
        boolean check = comp.compare(BA1, BA2)>0;
        if(!check)
        {
            fail();
            System.out.println("the name yuval should be longer than the name tomer and result should be higher than 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #2: check acc name roni vs acc name tamir :");

        BA1= new BankAccount("roni",1,1);
        BA2= new BankAccount("tamir",1,1);
        check = comp.compare(BA1, BA2)<0;
        if(!check) {
            fail();
            System.out.println("the name roni should be shorter than the name tamir and result should be lower than 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #3: check acc name tomer vs acc name tomerhagever :");

        BA1= new BankAccount("tomer",1,1);
        BA2= new BankAccount("tomerhagever",1,1);
        check = comp.compare(BA1, BA2)<0;
        if(!check) {
            fail();
            System.out.println("the name tomer should be shorter than the name tomerhagever and result should be shorter than 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #4: check acc name tomer vs acc name tomer :");

        BA1= new BankAccount("tomer",1,1);
        BA2= new BankAccount("tomer",1,1);
        check = comp.compare(BA1, BA2)==0;
        if(!check) {
            fail();
            System.out.println("the name tomer should be same as the name tomer and result should be 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        System.out.println("checking by number");

        if(isDisplay) System.out.println("test #1: check acc 2 vs acc 1 :");

        BA1= new BankAccount("yuval",2,1);
        BA2= new BankAccount("tomer",1,1);
        comp= new AccountComparatorByNumber();
        check = comp.compare(BA1, BA2)>0;
        if(!check)
        {
            fail();
            System.out.println("2 should be bigger than 1 so result should be higher than 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #2: check acc 1 vs acc 2 :");

        BA1= new BankAccount("roni",1,1);
        BA2= new BankAccount("tamir",2,1);
        check = comp.compare(BA1, BA2)<0;
        if(!check) {
            fail();
            System.out.println("1 should be less than 2 so result should be lower than 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("test #3: check acc 10 vs acc 10 :");

        BA1= new BankAccount("tomer",10,1);
        BA2= new BankAccount("shelly",10,5);
        check = comp.compare(BA1, BA2)==0;

        if(!check) {
            fail();
            System.out.println("10 should be equal to 10 so result should be 0 but yours: " + comp.compare(BA1, BA2) );
            good=false;
        }
        else if(isDisplay)
            System.out.println("good");

        if(good)
            good();
    }
    private static void t21(boolean isDisplay) {
        boolean good = true;
        System.out.println("checking 2.1:");
        String s;
        boolean check;

        if(isDisplay) System.out.println("check tree(2) :");

        Comparator<Integer> comp = Comparator.naturalOrder();
        BinarySearchTree<Integer> BT = new BinarySearchTree<Integer>(comp);
        BT.insert(2);
        s=BT.toString();
        check=CS(s,"tree(2)");
        if(!check) {
            fail();
            System.out.println("should be tree(2) but yours is: " + s );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check tree((1),2) :");

        BT.insert(1);
        s=BT.toString();
        check=CS(s,"tree((1),2)");
        if(!check) {
            fail();
            System.out.println("should be tree((1),2) but yours is: " + s );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check tree((1),2,(3)) :");

        BT.insert(3);
        s=BT.toString();
        check=CS(s,"tree((1),2,(3))");
        if(!check) {
            fail();
            System.out.println("should be tree((1),2,(3)) but yours is: " + s );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check tree((1),2,(3,((5,((7),8,((15),20))),60))) :");

        BT.insert(60);
        BT.insert(5);
        BT.insert(8);
        BT.insert(7);
        BT.insert(20);
        BT.insert(15);
        s=BT.toString();
        check=CS(s,"tree((1),2,(3,((5,((7),8,((15),20))),60)))");
        if(!check) {
            fail();
            System.out.println("should be tree((1),2,(3,((5,((7),8,((15),20))),60))) but yours is: " + s );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check tree((((6),7),8),9,(10,(12,((13),14)))) :");

        BT = new BinarySearchTree<Integer>(comp);
        BT.insert(9);
        BT.insert(8);
        BT.insert(7);
        BT.insert(6);
        BT.insert(10);
        BT.insert(12);
        BT.insert(14);
        BT.insert(13);
        s=BT.toString();
        check=CS(s,"tree((((6),7),8),9,(10,(12,((13),14))))");
        if(!check) {
            fail();
            System.out.println("should be tree((((6),7),8),9,(10,(12,((13),14)))) but yours is: " + s );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(good)
            good();
        System.out.println();

        if(good)
            good();
    }
    private static void t32(boolean isDisplay){
        boolean good=true;
        String s;
        boolean check;
        System.out.println("checking 3.2:");

        if(isDisplay) System.out.println("check tree(1) :");

        Comparator<BankAccount> comp = new AccountComparatorByNumber();
        BankAccountsBinarySearchTree BT = new BankAccountsBinarySearchTree(comp);
        BankAccount BA= new BankAccount("tomer",1,1);
        BinaryBalancedTree<BankAccount> checker = new BinaryBalancedTree<BankAccount>(BA);
        BT.insert(BA);
        BT.balance();
        s="tree"+cleanString(BT.toString());
        check=checker.isBalanced(BT.root);
        if(!check) {
            fail();
            System.out.println("input tree(1) should be balanced but yours is: " + s );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        BA= new BankAccount("tomer",2,1);
        BT.insert(BA);
        BA= new BankAccount("tomer",3,1);
        BT.insert(BA);
        String CD = "tree"+cleanString(BT.toString());
        BT.balance();
        s="tree"+cleanString(BT.toString());
        check=checker.isBalanced(BT.root);
        if(isDisplay) System.out.println("check "+CD+ " :");
        if(!check) {
            fail();
            System.out.println("input tree(1,(2,(3))) should be balanced but yours is: " + s );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        int[] insert0 = {4,2,1,3,6,7,8,5};
        int[] insert1 = {5,2,1,4,3,6,7,8};
        int[] insert2 = {2,1,3,4,5,6,7,8};
        int[] insert3 = {8,7,6,5,4,3,2,1};
        int[] insert4 = {50,17,9,14,12,76,54,72,67};
        int[] insert5 = {10,8,2,1,6,4,3,5,11,14,13,16};
        int[] insert6 = {13,3,1,2,4,12,10,5,8,7,6,9,11,14,18};
        int[][] matrix = new int[7][];
        matrix[0]=insert0;matrix[1]=insert1;matrix[2]=insert2;matrix[3]=insert3;
        matrix[4]=insert4;matrix[5]=insert5;matrix[6]=insert6;
        for(int j=0;j<matrix.length;j++) {
            BT = new BankAccountsBinarySearchTree(comp);
            for(int i=0;i<matrix[j].length;i++){
                BA= new BankAccount("tomer",matrix[j][i],1);
                BT.insert(BA);
                s="tree"+cleanString(BT.toString());
            }
            CD = "tree"+cleanString(BT.toString());
            BT.balance();
            s="tree"+cleanString(BT.toString());
            check=checker.isBalanced(BT.root);
            if(isDisplay) System.out.println("check "+CD+ " :");
            if(!check) {
                fail();
                System.out.println("the tree: "+ CD +" should be balanaced but yours is: " + s );
                good=false;
            }else if(isDisplay)
                System.out.println("good");
        }
        if(good)
            good();
    }
    private static void t34(boolean isDisplay){
        boolean good=true;
        String s;
        boolean check;
        System.out.println("checking 3.4:");

        if(isDisplay) System.out.println("check 1 and Threshold 100 :");

        BankAccount BA= new BankAccount("tomer",1,1);
        Filter<BankAccount> fil = new FilterByBalance(100);
        check = fil.accept(BA);
        if(check) {
            fail();
            System.out.println("check 1 and Threshold 100 should be false but yours is: " + check );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check 100 and Threshold 100 :");

        BA= new BankAccount("tomer",1,100);
        check = fil.accept(BA);
        if(!check) {
            fail();
            System.out.println("check 100 and Threshold 100 should be true but yours is: " + check );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check 1000 and Threshold 100 :");

        BA= new BankAccount("tomer",1,1000);
        check = fil.accept(BA);
        if(!check) {
            fail();
            System.out.println("check 1000 and Threshold 100 should be true but yours is: " + check );
            good=false;
        } else if(isDisplay)
            System.out.println("good");

        if(good)
            good();
    }
    private static void t35(boolean isDisplay){
        boolean good=true;
        String s;
        boolean check;
        System.out.println("checking 3.5:");

        if(isDisplay) System.out.println("check 1 and Threshold 100 to 200 :");

        BankAccount BA= new BankAccount("tomer",1,1);
        FilterByAccountNumber fil = new FilterByAccountNumber(100,200);
        check = fil.accept(BA);

        if(check) {
            fail();
            System.out.println("check 1 and Threshold 100 to 200 should be false but yours is: " + check );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check 100 and Threshold 100 to 200 :");

        BA= new BankAccount("tomer",100,1);
        check = fil.accept(BA);
        if(!check) {
            fail();
            System.out.println("check 100 and Threshold 100 to 200 should be true but yours is: " + check );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check 150 and Threshold 100 to 200 :");

        BA= new BankAccount("tomer",150,1);
        check = fil.accept(BA);
        if(!check) {
            fail();
            System.out.println("check 150 and Threshold 100 to 200 should be true but yours is: " + check );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        if(isDisplay) System.out.println("check 1000 and Threshold 100 to 200:");

        BA= new BankAccount("tomer",1000,1000);
        check = fil.accept(BA);
        if(check) {
            fail();
            System.out.println("input 1000 and Threshold 100 to 200 should be false but yours is: " + check );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        if(good)
            good();

    }
    private static void t37(boolean isDisplay){
        boolean good=true;
        String s;
        boolean check;
        BankAccount BA;
        BankAccountsBinarySearchTree BT;
        Comparator<BankAccount> comp = new AccountComparatorByNumber();

        System.out.println("checking 3.7 and 3.6 together:");

        int[][] matrix = new int[5][];
        int[] i0 = {2,3,4};
        int[] i1 = {1,3,5};
        int[] i2 = {1,2,3,4,5,6,7,8};
        int[] i3 = {1,5,6,7,8,9,10};
        int[] i4 = {};
        String[] ans0 = {"2,3,4","3","2,3,4","",""};
        matrix[0] = i0;matrix[1] = i1;matrix[2]=i2;matrix[3]=i3;matrix[4]=i4;
        for(int j=0;j<matrix.length;j++) {
            BT = new BankAccountsBinarySearchTree(comp);
            for(int i=0;i<matrix[j].length;i++){
                BA= new BankAccount("tomer",matrix[j][i],100000);
                BT.insert(BA);
            }
            if(isDisplay) System.out.println("creating new list for the filtered accounts");
            List<BankAccount> l = BankAccountFiltering.getAllValidAccounts(BT, 10000, 2, 4);
            String CD = cleanString(BT.toString());
            if(isDisplay) System.out.println("check "+ CD + " and Threshhold for account number is 2 to 4 (balance is fine):");
            check = CS(cleanString(l.toString()),ans0[j]);
            if(!check) {
                fail();
                System.out.println("input "+CD+" should be "+ans0[j]+" but yours is: " +cleanString(l.toString()));
                good=false;
            }else if(isDisplay)
            System.out.println("good");
        }

        int[] i00 = {2,3,4,7};
        int[] i10 = {1,3,6};
        int[] i20 = {1,2,3,4,5,6,7,8};
        int[] i30 = {1,2,3,4};
        int[] i40 = {};
        String[] ans00 = {"7","6","5,6,7,8","",""};
        matrix[0] = i00;matrix[1] = i10;matrix[2]=i20;matrix[3]=i30;matrix[4]=i40;
        for(int j=0;j<matrix.length;j++) {
            BT = new BankAccountsBinarySearchTree(comp);
            for(int i=0;i<matrix[j].length;i++){
                BA= new BankAccount("tomer",matrix[j][i],matrix[j][i]);
                BT.insert(BA);
            }
            if(isDisplay) System.out.println("creating new list for the filtered accounts");
            List<BankAccount> l = BankAccountFiltering.getAllValidAccounts(BT, 5, 1, 10);
            String CD = cleanString(BT.toString());
            if(isDisplay) System.out.println("check "+ CD + " where balance min is 5 (account number is fine):");
            check = CS(cleanString(l.toString()),ans00[j]);
            if(!check) {
                fail();
                System.out.println("input "+CD+" should be "+ans00[j]+" but yours is: " +cleanString(l.toString()));
                good=false;
            }else if(isDisplay)
                System.out.println("good");
        }

        if(good)
            good();

    }
    private static void t4(boolean isDisplay) {
        boolean good=true;
        String s;
        boolean check;
        System.out.println("checking 4: add");
        if(isDisplay)System.out.println("adding to the bank 3 account: tomer 1 10000 , dolev 2 5 and yuval 3 900");
        Bank TOMER = new Bank();
        BankAccount BA = new BankAccount("tomer",1,10000);
        check=TOMER.add(BA);
        if(isDisplay) System.out.println("adding tomer :");
        if(!check) {
            fail();
            System.out.println("trying to add tomer, should be true but yours is : "+ check);
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        BA = new BankAccount("dolev",2,5);
        TOMER.add(BA);
        BA = new BankAccount("yuval",3,900);
        TOMER.add(BA);


        s=cleanString(TOMER.lookUp(1).toString());
        check=CS(s,"1");
        if(isDisplay) System.out.println("check for account tomer 1 10000 by account number :");
        if(!check) {
            fail();
            System.out.println("input tomer 1 10000 by account number should be 1 but yours is: " + s );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        s=cleanString(TOMER.lookUp(2).toString()).substring(1);
        check=CS(s,"2");
        if(isDisplay) System.out.println("check for account dolev 2 5 by account number :");
        if(!check) {
            fail();
            System.out.println("input dolev 2 5 by account number should be 2 but yours is: " + s );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        s=cleanString(TOMER.lookUp("yuval").toString()).substring(1);
        check=CS(s,"3");
        if(isDisplay) System.out.println("check for account yuval 3 90 by name :");
        if(!check) {
            fail();
            System.out.println("input yuval 3 90 by name should be 3 but yours is: " + s );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        BA = new BankAccount("tomer",1,10000);
        check = TOMER.add(BA);
        if(isDisplay) System.out.println("trying to add tomer again :");
        if(check) {
            fail();
            System.out.println("input tomer 1 10000 all ready in so add should be false but yours is: " + check );
            good=false;
        }else if(isDisplay)
            System.out.println("good");

        if(good) {
            good();

            System.out.println("delete (both delete):");
            if(isDisplay)System.out.println();
            if(isDisplay)System.out.println("deleting all the account, tomer and dolev by acc number and yuval by name");
            check=TOMER.delete(1);
            if(isDisplay) System.out.println("deleting tomer :");
            if(!check) {
                fail();
                System.out.println("trying to delete tomer, should be true but yours is : "+ check);
                good=false;
            }else if(isDisplay)
                System.out.println("good");

            TOMER.delete(2);
            TOMER.delete("yuval");

            check=TOMER.lookUp(1)==null;
            if(isDisplay) System.out.println("check for account tomer 1 10000 by account number :");
            if(!check) {
                fail();
                System.out.println("input tomer 1 10000 by account number should not find but yours said it did");
                good=false;
            }else if(isDisplay)
                System.out.println("good");

            check=TOMER.lookUp(2)==null;
            if(isDisplay) System.out.println("check for account dolev 2 5 by account number :");
            if(!check) {
                fail();
                System.out.println("input dolev 2 5 by account number should not find but yours said it did");
                good=false;
            }else if(isDisplay)
                System.out.println("good");

            check=TOMER.lookUp("yuval")==null;
            if(isDisplay) System.out.println("check for account yuval 3 90 by name :");
            if(!check) {
                fail();
                System.out.println("input yuval 3 90 by name should not find but yours said it did");
                good=false;
            }else if(isDisplay)
                System.out.println("good");

            BA = new BankAccount("tomer",1,10000);
            check = TOMER.delete("tomer");
            if(isDisplay) System.out.println("trying to delete tomer again :");
            if(check) {
                fail();
                System.out.println("cant delete tomer again but yours said it did");
                good=false;
            }else if(isDisplay)
                System.out.println("good");

            if(good) {
                good();

                System.out.println("depositMoney:");
                if(isDisplay)System.out.println("adding tomer with 100");
                BA = new BankAccount("tomer",1,100);
                TOMER.add(BA);
                if(isDisplay)System.out.println("depositing to tomer 100 money: ");
                check = TOMER.depositMoney(100,1);
                if(!check) {
                    fail();
                    System.out.println("trying to deposit tomer, should be true but yours is : "+ check);
                    good=false;
                }else if(isDisplay)
                    System.out.println("good");

                check=TOMER.lookUp(1).getBalance()==200;
                if(isDisplay) System.out.println("check for account tomer if he has 200 now:");
                if(!check) {
                    fail();
                    System.out.println("after adding to tomer 100 when he had 100 should be 200 but yours is: " + TOMER.lookUp(1).getBalance() );
                    good=false;
                }else if(isDisplay)
                    System.out.println("good");

                if(isDisplay) System.out.println("trying to add money to a number with no account:");
                check = TOMER.depositMoney(100,2);
                if(check) {
                    fail();
                    System.out.println("trying to add money to a number with no account should be false, but yours is: "+ check );
                    good=false;
                }else if(isDisplay)
                    System.out.println("good");

                if(good) {
                    good();

                    System.out.println("withrawMoney:");
                    if(isDisplay)System.out.println("withrawing from tomer 150 money:");
                    check = TOMER.withdrawMoney(150,1);
                    if(!check) {
                        fail();
                        System.out.println("trying to withraw 150 from tomer who has 200, should be true but yours is : "+ check);
                        good=false;
                    }else if(isDisplay)
                        System.out.println("good");

                    check=TOMER.lookUp(1).getBalance()==50;
                    if(isDisplay) System.out.println("check for account tomer if he has 50 now:");
                    if(!check) {
                        fail();
                        System.out.println("after withraw from from tomer who has 200, should has now 50 but yours is: " + TOMER.lookUp(1).getBalance() );
                        good=false;
                    }else if(isDisplay)
                        System.out.println("good");

                    if(isDisplay) System.out.println("trying to withraw 150 from tomer who has 50:");
                    check = TOMER.withdrawMoney(150,1);
                    if(check) {
                        fail();
                        System.out.println("trying to withraw 150 from tomer who has 50 , should be false but yours is : "+ check);
                        good=false;
                    }else if(isDisplay)
                        System.out.println("good");

                    check = TOMER.withdrawMoney(100,2);
                    if(check) {
                        fail();
                        System.out.println("trying to withraw to a number that has no account should be false, but yours is: "+ check );
                        good=false;
                    }//if
                    if(good) {
                        good();
                        System.out.println();

                        System.out.println("transferMoney by numbers:");
                        if(isDisplay)System.out.println("adding noa with 100");
                        BA = new BankAccount("noa",2,100);
                        TOMER.add(BA);
                        if(isDisplay)System.out.println("transferring from noa to tomer 60 money:");
                        check = TOMER.transferMoney(60,2,1);
                        if(!check) {
                            fail();
                            System.out.println("trying to transfer from noa to tomer 60 money, should be true but yours is : "+ check);
                            good=false;
                        }else if(isDisplay)
                            System.out.println("good");

                        check=TOMER.lookUp(1).getBalance()==110;
                        if(isDisplay) System.out.println("check for account tomer if he has 110 now:");
                        if(!check) {
                            fail();
                            System.out.println("after adding to tomer 60 when he had 50 should be 110 but yours is: " + TOMER.lookUp(1).getBalance() );
                            good=false;
                        }else if(isDisplay)
                            System.out.println("good");

                        check=TOMER.lookUp(2).getBalance()==40;
                        if(isDisplay) System.out.println("check for account noa if she has 40 now:");
                        if(!check) {
                            fail();
                            System.out.println("after withdrawing from noa 60 when she had 100 should be 40 but yours is: " + TOMER.lookUp(1).getBalance() );
                            good=false;
                        }else if(isDisplay)
                            System.out.println("good");

                        if(isDisplay)System.out.println("transferring from noa to tomer another 60 money:");
                        check = TOMER.transferMoney(60,2,1);
                        if(check) {
                            fail();
                            System.out.println("trying to transfer from noa to tomer 60 money, should be false since noa dosent have 60 money ,but yours is : "+ check);
                            good=false;
                        }else if(isDisplay)
                            System.out.println("good");

                        if(isDisplay) System.out.println("transferring from tomer to no a real account 60 money:");
                        check = TOMER.transferMoney(60,1,3);
                        if(check) {
                            fail();
                            System.out.println("trying to transfer from tomer to not a real account 60 money, should be false but yours is : "+ check);
                            good=false;
                        }else if(isDisplay)
                            System.out.println("good");

                        if(isDisplay) System.out.println("transferring from not a real account to tomer 60 money:");
                        check = TOMER.transferMoney(60,3,1);
                        if(check) {
                            fail();
                            System.out.println("trying to transfer from no a real account  to tomer 60 money, should be false but yours is : "+ check);
                            good=false;
                        }else if(isDisplay)
                            System.out.println("good");

                        if(good) {
                            good();

                            System.out.println("transferMoney by name:");
                            if(isDisplay)System.out.println("adding segev with 100");
                            BA = new BankAccount("segev",4,100);
                            TOMER.add(BA);
                            if(isDisplay)System.out.println("adding guy with 100");
                            BA = new BankAccount("guy",5,100);
                            TOMER.add(BA);

                            if(isDisplay)System.out.println("transferring from segev to guy 60 money:");
                            check = TOMER.transferMoney(60,4,"guy");
                            if(!check) {
                                fail();
                                System.out.println("trying to transfer from segev to guy 60 money, should be true but yours is : "+ check);
                                good=false;
                            }else if(isDisplay)
                                System.out.println("good");

                            check=TOMER.lookUp(5).getBalance()==160;
                            if(isDisplay) System.out.println("check for account guy if he has 160 now:");
                            if(!check) {
                                fail();
                                System.out.println("after adding to guy 60 when he had 100 should be 160 but yours is: " + TOMER.lookUp(1).getBalance() );
                                good=false;
                            }else if(isDisplay)
                                System.out.println("good");

                            check=TOMER.lookUp(4).getBalance()==40;
                            if(isDisplay) System.out.println("check for account segev if she has 40 now:");
                            if(!check) {
                                fail();
                                System.out.println("after withdrawing from segev 60 when he had 100 should be 40 but yours is: " + TOMER.lookUp(1).getBalance() );
                                good=false;
                            }else if(isDisplay)
                                System.out.println("good");

                            if(isDisplay)System.out.println("transferring from segev to guy another 60 money:");
                            check = TOMER.transferMoney(60,4,"guy");
                            if(check) {
                                fail();
                                System.out.println("trying to transfer from segev to guy 60 money, should be false since segev dosent have 60 money ,but yours is : "+ check);
                                good=false;
                            }else if(isDisplay)
                                System.out.println("good");

                            if(isDisplay) System.out.println("transferring from guy to no a real account 60 money:");
                            check = TOMER.transferMoney(60,5,"test");
                            if(check) {
                                fail();
                                System.out.println("trying to transfer from segev to not a real account 60 money, should be false but yours is : "+ check);
                                good=false;
                            }else if(isDisplay)
                                System.out.println("good");

                            if(isDisplay) System.out.println("transferring from not a real account to guy account 60 money:");
                            check = TOMER.transferMoney(60,10,"guy");
                            if(check) {
                                fail();
                                System.out.println("trying to transfer from no a real account to guy 60 money, should be false but yours is : "+ check);
                                good=false;
                            }else if(isDisplay)
                                System.out.println("good");

                            if(good)
                                good();
                            System.out.println();
                        }}}}}

    }










}
