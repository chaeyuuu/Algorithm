import java.util.*;
import java.io.*;

public class boj21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int count = 1;
        int max = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < X; j++) {
            max += arr[j];
        }

        int temp = max;
        // 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            temp = temp - arr[i - X] + arr[i];
            if (temp > max) {
                max = temp;
                count = 1;
            } else if (temp == max) {
                count += 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
