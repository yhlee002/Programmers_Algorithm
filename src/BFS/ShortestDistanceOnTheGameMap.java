package BFS;

import java.util.*;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class ShortestDistanceOnTheGameMap {
    public int solution(int[][] maps) {
        Node start = new Node(0, 0, 1); // (0, 0) 좌표에서 시작했으며 이미 1칸을 지난 것으로 봄
        return BFS(maps, start);
    }

    public int BFS(int[][] maps, Node nd) {
        int n = maps.length;
        int m = maps[0].length;

        // 상하좌우 좌표 확인
        int[] dw = {1, 0, -1, 0};
        int[] dh = {0, 1, 0, -1};

        Queue<Node> q = new LinkedList<>();
        q.offer(nd);

        boolean[][] checked = new boolean[n][m];
        checked[nd.x][nd.y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.cost;
            }

            for (int i = 0; i < 4; i++) {
                int w = node.x + dw[i];
                int h = node.y + dh[i];

                // 상하좌우의 좌표들이 존재하는 좌표인지 확인
                if (h >= 0 && h < m && w >= 0 && w < n) {
                    // 해당 좌표가 벽이 아닌지 + 이미 지나간 길은 아닌지 확인
                    if (maps[w][h] == 1 && !checked[w][h]) {
                        Node item = new Node(w, h, node.cost + 1);
                        q.offer(item);
                        checked[w][h] = true;
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        public int x; // x, y: 실제 maps에서의 좌표
        public int y;
        public int cost; // 해당 경로로 몇 칸 이동했는지 확인을 위해 갱신

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
