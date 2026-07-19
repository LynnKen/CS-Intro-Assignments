import java.math.BigInteger;
import java.util.Random;

public class BigIntegerOperations {
    //Task 2.1
    //Assumes n!=null
    //Returns the sum of positive integers smaller than n
    public static BigInteger sumSmaller(BigInteger n) {
        BigInteger sum = null;
        // ---------------write your code BELOW this line only! ------------------
        if (n == null)
            throw new IllegalArgumentException("n cannot be null");

        sum = BigInteger.ZERO;

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
            sum = sum.add(i);
        }

        // ---------------write your code ABOVE this line only! ------------------
        return sum;
    }

    //Task 2.2
    //Assumes n>=0
    //prints n pseudo-random numbers
    public static void printRandoms(int n) {
        // ---------------write your code BELOW this line only! ------------------
        if (n < 0)
            throw new IllegalArgumentException("n should be Natural");
        Random rnd = new Random();
        for (int i = 0; i < n; i++)
            System.out.println(rnd.nextInt());
        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 2.3
    // Assumes n!=null and n>=0
    //Returns true iff n is a prime number
    public static boolean isPrime(BigInteger n) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if (n == null || n.compareTo(BigInteger.ZERO) == -1)
            throw new IllegalArgumentException("n should be Natural");

        if (n.compareTo(BigInteger.ONE) <= 0)
            ans = false;
        else {
            BigInteger index = new BigInteger("2");
            BigInteger iPow2 = index.multiply(index);

            while (ans && iPow2.compareTo(n) <= 0) {
                BigInteger reminder = n.remainder(index);
                if (reminder.compareTo(BigInteger.ZERO) == 0)
                    ans = false;
                index = index.add(BigInteger.ONE);
                iPow2 = index.multiply(index);
            }
        }

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 2.4
    //Assumes n>1
    //Returns a randomly chosen prime number, smaller than 2^n
    public static BigInteger randomPrime(int n) {
        BigInteger myRand = null;
        // ---------------write your code BELOW this line only! ------------------
        if (n <= 1)
            throw new IllegalArgumentException("n should be bigger than 1");
        Random rnd = new Random();
        myRand = new BigInteger(n, rnd);

        while (!isPrime(myRand))
            myRand = new BigInteger(n, rnd);
        // ---------------write your code ABOVE this line only! ------------------
        return myRand;
    }

    //Task 2.5
    // No assumptions
    //Returns false if primes==null, or is not sorted, or includes duplicates, or includes a composite number
    public static boolean isValidPrimesArray(BigInteger[] primes) {
        boolean isValid = true; // Assume the array is valid initially
        // ---------------write your code BELOW this line only! ------------------
        if (primes == null || !isSorted(primes))
            isValid = false;
        else {
            for (int i = 0; isValid && i < primes.length; i++)
                isValid = isPrime(primes[i]);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return isValid;
    }

    //get's an array of BigInteger's
    //check if the array is sorted in an upscale order
    private static boolean isSorted(BigInteger[] array) {
        boolean ans = true;
        if (array == null)
            return false;
        if (array.length > 1) {
            for (int i = 0; ans && i < array.length - 1; i++) {
                if (array[i].compareTo(array[i+1]) != -1)
                    ans = false;
            }
        }
        return ans;
    }

    //Task 2.6
    //Assumes primes != null, n !=null, and n>1. 'primes' is sorted, and includes only unique prime numbers.
    //Returns true if n can be expressed as a product of prime numbers from primes
    public static boolean canFactorizeToTarget(BigInteger[] primes, BigInteger n) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if (n == null || n.compareTo(BigInteger.ONE) <= 0)
            throw new IllegalArgumentException("n is illegal");
        if (primes == null || !isValidPrimesArray(primes))
            throw new IllegalArgumentException("primes is null or not sorted");

       ans = canFactorizeToTarget(primes, n, 0);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    public static boolean canFactorizeToTarget(BigInteger[] primes, BigInteger n, int index) {
        boolean ans = true;

        if (index == primes.length) //if primes is empty=>false
            ans = false;
        else {
            BigInteger remainder = n.remainder(primes[index]);
            boolean isADivider = remainder.compareTo(BigInteger.ZERO) == 0; //does primes[i] a divider of n

            if (isADivider) {
                BigInteger possibleFinalFactor = n.divide(primes[index]); // n/primes[index]
                if (possibleFinalFactor.compareTo(BigInteger.ONE) == 0) //does n/possibleFinalFactor==1
                    ans = true;
                else
                    ans = canFactorizeToTarget(primes, n.divide(primes[index]), 0);
            } else
                ans = canFactorizeToTarget(primes, n, index + 1);
        }
        return ans;
    }


    //Task 2.7
    //Assumes primes != null, n !=null, and n>1. 'primes' is sorted, and includes only unique prime numbers.
    //If n can be expressed as a product of prime numbers from primes, it prints the numbers in the factorization
    public static void printFactorization(BigInteger[] primes, BigInteger n) {
        // ---------------write your code BELOW this line only! ------------------
        if (canFactorizeToTarget(primes, n)) {
            printFactorization(primes, n, 0, "");
        }
        // ---------------write your code ABOVE this line only! ------------------
    }

    public static void printFactorization(BigInteger[] primes, BigInteger n, int index, String acc) {
        if (n.compareTo(BigInteger.ONE)==0)
            System.out.println(acc);
        else {
            BigInteger remainder = n.remainder(primes[index]);
            boolean isADivider = remainder.compareTo(BigInteger.ZERO) == 0; //does primes[i] a divider of n

            if (isADivider) {
                if (acc.equals(""))
                    acc=primes[index].toString();
                else
                    acc=acc+"," + primes[index].toString();

                printFactorization(primes,n.divide(primes[index]),0,acc);
            }
            else
                printFactorization(primes,n,index+1,acc);
        }
    }


}
