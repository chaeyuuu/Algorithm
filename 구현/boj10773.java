package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class boj10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int sum = 0;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                arrayDeque.pollLast();
            } else {
                arrayDeque.addLast(temp);
            }
        }

        for (int num : arrayDeque) {
            sum += num;
        }

        System.out.println(sum);
    }
}
    
