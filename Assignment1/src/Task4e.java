
import java.util.Scanner;

public class Task4e {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();

        for (int i=0; ans && i<5 ;i++) {
            double rndm = Math.random();
            int a = (int) (1 + (rndm * (n - 1)));
            int sum = 1;
            for (int exp = 1; exp <= n - 1; exp++){ //n>1
                sum = (sum * a) % n;
            }
            sum=sum%n;
            if (sum != 1)
                ans = false;
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}