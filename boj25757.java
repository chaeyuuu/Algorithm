import java.util.*;
import java.io.*;

public class boj25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();

        // 중복 저장
        HashSet<String> people = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            people.add(br.readLine());
        }

        switch (type) {
            case "Y":
                System.out.println(people.size());
                break;
            case "F":
                System.out.println(people.size() / 2);
                break;
            case "O":
                System.out.println(people.size() / 3);
        }
    }
}
