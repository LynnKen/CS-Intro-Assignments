
public class DecimalNumber {

    //----------------Fields------------------
    private String decimalValue;


    //----------------Constructors------------------

    //Task 1.6
    // 'value' is a string representing a valid decimal number.
    // Constructs a DecimalNumber with the given decimal string value
    public DecimalNumber(String value) {
        // ---------------write your code BELOW this line only! ------------------
        if (!legalNumericString(value,10))
            throw new IllegalArgumentException("value is not valid decimal number");
        decimalValue=value;
        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 1.7
    // 'value' is a string representing a valid number in the given 'base' (2, 8, or 10).
    // Constructs a DecimalNumber by converting the given value from the specified base to decimal.
    public DecimalNumber(String value, int base) {
        // ---------------write your code BELOW this line only! ------------------
        if (base!=2 && base != 8 && base != 10)
            throw new IllegalArgumentException("base is illegal. choose between {2,8,10}");

        if (base==10 && legalNumericString(value, 10))
            decimalValue=value;
        else if (base==8 && legalNumericString(value, 8))
            decimalValue = octalToDecimal(value);
        else if (legalNumericString(value, 2))
            decimalValue = binaryToDecimal(value);
        else
            throw new IllegalArgumentException("string is illegal");
        // ---------------write your code ABOVE this line only! ------------------
    }

    //----------------Public Methods------------------
    // Increments decimalValue by 1.
    public void increment() {
        this.decimalValue = decimalIncrement(this.decimalValue);
    }

    // Multiplies decimalValue by 2.
    public void multiplyByTwo() {
        this.decimalValue = decimalDouble(this.decimalValue);
    }

    public String getDecimalValue(){
        return decimalValue;
    }

    //Task 1.8
    // Returns the decimal number as a string.
    public String toString() {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        for (int i = 0; i < decimalValue.length(); i++) {
            ans = ans + decimalValue.charAt(i);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.8
    // No assumptions
    // Compares this DecimalNumber to another for equality based on their decimal values. If other is null, should return false.
    public boolean equals(Object other) {
        boolean equals = false;
        // ---------------write your code BELOW this line only! ------------------
        if (other instanceof DecimalNumber) {
            String otherDV = ((DecimalNumber)(other)).getDecimalValue();
            equals = (decimalValue.equals(otherDV));
        }
        // ---------------write your code ABOVE this line only! ------------------
        return equals;
    }


    //----------------Private Static Functions------------------
    // No assumptions
    // Converts the character 'c' to its integer value, returns -1 if 'c' is not a decimal digit.
    private static int toInt(char c) {
        return "0123456789".indexOf(c);
    }

    //Task 1.1
    // No assumptions
    // Checks if 's' is a valid numeric string in the specified 'base'>1.
    private static boolean legalNumericString(String s, int base) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if (base <= 1 || base > 10 || s == null || s.isEmpty()) //fast checks
            ans = false;
        else if (s.charAt(s.length()-1) == '0' && s.length() != 1)
            ans = false;
        else {
            for (int i = 0; i < s.length(); i++) {
                int checkFirst = toInt(s.charAt(i));
                if (checkFirst == -1 || checkFirst >= base) //if all values between 0 and (base-1) include
                    ans = false;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number.
    // Increments the number represented by 's' by 1 and returns the result as a string.
    private static String decimalIncrement(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (!legalNumericString(s,10))
            throw new IllegalArgumentException("input is illegal, check that s is a valid decimal number");
        ans=decimalIncrement(s,1);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }


    //Task 1.2
    // 's' is a string representing a valid decimal number, 0<='carry'<=1.
    // Increments the number represented by 's' by 'carry'.
    private static String decimalIncrement(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (carry == 1) {
            if (s.isEmpty()) {
                ans = "1";
            } else {
                char checkChar = s.charAt(0);
                int digit = toInt(checkChar);
                if (digit == 9) {
                    digit = 0;
                    ans = digit + decimalIncrement(s.substring(1), carry); //will run, 0<=beginindex<=s.length
                } else {
                    digit = digit + 1;
                    ans = digit + s.substring(1);
                    //carry=0;
                }
            }
        } else {
            ans = s;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number.
    // Doubles the decimal number represented by 's' and returns the result as a string.
    private static String decimalDouble(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (!legalNumericString(s,10))
            throw new IllegalArgumentException("s isn't valid decimal number");

        ans=decimalDouble(s,0);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number, 0<='carry'<=1
    // Doubles the decimal number represented by 's', and adds to it the 'carry'
    private static String decimalDouble(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (s.isEmpty()) {
            if (carry == 1)
                ans = "1";
        } else {
            char checkChar = s.charAt(0);
            int digit = toInt(checkChar);

            digit = digit * 2 + carry; //digit To Add
            if (digit < 10)
                carry = 0;
            else {
                digit = digit - 10;
                carry = 1;
            }
            ans = digit + decimalDouble(s.substring(1), carry);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.4
    // 's' is a string representing a valid binary number.
    // Converts a binary string 's' to its decimal string representation.
    private static String binaryToDecimal(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (s.length() == 1) {
            if (s.equals("0"))
                ans = "0";
            else
                ans = "1";
        } else {
            int value = toInt(s.charAt(0));

            ans = decimalIncrement(decimalDouble(binaryToDecimal(s.substring(1))), value);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }


    //Task 1.5
    // 's' is a string representing a valid octal number. s.length()>0
    // Converts an octal string 's' to its decimal string representation.
    private static String octalToDecimal(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------

        if (s.length() == 1) {
            if (s.equals("0"))
                ans = "0";
            else
                ans = s;
        } else {
            int value = toInt(s.charAt(0));

            ans = multiplyBy2PowerTimes(octalToDecimal(s.substring(1)), 3);
            ans = incrementBy(ans, value);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //'s' is a string valid decimal number, times>=0
    // Multiply the number represented 's' by (2^'times'), returns String.
    private static String multiplyBy2PowerTimes(String s,int times) {
        if (times < 0 || !legalNumericString(s, 10))
            throw new IllegalArgumentException("String should represent a valid decimal numeric number. Times should be at least 0");

        String ans = "";
        if (times == 0)
            ans = s;
        else
            ans = multiplyBy2PowerTimes(decimalDouble(s), times - 1);
        return ans;
    }

    //'s' is a valid decimal number, number to add should be at least 0;
    // Increments the number represented by 's' by 'toAdd'.
    private static String incrementBy(String s, int toAdd) {
        if (toAdd < 0 || !legalNumericString(s, 10))
            throw new IllegalArgumentException("String should represent a valid decimal numeric number. Number to add should be >= 0");
        if (toAdd==0)
            return s;
        return decimalIncrement(incrementBy(s,toAdd-1),1);
    }

}
