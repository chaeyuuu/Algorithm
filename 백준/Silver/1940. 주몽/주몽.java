import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ingredients = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredients);
        int count = 0;

        // 1 2 3 4 5 7
        int start = 1;
        int end = 2;
        int sum = 0;

        sum = ingredients[start]; // 1

        while (start < N) {
            // start에 해당하는 값을 우선 집어넣어놓아야하남 ..

            sum += ingredients[end]; // 1+5=6, 1+7 = 8

            // end index 가 끝까지 갔는데 sum이 안 나온는 경우에도 다시 앞으로

            if (sum == M) {
                // 합이 같으면 챱챱
                count++;
                start++;
                end = start + 1;
                sum = ingredients[start];
            } else if (end == N) {
                // 합이 안 같은데 end index가 끝까지 갔다면 ..
                // N = 6일때

                start++;
                end = start + 1;
                sum = ingredients[start];
            } else {
                // 값이 같지 않으면
                sum -= ingredients[end]; // 더했던거 빼고
                end++; // 인덱스 증가 2 3 index 4 index 5
                // System.out.println("sum: " + sum);
                // System.out.println("end: " + end);
            }

        }

        System.out.println(count);
    }

}
