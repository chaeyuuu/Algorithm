import java.io.*;

public class boj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] stairs = new int[num + 1];
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if (num >= 2)
            dp[2] = stairs[1] + stairs[2];
        if (num >= 3)
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        for (int i = 4; i <= num; i++) {
            // 한칸 건너뛰고 오는 경우 & 두칸 건너뛰고 오는 경우
            dp[i] = Math.max((stairs[i] + dp[i - 2]),
                    stairs[i] + dp[i - 3] + stairs[i - 1]);
        }
        System.out.println(dp[num]);
    }
}
