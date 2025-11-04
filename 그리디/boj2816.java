package 그리디;

import java.util.*;
import java.io.*;

public class boj2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> channels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            channels.add(br.readLine());
        }

        /*
         * 1. 화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
         * 2. 화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
         * 3. 현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
         * 4. 현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)
         */

        StringBuilder sb = new StringBuilder();
        // kbs1부터 1번으로 이동
        int cursor = 0;
        int kbs1Index = -1;
        for (int i = 0; i < channels.size(); i++) {
            if (channels.get(i).equals("KBS1")) {
                kbs1Index = i;
                break;
            }
        }

        // 지금은 3번임 얘를 1번으로 움직이려면
        while (kbs1Index > 0) {
            // 0번이 될 때까지 반복
            if (cursor < kbs1Index) {
                // 화살표가 kbs1Index보다 아래에 있다면
                cursor++;
                sb.append("1");
            } else if (cursor > kbs1Index) {
                // 화살표가 kbs1Index보다 위에 있다면
                cursor--;
                sb.append("2");
            } else {
                // 화살표가 kbs1Index를 가리키고 있다면
                sb.append("4");
                Collections.swap(channels, kbs1Index, kbs1Index - 1);
                cursor--;
                kbs1Index--;
            }
        }

        // kbs2를 2번으로 이동
        cursor = 0;
        int kbs2Index = -1;
        for (int i = 0; i < channels.size(); i++) {
            if (channels.get(i).equals("KBS2")) {
                kbs2Index = i;
                break;
            }
        }

        while (kbs2Index > 1) {
            // 0번이 될 때까지 반복
            if (cursor < kbs2Index) {
                cursor++;
                sb.append("1");
            } else if (cursor > kbs2Index) {
                cursor--;
                sb.append("2");
            } else {
                sb.append("4");
                Collections.swap(channels, kbs2Index, kbs2Index - 1);
                cursor--;
                kbs2Index--;
            }
        }
        System.out.print(sb.toString());
    }
}