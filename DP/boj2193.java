import java.io.*;
import java.util.*;

public class boj2193 {
    public static void main(String[] args) throws IOException {
        // 이친수는 0으로 시작하지 않음
        // 1이 연속으로 나오지 않음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[1] = 1;

        if (N >= 2)
            dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[N]);

    }

}
