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

        // 포인터 가르치는거 하나

        // abcd
        // abcdyx

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        ArrayList<Character> arr = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            arr.add(input.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        int pointer = arr.size();

        for (int j = 0; j < N; j++) {
            // P 일때만 하나 두 추가로
            StringTokenizer st = new StringTokenizer(br.readLine());

            char command = st.nextToken().charAt(0);
            if (command == 'P') {
                char data = st.nextToken().charAt(0);
                arr.add(pointer, data);

                if (pointer != arr.size())
                    pointer += 1;

            } else if (command == 'L') {
                if (pointer != 0)
                    pointer -= 1;

            } else if (command == 'D') {
                if (pointer != arr.size())
                    pointer += 1;

            } else if (command == 'B') {
                // 커서 왼쪽에 있는 문제 삭제
                // 커서 한 칸 왼쪽 이동
                if (pointer != 0) {
                    arr.remove(pointer - 1);
                    pointer -= 1;
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + "");
        }

    }
}
