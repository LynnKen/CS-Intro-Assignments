final public class Bit implements Comparable<Bit> {
    public static final Bit ONE = new Bit(true);
    public static final Bit ZERO = new Bit(false);

    private final boolean value;

    // This constructor is private so no additional instances can be created.
    private Bit(boolean value) {
        this.value = value;
    }

    // Gets the value of the bit as boolean
    // Returns Bit.ONE if it true, and Bit.ZERO otherwise
    public static Bit of(boolean value) {
        if(value){
            return ONE;
        }
        // else
        return ZERO;
    }

    // Assumes intValue is either 0 or 1
    // Returns the corresponding Bit
    public static Bit of(int intValue) {
        if (intValue != 0 && intValue != 1) {
            throw new IllegalArgumentException(intValue + " is neither 0 nor 1.");
        }
        if (intValue == 1){
            return ONE;
        }
        // else
        return ZERO;
    }

    // Returns the value of the Bit as integer
    public int toInt() {
        if (value){
            return 1;
        }
        // else
        return 0;
    }

    // Returns true if this Bit is Bit.ONE
    public boolean toBoolean() {
        return value;
    }

    public String toString() {
        if (value){
            return "1";
        }
        // else
        return "0";
    }

    // Performs the regular == check since there are only two possible instances of this class.
    public boolean equals(Object obj) {
        return this == obj;
    }

    public int compareTo(Bit other) {
        return Boolean.compare(this.value, other.value);
    }

    // Returns the negative of the current Bit
    public Bit negate() {
        if (this.value){
            return Bit.ZERO;
        }
        // else
        return Bit.ONE;
    }

    // Gets 3 Bits
    // Returns the full adder sum of the bits, as described in https://en.wikipedia.org/wiki/Adder_(electronics)
    // using bit-wise operations
    public static Bit fullAdderSum(Bit bit1, Bit bit2, Bit bit3) {
        if (bit1.value ^ bit2.value ^ bit3.value){
            return ONE;
        }
        // else
        return ZERO;
    }

    // Gets 3 Bits
    // Returns the full adder carry of the bits, as described in https://en.wikipedia.org/wiki/Adder_(electronics)
    // using bit-wise operations
    public static Bit fullAdderCarry(Bit bit1, Bit bit2, Bit bit3) {
        if (((bit1.value ^ bit2.value) && bit3.value) || (bit1.value && bit2.value)){
            return ONE;
        }
        // else
        return ZERO;
    }
}