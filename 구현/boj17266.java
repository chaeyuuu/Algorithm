package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수
        int[] lights = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        // 가로등의 높이를 h 라고 했을때, 가로등이 비추는 범위는 +h, -h
        // 최소 가로등의 높이는 첫번째 가로등의 위치 ~ 0, 마지막 가로등의 위치 ~ N

        int result = Math.max(lights[0] - 0, N - lights[M - 1]);

        for (int j = 0; j < M - 1; j++) {
            // 가로등 사이 거리 확인
            int distance = lights[j + 1] - lights[j];

            int height;
            if (distance % 2 == 0) {
                height = distance / 2;
            } else {
                height = distance / 2 + 1;
            }

            result = Math.max(height, result);
        }

        System.out.println(result);
    }
}
