import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 진실을 아는 사람이 포함되어 있는 파티는 빼야함

        int people = Integer.parseInt(st.nextToken()); // 파티 총 참여 인원
        int party = Integer.parseInt(st.nextToken()); // 파티 총 개수

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        boolean[] truths = new boolean[people + 1]; // 진실 아는 사람 체크용

        // 0이 아닐때만 다음거 입력받기
        if (truthNum > 0) {
            for (int i = 0; i < truthNum; i++) {
                truths[Integer.parseInt(st.nextToken())] = true;
            }
        }

        ArrayList<Integer>[] parties = new ArrayList[party];
        for (int i = 0; i < party; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int num = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>(); // 파티 정보 저장
            for (int j = 0; j < num; j++) {
                parties[i].add(Integer.parseInt(st.nextToken())); // 파티 정보 저장해놓기
            }
        }

        // 모든 파티 배열 돌면서
        while (true) {
            boolean isUpdated = false;
            for (int i = 0; i < party; i++) {
                // 파티 별로 돌면서
                // 진실 몰랐던 사람중에 진실 아는 사람이랑 같은 팀 있으면 containsTrue = true
                boolean containsTrue = false;
                for (int member : parties[i]) {
                    if (truths[member] == true) {
                        containsTrue = true;
                        break;
                    }
                }

                // truths 배열에 추가
                if (containsTrue) {
                    for (int member : parties[i]) {
                        if (!truths[member]) {
                            truths[member] = true;
                            isUpdated = true;
                        }

                    }
                }

            }

            if (!isUpdated)
                break;
        }

        // 이제 최종 과장 가능한 파티 세기
        // parties 돌면서.....
        // truths에 있는지 확인
        int count = 0;
        for (int i = 0; i < party; i++) {
            boolean canCount = false;
            // 진실을 말하는 애가 한명이라도 있으면 그 파티는 아웃
            for (int member : parties[i]) {

                if (truths[member]) {
                    canCount = true;
                }
            }
            if (!canCount) {
                count++;
            }
        }

        System.out.println(count);
    }

}
