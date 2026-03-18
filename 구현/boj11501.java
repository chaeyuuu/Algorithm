package 구현;

import java.util.*;
import java.io.*;

public class boj11501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long spend = 0;
            long result = 0;
            long maxPrice = arr[N - 1]; // 2
            for (int j = N - 1; j > 0; j--) {
                // 4 6
                if (arr[j] >= arr[j - 1]) {
                    if (maxPrice < arr[j])
                        maxPrice = arr[j]; // 7

                    result += maxPrice; // 7
                    spend += arr[j - 1]; // 4
                } else {
                    // arr[j] <= arr[j-1]
                    if (maxPrice > arr[j - 1]) {
                        result += maxPrice;
                        spend += arr[j - 1];
                    } else {
                        maxPrice = arr[j - 1]; // 6
                    }
                }
            }

            long answer = result - spend;
            System.out.println(answer);

        }

    }

}
