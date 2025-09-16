package 구현;

import java.util.*;
import java.io.*;

public class boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        List<Long> lines = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            lines.add(Long.parseLong(br.readLine()));
        }

        long high = Collections.max(lines);
        long low = 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long num = 0;

            // 배열 각 원소별로 mid로 나눠떨어지는 개수 저장
            // 저장한 개수 필요한 개수랑 비교

            for (int i = 0; i < lines.size(); i++) {
                num += lines.get(i) / mid;
            }

            if (num < N) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        System.out.println(high);
    }
}
