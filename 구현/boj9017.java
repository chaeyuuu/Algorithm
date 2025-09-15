package 구현;

import java.util.*;
import java.io.*;

public class boj9017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> players = new ArrayList<>(); // 등수랑 같이 저장
            Map<Integer, Integer> teams = new HashMap<>(); // 팀 별 인원수 체크하기

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int teamId = Integer.parseInt(st.nextToken()); // 팀 번호 나타내는 애들 입력받고
                players.add(teamId);
                teams.put(teamId, teams.getOrDefault(teamId, 0) + 1); // 팀 별 인원수 저장
            }

            // 6명 이상인 팀 번호
            List<Integer> validTeam = new ArrayList<>();
            for (int teamId : teams.keySet()) {
                if (teams.get(teamId) >= 6) {
                    validTeam.add(teamId);
                }
            }

            // 6명 넘는 팀만 배열 재구성
            List<Integer> newList = new ArrayList<>();
            for (int team : players) {
                if (validTeam.contains(team)) {
                    newList.add(team);
                }
            }

            // 팀 별로 새로운 등수로 저장
            Map<Integer, List<Integer>> teamScore = new HashMap<>();
            for (int j = 0; j < newList.size(); j++) {
                int team = newList.get(j);
                teamScore.putIfAbsent(team, new ArrayList<>());
                teamScore.get(team).add(j + 1);
            }

            int winTeam = -1;
            int minScore = Integer.MAX_VALUE;
            int compareScore = Integer.MAX_VALUE;

            // 팀 별로 4등까지 점수 합산
            for (int teamId : teamScore.keySet()) {
                List<Integer> totalScore = teamScore.get(teamId);
                int score = totalScore.get(0) + totalScore.get(1) + totalScore.get(2) + totalScore.get(3);
                int fifth = totalScore.get(4);

                if (score < minScore) {
                    minScore = score;
                    winTeam = teamId;
                    compareScore = fifth;
                } else if (score == minScore) {
                    if (fifth < compareScore) {
                        winTeam = teamId;
                        compareScore = fifth;
                    }
                }
            }
            System.out.println(winTeam);
        }
    }
}
