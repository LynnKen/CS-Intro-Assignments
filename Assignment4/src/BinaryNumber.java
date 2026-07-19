import java.util.Iterator;

public class BinaryNumber implements Comparable<BinaryNumber> {
    final private BinaryRepresentation rep;

//    //Todo: Temporary for testing remember to delete before submitting
    public BinaryNumber(int n, boolean nagtive) {
        int value = n * -1;
        BinaryNumber postiveBinaryNumber = new BinaryNumber(value);
        BinaryNumber nagtiveBinaryNumber = new BinaryNumber(postiveBinaryNumber.negate());
        this.rep = nagtiveBinaryNumber.getRep();
    }
//    public BinaryNumber(int n, boolean isNegative) {
//        this.rep = new BinaryRepresentation();
//
//        if (n == 0) {
//            this.rep.addFirst(Bit.ZERO);
//        } else {
//            int value = Math.abs(n);
//            while (value > 0) {
//                if (value % 2 == 1)
//                    this.rep.addFirst(Bit.ONE);
//                else
//                    this.rep.addFirst(Bit.ZERO);
//
//                value = value / 2;
//            }
//
//            // לוודא LSNF
//            if (!isNegative && this.rep.getLast().equals(Bit.ONE)) {
//                this.rep.addLast(Bit.ZERO);
//            } else if (isNegative && this.rep.getLast().equals(Bit.ZERO)) {
//                this.rep.addLast(Bit.ONE);
//            }
//        }
//
//        // טיפול ב־isNegative
//            if (isNegative) {
//                this.rep.complement();
//                BinaryNumber incremented = new BinaryNumber(this);
//                incremented = incremented.increment();
//                this.rep.copyFrom(incremented.rep);
//            }
//
//
////            this.rep.complement();
////            BinaryNumber incremented = this.increment();
////            this.rep.copyFrom(incremented.rep);
//////
////            BinaryNumber incremented = this.increment();
////            this.rep = incremented.rep;
//    }
    public BinaryRepresentation getRep() {
        return this.rep;
    }
//    //untill here

    // Task 2.1
    // Assumes n is non-negative
    // Initializes a BinaryNumber representing n
    public BinaryNumber(int n) {
        if (n<0)
            throw new IllegalArgumentException("number can't be negative");
        rep=new BinaryRepresentation();
        if (n==0)
            rep.addFirst(Bit.ZERO);
        else {
            while (n >= 1) {
                if (n==1){
                    rep.addLast(Bit.ONE);
                    n=-1;
                } else {
                    if ((n % 2) == 1)
                        rep.addLast(Bit.ONE);
                    else
                        rep.addLast(Bit.ZERO);
                    n = n / 2;
                }
            }
            rep.addLast(Bit.ZERO);
        }
    }

    // Assumes other is a non-null BinaryNumber
    // Initializes a copy of other
    public BinaryNumber(BinaryNumber other) {
        this.rep = new BinaryRepresentation(other.rep);
    }

    // Task 2.12
    // Assumes s is a string representing a valid number, either positive or negative
    // Initializes a BinaryNumber representing the number described in s
    public BinaryNumber(String s) {
        if (s==null)
            throw new IllegalArgumentException("s can't be null");
        String copy=s; //immutable
        BinaryNumber bn=new BinaryNumber(0);
        boolean isNegative=(s.charAt(0)=='-');

        if (isNegative)
            copy=s.substring(1);

        for (int i=copy.length()-1;i>=0;i--){
            int digit=toInt(copy.charAt(i));
            BinaryNumber digShifted=new BinaryNumber(digit);
            for (int j=i;j<copy.length()-1;j++)
                digShifted=digShifted.multiply(new BinaryNumber(10));
            bn=bn.add(digShifted);
        }

        if (isNegative)
            bn=bn.negate();

        this.rep=new BinaryRepresentation(bn.rep);
    }


