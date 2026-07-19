import java.math.BigInteger;
import java.util.Scanner;


public class Tomer_Tester_Ass4 {
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
        check1 = CS(s, "0") | CS(s, "1.1") | CS(s, "1.2") | CS(s, "1.3") | CS(s, "1.4") | CS(s, "1.5") | CS(s, "1.6") | CS(s, "1.7") | CS(s, "1.8");
        check1D = CS(s, "0 -D") | CS(s, "1.1 -D") | CS(s, "1.2 -D") | CS(s, "1.3 -D") | CS(s, "1.4 -D") | CS(s, "1.5 -D") | CS(s, "1.6 -D") | CS(s, "1.7 -D") | CS(s, "1.8 -D");
        check2 = CS(s, "1") | CS(s, "2") | CS(s, "2.1") | CS(s, "2.2") | CS(s, "2.3")| CS(s, "2.4")| CS(s, "2.5") | CS(s, "2.6") | CS(s, "2.7") | CS(s, "2.8") | CS(s, "2.9") | CS(s, "2.10") | CS(s, "2.11") | CS(s, "2.12") | CS(s, "2.13");
        check2D = CS(s, "1 -D") | CS(s, "2 -D") | CS(s, "2.1 -D") | CS(s, "2.2 -D") | CS(s, "2.3 -D")| CS(s, "2.4 -D")| CS(s, "2.5 -D") | CS(s, "2.6 -D") | CS(s, "2.7 -D") | CS(s, "2.8 -D") | CS(s, "2.9 -D") | CS(s, "2.10 -D") | CS(s, "2.11 -D") | CS(s, "2.12 -D") | CS(s, "2.13 -D");
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
        boolean isDisplay =  CS(s, "0 -D") | CS(s, "1.1 -D") | CS(s, "1.2 -D") | CS(s, "1.3 -D") | CS(s, "1.4 -D") | CS(s, "1.5 -D") | CS(s, "1.6 -D") | CS(s, "1.7 -D") | CS(s, "1.8 -D") |
                CS(s, "1 -D") | CS(s, "2 -D") | CS(s, "2.1 -D") | CS(s, "2.2 -D") | CS(s, "2.3 -D")| CS(s, "2.4 -D")| CS(s, "2.5 -D") | CS(s, "2.6 -D") | CS(s, "2.7 -D") | CS(s, "2.8 -D") | CS(s, "2.9 -D") | CS(s, "2.10 -D") | CS(s, "2.11 -D") | CS(s, "2.12 -D") | CS(s, "2.13 -D");

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
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.1")) {t21(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.2")) {t22(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.3")) {t23(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.4")) {t24(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.5")) {t25(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.6")) {t26(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.7")) {t27(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.8")) {t28(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.9")) {t29(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.10")) {t210(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.11")) {t211(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.12")) {t212(isDisplay);}
        if (CS(s, "2") | CS(s, "0") | CS(s, "2.13")) {t213(isDisplay);}

    }

    private static void t11(boolean isDisplay) {
        BinaryRepresentation BR = new BinaryRepresentation();
        boolean good = true;
        Bit b1 = Bit.ONE;
        Bit b0 = Bit.ZERO;
        boolean ans;

        System.out.println("checking 1.1:");
        System.out.print("addLast: ");

        if (isDisplay) {
            System.out.println("testing input : adding last 1, 1, 0, 0");
        }

        BR.addLast(b1);
        BR.addLast(b1);
        BR.addLast(b0);
        BR.addLast(b0);
        ans=BR.getFirst().toInt()==b1.toInt();
        if(!ans){
            fail();
            System.out.println("Input 1,1,0,0 your first isn't 1 its: " + BR.getFirst().toInt());
            good=false;
        }
        ans=BR.getLast().toInt()==b0.toInt();
        if(!ans){
            fail();
            System.out.println("Input 1,1,0,0 your last isn't 0 its: " + BR.getLast().toInt());
            good=false;
        }
        if(good)
            good();

        space();

        if(good){
            System.out.print("removeLast: ");
            if (isDisplay) {
                System.out.println("testing input : 1, 1, 0, 0");
            }
            Bit last=BR.removeLast();
            ans=last.toInt()==0;

            if(!ans){
                fail();
                System.out.println("Input 1,1,0,0 with add last removed last should send 0 but yours send: " + last.toInt());
                good=false;
            }
            ans=BR.getLast().toInt()==0;
            if(!ans){
                fail();
                System.out.println("Input 1,1,0,0 with add last after removing last, the last Bit should be 0 but yours is: " + BR.getLast().toInt());
                good=false;
            }
            BR.removeLast();
            ans=BR.getLast().toInt()==1;
            if(!ans){
                fail();
                System.out.println("Input 1,1,0,0 with add last after removing last , the last Bit should be 1 but yours is: " + BR.getLast().toInt());
                good=false;
            }
            last=BR.removeLast();
            ans=last.toInt()==1;
            if(!ans){
                fail();
                System.out.println("Input 1,1,0,0 with add last after removing last 2 times remove first should send 1 but yours send: " + last.toInt());
                good=false;
            }
            if(good)
                good();
        }//if removeLast
        else {
            System.out.println();
            System.out.println("cant check removeLast, fix addLast please");
            System.out.println();
        }

        System.out.print("addFirst: ");
        good=true;
        BR = new BinaryRepresentation();

        if (isDisplay) {
            System.out.println("testing input : adding first 0, 0, 1, 1");
        }
        BR.addFirst(b0);
        BR.addFirst(b0);
        BR.addFirst(b1);
        BR.addFirst(b1);
        ans=BR.getFirst().toInt()==b1.toInt();
        if(!ans){
            fail();
            System.out.println("Input 0, 0, 1, 1 your first isn't 1 its: " + BR.getFirst().toInt());
            good=false;
        }
        ans=BR.getLast().toInt()==b0.toInt();
        if(!ans){
            fail();
            System.out.println("Input 0, 0, 1, 1 your last isn't 0 its: " + BR.getLast().toInt());
            good=false;
        }
        if(good)
            good();

        space();
        if(good){
            System.out.print("removeFirst: ");
            if (isDisplay) {
                System.out.println("testing input :  0, 0, 1, 1");
            }
            Bit first=BR.removeFirst();
            ans=first.toInt()==1;
            if(!ans){
                fail();
                System.out.println("Input 0, 0, 1, 1 with add first remove first should send 1 but yours send: " + first.toInt());
                good=false;
            }
            ans=BR.getFirst().toInt()==1;
            if(!ans){
                fail();
                System.out.println("Input 0, 0, 1, 1 with add first after removing first, the first Bit should be 1 but yours is: " + BR.getFirst().toInt());
                good=false;
            }
            BR.removeFirst();
            ans=BR.getFirst().toInt()==0;
            if(!ans){
                fail();
                System.out.println("Input 0, 0, 1, 1 with add first after removing first 2 times, the First Bit should be 0 but yours is: " + BR.getFirst().toInt());
                good=false;
            }
            first=BR.removeFirst();
            ans=first.toInt()==0;
            if(!ans){
                fail();
                System.out.println("Input 0, 0, 1 ,1  with add first after removing first 3 time should send 0 but yours send: " + first.toInt());
                good=false;
            }
            if(good)
                good();
        }//if removeFirst
        else {
            space();
            System.out.println("cant check removeFirst, fix addFirst please ");
            space();
        }
    }
    private static void t12(boolean isDisplay) {

        System.out.print("checking 1.2: ");
        boolean good=true;
        String ans;
        if (isDisplay) {
            System.out.println("testing input : <001>");
        }
        BinaryRepresentation b1 = new BinaryRepresentation();
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ONE);
        ans=b1.toString();
        if(!CS(ans,"<001>")){
            System.out.println();
            fail();
            System.out.println("input 001 should be <001> but yours is: "+ans);
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing input : <101>");
        }

        b1 = new BinaryRepresentation();
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ONE);
        ans=b1.toString();
        if(!CS(ans,"<101>")){
            System.out.println();
            fail();
            System.out.println("input 101 should be <101> but yours is: "+ans);
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing input : <101111>");
        }

        b1 = new BinaryRepresentation();
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ONE);
        ans=b1.toString();
        if(!CS(ans,"<101111>")){
            System.out.println();
            fail();
            System.out.println("input 101111 should be <101111> but yours is: "+ans);
            good=false;
        }
        if(good)
            good();
        System.out.println();
    }
    private static void t13(boolean isDisplay) {
        System.out.print("checking 1.3:");
        boolean good=true;
        String ans;
        if (isDisplay) {
            System.out.println("testing #1 input : <001>");
        }

        BinaryRepresentation b1 = new BinaryRepresentation();
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ONE);
        if (isDisplay) {
            System.out.println("coping 001");
        }
        BinaryRepresentation b2 = new BinaryRepresentation(b1);
        if (isDisplay) {
            System.out.println("adding bits to the new BinaryRepresentation and creating: <001111>");
        }
        b2.addFirst(Bit.ONE);
        b2.addFirst(Bit.ONE);
        b2.addFirst(Bit.ONE);
        ans=b1.toString();
        if(!CS(ans,"<001>")){
            System.out.println();
            fail();
            System.out.println("input <001> should be <001> but yours is: "+ans);
            good=false;
        }
        ans=b2.toString();
        if(!CS(ans,"<001111>")){
            System.out.println();
            fail();
            System.out.println("input <001111> should be <001111> but yours is: "+ans);
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : <101111>");
        }
        b1 = new BinaryRepresentation();
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ZERO);
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ONE);
        if (isDisplay) {
            System.out.println("coping 101111");
        }
        b2 = new BinaryRepresentation(b1);
        if (isDisplay) {
            System.out.println("removing bits to the new BinaryRepresentation and creating: <101>");
        }
        b2.removeFirst();
        b2.removeFirst();
        b2.removeFirst();
        ans=b1.toString();
        if(!CS(ans,"<101111>")){
            System.out.println();
            fail();
            System.out.println("input <101111> should be <101111> but yours is: "+ans);
            good=false;
        }
        ans=b2.toString();
        if(!CS(ans,"<101>")){
            System.out.println();
            fail();
            System.out.println("input <101> should be <101> but yours is: "+ans);
            good=false;
        }

        if(good)
            good();
        System.out.println();
    }
    private static void t14(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        System.out.print("checking 1.4: ");
        BinaryRepresentation b1 = new BinaryRepresentation();
        if (isDisplay) {
            System.out.println("testing #1 input : <>");
        }
        ans=b1.isLegalNumber();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input nothing should be false but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : <0>");
        }

        b1.addFirst(Bit.ZERO);
        ans=b1.isLegalNumber();
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : <1>");
        }

        b1.removeFirst();
        b1.addFirst(Bit.ONE);
        ans=b1.isLegalNumber();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 1 should be false but yours is: " + ans );
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing #4 input : <10>");
        }

        b1.addFirst(Bit.ZERO);
        ans=b1.isLegalNumber();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 10 should be false but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 input : <100>");
        }

        b1.addFirst(Bit.ZERO);
        ans=b1.isLegalNumber();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 100 should be false but yours is: " + ans );
            good=false;
        }

        if(good)
            good();
        System.out.println();
    }
    private static void t15(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        System.out.println("checking 1.5: ");
        System.out.print("isReduced :");
        if (isDisplay) {
            System.out.println("testing #1 input : <>");
        }
        BinaryRepresentation b1 = new BinaryRepresentation();
        ans=b1.isReduced();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input nothing should be false but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : <1>");
        }

        b1.addFirst(Bit.ONE);
        ans=b1.isReduced();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 1 should be false but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : <01>");
        }

        b1.addLast(Bit.ZERO);
        ans=b1.isReduced();
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 01 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input : <001>");
        }

        b1.addLast(Bit.ZERO);
        ans=b1.isReduced();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 001 should be false but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 input : <1001>");
        }

        b1.addLast(Bit.ONE);
        ans=b1.isReduced();
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1001 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #6 input : <01001>");
        }

        b1.addLast(Bit.ZERO);
        ans=b1.isReduced();
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 01001 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #7 input : <00001001>");
        }

        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ZERO);
        ans=b1.isReduced();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 00001001 should be false but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #8 input : <0>");
        }

        b1 = new BinaryRepresentation();
        b1.addLast(Bit.ZERO);
        ans=b1.isReduced();
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #9 input : <11>");
        }

        b1.removeFirst();
        b1.addLast(Bit.ONE);
        b1.addLast(Bit.ONE);
        ans=b1.isReduced();
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 11 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #10 input : <0000>");
        }

        b1 = new BinaryRepresentation();
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ZERO);
        ans=b1.isReduced();
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 0000 should be false but yours is: " + ans );
            good=false;
        }
        if(good) {
            good();
            System.out.print("reduce :");
            String s;
            if (isDisplay) {
                System.out.println("testing #1 input : <11>");
            }

            b1 = new BinaryRepresentation();
            b1.addLast(Bit.ONE);
            b1.addLast(Bit.ONE);

            b1.reduce();
            s=b1.toString();
            ans=CS(s,"<11>");
            if(!ans){
                System.out.println();
                fail();
                System.out.println("Input <11> after reduce should be <11> but yours is: " + s );
                good=false;
            }
            if (isDisplay) {
                System.out.println("testing #2 input : <000011>");
            }

            b1.addLast(Bit.ZERO);
            b1.addLast(Bit.ZERO);
            b1.addLast(Bit.ZERO);
            b1.addLast(Bit.ZERO);
            b1.reduce();
            s=b1.toString();
            ans=CS(s,"<011>");
            if(!ans){
                System.out.println();
                fail();
                System.out.println("Input <000011> after reduce should be <011> but yours is: " + s );
                good=false;
            }
            if (isDisplay) {
                System.out.println("testing #3 input : <011011>");
            }

            b1.addLast(Bit.ONE);
            b1.addLast(Bit.ONE);
            b1.addLast(Bit.ZERO);
            b1.reduce();
            s=b1.toString();
            ans=CS(s,"<011011>");
            if(!ans){
                System.out.println();
                fail();
                System.out.println("Input <011011> after reduce should be <011011> but yours is: " + s );
                good=false;
            }
            if(good)
                good();
        }
        else
            System.out.println("cant test Reduce, please fix isReduced" );
    }
    private static void t16(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        System.out.println("checking 1.6: ");
        if (isDisplay) {
            System.out.println("testing #1 input : <>");
        }
        BinaryRepresentation b1 = new BinaryRepresentation();
        b1.complement();
        ans=CS(b1.toString(),"<>");
        if(!ans){
            space();
            fail();
            System.out.println("Input <> should be <> but yours is: " + b1 );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : <1>");
        }
        b1 = new BinaryRepresentation();
        b1.addLast(Bit.ZERO);
        b1.complement();
        ans=CS(b1.toString(),"<1>");
        if(!ans){
            space();
            fail();
            System.out.println("Input <0> should be <1> but yours is: " + b1 );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : <0>");
        }
        b1 = new BinaryRepresentation();
        b1.addLast(Bit.ONE);
        b1.complement();
        ans=CS(b1.toString(),"<0>");
        if(!ans){
            space();
            fail();
            System.out.println("Input <1> should be <0> but yours is: " + b1 );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input : <1001>");
        }
        b1 = new BinaryRepresentation();
        b1.addLast(Bit.ONE);
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ONE);
        b1.complement();
        ans=CS(b1.toString(),"<0110>");
        if(!ans){
            space();
            fail();
            System.out.println("Input <1001> should be <0110> but yours is: " + b1 );
            good=false;
        }

        if(good)
            good();
    }
    private static void t17(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.println("checking 1.7: ");
        System.out.print("shiftRight: ");
        if (isDisplay) {
            System.out.println("testing #1 input : <>");
        }
        BinaryRepresentation b1 = new BinaryRepresentation();
        b1.shiftRight();
        s=b1.toString();
        ans=CS(s,"<>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <> should be <> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : <010>");
        }
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ONE);
        b1.addLast(Bit.ZERO);
        b1.shiftRight();
        s=b1.toString();
        ans=CS(s,"<01>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <010> should be <01> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : <01>");
        }

        b1.shiftRight();
        s=b1.toString();
        ans=CS(s,"<0>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <01> should be <0> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input : <0>");
        }

        b1.shiftRight();
        s=b1.toString();
        ans=CS(s,"<>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <0> should be <> but yours is: " + s );
            good=false;
        }
        if(good)
            good();
        System.out.println();

        System.out.print("shiftLeft: ");
        if (isDisplay) {
            System.out.println("testing #1 input : <>");
        }
        b1 = new BinaryRepresentation(); // <>
        b1.shiftLeft();
        s=b1.toString();
        ans=CS(s,"<0>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <> should be <0> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : <010>");
        }
        b1.removeFirst();
        b1.addLast(Bit.ZERO);
        b1.addLast(Bit.ONE);
        b1.addLast(Bit.ZERO);
        b1.shiftLeft();
        s=b1.toString();
        ans=CS(s,"<0100>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <010> should be <0100> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : <0100>");
        }
        b1.shiftLeft();
        s=b1.toString();
        ans=CS(s,"<01000>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <0100> should be <01000> but yours is: " + s );
            good=false;
        }

        if(good)
            good();
        System.out.println();
    }
    private static void t18(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.print("checking 1.8: ");
        BinaryRepresentation b1 = new BinaryRepresentation();
        b1.addLast(Bit.ONE);
        if (isDisplay) {
            System.out.println("testing #1 input : <1> , 0");
        }
        b1.padding(0);
        s=b1.toString();
        ans=CS(s,"<1>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <1> and padding to 0 should be <1> but yours is: " + s );
            good=false;
        }
        b1= new BinaryRepresentation();
        b1.addLast(Bit.ZERO);
        if (isDisplay) {
            System.out.println("testing #2 input : <0> , 3");
        }
        b1.padding(3);
        s=b1.toString();
        ans=CS(s,"<000>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <0> and padding to 3 should be <000> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : <000> , 3");
        }
        b1.padding(1);
        s=b1.toString();
        ans=CS(s,"<000>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <000> and padding to 3 should be <000> but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input : <1000> , 6");
        }
        b1.addLast(Bit.ONE);
        b1.padding(6);
        s=b1.toString();
        ans=CS(s,"<111000>");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input <1000> and padding to 6 should be <111000> but yours is: " + s );
            good=false;
        }
        if(good)
            good();
    }
    private static void t21(boolean isDisplay) {
        t22(isDisplay);
    }
    private static void t22(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.print("checking 2.1 and 2.2 together: ");
        if (isDisplay) {
            System.out.println("testing #1 input : 0 ");
        }
        BinaryNumber b1 = new BinaryNumber(0);
        s=b1.toString();
        ans=CS(s,"0");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 should be 0 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : 1 ");
        }
        b1 = new BinaryNumber(1);
        s=b1.toString();
        ans=CS(s,"01");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1 should be 01 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : 3 ");
        }
        b1 = new BinaryNumber(3);
        s=b1.toString();
        ans=CS(s,"011");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 3 should be 011 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : 2 ");
        }
        b1 = new BinaryNumber(2);
        s=b1.toString();
        ans=CS(s,"010");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 2 should be 010 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input : 5 ");
        }
        b1 = new BinaryNumber(5);
        s=b1.toString();
        ans=CS(s,"0101");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 5 should be 0101 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 input : 9 ");
        }
        b1 = new BinaryNumber(9);
        s=b1.toString();
        ans=CS(s,"01001");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 9 should be 01001 but yours is: " + s );
            good=false;
        }
        if(good)
            good();
        System.out.println();

    }
    private static void t23(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        System.out.print("checking 2.3: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 0==0 ");
        }
        BinaryNumber b1 = new BinaryNumber(0);
        BinaryNumber b2 = new BinaryNumber(0);
        ans=b1.equals(b2);
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 and 0 should be true but yours is: " + ans );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : 1==0 ");
        }
        b2 = new BinaryNumber(1);
        ans=b1.equals(b2);
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 0 and 1 should be false but yours is: " + ans );
            good=false;
        }
        b1 = new BinaryNumber(5);
        b2 = new BinaryNumber(6);
        if (isDisplay) {
            System.out.println("testing #1 inputs : 5==6 ");
        }
        ans=b1.equals(b2);
        if(ans){
            System.out.println();
            fail();
            System.out.println("Input 5 and 6 should be false but yours is: " + ans );
            good=false;
        }
        b1 = new BinaryNumber('8');
        b2 = new BinaryNumber('8');
        if (isDisplay) {
            System.out.println("testing #1 inputs : 8==8 ");
        }
        ans=b1.equals(b2);
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 8 and 8 should be true but yours is: " + ans );
            good=false;
        }
        if(good)
            good();
        System.out.println();
    }
    private static void t24(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.print("checking 2.4: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 0+0 ");
        }
        BinaryNumber b1 = new BinaryNumber(0);
        BinaryNumber b2 = new BinaryNumber(0);
        s=b1.add(b2).toString();
        ans=CS(s,b1.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 and 0 should be 0 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : 0+1 ");
        }
        b2 = new BinaryNumber(1);
        s=b1.add(b2).toString();
        ans=CS(s,b2.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 and 1 should be 1 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : 3+2 ");
        }
        b1 = new BinaryNumber(3);
        b2 = new BinaryNumber(2);
        s=b1.add(b2).toString();
        b2 = new BinaryNumber(5);
        ans=CS(s,b2.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 3 and 2 should be 5 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 inputs : 4+5 ");
        }
        b1 = new BinaryNumber(4);
        b2 = new BinaryNumber(5);
        s=b1.add(b2).toString();
        b2 = new BinaryNumber(9);
        ans=CS(s,b2.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 4 and 5 should be 9 but yours is: " + s );
            good=false;
        }
        if(good)
            good();
    }
    private static void t25(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.print("checking 2.5: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : -1+0 ");
        }
        BinaryNumber b1 = new BinaryNumber(1);
        b1=b1.negate();
        BinaryNumber b2 = new BinaryNumber(0);
        s=b1.add(b2).toString();
        ans=CS(s,b1.toString());
        if(!ans){
            space();
            System.out.println("Input -1+0 should be -1 but yours is: s:" + s + "and your negated number 1 -> -1 is: b1" + b1 );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : -1+-1 ");
        }
        b2 = new BinaryNumber(1);
        b2=b2.negate();
        s=b1.add(b2).toString();
        b2 = new BinaryNumber(2);
        b2=b2.negate();
        ans=CS(s,b2.toString());
        if(!ans){
            space();
//            System.out.println("b1:"+b1+". b2:"+b2+". output:"+s);
            System.out.println("Input -1+-1 should be -2 but yours is: " + s + "and your negated number 2 -> -2 is: " + b2);
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : -3+-2 ");
        }
        b1 = new BinaryNumber(3);
        b1=b1.negate();
        b2 = new BinaryNumber(2);
        b2=b2.negate();
        s=b1.add(b2).toString();
        b2 = new BinaryNumber(5);
        b2=b2.negate();
        ans=CS(s,b2.toString());
        if(!ans){
            space();
            System.out.println("Input -3+-2 should be -5 but yours is: s:" + s + "and your negated numbers -3 -5 are: b1:" + b1 + " and b2:" + b2 );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 inputs : -4+7 ");
        }
        b1 = new BinaryNumber(4);
        b1=b1.negate();
        b2 = new BinaryNumber(7);
        s=b1.add(b2).toString();
        b2 = new BinaryNumber(3);
        ans=CS(s,b2.toString());
        if(!ans){
            space();
            System.out.println("Input -4+7 should be 3 but yours is: " + s + "and your negated number -4 is: " + b1 );
            good=false;
        }
        if(good)
            good();
    }
    private static void t26(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.print("checking 2.6: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 1-0 ");
        }
        BinaryNumber b1 = new BinaryNumber(1);
        BinaryNumber b2 = new BinaryNumber(0);
        s=b1.subtract(b2).toString();
        ans=CS(s,b1.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1-0 should be 1 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : 5-2 ");
        }
        b1 = new BinaryNumber(5);
        b2 = new BinaryNumber(2);
        BinaryNumber b3 = new BinaryNumber(3);
        s=b1.subtract(b2).toString();
        ans=CS(s,b3.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 5-2 should be 3 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : 3-2 ");
        }
        b1 = new BinaryNumber(3);
        b2 = new BinaryNumber(2);
        s=b1.subtract(b2).toString();
        b3 = new BinaryNumber(1);
        ans=CS(s,b3.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 3-2 should be 1 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 inputs : 5-5 ");
        }
        b1 = new BinaryNumber(5);
        b2 = new BinaryNumber(5);
        s=b1.subtract(b2).toString();
        b2 = new BinaryNumber(0);
        ans=CS(s,b2.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 5 and 5 should be 0 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 inputs : 320-20 ");
        }
        b1=new BinaryNumber(320);
        b2=new BinaryNumber(20);
        s=b1.subtract(b2).toString();//300
        b3 = new BinaryNumber(300);
        ans=CS(s,b3.toString());
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 320-20 should be 300 but yours is: " + s );
            good=false;
        }
        if(good)
            good();
    }
    private static void t27(boolean isDisplay) {
        boolean good=true;
        int sig;
        boolean ans;
        System.out.print("checking 2.7: ");
        if (isDisplay) {
            System.out.println("testing #1 input: 1 ");
        }
        BinaryNumber b1 = new BinaryNumber(1);
        BinaryNumber b0 = new BinaryNumber(0);
        BinaryNumber b11 = new BinaryNumber(1);
        b11=b11.negate();
        sig=b1.signum();
        ans=sig==1;
        if(!ans){
            fail();
            System.out.println("Input 1 should be 1 but yours is: " + sig );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input: 0 ");
        }
        sig=b0.signum();
        ans=sig==0;
        if(!ans){
            fail();
            System.out.println("Input 0 should be 0 but yours is: " + sig );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : -1 ");
        }
        sig=b11.signum();
        ans=sig==-1;
        if(!ans){
            fail();
            System.out.println("Input -1 should be -1 but yours is: " + sig );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input: 5 ");
        }
        BinaryNumber b2 = new BinaryNumber(5);
        BinaryNumber b3 = new BinaryNumber(9);
        b3=b3.negate();
        sig=b2.signum();
        ans=sig==1;
        if(!ans){
            fail();
            System.out.println("Input 5 should be 1 but yours is: " + sig );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 input: -9 ");
        }
        sig=b3.signum();
        ans=sig==-1;
        if(!ans){
            fail();
            System.out.println("Input -9 should be -1 but yours is: " + sig );
            good=false;
        }
        if(good)
            good();

    }
    private static void t28(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        int i;
        System.out.print("checking 2.8: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 0 compare to 1 ");
        }
        BinaryNumber b1 = new BinaryNumber(1);
        BinaryNumber b2 = new BinaryNumber(0);
        i=b1.compareTo(b2);
        ans= i==1;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1 compare to 0 should be 1 but yours is: " + i );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : 4 compare to 4 ");
        }
        b1 = new BinaryNumber(4);
        b2 = new BinaryNumber(4);
        i=b1.compareTo(b2);
        ans= i==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 4 compare to 4 should be 0 but yours is: " + i );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : 6 compare to 9 ");
        }
        b1 = new BinaryNumber(6);
        b2 = new BinaryNumber(9);
        i=b1.compareTo(b2);
        ans= i==-1;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 6 compare to 9 should be 0 but yours is: " + i );
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing #4 inputs : 144 compare to 145 ");
        }
        b1 = new BinaryNumber(144);
        b2 = new BinaryNumber(145);
        i=b1.compareTo(b2);
        ans= i==-1;
        if(!ans){
            fail();
            System.out.println("Input 144 compare to 145 should be -1 but yours is: " + i );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 inputs : 144 compare to 288 ");
        }
        b2 = new BinaryNumber(288);
        i=b1.compareTo(b2);
        ans= i==-1;
        if(!ans){
            fail();
            System.out.println("Input 144 compare to 288 should be -1 but yours is: " + i );
            good=false;
        }

        if(good)
            good();
    }
    private static void t29(boolean isDisplay) {
        boolean good=true;
        int i;
        boolean ans;
        System.out.print("checking 2.9: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 1 ");
        }
        BinaryNumber b1 = new BinaryNumber(1);
        i=b1.toInt();
        ans=i==1;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1 should be 1 but yours is: " +  i);
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing #2 inputs : 0 ");
        }
        b1 = new BinaryNumber(0);
        i=b1.toInt();
        ans=i==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 should be 0 but yours is: " + i );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : 36 ");
        }
        b1 = new BinaryNumber(36);
        i=b1.toInt();
        ans=i==36;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 36 should be 36 but yours is: " + i );
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing #4 inputs : 144 ");
        }
        b1 = new BinaryNumber(144);
        i=b1.toInt();
        ans=i==144;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 144 should be 144 but yours is: " + i );
            good=false;
        }

        if(good)
            good();

        System.out.println();

    }
    private static void t210(boolean isDisplay) {
        boolean good = true;
        boolean ans;
        System.out.print("checking 2.10: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 0*3 ");
        }
        BinaryNumber b1 = new BinaryNumber(0);
        BinaryNumber b2 = new BinaryNumber(3);
        BinaryNumber b3 = new BinaryNumber(0);
        BinaryNumber mult;
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 0 and 3 should be 0 but yours is: " + mult);
            good = false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : 3*0 ");
        }
        b1 = new BinaryNumber(3);
        b2 = new BinaryNumber(0);
        b3 = new BinaryNumber(0);
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 3 and 0 should be 0 but yours is: " + mult);
            good = false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : 2*3 ");
        }

        b1 = new BinaryNumber(2);
        b2 = new BinaryNumber(3);
        b3 = new BinaryNumber(6);
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 2 and 3 should be 6 but yours is: " + mult);
            good = false;
        }
        if (isDisplay) {
            System.out.println("testing #4 inputs : 8*5 ");
        }

        b1 = new BinaryNumber(8);
        b2 = new BinaryNumber(5);
        b3 = new BinaryNumber(40);
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 8 and 5 should be 40 but yours is: " + mult);
            good = false;
        }
        if (isDisplay) {
            System.out.println("testing #5 inputs : 16*3 ");
        }

        b1 = new BinaryNumber(16);
        b2 = new BinaryNumber(3);
        b3 = new BinaryNumber(48);
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 16 and 3 should be 48 but yours is: " + mult);
            good = false;
        }
        if (isDisplay) {
            System.out.println("testing #5 inputs : 108*16 ");
        }

        b1 = new BinaryNumber(108);
        b2 = new BinaryNumber(16);
        b3 = new BinaryNumber(1728);
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 108 and 16 should be 1728 but yours is: " + mult);
            good = false;
        }

        if (isDisplay) {
            System.out.println("testing #6 , if not optimise it wont work, inputs : 1080*1600 ");
        }

        b1 = new BinaryNumber(1080);
        b2 = new BinaryNumber(1600);
        b3 = new BinaryNumber(1728000);
        mult = b1.multiply(b2);
        ans = mult.compareTo(b3) == 0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 1080 and 1600 should be 1728000 but yours is: " + mult);
            good = false;
        }

        if(good)
            good();
    }
    private static void t211(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        System.out.print("checking 2.11: ");
        if (isDisplay) {
            System.out.println("testing #1 inputs : 0/3 ");
        }
        BinaryNumber b1 = new BinaryNumber(0);
        BinaryNumber b2 = new BinaryNumber(3);
        BinaryNumber b3 = new BinaryNumber(0);
        BinaryNumber div;
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 and 3 should be 0 but yours is: " + div );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 inputs : 3/1 ");
        }
        b1 = new BinaryNumber(3);
        b2 = new BinaryNumber(1);
        b3 = new BinaryNumber(3);
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 3 and 1 should be 3 but yours is: " + div );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 inputs : 2/3 ");
        }

        b1 = new BinaryNumber(2);
        b2 = new BinaryNumber(3);
        b3 = new BinaryNumber(0);
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 2 and 3 should be 0 but yours is: " + div );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 inputs : 8/5 ");
        }

        b1 = new BinaryNumber(8);
        b2 = new BinaryNumber(5);
        b3 = new BinaryNumber(1);
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 8 and 5 should be 1 but yours is: " + div );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 inputs : 16/3 ");
        }

        b1 = new BinaryNumber(16);
        b2 = new BinaryNumber(3);
        b3 = new BinaryNumber(5);
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 16 and 3 should be 5 but yours is: " + div );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 inputs : 108/16 ");
        }
        b1 = new BinaryNumber(108);
        b2 = new BinaryNumber(16);
        b3 = new BinaryNumber(6);
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if(!ans) {
            System.out.println();
            fail();
            System.out.println("Input 108 and 16 should be 6 but yours is: " + div);
            good = false;
        }


        if (isDisplay) {
            System.out.println("testing #6 , if not optimise it wont work, inputs : 1600/57 ");
        }
        b1 = new BinaryNumber(1600);
        b2 = new BinaryNumber(57);
        b3 = new BinaryNumber(28);
        div=b1.divide(b2);
        ans=div.compareTo(b3)==0;
        if (!ans) {
            System.out.println();
            fail();
            System.out.println("Input 1600 and 57 should be 28 but yours is: " + div);
            good = false;
        }

        if(good)
            good();

    }
    private static void t212(boolean isDisplay) {
        boolean good=true;
        boolean ans;

        System.out.print("checking 2.12");
        if (isDisplay) {
            System.out.println("testing #1 input : 12 ");
        }
        BinaryNumber b1 = new BinaryNumber("12");
        BinaryNumber b2 = new BinaryNumber(12);
        ans=b2.compareTo(b1)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 12 should be 12 but yours is: " + b1.toInt() );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : 50 ");
        }

        b1 = new BinaryNumber("50");
        b2 = new BinaryNumber(50);
        ans=b2.compareTo(b1)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 50 should be 50 but yours is: " + b1.toInt() );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : 101 ");
        }
        b1 = new BinaryNumber("-101");
        b2 = new BinaryNumber(101);
        b2=b2.negate();
        ans=b2.compareTo(b1)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input -101 should be -101 but yours is: " + b1.toInt() );
            good=false;
        }

        System.out.print("checking 2.12");
        if (isDisplay) {
            System.out.println("testing #4 input : 1 ");
        }
        b1 = new BinaryNumber("1");
        b2 = new BinaryNumber(1);
        ans=b2.compareTo(b1)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1 should be 1 but yours is: " + b1.toInt() );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 input : 0 ");
        }

        b1 = new BinaryNumber("0");
        b2 = new BinaryNumber(0);
        ans=b2.compareTo(b1)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 should be 0 but yours is: " + b1.toInt() );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #6 input : -1 ");
        }
        b1 = new BinaryNumber("-1");
        b2 = new BinaryNumber(1);
        b2=b2.negate();
        ans=b2.compareTo(b1)==0;
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input -1 should be -1 but yours is: " + b1.toInt() );
            good=false;
        }

        if(good)
            good();

    }
    private static void t213(boolean isDisplay) {
        boolean good=true;
        boolean ans;
        String s;
        System.out.print("checking 2.13: ");
        if (isDisplay) {
            System.out.println("testing #1 input : 0 ");
        }
        BinaryNumber b1 = new BinaryNumber("0");
        s=b1.toIntString();
        ans=CS(s,"0");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 0 should be 0 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : 1 ");
        }

        b1 = new BinaryNumber("1");
        s=b1.toIntString();
        ans=CS(s,"1");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1 should be 1 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #2 input : 2 ");
        }
        b1 = new BinaryNumber("2");
        s=b1.toIntString();
        ans=CS(s,"2");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 2 should be 2 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #3 input : 1234 ");
        }
        b1 = new BinaryNumber("1234");
        s=b1.toIntString();
        ans=CS(s,"1234");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1234 should be 1234 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #4 input : 222000333 ");
        }
        b1 = new BinaryNumber("222000333");
        s=b1.toIntString();
        ans=CS(s,"222000333");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 222000333 should be 222000333 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #5 input : 12345678900987654321 ");
        }
        b1 = new BinaryNumber("12345678900987654321");
        s=b1.toIntString();
        ans=CS(s,"12345678900987654321");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 12345678900987654321 should be 12345678900987654321 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #6 input : 1234567890098765432112345678900987654321 ");
        }
        b1 = new BinaryNumber("1234567890098765432112345678900987654321");
        s=b1.toIntString();
        ans=CS(s,"1234567890098765432112345678900987654321");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input 1234567890098765432112345678900987654321 should be 1234567890098765432112345678900987654321 but yours is: " + s );
            good=false;
        }

        if (isDisplay) {
            System.out.println("testing #7 input : -1 ");
        }

        b1 = new BinaryNumber("-1");
        s=b1.toIntString();
        ans=CS(s,"-1");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input -1 should be -1 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #8 input : -2 ");
        }
        b1 = new BinaryNumber("-2");
        s=b1.toIntString();
        ans=CS(s,"-2");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input -2 should be -2 but yours is: " + s );
            good=false;
        }
        if (isDisplay) {
            System.out.println("testing #9 input : -1234 ");
        }
        b1 = new BinaryNumber("-1234");
        s=b1.toIntString();
        ans=CS(s,"-1234");
        if(!ans){
            System.out.println();
            fail();
            System.out.println("Input -1234 should be -1234 but yours is: " + s );
            good=false;
        }

        if(good)
            good();
    }







}
