package 구현;

import java.io.*;
import java.util.*;

public class boj1406 {

    public static void main(String[] args) throws IOException {
        // L: 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
        // D: 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
        // B: 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
        // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
        // P $: $라는 문자를 커서 왼쪽에 추가함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            left.add(input.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if (command == 'P') {
                char data = st.nextToken().charAt(0);
                left.push(data);
            } else if (command == 'L') {
                if (left.size() != 0)
                    right.push(left.pop());
            } else if (command == 'D') {
                if (right.size() != 0)
                    left.push(right.pop());
            } else if (command == 'B') {
                if (left.size() != 0) {
                    left.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < left.size(); i++) {
            sb.append(left.get(i));
        }

        for (int i = right.size() - 1; i >= 0; i--) {
            sb.append(right.get(i));
        }

        System.out.println(sb.toString());

    }
}
