package 구현;

import java.util.Scanner;

public class boj27866 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        int i = scan.nextInt();
        System.out.println(str.charAt(i-1));
    }
}