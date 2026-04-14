import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열에 담기
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = N; i >= 1; i--) {
            int index = people[i];
            arr.add(index, i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr.get(i) + " ");
        }

    }
}
