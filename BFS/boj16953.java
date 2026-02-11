package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16953 {
    static long start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        System.out.println(bfs(start, end));
    }

    static int bfs(long start, long end) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] { start, 1 });

        while (!queue.isEmpty()) {
            long[] now = queue.poll();
            long cur = now[0];
            long count = now[1];

            if (cur == end) {
                return (int) count;
            }

            if (cur * 2 <= end) {
                queue.add(new long[] { cur * 2, count + 1 });
            }

            if (cur * 10 + 1 <= end) {
                queue.add(new long[] { cur * 10 + 1, count + 1 });
            }
        }
        return -1;
    }
}