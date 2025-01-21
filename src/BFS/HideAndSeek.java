package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */
public class HideAndSeek {
    public static void main(String[] args) {
        int n = 5; // 수빈이의 위치
        int k = 17; // 동생의 위치
        int[] visited = new int[100000];
        System.out.println(bfs(n, k, visited, 0));
    }

    private static int bfs(int n, int k, int[] visited, int sec) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int num = queue.poll();

                if (num == k) {
                    return sec;
                }

                if (num + 1 < visited.length && visited[num + 1] != 1) {
                    queue.offer(num + 1);
                    visited[num + 1] = 1;
                }
                if (num - 1 >= 0 && visited[num - 1] != 1) {
                    queue.offer(num - 1);
                    visited[num - 1] = 1;
                }
                if (num * 2 < visited.length && visited[num * 2] != 1) {
                    queue.offer(num * 2);
                    visited[num * 2] = 1;
                }
            }
            sec++;
        }
        return sec;
    }
}
