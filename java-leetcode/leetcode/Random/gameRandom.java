package Random;

import java.util.Random;
import java.util.Scanner;

public class gameRandom {
    public static void main(String[] args) {
        // scanner
        Random r = new Random();
        int num = r.nextInt(100); // [0,99]+1 >>> [1,100]
        Scanner scan = new Scanner(System.in);

        while (true){
            int guess = scan.nextInt();
            if (guess > num) {
                System.out.println("wrong,too large ");
            }else if(guess<num){
                System.out.println("wrong,too small ");
            }else {
                System.out.println("Congratulations!!");
                break;
            }
        }

    }


}
