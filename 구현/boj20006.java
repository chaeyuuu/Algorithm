package 구현;

import java.util.*;
import java.io.*;

public class boj20006 {

    static class Player {
        int level;
        String nickname;

        public Player() {
        }

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return level + " " + nickname;
        }
    }

    static class Room {
        int baseLevel;
        List<Player> players = new ArrayList<>();

        public Room() {
        }

        // 추가 가능 여부
        boolean canJoin(Player p, int m) {
            return players.size() < m &&
                    p.level >= baseLevel - 10 &&
                    p.level <= baseLevel + 10;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Player> playerList = new ArrayList<>();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 플레이어 레벨, 닉네임
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player player = new Player(l, n);
            playerList.add(player);
        }

        List<Room> roomList = new ArrayList<>();

        for (Player player : playerList) {
            boolean conJoin = false;
            // 방 리스트 돌면서 들어갈 수 있는 방 찾기
            for (Room room : roomList) {
                if (room.canJoin(player, m)) {
                    room.players.add(player);
                    conJoin = true;
                    break;
                }
            }

            // 들어갈 수 있는 방 없으면
            if (!conJoin) {
                Room room = new Room();
                room.baseLevel = player.level;
                room.players.add(player);
                roomList.add(room);
            }
        }

        // 출력
        // 닉네임은 사전 순
        for (Room room : roomList) {
            if (room.players.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            // 닉네임 순으로 정렬해서 출력
            room.players.sort((o1, o2) -> o1.nickname.compareTo(o2.nickname));

            for (Player player : room.players) {
                System.out.println(player);
            }

        }
    }
}
