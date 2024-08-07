package Heap;

import java.util.*;

/**
 * 더 맵게(배열) - PriorityQueue로 구현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class MoreSpicy_PriorityQueue {
    public int solution(int[] scoville, int K) {
        int cnt = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : scoville) {
            queue.add(n);
        }

        if (queue.peek() >= K) {
            return cnt;
        }

        while (queue.size() > 1) {
            int val0 = queue.remove();
            int val1 = queue.remove();
            queue.add(val0 + val1 * 2);
            cnt++;

            if (queue.peek() >= K) {
                break;
            }

            if (queue.size() <= 1) {
                return -1;
            }
        }

        return cnt;
    }
}
