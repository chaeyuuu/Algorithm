import java.io.*;
import java.util.*;

public class boj14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine()); // N: 기간
        int[] price = new int[num + 1]; // 가격 저장할 곳
        int[] day = new int[num + 1]; // 상담 걸리는 시간
        int[] dp = new int[num + 2];

        for (int i = 1; i <= num; i++) {
            // 초기값 저장
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= num; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int next = i + day[i];

            if (next <= num + 1) {
                // 상담이 끝나는 날의 수익 = max(기존 기록, 오늘까지 최대 수익 + 오늘 상담비)
                dp[next] = Math.max(dp[next], dp[i] + price[i]);
            }

            // System.out.println("i: " + i + ", dp[i]: " + dp[i] + ", price[i]: " +
            // price[i]);

        }

        dp[num + 1] = Math.max(dp[num + 1], dp[num]);

        System.out.println(dp[num + 1]);

    }

}