    // Task 2.4
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the addition of other to this (i.e. this + other)
    public BinaryNumber add(BinaryNumber other) {
        if (other == null)
            throw new IllegalArgumentException("can't add null");

        //checks if negative
        BinaryNumber thisToAdd=new BinaryNumber(this);
        BinaryNumber otherToAdd =new BinaryNumber(other);

        //padding
        if (this.rep.length() >= other.rep.length())
            otherToAdd.rep.padding(this.rep.length());
        else
            thisToAdd.rep.padding(other.rep.length());

        //declarations
        BinaryNumber sum = new BinaryNumber(0);
        sum.rep.removeFirst();
        BinaryRepresentation sumRep=sum.rep;

        Iterator<Bit> thisITR = thisToAdd.rep.iterator();
        Iterator<Bit> otherITR = otherToAdd.rep.iterator();
        Bit carry = Bit.ZERO;

        //adding
        while (thisITR.hasNext()) {
            Bit firstDig = thisITR.next();
            Bit secondDig = otherITR.next();

            Bit sumDigits = Bit.fullAdderSum(firstDig, secondDig, carry);
            carry = Bit.fullAdderCarry(firstDig, secondDig, carry);
            sumRep.addLast(sumDigits);
        }
        //checking signs
        Bit msbThis=this.rep.getLast();
        Bit msbOther=other.rep.getLast();
        Bit msbSum= sum.rep.getLast();

        if (msbThis.equals(msbOther)) {
            if (!msbThis.equals(msbSum)) //if overflow
                sum.rep.addLast(msbThis);
            else if (carry.equals(Bit.ONE))
                sum.rep.addLast(carry);
        }
//        if (msbThis.equals(msbOther) && !msbThis.equals(msbSum))
//                sum.rep.addLast(msbThis);

        sumRep.reduce();
        return sum;
    }

    //returns new BinaryNumber represents this BinaryNumber+1
    private BinaryNumber increment() {
        BinaryNumber increment = null;
        if (rep.getFirst().equals(Bit.ZERO)) {
                increment=new BinaryNumber(this);
                increment.rep.removeFirst();
                increment.rep.addFirst(Bit.ONE);
            } else {
            //clear
            increment = new BinaryNumber(0);
            increment.rep.removeFirst();

            Iterator<Bit> itr = this.rep.iterator();
            Bit carry = Bit.ONE;

            while (itr.hasNext() && carry.equals(Bit.ONE)) {
                Bit current = itr.next();
                Bit sumDigits = Bit.fullAdderSum(current, Bit.ZERO, carry);
                carry = Bit.fullAdderCarry(current, Bit.ZERO, carry);
                increment.rep.addLast(sumDigits);
            }
            if (carry.equals(Bit.ONE)) {
                increment.rep.addLast(Bit.ONE);
            } else {
                while (itr.hasNext())
                    increment.rep.addLast(itr.next());
            }

//            Iterator<Bit> thisITR = this.rep.iterator();
//            Bit carry = Bit.ONE;
//
//            //adding
//            while (thisITR.hasNext() && carry.equals(Bit.ONE)) {
//                Bit firstDig = thisITR.next();
//
//                Bit sumDigits = Bit.fullAdderSum(firstDig, Bit.ZERO, carry);
//                carry = Bit.fullAdderCarry(firstDig, Bit.ZERO, carry);
//                increment.rep.addLast(sumDigits);
//
//            }
        }
        return increment;
    }
    // Task 2.5
    // Returns a new BinaryNumber that represents the Additive Inverse of this, that is, if this equals X, the return value is -X
    public BinaryNumber negate() {
        BinaryNumber negative=null;
        if (isLegal()) {
            negative = new BinaryNumber(this);
            if (negative.rep.length()!=1) { //if not <0>
                negative.rep.complement();
                negative = negative.increment();

            }
            negative.rep.reduce();
        }
        return negative;
    }

    // Task 2.6
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the subtraction of other from this (i.e. this - other)
    public BinaryNumber subtract(BinaryNumber other) {
        if (other==null)
            throw new IllegalArgumentException("can't subtract null");
        BinaryNumber subtracted;
        BinaryNumber toSubtract = other.negate();
        subtracted = this.add(toSubtract);

        return subtracted;
    }

    // Task 2.7
    // Returns 1 if the number represented by this object is positive, -1 if it negative and 0 if it equals 0
    public int signum() {
        int ans;
        if (rep.length()==1) //can't be <1>
            ans=0;
        else {
            Bit lastDig=rep.getLast();
            if (lastDig.equals(Bit.ZERO))
                ans=1;
            else
                ans=-1;
        }
        return ans;
    }

