package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class boj9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[11];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;

            for (int k = 3; k <= n; k++) {
                dp[k] = dp[k - 1] + dp[k - 2] + dp[k - 3];
            }

            System.out.println(dp[n-1]);
        }
    }
}