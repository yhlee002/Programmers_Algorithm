package BFS;

import java.util.*;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Network_lv3 {
    private static int[][] computers;
    private static int[] checked;
    private static int cnt;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.checked = new int[n];

        for (int i = 0; i < n; i++) {
            if (checked[i] == 0) {
                BFS(i);
                cnt++;
            }
        }

        return cnt;
    }

    public void BFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num); // index

        while (!q.isEmpty()) {
            System.out.println(q.toString());
            int idx = q.poll();
            checked[idx] = 1;
            for (int i = 0; i < computers[idx].length; i++) {
                if (i == idx || checked[i] == 1) {
                    continue;
                }

                if (computers[idx][i] == 1) {
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Network_lv3 networkLv3 = new Network_lv3();
        int result = networkLv3.solution(3, arr);
        System.out.println("result: " + result);
    }
}