    // Task 2.10
    // Assumes other is non-null BinaryNumber which is positive
    // Returns a new BinaryNumber containing the result of the multiplication of other and this (i.e. this * other)
    private BinaryNumber multiplyPositive(BinaryNumber other) {
        BinaryNumber temp1 = new BinaryNumber(this);
        BinaryNumber temp2 = new BinaryNumber(other);
        temp1.rep.padding(temp2.rep.length());
        BinaryNumber ans = new BinaryNumber(0);

        ans = multiplyPositive(temp1, temp2, ans);
        return ans;
    }
    private BinaryNumber multiplyPositive(BinaryNumber thisT,BinaryNumber otherT, BinaryNumber sum) {
        if (otherT.rep.length() == 1) //positive, last=0
            return sum;
        Bit digPointer = otherT.rep.removeFirst();
        if (digPointer.equals(Bit.ONE)) {
            sum=sum.add(thisT);
        }
        thisT.rep.shiftLeft();
        return multiplyPositive(thisT, otherT, sum);
    }

    // Task 2.10
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the multiplication of other and this (i.e. this * other)
    public BinaryNumber multiply(BinaryNumber other) {
        if (other==null)
            throw new IllegalArgumentException("other can't be null");
        BinaryNumber thisTemp=new BinaryNumber(this);
        BinaryNumber otherTemp=new BinaryNumber(other);

        int thisS=this.signum();
        int otherS= other.signum();
        if (thisS==-1) {
            thisTemp=this.negate();
        }
        if (otherS==-1) {
            otherTemp = other.negate();
        }
        BinaryNumber ans=thisTemp.multiplyPositive(otherTemp);
        if (thisS==-1 && otherS!=-1 || thisS!=-1 && otherS==-1)
            ans=ans.negate();
        return ans;
    }

    // Task 2.11
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the integer-division of other from this (i.e. this / other)
    public BinaryNumber divide(BinaryNumber other) {
        if (other == null)
            throw new IllegalArgumentException("can't divide with null");

        BinaryNumber thisTemp = new BinaryNumber(this);
        BinaryNumber otherTemp = new BinaryNumber(other);
        //thisTemp.equalPadding(otherTemp);

        int thisS = this.signum();
        int otherS = other.signum();
        if (thisS == -1) {
            thisTemp = this.negate();
        }
        if (otherS == -1) {
            otherTemp = other.negate();
        }
        BinaryNumber ans = thisTemp.dividePositive(otherTemp);
        if (thisS == -1 && otherS != -1 || thisS != -1 && otherS == -1)
            ans = ans.negate();
        return ans;
    }
    private BinaryNumber dividePositive(BinaryNumber divisor){
        BinaryNumber divided=new BinaryNumber(this);
        BinaryNumber quotient=new BinaryNumber(0);

        while (divided.compareTo(divisor)>=0){
            BinaryNumber shiftedDivisor=new BinaryNumber(divisor);
            BinaryNumber multiple=new BinaryNumber(1);

            //find the largest divider that is smaller than divided
            BinaryNumber tryShift = new BinaryNumber(shiftedDivisor);
            tryShift.rep.shiftLeft();

            while (tryShift.compareTo(divided) <= 0) {
                shiftedDivisor = tryShift;
                multiple.rep.shiftLeft();

                tryShift = new BinaryNumber(shiftedDivisor);
                tryShift.rep.shiftLeft();
            }

            //update data
            divided = divided.subtract(shiftedDivisor);
            quotient = quotient.add(multiple);
        }
        return quotient;
    }

    // Task 2.2
    // Assumes this object represents a legal binary number
    // Returns the represention of this BinaryNumber as a binary string, that is, all the chars are either 0 or 1
    public String toString() {
        if (!isLegal()) {
            throw new IllegalArgumentException("Illegal Number");
        }
        String s="";
        Iterator<Bit> itr= rep.iterator();
        while (itr.hasNext())
            s=itr.next().toString()+s;
        return s;
    }

