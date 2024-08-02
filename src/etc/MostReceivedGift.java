package etc;

import java.util.*;

/**
 * 가장 많이 받은 선물
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
public class MostReceivedGift {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        int result = solution(friends, gifts);

        System.out.println("result : " + result);
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        List<String> giftList = Arrays.asList(gifts);

        // 이름과 이름의 인덱스를 연결짓기 위한 맵(그래프에서 해당 이름의 인덱스를 알기 위함)
        Map<String, Integer> pos = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            pos.put(friends[i], i);
        }

        // 선물 지수
        int[] result = new int[friends.length];

        // 각자가 선물을 준 횟수
        int[][] map = new int[friends.length][friends.length];

        // 내년에 받을 선물의 수
        int[] arr = new int[friends.length];

        giftList.forEach(g -> {
            String a = g.split(" ")[0];
            String b = g.split(" ")[1];

            result[pos.get(a)]++;
            result[pos.get(b)]--;
            map[pos.get(a)][pos.get(b)]++;
        });

        for (int i = 0; i < friends.length; i++) {
            for (int k = 0; k < friends.length; k++) {
                if (i == k) continue;

                String a = friends[i];
                String b = friends[k];

                int aVal = map[pos.get(a)][pos.get(b)];
                int bVal = map[pos.get(b)][pos.get(a)];

                // 중첩 for문에 의해 중복된 두 대상을 비교할 경우를 대비해 조건에 따라 한 쪽만 값 증가 시키기
                if (aVal == bVal) {
                    if (result[pos.get(a)] != result[pos.get(b)]) { // 같으면 둘 다 내년에 선물을 주고받지 않음
                        if (result[pos.get(a)] > result[pos.get(b)]) arr[pos.get(a)]++;
//                        else arr[pos.get(b)]++;
                    }
                } else {
                    if (aVal > bVal) arr[pos.get(a)]++;
//                    else arr[pos.get(b)]++;
                }

                int num = Math.max(arr[pos.get(a)], arr[pos.get(b)]);
                if (answer < num) {
                    answer = num;
                }
            }
        }

        return answer;
    }
}
