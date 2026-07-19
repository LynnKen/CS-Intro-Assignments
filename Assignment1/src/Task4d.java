
import java.util.Scanner;

public class Task4d {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	int ans = 0;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt(); //n is composite
        boolean isComposite=true;

        for (int i=1; isComposite ;i++) { //i would be equal to numbers of tests
            int sum=1;
            double rndm = Math.random();
            int a = (int) (1 + (rndm * (n - 1)));
            System.out.println(a);
            for (int exp = 1; exp <= n - 1; exp++) // n>2
                sum = (sum * a) % n;

            sum = sum % n;
            if (sum!=1)
                isComposite=false;
            ans++;
        }

        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}