    // Task 2.3
    // Returns true if and only if this and other represent the same number
    public boolean equals(Object other) {
        //return super.equals(other); // This is the default implementation of equals

        boolean ans=true;
        if (!(other instanceof BinaryNumber))
            ans=false;
        //return (this.compareTo(((BinaryNumber) other))==0);
        else {
            if (this.rep.length()!=((BinaryNumber)other).rep.length())
                ans=false;
            else {
                Iterator<Bit> thisITR = this.rep.iterator();
                Iterator<Bit> otherITR = ((BinaryNumber) other).rep.iterator();
                while (thisITR.hasNext())
                    if (!thisITR.next().equals(otherITR.next()))
                        ans = false;
            }
        }
        return ans;
    }

//    //padding this or other to equalize number of Bits in rep
//    private void equalPadding(BinaryNumber other){
//        if (isLegal()&&other.isLegal()) {
//            int maxLength;
//            if (this.rep.length() >= other.rep.length()) {
//                maxLength = this.rep.length();
//                other.rep.padding(maxLength);
//            } else {
//                maxLength = other.rep.length();
//                this.rep.padding(maxLength);
//            }
//        }
//    }
    // Task 2.8
    // Returns a positive number if this object represents a number bigger than the one other represents,
    // 0 if they are equal, and a negative number if it is smaller.
    public int compareTo(BinaryNumber other) {
        if (other==null)
            throw new IllegalArgumentException("can't compare to null");
        return (this.subtract(other)).signum();
//        int ans = 0;
//        int sign=signum();
//        //different signs
//        if (sign > other.signum())
//            ans = 1;
//        else if (sign < other.signum())
//            ans = -1;
//        else { //same signs, different lengths
//            if (this.rep.length() > other.rep.length()) {
//                if (this.rep.getLast().equals(Bit.ZERO)) //check if positive or negative
//                    ans = 1;
//                else
//                    ans = -1;
//            } else if (this.rep.length() < other.rep.length()) {
//                if (this.rep.getLast().equals(Bit.ZERO)) //check if positive or negative
//                    ans = -1;
//                else
//                    ans = 1;
//            }else { //same signs, same lengths
//                Bit[] thisArrayRep = new Bit[rep.length()];
//                Bit[] otherArrayRep = new Bit[other.rep.length()];
//                Iterator<Bit> itr = rep.iterator();
//                Iterator<Bit> otherItr = other.rep.iterator();
//                for (int i = rep.length() - 1; i >= 0; i--) { //same length
//                    thisArrayRep[i] = itr.next();
//                    otherArrayRep[i] = otherItr.next();
//                }
//                for (int i = 1; ans == 0 && i < rep.length(); i++) { //MSB must be equal>i=1
//                    if (thisArrayRep[i].equals(Bit.ONE) && otherArrayRep[i].equals(Bit.ZERO)) {
//                        if (sign == 1)
//                            ans = 1;
//                        else
//                            ans = -1;
//                    } else if (thisArrayRep[i].equals(Bit.ZERO) && otherArrayRep[i].equals(Bit.ONE))
//                        if (sign == 1)
//                            ans = -1;
//                        else
//                            ans = 1;
//                }
//            }
//        }
//        return ans;
    }

    // Task 2.9
    // Assumes this current number is small enough to be represented by an int
    // Returns the int value of the number represented by this
    public int toInt() {
        if (this.rep.getLast().equals(Bit.ZERO) && this.rep.length()>31 || this.rep.length()>32)
            throw new IllegalArgumentException("number can't be presented with int");
        BinaryNumber temp=new BinaryNumber(this);
        int ans=0;
        int sign=this.signum();
        return toInt(temp.rep,ans,sign);
    }
    private int toInt(BinaryRepresentation bnRep,int counter,int sign) {
        //positive/negative
        if (bnRep.length() == 1) {
            if (bnRep.getLast().equals(Bit.ONE))
                return -1;
            else
                return 0;
        }
        Bit firstDig = bnRep.getFirst();
        if (firstDig.equals(Bit.ONE)) {
            bnRep.removeFirst();
            return 1 + 2 * toInt(bnRep, counter, sign);
        } else {
            bnRep.removeFirst();
            return 2 * toInt(bnRep, counter, sign);
        }
    }
    // No assumptions
    // Converts the character 'c' to its integer value, returns -1 if 'c' is not a decimal digit.
    private static int toInt(char c) {
        return "0123456789".indexOf(c);
    }


