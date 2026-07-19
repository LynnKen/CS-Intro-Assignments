
import java.util.Scanner;

public class Task3a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------

        int n=scanner.nextInt(); //n>=0 && n<=30
        ans=1;
        if (n!=0) {
            for (int i = 1; i <= n; i++)
                ans = ans * 2;
        }

        //---------------write your code ABOVE this line only!--------------
        System.out.println(ans);
		scanner.close();
	}
}