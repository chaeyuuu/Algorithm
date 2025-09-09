import java.io.*;

// 나누기 3, 나누기 2, 빼기 1 다 해보고...
// 연산을 하는 횟수의 최솟값을 출력 -> 횟수를 배열에 저장
// 3으로도 나눠떨어지고 2로도 나눠떨어지는 경우는.. 어떻게 해야하는거지렁이
// 10이 예시면 3으로 시작하는거 한 번, 2로 시작하는거 한 번,, 1로 시작하는거 한 번..
// 그거 저장해서 그 다음에도 3으로 시작하는거 한 번 2로 시작하는거 한번 1로시작하는거한번.. 이렇게 해야하능거자나
// 그래프 느낌으로 반복하면될듯?

// d[1]은 이미 1 <- 최소연산횟수 
// dp[2]에는 2를 만들기 위한 최소연산횟수가 들어가는거임

// DP는 bottom-up 방식

public class boj1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[N]);

    }
}
