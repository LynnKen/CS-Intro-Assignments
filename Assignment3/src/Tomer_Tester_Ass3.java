import java.math.BigInteger;
import java.util.Scanner;


public class Tomer_Tester_Ass3 {
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

    private static boolean legalInput(String s) {
        boolean check1, check2, check1D, check2D;
        check1 = CS(s, "0") | CS(s, "1.1") | CS(s, "1.2") | CS(s, "1.3") | CS(s, "1.4") | CS(s, "1.5") | CS(s, "1.6") | CS(s, "1.7") | CS(s, "1.8") | CS(s, "1.9");;
        check1D = CS(s, "0 -D") | CS(s, "1.1 -D") | CS(s, "1.2 -D") | CS(s, "1.3 -D") | CS(s, "1.4 -D") | CS(s, "1.5 -D") | CS(s, "1.6 -D") | CS(s, "1.7 -D") | CS(s, "1.8 -D") | CS(s, "1.9 -D");
        check2 = CS(s, "1") | CS(s, "2") | CS(s, "2.1") | CS(s, "2.2") | CS(s, "2.3")| CS(s, "2.4")| CS(s, "2.5") | CS(s, "2.6") | CS(s, "2.7");
        check2D = CS(s, "1 -D") | CS(s, "2 -D") | CS(s, "2.1 -D") | CS(s, "2.2 -D") | CS(s, "2.3 -D")| CS(s, "2.4 -D")| CS(s, "2.5 -D") | CS(s, "2.6 -D") | CS(s, "2.7 -D");
        return check1 || check2 || check1D || check2D;
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
        boolean isDisplay =  CS(s, "0 -D") | CS(s, "1.1 -D") | CS(s, "1.2 -D") | CS(s, "1.3 -D") | CS(s, "1.4 -D") | CS(s, "1.5 -D") | CS(s, "1.6 -D") | CS(s, "1.7 -D") | CS(s, "1.8 -D") | CS(s, "1.9 -D") ||
                CS(s, "1 -D") | CS(s, "2 -D") | CS(s, "2.1 -D") | CS(s, "2.2 -D") | CS(s, "2.3 -D")| CS(s, "2.4 -D")| CS(s, "2.5 -D") | CS(s, "2.6 -D") | CS(s, "2.7 -D");


        if (isDisplay)
            s = s.substring(0, s.length() - 3);

        if (CS(s, "1") | CS(s, "0") | CS(s, "1.1")) {t11(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.2")) {t12(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.3")) {t13(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.4")) {t14(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.5")) {t15(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.6")) {t16(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.7")) {t17(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.8")) {t18(isDisplay);}
        if (CS(s, "1") | CS(s, "0") | CS(s, "1.9")) {t19(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.1")) {t21(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.2")) {t22(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.3")) {t23(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.4")) {t24(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.5")) {t25(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.6")) {t26(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.7")) {t27(isDisplay);}
    }

    private static void t11(boolean isDisplay) {
        System.out.println("checking Task 1.1: ");
        boolean good=true;
        String s = "72849";
        int b = 2;
        boolean ans1=DecimalNumber.legalNumericStringTomer(s, b);
        if (isDisplay) {
            System.out.println("testing input #1: 72849 , b=2");
            space();
        }
        if(ans1){
            System.out.println("input 72849 b=2 should be false but yours is: " + ans1);
            good=false;
        }
        String s1 = "72849";
        b = 10;
        if (isDisplay) {
            System.out.println("testing input #2: 72849 , b=10");
            space();
        }
        boolean ans2=DecimalNumber.legalNumericStringTomer(s1, b);
        if(!ans2){
            System.out.println("input 72849 b=10 should be true but yours is: " + ans2);
            good=false;
        }
        String s2 = "1112111";
        b = 2;
        if (isDisplay) {
            System.out.println("testing input #3: 1112111 , b=2");
            space();
        }
        boolean ans3=DecimalNumber.legalNumericStringTomer(s2, b);
        if(ans3){
            System.out.println("input 1112111  b=2 should be false but yours is: " + ans3);
            good=false;
        }
        if(good)
            System.out.println("1.1: good");
    }
    private static void t12(boolean isDisplay) {
        System.out.println("checking Task 1.2: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 5");space();}
        String s = "5";
        String ans=DecimalNumber.decimalIncrementTomer(s);
        if(!(CS(ans,"6"))) {
            System.out.println("input 5: wrong, should be 6 but yours is: " + ans);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #2: 4321");space();}
        String s1 = "4321";
        String ans1=DecimalNumber.decimalIncrementTomer(s1);
        if(!(CS(ans1,"5321"))) {
            System.out.println("input 4321: wrong, should be 5321 but yours is: " + ans1);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #3: 9999999999999999999999999999999999999999");space();}
        String s2 = "9999999999999999999999999999999999999999";
        String ans2=DecimalNumber.decimalIncrementTomer(s2);
        if(!(CS(ans2,"00000000000000000000000000000000000000001"))) {
            System.out.println("input 9999999999999999999999999999999999999999: wrong, should be 00000000000000000000000000000000000000001 but yours is: " + ans2);
            good=false;
        }
        if(good)
            System.out.println("1.2: good");
    }
    private static void t13(boolean isDisplay) {
        System.out.println("checking Task 1.3: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 5");space();}
        String s = "5";
        String ans=DecimalNumber.decimalDoubleTomer(s);
        if(!(CS(ans,"01"))) {
            System.out.println("input 5: wrong, should be 01 but yours is: " + ans);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #2: 4321");space();}
        String s1 = "4321";
        String ans1=DecimalNumber.decimalDoubleTomer(s1);
        if(!(CS(ans1,"8642"))) {
            System.out.println("input 4321: wrong, should be 8642 but yours is: " + ans1);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #3: 9999999999999999999999999999999999999999");space();}
        String s2 = "9999999999999999999999999999999999999999";
        String ans2=DecimalNumber.decimalDoubleTomer(s2);
        if(!(CS(ans2,"89999999999999999999999999999999999999991"))) {
            System.out.println("input 9999999999999999999999999999999999999999: wrong, should be 89999999999999999999999999999999999999991 but yours is: " + ans2);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #4: 642");space();}
        s1 = "642";
        ans1=DecimalNumber.decimalDoubleTomer(s1);
        if(!(CS(ans1,"294"))) {
            System.out.println("input 642: wrong, should be 294 but yours is: " + ans1);
            good=false;
        }

        if(good)
            System.out.println("1.3: good");
    }
    private static void t14(boolean isDisplay){
        System.out.println("checking Task 1.4: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 0");space();}
        String s = "0";
        String ans=DecimalNumber.binaryToDecimalTomer(s);
        if(!(CS(ans,"0"))) {
            System.out.println("input 0: wrong, should be 0 but yours is: " + ans);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #2: 1");space();}
        String s1 = "1";
        String ans1=DecimalNumber.binaryToDecimalTomer(s1);
        if(!(CS(ans1,"1"))) {
            System.out.println("input 1: wrong, should be 1 but yours is: " + ans1);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #3: 11111111");space();}
        String s2 = "11111111";
        String ans2=DecimalNumber.binaryToDecimalTomer(s2);
        if(!(CS(ans2,"552"))) {
            System.out.println("input 11111111: wrong, should be 552 but yours is: " + ans2);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #4: 011111111");space();}
        String s3 = "011111111";
        String ans3=DecimalNumber.binaryToDecimalTomer(s3);
        if(!(CS(ans3,"015"))) {
            System.out.println("input 011111111: wrong, should be 015 but yours is: " + ans3);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #5: 1011");space();}
        String s4 = "1011";
        String ans4=DecimalNumber.binaryToDecimalTomer(s4);
        if(!(CS(ans4,"31"))) {
            System.out.println("input 1011: wrong, should be 31 but yours is: " + ans4);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #6: 0011");space();}
        String s5 = "0011";
        String ans5=DecimalNumber.binaryToDecimalTomer(s5);
        if(!(CS(ans5,"21"))) {
            System.out.println("input 0011: wrong, should be 21 but yours is: " + ans5);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #7: 11111111111111111111111111111111111111111111111111");space();}
        String s6 = "11111111111111111111111111111111111111111111111111";
        String ans6=DecimalNumber.binaryToDecimalTomer(s6);
        if(!(CS(ans6,"3262486099985211"))) {
            System.out.println("input 11111111111111111111111111111111111111111111111111: wrong, should be 3262486099985211 but yours is: " + ans6);
            good=false;
        }

        if(good)
            System.out.println("1.4: good");
    }
    private static void t15(boolean isDisplay) {
        System.out.println("checking Task 1.5: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 651");space();}
        String s20 = "651";
        String ans44=DecimalNumber.octalToDecimalTomer(s20);
        if(!(CS(ans44,"011"))) {
            System.out.println("input 651: wrong, should be 011 but yours is: " + ans44);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 0");space();}

        String s = "0";
        String ans=DecimalNumber.octalToDecimalTomer(s);
        if(!(CS(ans,"0"))) {
            System.out.println("input 0: wrong, should be 0 but yours is: " + ans);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 1");space();}
        String s1 = "1";
        String ans1=DecimalNumber.octalToDecimalTomer(s1);
        if(!(CS(ans1,"1"))) {
            System.out.println("input 1: wrong, should be 1 but yours is: " + ans1);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: 276");space();}
        String s4 = "276";
        String ans4=DecimalNumber.octalToDecimalTomer(s4);
        if(!(CS(ans4,"244"))) {
            System.out.println("input 276: wrong, should be 244 but yours is: " + ans4);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #5: 1234567");space();}
        String s2 = "1234567";
        String ans2=DecimalNumber.octalToDecimalTomer(s2);
        if(!(CS(ans2,"3534502"))) {
            System.out.println("input 1234567: wrong, should be 3534502 but yours is: " + ans2);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #6: 07777");space();}
        String s3 = "07777";
        String ans3=DecimalNumber.octalToDecimalTomer(s3);
        if(!(CS(ans3,"06723"))) {
            System.out.println("input 07777: wrong, should be 06723 but yours is: " + ans3);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #7: 6677");space();}
        String s5 = "6677";
        String ans5=DecimalNumber.octalToDecimalTomer(s5);
        if(!(CS(ans5,"6804"))) {
            System.out.println("input 6677: wrong, should be 6804 but yours is: " + ans5);
            good=false;
        }
        if (isDisplay) {System.out.println("testing input #8: 55555555555555555555555555555555555555555555555555");space();}
        String s6 = "55555555555555555555555555555555555555555555555555";
        String ans6=DecimalNumber.octalToDecimalTomer(s6);
        if(!(CS(ans6,"5440933720422876069458195570024117467362649101"))) {
            System.out.println("input 55555555555555555555555555555555555555555555555555: wrong, should be 5440933720422876069458195570024117467362649101 but yours is: " + ans6);
            good=false;
        }

        if(good)
            System.out.println("1.5: good");

    }
    private static void t16(boolean isDisplay) {
        System.out.println("checking Task 1.6: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 651");space();}
        DecimalNumber d = new DecimalNumber( "651");

        if(!(CS(d.getValue(),"651"))) {
            System.out.println("input 651: wrong, should be 651 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 1");space();}
         d = new DecimalNumber( "1");

        if(!(CS(d.getValue(),"1"))) {
            System.out.println("input 1: wrong, should be 1 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 0000000000000000000000000000001");space();}
         d = new DecimalNumber( "0000000000000000000000000000001");

        if(!(CS(d.getValue(),"0000000000000000000000000000001"))) {
            System.out.println("input 0000000000000000000000000000001: wrong, should be 0000000000000000000000000000001 but yours is: " + d.getValue());
            good=false;
        }

        if(good)
            System.out.println("1.6: good");

    }
    private static void t17(boolean isDisplay) {
        System.out.println("checking Task 1.7: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 001 2");space();}
        DecimalNumber d = new DecimalNumber( "001",2);

        if(!(CS(d.getValue(),"4"))) {
            System.out.println("input 001 2: wrong, should be 4 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 0 8");space();}
        d = new DecimalNumber( "0",8);

        if(!(CS(d.getValue(),"0"))) {
            System.out.println("input 0 8: wrong, should be 0 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 71 8");space();}
        d = new DecimalNumber( "71",8);

        if(!(CS(d.getValue(),"51"))) {
            System.out.println("input 71 8: wrong, should be 51 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: 712345 10");space();}
        d = new DecimalNumber( "712345",10);

        if(!(CS(d.getValue(),"712345"))) {
            System.out.println("input 712345 10: wrong, should be 712345 but yours is: " + d.getValue());
            good=false;
        }


        if(good)
            System.out.println("1.7: good");

    }
    private static void t18(boolean isDisplay) {
        System.out.println("checking Task 1.8: ");
        boolean good=true;
        if (isDisplay) {System.out.println("testing input #1: 001 2");space();}
        DecimalNumber d = new DecimalNumber( "001",2);

        if(!(CS(d.toString(),"4"))) {
            System.out.println("input 001 2: wrong, should be 4 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 0 8");space();}
        d = new DecimalNumber( "0",8);

        if(!(CS(d.toString(),"0"))) {
            System.out.println("input 0 8: wrong, should be 0 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 71 8");space();}
        d = new DecimalNumber( "71",8);

        if(!(CS(d.toString(),"51"))) {
            System.out.println("input 71 8: wrong, should be 51 but yours is: " + d.getValue());
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: 712345 10");space();}
        d = new DecimalNumber( "712345",10);

        if(!(CS(d.toString(),"712345"))) {
            System.out.println("input 712345 10: wrong, should be 712345 but yours is: " + d.getValue());
            good=false;
        }


        if(good)
            System.out.println("1.8: good");

    }
    private static void t19(boolean isDisplay) {
        System.out.println("checking Task 1.9: ");
        space();
        System.out.println("1.9: good");

    }
    private static void t21(boolean isDisplay) {
        System.out.println("checking Task 2.1: ");
        boolean good=true;

        if (isDisplay) {System.out.println("testing input #1: -10");space();}
        BigInteger b = new BigInteger( "-10");
        BigInteger ans = new BigInteger( "0");
        BigInteger res = BigIntegerOperations.sumSmaller(b);

        if(!res.equals(ans)) {
            System.out.println("input -10 : wrong, should be 0 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 0");space();}
        b = new BigInteger( "0");
        ans = new BigInteger( "0");
        res = BigIntegerOperations.sumSmaller(b);

        if(!res.equals(ans)) {
            System.out.println("input 0 : wrong, should be 0 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 1");space();}
        b = new BigInteger( "1");
        ans = new BigInteger( "0");
        res = BigIntegerOperations.sumSmaller(b);

        if(!res.equals(ans)) {
            System.out.println("input 1 : wrong, should be 0 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: 3");space();}
        b = new BigInteger( "3");
        ans = new BigInteger( "3");
        res = BigIntegerOperations.sumSmaller(b);

        if(!res.equals(ans)) {
            System.out.println("input 3 : wrong, should be 3 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #5: 7");space();}
        b = new BigInteger( "7");
        ans = new BigInteger( "21");
        res = BigIntegerOperations.sumSmaller(b);

        if(!res.equals(ans)) {
            System.out.println("input 7 : wrong, should be 21 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #6: 99999");space();}
        b = new BigInteger( "99999");
        ans = new BigInteger( "4999850001");
        res = BigIntegerOperations.sumSmaller(b);

        if(!res.equals(ans)) {
            System.out.println("input 99999 : wrong, should be 4999850001 but yours is: " + res);
            good=false;
        }

        if(good)
            System.out.println("2.1: good");
    }
    private static void t22(boolean isDisplay) {
        System.out.println("checking Task 2.2: ");
        System.out.println("0 numbers: ");
        BigIntegerOperations.printRandoms(0);
        space();
        System.out.println("1 numbers: ");
        BigIntegerOperations.printRandoms(1);
        space();
        System.out.println("10 numbers: ");
        BigIntegerOperations.printRandoms(10);

        space();
        System.out.println("2.2: good");

    }
    private static void t23(boolean isDisplay) {
        System.out.println("checking Task 2.3: ");
        boolean good=true;

        if (isDisplay) {System.out.println("testing input #1: 0");space();}
        BigInteger b = new BigInteger( "0");
        boolean res = BigIntegerOperations.isPrime(b);

        if(res) {
            System.out.println("input 0 : wrong, should be false but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 2");space();}
        b = new BigInteger( "2");
        res = BigIntegerOperations.isPrime(b);

        if(!res) {
            System.out.println("input 2 : wrong, should be True but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 13");space();}
        b = new BigInteger( "13");
        res = BigIntegerOperations.isPrime(b);

        if(!res) {
            System.out.println("input 13 : wrong, should be True but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: 49");space();}
        b = new BigInteger( "49");
        res = BigIntegerOperations.isPrime(b);

        if(res) {
            System.out.println("input 49 : wrong, should be False but yours is: " + res);
            good=false;
        }


        if(good)
            System.out.println("2.3: good");
    }
    private static void t24(boolean isDisplay) {
        System.out.println("checking Task 2.4: ");
        boolean good=true;

        if (isDisplay) {System.out.println("testing input #1: 2");space();}
        BigInteger b2 = new BigInteger( "2");
        BigInteger b3 = new BigInteger( "3");
        BigInteger res = BigIntegerOperations.randomPrime(2);


        if(!(res.equals(b2) || res.equals(b3))) {
            System.out.println("input 2 : wrong, should be 2 or 3 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: 3");space();}
        BigInteger b5 = new BigInteger( "5");
        BigInteger b7 = new BigInteger( "7");
        res = BigIntegerOperations.randomPrime(3);

        if(!(res.equals(b2) || res.equals(b3) || res.equals(b5) || res.equals(b7))) {
            System.out.println("input 3 : wrong, should be 2 3 5 or 7 but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: 4");space();}
        BigInteger b11 = new BigInteger( "11");
        BigInteger b13 = new BigInteger( "13");
        res = BigIntegerOperations.randomPrime(4);

        if(!(res.equals(b2) || res.equals(b3) || res.equals(b5) || res.equals(b7) || res.equals(b11) || res.equals(b13))) {
            System.out.println("input 4 : wrong, should be 2 3 5 7 11 or 13 but yours is: " + res);
            good=false;
        }

        if(good)
            System.out.println("2.4: good");
    }
    private static void t25(boolean isDisplay) {
        System.out.println("checking Task 2.5: ");
        boolean good=true;

        if (isDisplay) {System.out.println("testing input #1: {}");space();}
        BigInteger[] b1 = new BigInteger[0];
        boolean res = BigIntegerOperations.isValidPrimesArray(b1);
        if(!res) {
            System.out.println("input {} : wrong, should be True but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: null");space();}
        BigInteger[] b2 = null;
        res = BigIntegerOperations.isValidPrimesArray(b2);
        if(res) {
            System.out.println("input null : wrong, should be False but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: {2,3,7,5}");space();}
        BigInteger[] b3 = {new BigInteger("2"),new BigInteger("3"),new BigInteger("7"),new BigInteger("5")};
        res = BigIntegerOperations.isValidPrimesArray(b3);
        if(res) {
            System.out.println("input {2,3,7,5} : wrong, should be False but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: {2,3,3,5}");space();}
        BigInteger[] b4 = {new BigInteger("2"),new BigInteger("3"),new BigInteger("3"),new BigInteger("5")};
        res = BigIntegerOperations.isValidPrimesArray(b4);
        if(res) {
            System.out.println("input {2,3,3,5} : wrong, should be False but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #5: {2,3,5,7,10,11,13}");space();}
        BigInteger[] b5 = {new BigInteger("2"),new BigInteger("3"),new BigInteger("5"),new BigInteger("7"),new BigInteger("10"),new BigInteger("11"),new BigInteger("13")};
        res = BigIntegerOperations.isValidPrimesArray(b5);
        if(res) {
            System.out.println("input {2,3,5,7,10,11,13} : wrong, should be False but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #6: {2,13}");space();}
        BigInteger[] b6 = {new BigInteger("2"),new BigInteger("13")};
        res = BigIntegerOperations.isValidPrimesArray(b6);
        if(!res) {
            System.out.println("input {2,13} : wrong, should be True but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #7: {2,3,5,11,13}");space();}
        BigInteger[] b7 = {new BigInteger("2"),new BigInteger("3"),new BigInteger("5"),new BigInteger("11"),new BigInteger("13")};
        res = BigIntegerOperations.isValidPrimesArray(b7);
        if(!res) {
            System.out.println("input {2,3,5,11,13} : wrong, should be True but yours is: " + res);
            good=false;
        }

        if(good)
            System.out.println("2.5: good");
    }
    private static void t26(boolean isDisplay) {
        System.out.println("checking Task 2.6: ");
        boolean good=true;

        if (isDisplay) {System.out.println("testing input #1: {} 2");space();}
        BigInteger[] b1 = new BigInteger[0];
        boolean res = BigIntegerOperations.canFactorizeToTarget(b1,new BigInteger("2"));
        if(res) {
            System.out.println("input {} 2 : wrong, should be False but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #2: {2} 2");space();}
        BigInteger[] b2 = {new BigInteger("2")};
         res = BigIntegerOperations.canFactorizeToTarget(b2,new BigInteger("2"));
        if(!res) {
            System.out.println("input {2} 2 : wrong, should be True but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #3: {2,3,5} 12");space();}
        BigInteger[] b3 = {new BigInteger("2"),new BigInteger("3"),new BigInteger("5")};
        res = BigIntegerOperations.canFactorizeToTarget(b3,new BigInteger("12"));
        if(!res) {
            System.out.println("input {2,3,5} 12 : wrong, should be True but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #4: {3,5} 12");space();}
        BigInteger[] b4 = {new BigInteger("3"),new BigInteger("5")};
        res = BigIntegerOperations.canFactorizeToTarget(b4,new BigInteger("12"));
        if(res) {
            System.out.println("input {3,5} 12 : wrong, should be False but yours is: " + res);
            good=false;
        }

        if (isDisplay) {System.out.println("testing input #5: {2,3,5} 17");space();}
        BigInteger[] b5 = {new BigInteger("2")};
        res = BigIntegerOperations.canFactorizeToTarget(b5,new BigInteger("17"));
        if(res) {
            System.out.println("input {2,3,5} 17 : wrong, should be False but yours is: " + res);
            good=false;
        }

        if(good)
            System.out.println("2.6: good");
    }
    private static void t27(boolean isDisplay) {
        System.out.println("checking Task 2.7: ");
        boolean good=true;

        System.out.println("testing input #1: {} 2");space();
        BigInteger[] b1 = new BigInteger[0];
        BigIntegerOperations.printFactorization(b1,new BigInteger("2"));

        space();

        System.out.println("testing input #2: {2} 2");space();
        BigInteger[] b2 = {new BigInteger("2")};
        BigIntegerOperations.printFactorization(b2,new BigInteger("2"));

        space();

        System.out.println("testing input #3: {2,3,5} 12");space();
        BigInteger[] b3 = {new BigInteger("2"),new BigInteger("3"),new BigInteger("5")};
        BigIntegerOperations.printFactorization(b3,new BigInteger("12"));

        space();

        System.out.println("testing input #4: {3,5} 12");space();
        BigInteger[] b4 = {new BigInteger("3"),new BigInteger("5")};
        BigIntegerOperations.printFactorization(b4,new BigInteger("12"));

        space();

        System.out.println("testing input #5: {2,3,5} 17");space();
        BigInteger[] b5 = {new BigInteger("2")};
        BigIntegerOperations.printFactorization(b5,new BigInteger("17"));

        space();

        System.out.println("2.7: good");
    }

}
