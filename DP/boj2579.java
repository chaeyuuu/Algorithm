import java.io.*;
import java.util.*;

public class boj2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 계단은 한번에 한 계단이나 두계단씩
        // 연속된 세개의 계단을 모두 밟아서는 안됨
        // 시작점은 계단에 포함되지 않음
        // 마지막 도착 계단은 반드시 밟아야함

        int num = Integer.parseInt(br.readLine());
        int[] stairs = new int[num + 1];
        int[][] dp = new int[num + 1][2];

        for (int i = 1; i <= num; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = stairs[1]; // 첫번째 계단
        dp[1][1] = 0;

        if (num >= 2) {
            dp[2][0] = stairs[2]; // 두번째 계단
            dp[2][1] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= num; i++) {
            // 연속번째가 아닌 경우 [0]
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];

            // 연속번째인경우 [1]
            dp[i][1] = dp[i - 1][0] + stairs[i];
        }

        System.out.println(Math.max(dp[num][0], dp[num][1]));

    }

}
