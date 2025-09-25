package 그리디;

import java.util.*;
import java.io.*;

public class boj18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] houses = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);
        int minSum = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += Math.abs(houses[i] - houses[j]);
            }

            if (sum < minSum) {
                minSum = sum;
                result = houses[i];
            }
        }

        System.out.println(result);
    }

}
