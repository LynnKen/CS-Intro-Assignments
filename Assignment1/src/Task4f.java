
import java.util.Scanner;

public class Task4f {

    public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        int ans = 0;
        //---------------write your code BELOW this line only!--------------

        int x= scanner.nextInt();
        int y= scanner.nextInt();
        boolean foundPrime= false;

        while (!foundPrime) {
            double rndmRange = Math.random();
            int n = (int) (x + (rndmRange * (y - x + 1)));
            boolean isPrime = true;

            for (int j = 0; isPrime && j < 5; j++) {
                int sum = 1;
                double rndmPrimeCheck = Math.random();
                int a = (int) (rndmPrimeCheck * (n - 1) + 1);

                for (int i = 1; i <= n - 1; i++) { //n>1
                    sum = (sum * a) % n;
                }
                sum = sum % n;
                if (sum != 1)
                    isPrime = false;
            }
            if (isPrime) {
                foundPrime = true;
                ans = n;
            }
        }
            //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);

		scanner.close();
    }
}