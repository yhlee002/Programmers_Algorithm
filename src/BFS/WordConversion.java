package BFS;

import java.util.*;

/**
 * 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class WordConversion {
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(words, begin, target);
        return answer;
    }

    public int bfs(String[] words, String begin, String target) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            int cnt = 0;

            Node n = q.poll();
            String str = n.word;

            if (n.word.equals(target)) {
                return n.cost;
            }

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(n.word)) {
                    continue;
                }
                if (!visited[i] && isChangable(n.word, words[i])) {
                    q.offer(new Node(words[i], n.cost + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    // 한 글자만 달라서 변환시킬 수 있는 경우
    boolean isChangable(String a, String b) {
        int diffCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCnt++;
            }
        }

        if (diffCnt == 1) return true;
        else return false;
    }

    static class Node {
        public String word;
        public int cost;

        public Node(String word, int cost) {
            this.word = word;
            this.cost = cost;
        }
    }
}