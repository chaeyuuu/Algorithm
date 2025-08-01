import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class boj10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_front": {
                    arrayDeque.addFirst(Integer.parseInt(s[1]));
                    break;
                }

                case "push_back": {
                    arrayDeque.addLast(Integer.parseInt(s[1]));
                    break;
                }

                case "pop_front": {
                    if (arrayDeque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        int temp = arrayDeque.removeFirst();
                        sb.append(temp).append('\n');
                    }
                    break;
                }

                case "pop_back": {
                    if (arrayDeque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        int temp = arrayDeque.removeLast();
                        sb.append(temp).append('\n');
                    }
                    break;
                }

                case "size": {
                    sb.append(arrayDeque.size()).append('\n');
                    break;
                }

                case "empty": {
                    if (arrayDeque.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                }

                case "front": {
                    if (arrayDeque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(arrayDeque.peekFirst()).append('\n');
                    }
                    break;
                }

                case "back": {
                    if (arrayDeque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(arrayDeque.peekLast()).append('\n');
                    }
                    break;
                }
            }
        }
        System.out.println(sb);

    }
}