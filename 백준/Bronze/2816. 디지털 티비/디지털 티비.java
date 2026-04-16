import java.util.*;
import java.io.*;

// 모든 채널의 이름은 서로 다르고, 항상 KBS1과 KBS2를 포함
// 가장 처음에 화살표는 제일 첫 번째 채널
// 1. 화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
// 2. 화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
// 3. 현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
// 4. 현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)

// KBS1를 첫 번째로, KBS2를 두 번째로 순서를 바꾸는 방법
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];
        for (int i = 0; i < N; i++) {
            channels[i] = br.readLine();
        }

        ArrayList<Integer> arrows = new ArrayList<>();

        int cur = 0;
        // kbs1 먼저
        // 첫번째가 kbs1이아니면 kbs1을 찾으러 가야함
        for (int i = 0; i < N; i++) {
            if (channels[i].equals("KBS1")) {
                cur = i;
                break;
            } else {
                arrows.add(1);
            }
        }

        // 선택한 kbs1을 위로 올리기
        while (cur > 0) {
            String temp = channels[cur];
            channels[cur] = channels[cur - 1];
            channels[cur - 1] = temp;
            cur--;
            arrows.add(4);
        }

        // kbs2
        // 두번째가 kbs2이아니면 kbs2을 찾으러 가야함
        for (int i = 0; i < N; i++) {
            if (channels[i].equals("KBS2")) {
                cur = i;
                break;
            } else {
                arrows.add(1);
            }
        }

        while (cur > 1) {
            String temp = channels[cur];
            channels[cur] = channels[cur - 1];
            channels[cur - 1] = temp;
            cur--;
            arrows.add(4);
        }

        for (int i = 0; i < arrows.size(); i++) {
            System.out.print(arrows.get(i));
        }

    }
}
