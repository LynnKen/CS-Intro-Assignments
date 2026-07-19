import java.util.LinkedList;
import java.util.NoSuchElementException;

public class testBinaryRepresentation {

    public static void main(String[] args) {

        testAddFirst();
        testAddFirstNull();
        testAddLast();
        testRemoveFirst();
        testRemoveFirstEmpty();
        testRemoveLast();
        testRemoveLastEmpty();
        testToString();
        testEquals();
        testIsLegalNumber_True();
        testIsLegalNumber_False();
        testIsReduced();
        testReduce();
        testComplement();
        testShiftLeft();
        testShiftRight();
        testPaddingExpand();
        testPaddingNoChange();

    }

    public static void testAddFirst() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ONE);
        String expected = "<01>";
        String actual = b.toString();
        printResult("testAddFirst", expected.equals(actual));
    }

    public static void testAddFirstNull() {
        BinaryRepresentation b = new BinaryRepresentation();
        boolean exceptionThrown = false;
        try {
            b.addFirst(null);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        printResult("testAddFirstNull", exceptionThrown);
    }

    public static void testAddLast() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addLast(Bit.ONE);
        b.addLast(Bit.ZERO);
        String expected = "<01>";
        String actual = b.toString();
        printResult("testAddLast", expected.equals(actual));
    }

    public static void testRemoveFirst() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO);
        Bit removed = b.removeFirst();
        boolean correct = (removed == Bit.ZERO) && b.toString().equals("<1>");
        printResult("testRemoveFirst", correct);
    }

    public static void testRemoveFirstEmpty() {
        BinaryRepresentation b = new BinaryRepresentation();
        boolean exceptionThrown = false;
        try {
            b.removeFirst();
        } catch (NoSuchElementException | IllegalArgumentException e) {
            exceptionThrown = true;
        }
        printResult("testRemoveFirstEmpty", exceptionThrown);
    }

    public static void testRemoveLast() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addLast(Bit.ZERO);
        Bit removed = b.removeLast();
        boolean correct = (removed == Bit.ZERO) && b.toString().equals("<1>");
        printResult("testRemoveLast", correct);
    }

    public static void testRemoveLastEmpty() {
        BinaryRepresentation b = new BinaryRepresentation();
        boolean exceptionThrown = false;
        try {
            b.removeLast();
        } catch (NoSuchElementException | IllegalArgumentException e) {
            exceptionThrown = true;
        }
        printResult("testRemoveLastEmpty", exceptionThrown);
    }

    public static void testToString() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ONE);
        String expected = "<01>";
        String actual = b.toString();
        printResult("testToString", expected.equals(actual));
    }

    public static void testEquals() {
        BinaryRepresentation b1 = new BinaryRepresentation();
        b1.addFirst(Bit.ONE);
        b1.addFirst(Bit.ZERO);

        BinaryRepresentation b2 = new BinaryRepresentation();
        b2.addFirst(Bit.ONE);
        b2.addFirst(Bit.ZERO);

        printResult("testEquals", b1.equals(b2));
    }

    public static void testIsLegalNumber_True() {
        BinaryRepresentation b = new BinaryRepresentation();
        // <1100> → חוקי (עבור -4 לדוגמא)
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ONE);

        printResult("testIsLegalNumber_True", b.isLegalNumber());
    }

    public static void testIsLegalNumber_False() {
        BinaryRepresentation b = new BinaryRepresentation();
        // <001> → לא חוקי
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ZERO);

        printResult("testIsLegalNumber_False", !b.isLegalNumber());
    }

    public static void testReduce() {
        BinaryRepresentation b = new BinaryRepresentation();
        // <000001> → צריך להפוך ל-<01>
        b.addFirst(Bit.ONE);
        for (int i = 0; i < 5; i++) {
            b.addFirst(Bit.ZERO);
        }

        b.reduce();
        String expected = "<01>";
        String actual = b.toString();
        printResult("testReduce", expected.equals(actual));
    }

    public static void testIsReduced() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO);

        printResult("testIsReduced", b.isReduced());
    }

    public static void testComplement() {
        BinaryRepresentation b = new BinaryRepresentation();
        // <001> → complement → <110>
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ZERO);

        b.complement();
        String expected = "<110>";
        String actual = b.toString();
        printResult("testComplement", expected.equals(actual));
    }

    public static void testShiftLeft() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ZERO); // <001>

        b.shiftLeft(); // → <0010>
        String expected = "<0010>";
        String actual = b.toString();
        printResult("testShiftLeft", expected.equals(actual));
    }

    public static void testShiftRight() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO);
        b.addFirst(Bit.ZERO); // <001>

        b.shiftRight(); // → <00>
        String expected = "<00>";
        String actual = b.toString();
        printResult("testShiftRight", expected.equals(actual));
    }

    public static void testPaddingExpand() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO); // <01>

        b.padding(5); // → <00001>
        String expected = "<00001>";
        String actual = b.toString();
        printResult("testPaddingExpand", expected.equals(actual));
    }

    public static void testPaddingNoChange() {
        BinaryRepresentation b = new BinaryRepresentation();
        b.addFirst(Bit.ONE);
        b.addFirst(Bit.ZERO); // <01>

        b.padding(2); // אמור לא לשנות כלום
        String expected = "<01>";
        String actual = b.toString();
        printResult("testPaddingNoChange", expected.equals(actual));
    }

    // פונקצית עזר להדפסת תוצאות
    public static void printResult(String testName, boolean passed) {
        if (passed) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }
}
