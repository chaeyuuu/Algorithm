package 구현;

import java.io.*;
import java.util.*;

public class boj19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = new char[N];
        arr = br.readLine().toCharArray();

        boolean[] eaten = new boolean[N];

        int count = 0;

        // 사람 기준으로 왼쪽, 오른쪽으로 K만큼 돌아가면서 햄부기 만나면
        // 안 먹은 햄부기다? 그러면 먹고 eaten을 true로, 햄부기 먹을 수 있는 사람 수 +1
        // 먹은 햄부기면 패스

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                // 사람을 만나면 양옆으로 햄부기가 K 이하인 곳에 있는지 확인
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < N && arr[j] == 'H') {
                        // 배열 내 크기인지 확인
                        // 먹지않은 햄부기인지 확인
                        if (!eaten[j]) {
                            count += 1;
                            eaten[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
