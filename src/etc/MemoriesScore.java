package etc;

import java.util.*;

/**
 * 추억 점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
public class MemoriesScore {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] result = solution(name, yearning, photo);

        for (int r : result) {
            System.out.println(r); // expect: [19, 15, 6]
        }
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> pos = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            pos.put(name[i], i);
        }

        // 사진별 추억 점수
        for (int i = 0; i < photo.length; i++) {

            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String person = photo[i][j];
                Integer k = pos.get(person);
                int val = k != null ? yearning[k] : 0;

                sum += val;
            }

            answer[i] = sum;
        }

        return answer;
    }
}