    //return signum of int
    private int signum(int num){
        if (num==0)
            return 0;
        if (num>0)
            return 1;
        return -1;
    }

    // Task 2.13
    // Assumes this object represents a legal binary number
    // Returns a decimal string (positive or negative) of the number represented by this
    public String toIntString() {
        if (!isLegal()) {
            throw new IllegalArgumentException("Illegal Number");
        }
        String s = "";
        if (rep.length() == 1 && rep.getFirst().equals(Bit.ZERO))
            s="0";
        else {

            boolean isNegative = (signum() == -1);
            Iterator<Bit> itr = rep.iterator();
            String multiple = "1";

            for (int i = 0; i < rep.length() - 1; i++) { //until one before last
                Bit bit = itr.next();
                if (bit.equals(Bit.ONE)) {
                    s = sumDecimalPositive(s, multiple);
                }
                multiple = multiplyDecimalBy2(multiple);
            }

            if (isNegative) {
                s = subDecimalS(multiple, s);
                s = "-" + s;

            }
        }

        return s;
    }
    //assumes bigger>smaller
    //returns bigger-smaller
    private String subDecimalS(String bigger, String smaller) {
        String result = "";
        //padding smaller
        while (bigger.length() > smaller.length()) {
            smaller = "0" + smaller;
        }
        int borrow = 0;
        for (int i = bigger.length() - 1; i >= 0; i--) {
            int digBg = toInt(bigger.charAt(i));
            int digSm = toInt(smaller.charAt(i));
            int dif = digBg - digSm - borrow;

            if (dif < 0) {
                dif = dif + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result = dif + result;
        }
        // reduce
        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return result;
    }

    //asuumes s represents positive number
    //returnes String represents s*2;
    private String multiplyDecimalBy2(String s) {
        String ans = "";
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digToAdd = toInt(s.charAt(i)) * 2 + carry;
            if (digToAdd > 9) {
                digToAdd = digToAdd - 10;
                carry = 1;
            } else
                carry = 0;
            ans = digToAdd + ans;
        }
        if (carry == 1)
            ans = 1 + ans;
        return ans;
    }

    //assumes num1,num2>=0
    //returns a String represented sum1+sum2
    private String sumDecimalPositive(String num1, String num2) {
        String s = "";
        String bigger;
        String smaller;
        int carry = 0;

        if (num1.length() >= num2.length()) {
            bigger = num1;
            smaller = num2;
        } else {
            bigger = num2;
            smaller = num1;
        }
        for (int i = bigger.length() - 1; i >= 0; i--) {
            int dig1 = toInt(bigger.charAt(i));
            int dig2;
            int difLength = bigger.length() - smaller.length();
            if (i - difLength >= 0)
                dig2 = toInt(smaller.charAt(i - difLength));
            else
                dig2 = 0;
            int sumDig = dig1 + dig2 + carry;

            if (sumDig > 9) {
                sumDig = sumDig - 10;
                carry = 1;
            } else
                carry = 0;
            s = sumDig + s;
        }
        if (carry == 1)
            s = 1 + s;
        return s;
    }
    /*
     * =================================================================
     *              Don't change the following functions:
     * =================================================================
     */

     // Returns true if and only if the representation of this BinaryNumber is a legal and minimal representation of a number
    public boolean isLegal() {
        return rep.isLegalNumber() && rep.isReduced();
    }

    // Returns the number of bits currently in the representation of this BinaryNumber
    public int length() {
        return this.rep.length();
    }

    // Returns a new BinaryNumber representing this * 2
    private BinaryNumber multiplyBy2() {
        BinaryNumber res = new BinaryNumber(this);
        res.rep.shiftLeft();
        return res;
    }

    // Returns a new BinaryNumber representing this / 2
    private BinaryNumber divideBy2() {
        BinaryNumber res = new BinaryNumber(this);
        res.rep.shiftRight();
        return res;
    }
}
