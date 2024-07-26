package lv1;

import java.util.*;

/**
 * 해시 - 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class PhoneKetmon_Hash {
    public static int solution(int[] nums) {
        int size = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            Integer cnt = map.get(n);
            if (cnt == null) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }

        Set<Integer> set = map.keySet();
        return size <= set.size() ? size : set.size();
    }
}
