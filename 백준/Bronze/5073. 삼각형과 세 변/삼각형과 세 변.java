import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = 0;
            if (a >= b) {
                max = a;
            } else {
                max = b;
            }

            if (max <= c) {
                max = c;
            }

            if (max == c) {
                if (c >= a + b) {
                    System.out.println("Invalid");
                    continue;
                }

            } else if (max == b) {
                if (b >= a + c) {
                    System.out.println("Invalid");
                    continue;
                }
            } else if (max == a) {
                if (a >= b + c) {
                    System.out.println("Invalid");
                    continue;
                }
            }

            if (a == b && b == c && a == c) {
                System.out.println("Equilateral");
            }

            if ((a != b && b != c && a != c)) {
                System.out.println("Scalene");
            }

            if ((b == c && b != a && c != a) ||
                    (b == a && b != c && a != c) ||
                    (a == c && a != b && b != c)) {
                System.out.println("Isosceles");

            }

        }
    }

}
