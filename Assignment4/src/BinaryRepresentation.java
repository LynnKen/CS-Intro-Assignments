import java.util.Iterator;
import java.util.LinkedList;

public class BinaryRepresentation implements Iterable<Bit> {
    final private LinkedList<Bit> bits;
    private int numOfOnes;

    //Todo : Temporary for testing remember to delete before submitting
    public LinkedList<Bit> getbits() {
        return this.bits;
    }
    public void copyFrom(BinaryRepresentation other) {
        this.bits.clear();
        for (Bit b : other) {
            this.addLast(b);
        }
    }
    //untill here

    // Creates an empty BinaryRepresentation
    public BinaryRepresentation() {
        this.bits = new LinkedList<>();
        this.numOfOnes = 0;
    }

    // Task 1.3
    // Assumes other is a non-null BinaryRepresentation
    // Creates a copy of the other
    public BinaryRepresentation(BinaryRepresentation other) {
        this.bits = new LinkedList<>();
        checkIfNull(other);
        Iterator<Bit> itr=other.iterator();
        Bit element;
        while (itr.hasNext()) {
            element=itr.next();
            bits.addLast(element);
            updateOneNum(element,1); //element is'nt null
        }
    }

    //checks if the Bit value is null and throw exception if so
    private void checkIfNull(Bit bit){
        if (bit==null)
            throw new IllegalArgumentException("input is illegal");
    }
    //checks if the BinaryRepresentation value is null and throw exception if so
    private void checkIfNull(BinaryRepresentation toCheck){
        if (toCheck==null)
            throw new IllegalArgumentException("input is illegal");
    }

    // assums bit isn't null
    // update numOfOnes fields according to action={1,-1} (1=add,-1=remove)
    private void updateOneNum(Bit bit,int action){
        if (Bit.ONE.equals(bit)){
            numOfOnes=numOfOnes+action;
        }
    }

    // Task 1.1
    // Assumes bit is a non-null Bit
    // Adds the bit into the first position in this representation
    public void addFirst(Bit bit) {
        checkIfNull(bit);
        bits.addFirst(bit);
        updateOneNum(bit,1);
    }

    // Task 1.1
    // Assumes bit is a non-null Bit
    // Adds the bit into the last position in this representation
    public void addLast(Bit bit) {
        checkIfNull(bit);
        bits.addLast(bit);
        updateOneNum(bit,1);
    }

    // Task 1.1
    // Removes the first bit of the representation
    public Bit removeFirst() {
        Bit first=bits.getFirst();
        bits.removeFirst();
        updateOneNum(first,-1);
        return first;
    }

    // Task 1.1
    // Removes the last bit of the representation
    public Bit removeLast() {
        Bit last=bits.getLast();
        bits.removeLast();
        updateOneNum(last,-1);
        return last;
    }

    // Task 1.4
    // Returns true if and only if the representation is a valid number, but not necessarly a minimal representation
    public boolean isLegalNumber() {
        boolean ans = false;
        if (!(bits == null || bits.isEmpty())) {
            if (bits.getLast().equals(Bit.ZERO) || getNumOfOnes() > 1)
                ans = true;
        }
        return ans;
    }

    // Task 1.5
    // Returns true if and only if the representation is a valid minimal representation of a number
    public boolean isReduced() {
        boolean ans = false;

        if (isLegalNumber()) { //if empty
            if (bits.size() == 1 && bits.getFirst().equals(Bit.ZERO)) //length==1
                ans = true;
            else { //length>=2
                Iterator<Bit> itr = bits.descendingIterator(); //from end
                Bit last = itr.next();
                Bit preLast = itr.next();
                if (last.equals(Bit.ZERO) && preLast.equals(Bit.ONE) || //<01#>
                        last.equals(Bit.ONE) && preLast.equals(Bit.ONE) && numOfOnes == 2) //<11>,<110>
                    ans = true;
                else if (bits.size() > 2 && last.equals(Bit.ONE) && preLast.equals(Bit.ZERO)) //<10#>
                    ans = true;
            }
        }
        return ans;
    }

    // Task 1.5
    // If the current representation is not a minimal representation of a number, reduces it to the minimal form
    public void reduce() {
        while (!isReduced() && !bits.isEmpty()){ //checks if legal number
            Bit toRemove=bits.removeLast();
            updateOneNum(toRemove,-1);
        }
    }

    // Task 1.6
    // Replaces each Bit in the representation with its negative
    public void complement() {
        LinkedList<Bit> newBits = new LinkedList<Bit>();
        for (Bit value : bits) {
            if (value.equals(Bit.ONE))
                newBits.addLast(Bit.ZERO);
            else
                newBits.addLast(Bit.ONE);
        }
        bits.clear();
        bits.addAll(newBits);
        numOfOnes=bits.size()-numOfOnes;
    }

    // Task 1.7
    // Adds a zero bit in the first position of the representation
    public void shiftLeft() {
        bits.addFirst(Bit.ZERO);
    }

    // Task 1.7
    // Removes and returns the rightmost Bit of the representation if exists, and returns null if the representation is empty
    public Bit shiftRight() {
        Bit ans = null;
        if (!bits.isEmpty()) {
            ans = bits.removeFirst();
            updateOneNum(ans,-1);
        }
        return ans;
    }

    // Task 1.8
    // Pads this binary representation to the length newLength if it is larger than the current representation length
    // by adding the last Bit of the representation until reaching the desired length
    public void padding(int newLength) {
        if (isLegalNumber()) {
            Bit last = bits.getLast();
            while (bits.size() < newLength) {
                bits.addLast(last);
                updateOneNum(last,1);
            }
        }
    }

    // Task 1.2
    // Returns a string of the bits of this representation surrounded by '<' and '>'
    public String toString() {
        String st;
        if (bits.size() == 0)
            st = "<>";
        else {
            st = ">";
            Iterator<Bit> itr = bits.iterator();
            while (itr.hasNext()) {
                st = itr.next().toString() + st;
            }
            st = "<" + st;
        }
        return st;
    }

    /*
     * =====================================================
     *                                        Do not change the following methods:
     * =====================================================
     */

     // Returns the last bit of this representation without removing it
    public Bit getLast() {
        return this.bits.get(this.bits.size() - 1);
    }

    // Returns the first bit of this representation without removing it
    public Bit getFirst() {
        return this.bits.get(0);
    }

    // Returns the number of ones in the representation
    public int getNumOfOnes() { return this.numOfOnes; }

    // Returns the number of bits in the representation
    public int length() {
        return this.bits.size();
    }

    // Returns the built-in iterator of java.util.LinkedList<T> for easier iteration over the representation
    public Iterator<Bit> iterator() {
        return this.bits.iterator();
    }
}
