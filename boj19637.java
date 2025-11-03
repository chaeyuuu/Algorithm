import java.util.*;
import java.io.*;

public class boj19637 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N];
        int[] powers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            names[i] = name;
            powers[i] = power;
        }

        // 시간 초과 방지
        StringBuilder sb = new StringBuilder();

        // 이진 탐색
        for (int i = 0; i < M; i++) {
            int level = Integer.parseInt(br.readLine());

            // 인덱스 기준
            int low = 0;
            int high = N - 1;
            int resultIndex = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (powers[mid] >= level) {
                    resultIndex = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(names[resultIndex]).append('\n');
        }
        System.out.println(sb.toString());
    }
}