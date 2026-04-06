import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < K; i++) {
            max += temp[i];
        }

        int curMax = max;

        for (int i = K; i < N; i++) {
            curMax += temp[i];
            curMax -= temp[i - K];
            max = Math.max(curMax, max);
        }

        System.out.println(max);

    }

}
