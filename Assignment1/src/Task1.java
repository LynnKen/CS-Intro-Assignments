
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = false;

        //---------------write your code BELOW this line only!--------------

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int q = scanner.nextInt();
        int r = scanner.nextInt();
        if (b != 0 && r < b && a == (b * q + r))
            ans = true;

        //---------------write your code ABOVE this line only!--------------


        scanner.close();
    }
}