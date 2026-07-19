
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------

        int a=scanner.nextInt();
        int b=scanner.nextInt();
        double rndm = Math.random();
        ans = (int) (a+(rndm*(b-a+1))); // [0<=rndm<1] -> [0<=rndm*(b-a+1)<b-a+1] -> [a<=(rndm*b-a+1)+a<b+1]


        //---------------write your code ABOVE this line only!--------------
        System.out.println(ans);
		scanner.close();
    }
}