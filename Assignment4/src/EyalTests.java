import java.util.Scanner;
import java.util.LinkedList;

public class EyalTests {
        public interface BooleanTest {
                boolean run();
        }

        private static int totalTests = 0;
        private static int passedTests = 0;

        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String RESET_COLOR = "\u001B[0m";
        public static final String BLUE = "\u001B[34m";
        public static String passedColor;

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                handleUserInput(scanner);
                printTestSummary();
                scanner.close();
        }

        private static void handleUserInput(Scanner scanner) {
                System.out.println("1 for Part 1\n2 for Part 2\n4 for more info");
                String part = scanner.nextLine();

                switch (part) {
                        case "1":
                        case "2":
                                runTests(part, scanner);
                                break;
                        case "4":
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
                System.out.println("1 for Logic tests\n2 for for exception testing");
                String testType = scanner.nextLine();

                switch (testType) {
                        case "1":
                                if (part.equals("1"))
                                        logicTestsPart1();
                                else
                                        logicTestsPart2();
                                break;
                        case "2":
                                if (part.equals("1"))
                                        exceptionTestPart1();
                                else
                                        exceptionTestsPart2();
                                break;
                        default:
                                System.out.println("nope");
                }
        }

        private static void logicTestsPart1() {

                runTest("addFirst", "add 0 to <> ", "<0> Number of ones: 0",
                                () -> addFirstTest(new int[] {}, Bit.ZERO, new int[] {0}, 0));
                runTest("addFirst", "add 0 to <0> ", "<0,0> Number of ones: 0",
                                () -> addFirstTest(new int[] {0}, Bit.ZERO, new int[] {0, 0}, 0));
                runTest("addFirst", "add 1 to <0,0> ",
                                "<0,0,1> Number of ones: 1",
                                () -> addFirstTest(new int[] {0, 0}, Bit.ONE, new int[] {0, 0, 1}, 1));
                runTest("addFirst", "add 0 to <0, 0, 1, 1, 0> ", "List:[0, 0, 1, 1, 0,0] Number of ones: 2",
                                () -> addFirstTest(new int[] {0, 0, 1, 1, 0}, Bit.ZERO, new int[] {0, 0, 1, 1, 0, 0}, 2));



                runTest("addLast", "add 1 to empty list", "<1> Number of ones: 1",
                                () -> addLastTest(new int[] {}, Bit.ONE, new int[] {1}, 1));
                runTest("addLast", "add 0 to <1>", "<0,1> Number of ones: 1",
                                () -> addLastTest(new int[] {1}, Bit.ZERO, new int[] {0, 1}, 1));
                runTest("addLast", "add one to <1,0>", "<1,1,0> Number of ones: 2",
                                () -> addLastTest(new int[] {1, 0}, Bit.ONE, new int[] {1, 1, 0}, 2));
                runTest("addLast", "add zero <1,1,0,1>", "<0,1,1,0,1> Number of ones: 3",
                                () -> addLastTest(new int[] {1, 1, 0, 1}, Bit.ZERO, new int[] {0, 1, 1, 0, 1}, 3));

                runTest("removeFirst", "remove 1 from <0,1>", "<0> Number of ones: 0",
                                () -> removedFirstTest(new int[] {0, 1}, new int[] {0}, Bit.ONE, 0));
                runTest("removeFirst", "remove 0 from <1,1,0>", "<1,1> Number of ones: 2",
                                () -> removedFirstTest(new int[] {1, 1, 0}, new int[] {1, 1}, Bit.ZERO, 2));
                runTest("removeFirst", "remove 1 from <1,0,1,1>", "<1,0,1> Number of ones: 2",
                                () -> removedFirstTest(new int[] {1, 0, 1, 1}, new int[] {1, 0, 1}, Bit.ONE, 2));

                runTest("removeLast", "remove 1 from <1,0>", "<0> Number of ones: 0",
                                () -> removedLastTest(new int[] {1, 0}, new int[] {0}, Bit.ONE, 0));
                runTest("removeLast", "remove 0 from <0,1>", "<1> Number of ones: 1",
                                () -> removedLastTest(new int[] {0, 1}, new int[] {1}, Bit.ZERO, 1));
                runTest("removeLast", "remove 1 from <1,1,0,1>", "<1,0,1> Number of ones: 2",
                                () -> removedLastTest(new int[] {1, 1, 0, 1}, new int[] {1, 0, 1}, Bit.ONE, 2));

                runTest("To String", "<>", "<>",
                                () -> testToString(new int[] {}, "<>"));
                runTest("To String", "<0>", "<0>",
                                () -> testToString(new int[] {0}, "<0>"));
                runTest("To String", "<0,0>", "<00>",
                                () -> testToString(new int[] {0, 0}, "<00>"));
                runTest("To String", "<0,0,1>", "<001>",
                                () -> testToString(new int[] {0, 0, 1}, "<001>"));
                runTest("To String", "<0,0,0>", "<000>",
                                () -> testToString(new int[] {0, 0, 0}, "<000>"));
                runTest("To String", "<1,1,0,0,1>", "<11001>",
                                () -> testToString(new int[] {1, 1, 0, 0, 1}, "<11001>"));
                runTest("To String", "<1,1,1,1>", "<1111>",
                                () -> testToString(new int[] {1, 1, 1, 1}, "<1111>"));
                runTest("To String", "<1,0,1,0,1>", "<10101>",
                                () -> testToString(new int[] {1, 0, 1, 0, 1}, "<10101>"));
                runTest("To String", "<0,1,1,0,1,1>", "<011011>",
                                () -> testToString(new int[] {0, 1, 1, 0, 1, 1}, "<011011>"));

                runTest("test Hard Copy", "<1,1,0,0,1>", "<1,1,0,0,1> , 3",
                                () -> testHardCopy(new int[] {1, 1, 0, 0, 1}, 3));
                runTest("test Hard Copy", "<>", "<> , 0",
                                () -> testHardCopy(new int[] {}, 0));
                runTest("test Hard Copy", "<0,0,0,0,0,0>", "<0,0,0,0,0,0> , 3",
                                () -> testHardCopy(new int[] {0, 0, 0, 0, 0, 0}, 3));

                // Test independence after modification
                runTest("test Hard Copy Independence", "<1,0,1>", "True",
                                () -> {
                                        BinaryRepresentation original = createBinaryRepresentation(new int[] {1, 0, 1});
                                        BinaryRepresentation copy = new BinaryRepresentation(original);
                                        original.addFirst(Bit.ONE);
                                        return !original.getbits().equals(copy.getbits());
                                });

                // Test independence of ones count
                runTest("test Hard Copy Ones Count", "<1,1,0>", "True",
                                () -> {
                                        BinaryRepresentation original = createBinaryRepresentation(new int[] {1, 1, 0});
                                        BinaryRepresentation copy = new BinaryRepresentation(original);
                                        original.addFirst(Bit.ONE);
                                        return original.getNumOfOnes() != copy.getNumOfOnes();
                                });

                runTest("test is Legal Number", "<0,0,0,0,0,0>", "true",
                                () -> tesisLegalNumber(new int[] {0, 0, 0, 0, 0, 0}, true));
                runTest("test is Legal Number", "<1,0,0,0,0,0>", "false",
                                () -> tesisLegalNumber(new int[] {1, 0, 0, 0, 0, 0}, false));
                runTest("test is Legal Number", "<>", "false",
                                () -> tesisLegalNumber(new int[] {}, false));
                runTest("test is Legal Number", "<1>", "false",
                                () -> tesisLegalNumber(new int[] {1}, false));
                runTest("test is Legal Number", "<1,1>", "true",
                                () -> tesisLegalNumber(new int[] {1, 1}, true));
                runTest("test is Legal Number", "<0,1,0,0>", "true",
                                () -> tesisLegalNumber(new int[] {0, 1, 0, 0}, true));
                runTest("test is Legal Number", "<0,1,0,0,1>", "true",
                                () -> tesisLegalNumber(new int[] {0, 1, 0, 0, 1}, true));
                runTest("test is Legal Number", "<1,0,0,1,0>", "true",
                                () -> tesisLegalNumber(new int[] {1, 0, 0, 1, 0}, true));
                runTest("test is Legal Number", "<1,1,0,0,0>", "true",
                                () -> tesisLegalNumber(new int[] {1, 1, 0, 0, 0}, true));
                runTest("test is Legal Number", "<1,0,0,0>", "false",
                                () -> tesisLegalNumber(new int[] {1, 0, 0, 0}, false));
                runTest("test is Legal Number", "<1,1>", "true",
                                () -> tesisLegalNumber(new int[] {1, 1}, true));

                runTest("test Is Reduced", "<1,1>", "true",
                                () -> testIsReduced(new int[] {1, 1}, true));
                runTest("test Is Reduced", "<0>", "true",
                                () -> testIsReduced(new int[] {0}, true));
                runTest("test Is Reduced", "<1>", "false",
                                () -> testIsReduced(new int[] {1}, false));
                runTest("test Is Reduced", "<0,1>", "false",
                                () -> testIsReduced(new int[] {1}, false));
                runTest("test Is Reduced", "<0,1,0,0>", "true",
                                () -> testIsReduced(new int[] {0, 1, 0, 0}, true));

                runTest("test Is Reduced", "<1,1,0,1,1>", "false",
                                () -> testIsReduced(new int[] {1, 1, 0, 1, 1}, false));
                runTest("test Is Reduced", "<1,0,1>", "true",
                                () -> testIsReduced(new int[] {1, 0, 1}, true));
                runTest("test Is Reduced", "<1,0,1,0,1>", "true",
                                () -> testIsReduced(new int[] {1, 0, 1, 0, 1}, true));
                runTest("test Is Reduced", "<1,1,0>", "true",
                                () -> testIsReduced(new int[] {1, 1, 0}, true));
                runTest("test Is Reduced", "<1,1,0,0>", "true",
                                () -> testIsReduced(new int[] {1, 1, 0, 0}, true));
                runTest("test Is Reduced", "<1,1,0,0,0>", "true",
                                () -> testIsReduced(new int[] {1, 1, 0, 0, 0}, true));
                runTest("test Is Reduced", "<1,0>", "false",
                                () -> testIsReduced(new int[] {1, 0}, false));
                runTest("test Is Reduced", "<1,1,1>", "false",
                                () -> testIsReduced(new int[] {1, 1, 1}, false));
                runTest("test Is Reduced", "<0,0,0>", "false",
                                () -> testIsReduced(new int[] {0, 0, 0}, false));

                runTest("test Reduced", "<000001>", "<0,1>",
                                () -> testReduce(new int[] {0, 0, 0, 0, 0, 1}, new int[] {0, 1}));
                runTest("test Reduced", "<0,0,0>", "<0>",
                                () -> testReduce(new int[] {0, 0, 0}, new int[] {0}));
                runTest("test Reduced", "<11101>", "<1,0,1>",
                                () -> testReduce(new int[] {1, 1, 1, 0, 1}, new int[] {1, 0, 1}));
                runTest("test Reduced", "<1111100>", "[1, 1, 0, 0]",
                                () -> testReduce(new int[] {1, 1, 1, 1, 1, 0, 0}, new int[] {1, 1, 0, 0}));
                runTest("test Reduced", "<1,0,1>", "<1,0,1>",
                                () -> testReduce(new int[] {1, 0, 1}, new int[] {1, 0, 1}));
                runTest("test Reduced", "<1,1>", "<1,1>",
                                () -> testReduce(new int[] {1, 1}, new int[] {1, 1}));
                runTest("test Reduced", "<1,0>", "<0>",
                                () -> testReduce(new int[] {1, 0}, new int[] {0}));
                runTest("test Reduced", "<0,1>", "<0,1>",
                                () -> testReduce(new int[] {0, 1}, new int[] {0, 1}));
                runTest("test Reduced", "<0>", "<0>",
                                () -> testReduce(new int[] {0}, new int[] {0}));

                runTest("test Complement", "<1,0,1>", "<0,1,0>",
                                () -> testComplement(new int[] {1, 0, 1}, new int[] {0, 1, 0}));
                runTest("test Complement", "<0,0,0>", "<1,1,1>",
                                () -> testComplement(new int[] {0, 0, 0}, new int[] {1, 1, 1}));
                runTest("test Complement", "<1,1,1,1>", "<0,0,0,0>",
                                () -> testComplement(new int[] {1, 1, 1, 1}, new int[] {0, 0, 0, 0}));
                runTest("test Complement", "<1,0,1,0>", "<0,1,0,1>",
                                () -> testComplement(new int[] {1, 0, 1, 0}, new int[] {0, 1, 0, 1}));
                runTest("test Complement", "<1>", "<0>",
                                () -> testComplement(new int[] {1}, new int[] {0}));


                runTest("Shift Right", "<0,1,1>", "<0,1>",
                                () -> testShiftRight(new int[] {0, 1, 1}, new int[] {0, 1}));
                runTest("Shift Right", "<1,0,0>", "<1,0>",
                                () -> testShiftRight(new int[] {1, 0, 0}, new int[] {1, 0}));
                runTest("Shift Right", "<1>", "<>",
                                () -> testShiftRight(new int[] {1}, new int[] {}));
                runTest("Shift Right", "<>", "<>",
                                () -> testShiftRight(new int[] {}, new int[] {}));
                runTest("Shift Right", "<1,0,1,1>", "<0,1,1>",
                                () -> testShiftRight(new int[] {1, 0, 1, 1}, new int[] {1, 0, 1}));

                runTest("Return Value Shift Right", "<0,1,1>", "0",
                                () -> testReturnValueShiftRight(new int[] {0, 1, 1}, Bit.ONE));
                runTest("Return Value Shift Right", "<1>", "1",
                                () -> testReturnValueShiftRight(new int[] {1}, Bit.ONE));
                runTest("Return Value Shift Right", "<>", "null",
                                () -> testReturnValueShiftRight(new int[] {}, null));
                runTest("Return Value Shift Right", "<1,0,1,1>", "1",
                                () -> testReturnValueShiftRight(new int[] {1, 0, 1, 1}, Bit.ONE));

                runTest("Shift Left", "<1,1>", "<1,1,0>",
                                () -> testShiftLeft(new int[] {1, 1}, new int[] {1, 1, 0}));
                runTest("Shift Left", "<>", "<0>",
                                () -> testShiftLeft(new int[] {}, new int[] {0}));
                runTest("Shift Left", "<1,0,1>", "<1,0,1,0>",
                                () -> testShiftLeft(new int[] {1, 0, 1}, new int[] {1, 0, 1, 0}));
                runTest("Shift Left", "<0>", "<0,0>",
                                () -> testShiftLeft(new int[] {0}, new int[] {0, 0}));

                runTest("test Padding", "<1,0,1> , 3", "<1,0,1>",
                                () -> testPadding(new int[] {1, 0, 1}, 3, new int[] {1, 0, 1}));
                runTest("test Padding", "<1,0,1>", "<1,1,1,0,1>",
                                () -> testPadding(new int[] {1, 0, 1}, 5, new int[] {1, 1, 1, 0, 1}));
                runTest("test Padding", "<0,1,0>", "<0,0,0,1,0>",
                                () -> testPadding(new int[] {0, 1, 0}, 5, new int[] {0, 0, 0, 1, 0}));
                runTest("test Padding", "<1,0,1>", "<1,1,1,1,1,0,1>",
                                () -> testPadding(new int[] {1, 0, 1}, 7, new int[] {1, 1, 1, 1, 1, 0, 1}));

        }

        private static void exceptionTestPart1() {
                testException("Bit cannot be null",
                                () -> addFirstTest(null, Bit.ONE, new int[] {0, 0, 1, 1, 0}, 2));
                testException("addLast with null bit",
                                () -> addLastTest(null, Bit.ZERO, new int[] {0, 0, 1, 1, 0}, 2));
                testException("test Hard Copy null",
                                () -> testHardCopy(null, 2));
        }

        private static void logicTestsPart2() {
                runTest("Binary Number Constarctor", "5", "<0,1,0,1>",
                                () -> testBinaryNumberConstarctor(5, new int[] {0, 1, 0, 1}));
                runTest("Binary Number Constructor", "0", "<0>",
                                () -> testBinaryNumberConstarctor(0, new int[] {0}));
                runTest("Binary Number Constructor", "1", "<0,1>",
                                () -> testBinaryNumberConstarctor(1, new int[] {0, 1}));
                runTest("Binary Number Constructor", "6", "<0,1,1,0>",
                                () -> testBinaryNumberConstarctor(6, new int[] {0, 1, 1, 0}));
                runTest("Binary Number Constructor", "16", "<0,1,0,0,0,0>",
                                () -> testBinaryNumberConstarctor(16, new int[] {0, 1, 0, 0, 0, 0}));

                runTest("testEqual", "5", "0101",
                                () -> testToStringBinaryNumber(5, "0101"));

                runTest("test Equal", "5,6", "false",
                                () -> testEqual(5, 6, false));
                runTest("test Equal", "5,5", "true",
                                () -> testEqual(5, 5, true));
                runTest("test Equal", "197462,197462", "true",
                                () -> testEqual(197462, 197462, true));
                runTest("test Equal", "65482546,321415647", "false",
                                () -> testEqual(65482546, 321415647, false));
                runTest("test Equal", "65482546,null", "false",
                                () -> testEqual(65482546, null, false));

                runTest("test Add Numbers", "5+3", "8",
                                () -> testBinaryNumberAdd(5, 3, 8));
                runTest("test Add Numbers", "2+7", "9",
                                () -> testBinaryNumberAdd(2, 7, 9));
                runTest("test Add Numbers", "0+0", "0",
                                () -> testBinaryNumberAdd(0, 0, 0));
                runTest("test Add Numbers", "1+0", "1",
                                () -> testBinaryNumberAdd(1, 0, 1));
                runTest("test Add Numbers", "1+1", "2",
                                () -> testBinaryNumberAdd(1, 1, 2));


                runTest("test Negate", "1", "-1",
                                () -> testNegate(1, -1));
                runTest("test Negate", "0", "0",
                                () -> testNegate(0, 0));
                runTest("test Negate", "8", "-8",
                                () -> testNegate(8, -8));
                runTest("test Negate", "-5", "5",
                                () -> testNegate(-5, 5));

                runTest("test Add Numbers", "-5+3", "-2",
                                () -> testBinaryNumberAdd(-5, 3, -2));
                runTest("test Add Numbers", "5+(-3)", "2",
                                () -> testBinaryNumberAdd(-3, 5, 2));
                runTest("test Add Numbers", "10+(-7)", "3",
                                () -> testBinaryNumberAdd(-7, 10, 3));
                runTest("test Add Numbers", "(-15)+8", "-7",
                                () -> testBinaryNumberAdd(-15, 8, -7));
                runTest("test Add Numbers", "(-20)+(-5)", "-25",
                                () -> testBinaryNumberAdd(-20, -5, -25));
                runTest("test Add Numbers", "100+(-50)", "50",
                                () -> testBinaryNumberAdd(-50, 100, 50));

                runTest("test Binary Number Subtract", "10-(-5)", "15",
                                () -> testBinaryNumberSubtract(10, -5, 15));
                runTest("test Binary Number Subtract", "(-8)-3", "-11",
                                () -> testBinaryNumberSubtract(-8, 3, -11));
                runTest("test Binary Number Subtract", "20-(-10)", "30",
                                () -> testBinaryNumberSubtract(20, -10, 30));
                runTest("test Binary Number Subtract", "(-15)-(-7)", "-8",
                                () -> testBinaryNumberSubtract(-15, -7, -8));
                runTest("test Binary Number Subtract", "5-(-3)", "2",
                                () -> testBinaryNumberSubtract(5, -3, 8));
                runTest("test Signum", "65482546", "1",
                                () -> testSignum(65482546, 1));
                runTest("test Signum", "0", "0",
                                () -> testSignum(0, 0));
                runTest("test Signum", "-65482546", "-1",
                                () -> testSignum(-65482546, -1));

                runTest("test Compare To", "5 compare 4", "1",
                                () -> testCompareTo(5, 4, 1));
                runTest("test Compare To", "4 compare 4", "0",
                                () -> testCompareTo(4, 4, 0));
                runTest("test Compare To", "4 compare 5", "-1",
                                () -> testCompareTo(4, 5, -1));
                runTest("test Compare To", "1000000 compare 999999", "1",
                                () -> testCompareTo(1000000, 999999, 1));
                runTest("test Compare To", "-500000 compare -500000", "0",
                                () -> testCompareTo(-500000, -500000, 0));
                runTest("test Compare To", "-750000 compare 750000", "-1",
                                () -> testCompareTo(-750000, 750000, -1));


                runTest("test To int", "-2147483647", "-2147483647",
                                () -> testToInt(-2147483646, -2147483646));
                runTest("test To int", "5", "5",
                                () -> testToInt(5, 5));
                runTest("test To int", "-8", "-8",
                                () -> testToInt(-8, -8));
                runTest("test To int", "0", "0",
                                () -> testToInt(0, 0));
                runTest("test To int", "2147483647", "2147483647",
                                () -> testToInt(2147483647, 2147483647));

                runTest("test Multiply", "5*3", "15",
                                () -> testMultiply(5, 3, 15));
                runTest("test Multiply", "-4*3", "-12",
                                () -> testMultiply(-4, 3, -12));
                runTest("test Multiply", "-5*(-2)", "10",
                                () -> testMultiply(-5, -2, 10));
                runTest("test Multiply", "10*(-3)", "-30",
                                () -> testMultiply(10, -3, -30));
                runTest("test Multiply", "0*0", "0",
                                () -> testMultiply(0, 0, 0));
                runTest("test Multiply", "15*2", "30",
                                () -> testMultiply(15, 2, 30));
                runTest("test Multiply", "8*4", "32",
                                () -> testMultiply(8, 4, 32));
                runTest("test Multiply", "3*6", "18",
                                () -> testMultiply(3, 6, 18));
                runTest("test Multiply", "MAX_VALUE*3", Long.toString(Integer.MAX_VALUE * 3L),
                                () -> {
                                        BinaryNumber num1 = new BinaryNumber(Integer.MAX_VALUE);
                                        BinaryNumber num2 = new BinaryNumber(3);
                                        BinaryNumber result = num1.multiply(num2);
                                        return result.toString().equals(new BinaryNumber(Integer.MAX_VALUE).multiply(new BinaryNumber(3)).toString());
                                });

                runTest("test Divide", "10/2", "5",
                                () -> testDivide(10, 2, 5));
                runTest("test Divide", "-15/3", "-5",
                                () -> testDivide(-15, 3, -5));
                runTest("test Divide", "100/-4", "-25",
                                () -> testDivide(100, -4, -25));
                runTest("test Divide", "0/-4", "0",
                                () -> testDivide(0, -4, 0));
                runTest("test Divide", "1/-4", "0",
                                () -> testDivide(1, -4, 0));

                runTest("test Divide", "MAX_VALUE*3/3", Integer.toString(Integer.MAX_VALUE),
                                () -> {
                                        BinaryNumber num1 = new BinaryNumber(Integer.MAX_VALUE);
                                        BinaryNumber tripled = num1.multiply(new BinaryNumber(3));
                                        BinaryNumber divisor = new BinaryNumber(3);
                                        BinaryNumber result = tripled.divide(divisor);
                                        return result.equals(num1);
                                });
                runTest("test String Constractor", "1", "1",
                                () -> testStringConstractor("1", 1));
                runTest("test String Constractor", "0", "0",
                                () -> testStringConstractor("0", 0));
                runTest("test String Constractor", "-1", "-1",
                                () -> testStringConstractor("-1", -1));
                runTest("test String Constractor", "25", "25",
                                () -> testStringConstractor("25", 25));
                runTest("test String Constractor", "-25", "-25",
                                () -> testStringConstractor("-25", -25));
                runTest("test String Constractor", "2147483647", "2147483647",
                                () -> testStringConstractor("2147483647", 2147483647));

                runTest("test String Constractor", "6442450943", "6442450943",
                                () -> {
                                        BinaryNumber num = new BinaryNumber("6442450941");
                                        BinaryNumber expected = new BinaryNumber(Integer.MAX_VALUE).multiply(new BinaryNumber(3));
                                        return num.equals(expected);
                                });

                runTest("test Int String", "-54321", "-54321",
                                () -> testToIntString(-54321, "-54321"));
                runTest("test Int String", "0", "0",
                                () -> testToIntString(0, "0"));

                runTest("test Int String", "-1000000", "-1000000",
                                () -> testToIntString(-1000000, "-1000000"));
                runTest("test Int String", "54321", "54321",
                                () -> testToIntString(54321, "54321"));
                runTest("test Int String", "1000000", "1000000",
                                () -> testToIntString(1000000, "1000000"));
                runTest("test Int String", "42", "42",
                                () -> testToIntString(42, "42"));
                runTest("test Int String", "-123", "-123",
                                () -> testToIntString(-123, "-123"));
                runTest("test Int String", "2147483647", "2147483647",
                                () -> testToIntString(Integer.MAX_VALUE, "2147483647"));

                // Large number tests (beyond Integer.MAX_VALUE)
                runTest("test Int String", "MAX_VALUE*2", "4294967294",
                                () -> {
                                        BinaryNumber num = new BinaryNumber(Integer.MAX_VALUE);
                                        BinaryNumber doubled = num.multiply(new BinaryNumber(2));
                                        return doubled.toIntString().equals("4294967294");
                                });

                runTest("test Int String", "MAX_VALUE*3", "6442450941",
                                () -> {
                                        BinaryNumber num = new BinaryNumber(Integer.MAX_VALUE);
                                        BinaryNumber tripled = num.multiply(new BinaryNumber(3));
                                        return tripled.toIntString().equals("6442450941");
                                });
                runTest("test Int String", "354224848179261915075", "354224848179261915075",
                                () -> {
                                        BinaryNumber num = new BinaryNumber("354224848179261915075");
                                        return num.toIntString().equals("354224848179261915075");
                                });
        }

        private static void exceptionTestsPart2() {
                testException("n cannot be below zero for Binary Constractor",
                                () -> testBinaryNumberConstarctor(-100, new int[] {0, 1, 0, 0, 0, 0}));
                testException("Object cannot be null for add",
                                () -> testBinaryNumberAdd(1, null, -20));
                testException("Object cannot be null for substract",
                                () -> testBinaryNumberSubtract(1, null, -20));
                testException("Object cannot be null for comapre to",
                                () -> testCompareTo(1, null, -20));
                testException("To int:Number too large for int conversion",
                                () -> {
                                        BinaryNumber large = new BinaryNumber(1);
                                        large = large.add(new BinaryNumber(2147483647));
                                        large.toInt();
                                });
                testException("To int:Number too large for int conversion",
                                () -> {
                                        BinaryNumber number1 = new BinaryNumber(Integer.MAX_VALUE);
                                        BinaryNumber number2 = new BinaryNumber(Integer.MIN_VALUE);
                                        number1 = number1.add(number2);
                                        number1.toInt();
                                });
                testException("Object cannot be null for Multiply",
                                () -> testMultiply(1, null, -20));

                testException("testStringConstractor: S Must be numeric",
                                () -> testStringConstractor("12a354", 20));

                testException("testStringConstractor: S cant be nulll",
                                () -> testStringConstractor(null, 20));

        }

        private static LinkedList<Bit> createLinkList(int bits[]) {
                LinkedList<Bit> bitLinkList = new LinkedList<Bit>();
                for (int i = 0; i < bits.length; i++) {
                        Bit newbit = bits[i] == 1 ? Bit.ONE : Bit.ZERO;
                        bitLinkList.addFirst(newbit);
                }
                return bitLinkList;
        }

        private static boolean testToIntString(int inputBinaryNumber, String excptedResult) {
                BinaryNumber binaryNumber = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber);
                return binaryNumber.toIntString().equals(excptedResult);
        }

        private static boolean testStringConstractor(String inputBinaryNumber, int excptedResult) {
                BinaryNumber binaryNumber = new BinaryNumber(inputBinaryNumber);
                BinaryNumber excptedResultBinaryNumber = buildNagtiveOrPostiveBinaryNumber(excptedResult);
                return binaryNumber.equals(excptedResultBinaryNumber);
        }

        private static boolean testDivide(int inputBinaryNumber1, Integer inputBinaryNumber2, int excptedResult) {
                BinaryNumber binaryNumber1 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber1);
                BinaryNumber binaryNumber2 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber2);
                BinaryNumber excptedResultBinaryNumber = buildNagtiveOrPostiveBinaryNumber(excptedResult);
                return binaryNumber1.divide(binaryNumber2).equals(excptedResultBinaryNumber);
        }

        private static boolean testMultiply(int inputBinaryNumber1, Integer inputBinaryNumber2, int excptedResult) {
                BinaryNumber binaryNumber1 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber1);
                BinaryNumber binaryNumber2 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber2);
                BinaryNumber excptedResultBinaryNumber = buildNagtiveOrPostiveBinaryNumber(excptedResult);
                return binaryNumber1.multiply(binaryNumber2).equals(excptedResultBinaryNumber);
        }

        private static boolean testToInt(int inputBinaryNumber, int excptedResult) {
                BinaryNumber binaryNumber1 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber);
                return binaryNumber1.toInt() == excptedResult;
        }

        private static boolean testCompareTo(int inputBinaryNumber1, Integer inputBinaryNumber2, int excptedResult) {
                BinaryNumber binaryNumber1 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber1);
                BinaryNumber binaryNumber2 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber2 == null ? null : inputBinaryNumber2.intValue());
                return binaryNumber1.compareTo(binaryNumber2) == excptedResult;
        }

        private static boolean testNegate(int inputBinaryNumber, int excptedResult) {
                BinaryNumber binaryNumber = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber);
                BinaryNumber excptedResultbBinaryNumber = buildNagtiveOrPostiveBinaryNumber(excptedResult);
                BinaryNumber result = binaryNumber.negate();
                return result.equals(excptedResultbBinaryNumber);
        }

        private static BinaryNumber buildNagtiveOrPostiveBinaryNumber(Integer n) {
                if ((Integer) n == null)
                        return null;
                if (n.intValue() < 0) {
                        return new BinaryNumber(n.intValue(), true);
                }
                return new BinaryNumber(n.intValue());
        }

        private static boolean testBinaryNumberSubtract(Integer inputBinaryNumber1, Integer inputBinaryNumber2, int excptedResult) {
                BinaryNumber binaryNumber1 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber1.intValue());
                BinaryNumber binaryNumber2 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber2 == null ? null : inputBinaryNumber2.intValue());
                BinaryNumber excptedResultBinaryNumber = buildNagtiveOrPostiveBinaryNumber(excptedResult);;

                return binaryNumber1.subtract(binaryNumber2).equals(excptedResultBinaryNumber);
        }

        private static boolean testBinaryNumberAdd(Integer inputBinaryNumber1, Integer inputBinaryNumber2, int excptedResult) {
                BinaryNumber binaryNumber1 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber1.intValue());
                BinaryNumber binaryNumber2 = buildNagtiveOrPostiveBinaryNumber(inputBinaryNumber2 == null ? null : inputBinaryNumber2.intValue());;
                BinaryNumber excptedResultBinaryNumber = buildNagtiveOrPostiveBinaryNumber(excptedResult);;

                return binaryNumber1.add(binaryNumber2).equals(excptedResultBinaryNumber);
        }

        private static boolean testSignum(int number, int excptedResult) {
                BinaryNumber binaryNumber = buildNagtiveOrPostiveBinaryNumber(number);
                return binaryNumber.signum() == excptedResult;
        }

        private static boolean testEqual(int number1, Integer number2, boolean excptedResult) {
                BinaryNumber binaryNumber1 = new BinaryNumber(number1);
                BinaryNumber binaryNumber2 = null;
                if (excptedResult) {
                        binaryNumber2 = new BinaryNumber(binaryNumber1);
                } else if (number2 != null) {
                        binaryNumber2 = new BinaryNumber(number2.intValue());
                }

                return binaryNumber1.equals(binaryNumber2) == excptedResult;
        }

        private static boolean testToStringBinaryNumber(int number, String excptedOutPut) {
                BinaryNumber binaryNumberResult = new BinaryNumber(number);
                return binaryNumberResult.toString().equals(excptedOutPut);
        }

        private static boolean testBinaryNumberConstarctor(int n, int[] excptedOutput) {
                BinaryNumber resultBinaryNumber = new BinaryNumber((int) n);
                BinaryRepresentation binaryRepresentationExcptedOutput = createBinaryRepresentation(excptedOutput);
                return (resultBinaryNumber.getRep().getbits()).equals(binaryRepresentationExcptedOutput.getbits());

        }

        private static boolean testPadding(int inputBits[], int pedding, int excptedResult[]) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                binaryRepresentation.padding(pedding);
                BinaryRepresentation excptedbinaryRepresentation = createBinaryRepresentation(excptedResult);
                return binaryRepresentation.getNumOfOnes() == excptedbinaryRepresentation.getNumOfOnes() &&
                                binaryRepresentation.getbits().equals(excptedbinaryRepresentation.getbits());
        }

        private static boolean testReturnValueShiftRight(int inputBits[], Bit excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                return excptedResult == binaryRepresentation.shiftRight();
        }

        private static boolean testShiftRight(int inputBits[], int[] excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                binaryRepresentation.shiftRight();
                BinaryRepresentation excptedbinaryRepresentation = createBinaryRepresentation(excptedResult);
                return binaryRepresentation.getNumOfOnes() == excptedbinaryRepresentation.getNumOfOnes() &&
                                binaryRepresentation.getbits().equals(excptedbinaryRepresentation.getbits());
        }

        private static boolean testShiftLeft(int inputBits[], int[] excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                binaryRepresentation.shiftLeft();
                BinaryRepresentation excptedbinaryRepresentation = createBinaryRepresentation(excptedResult);
                return binaryRepresentation.getNumOfOnes() == excptedbinaryRepresentation.getNumOfOnes() &&
                                binaryRepresentation.getbits().equals(excptedbinaryRepresentation.getbits());
        }

        private static boolean testComplement(int inputBits[], int[] excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                binaryRepresentation.complement();
                BinaryRepresentation excptedbinaryRepresentation = createBinaryRepresentation(excptedResult);
                return binaryRepresentation.getNumOfOnes() == excptedbinaryRepresentation.getNumOfOnes() &&
                                binaryRepresentation.getbits().equals(excptedbinaryRepresentation.getbits());
        }

        private static boolean testReduce(int inputBits[], int[] excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                binaryRepresentation.reduce();
                BinaryRepresentation excptedbinaryRepresentation = createBinaryRepresentation(excptedResult);
                return binaryRepresentation.getNumOfOnes() == excptedbinaryRepresentation.getNumOfOnes() &&
                                binaryRepresentation.getbits().equals(excptedbinaryRepresentation.getbits());
        }

        private static boolean testIsReduced(int inputBits[], boolean excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                return binaryRepresentation.isReduced() == excptedResult;
        }

        private static boolean tesisLegalNumber(int inputBits[], boolean excptedResult) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                return excptedResult == binaryRepresentation.isLegalNumber();
        }

        private static boolean testHardCopy(int inputBits[], int expectedNumberOfOnes) {
                BinaryRepresentation binaryRepresentation = createBinaryRepresentation(inputBits);
                BinaryRepresentation hardCopyBinaryRepresentation = new BinaryRepresentation(binaryRepresentation);
                return binaryRepresentation.getbits().equals(hardCopyBinaryRepresentation.getbits()) &&
                                binaryRepresentation.getNumOfOnes() == hardCopyBinaryRepresentation.getNumOfOnes();
        }

        private static boolean testToString(int inputBits[], String excptedOutPut) {
                BinaryRepresentation newbBinaryRepresentation = createBinaryRepresentation(inputBits);
                return newbBinaryRepresentation.toString().equals(excptedOutPut);
        }

        private static boolean removedLastTest(int inputBits[], int ExcptedResult[], Bit excptedBit, int expectedNumberOfOnes) {
                LinkedList<Bit> expectedResult = createLinkList(ExcptedResult);
                BinaryRepresentation newbBinaryRepresentation = createBinaryRepresentation(inputBits);
                Bit RetunredBit = newbBinaryRepresentation.removeLast();
                return newbBinaryRepresentation.getbits().equals(expectedResult) &&
                                expectedNumberOfOnes == newbBinaryRepresentation.getNumOfOnes() && RetunredBit.equals(excptedBit);
        }

        private static BinaryRepresentation createBinaryRepresentation(int inputBits[]) {
                if (inputBits == null) {
                        return null;
                }
                BinaryRepresentation newbBinaryRepresentation = new BinaryRepresentation();
                for (int i = 0; i < inputBits.length; i++) {
                        Bit newbit = (inputBits[i] == 1) ? Bit.ONE : Bit.ZERO;
                        newbBinaryRepresentation.addFirst(newbit);
                }
                return newbBinaryRepresentation;
        }

        private static boolean removedFirstTest(int inputBits[], int ExcptedResult[], Bit excptedBit, int expectedNumberOfOnes) {
                LinkedList<Bit> expectedResult = createLinkList(ExcptedResult);
                BinaryRepresentation newbBinaryRepresentation = createBinaryRepresentation(inputBits);
                Bit RetunredBit = newbBinaryRepresentation.removeFirst();
                return newbBinaryRepresentation.getbits().equals(expectedResult) &&
                                expectedNumberOfOnes == newbBinaryRepresentation.getNumOfOnes() && RetunredBit.equals(excptedBit);
        }

        private static boolean addLastTest(int inputBits[], Bit bitToAdd, int ExcptedResult[], int expectedNumberOfOnes) {
                LinkedList<Bit> expectedList = createLinkList(ExcptedResult);
                BinaryRepresentation newbBinaryRepresentation = new BinaryRepresentation();
                if (inputBits == null) {
                        newbBinaryRepresentation.addLast(null);
                }
                for (int i = 0; i < inputBits.length; i++) {
                        Bit buildBit = (inputBits[i] == 1) ? Bit.ONE : Bit.ZERO;
                        newbBinaryRepresentation.addFirst(buildBit);
                }
                newbBinaryRepresentation.addLast(bitToAdd);
                return newbBinaryRepresentation.getbits().equals(expectedList) && expectedNumberOfOnes == newbBinaryRepresentation.getNumOfOnes();
        }

        private static boolean addFirstTest(int inputBits[], Bit bitToAdd, int ExcptedResult[], int expectedNumberOfOnes) {
                LinkedList<Bit> expectedList = createLinkList(ExcptedResult);
                BinaryRepresentation newbBinaryRepresentation = new BinaryRepresentation();
                if (inputBits == null) {
                        newbBinaryRepresentation.addFirst(null);
                }
                for (int i = 0; i < inputBits.length; i++) {
                        Bit buildBit = (inputBits[i] == 1) ? Bit.ONE : Bit.ZERO;
                        newbBinaryRepresentation.addFirst(buildBit);
                }
                newbBinaryRepresentation.addFirst(bitToAdd);
                return newbBinaryRepresentation.getbits().equals(expectedList) && expectedNumberOfOnes == newbBinaryRepresentation.getNumOfOnes();
        }

        private static void testException(String description, Runnable test) {
                totalTests++;
                try {
                        test.run();
                        System.out.println(RED + "test failed: Expected exception for " + description + RESET_COLOR);
                } catch (IllegalArgumentException e) {
                        System.out.println(GREEN + "test passed: Caught expected exception for " + description
                                        + RESET_COLOR);
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
                String description = String.format("Test %d: %s: input = %s expected = %s --> %s",
                                totalTests, testName, input, expectedOutput, resultString);
                System.out.println(passedColor + description + RESET_COLOR);
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
