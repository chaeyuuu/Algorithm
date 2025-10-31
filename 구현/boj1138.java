package 구현;

import java.io.*;
import java.util.*;

public class boj1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = N - 1; i >= 0; i--) {
            // 내 왼쪽에 있는 사람의 수가 내가 삽입될 인덱스 번호
            // i 값이 result에 들어갈 곳
            // 근데 내 인덱스 번호에 이미 누가 있으면 그 뒤에 삽입 (arryalist는 자동으로 밀어냄)
            result.add(people[i], i + 1);

        }

        for (int i = 0; i < N; i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
