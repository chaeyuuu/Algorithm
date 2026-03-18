package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19941_1 {
    // K 이하
    // 식탁길이 N, 햄버거 선택거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        char[] arr = line.toCharArray();

        int result = 0;
        int[] hambugers = new int[N];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                // P기준에서 앞뒤로 K 범위만큼 H 있으면 result+1
                // 근데 먹은 햄버거면 안됨..
                for (int j = Math.max(0, i - K); j <= Math.min(i + K, N - 1); j++) {
                    if (arr[j] == 'H' && hambugers[j] == 0) {
                        result++;
                        hambugers[j] = 1;
                        break;
                    }
                }

            }
        }

        System.out.println(result);

    }
}