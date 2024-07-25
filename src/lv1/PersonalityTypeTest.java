package lv1;

import java.util.*;

/**
 * 성격 유형 검사하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class PersonalityTypeTest {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String type = solution(survey, choices);
        System.out.println("type : " + type);
    }

    public static String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> t = Arrays.asList('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N');
        for (char c : t) {
            map.put(c, 0);
        }

        for(int i = 0; i < survey.length; i++) {
            char[] types = survey[i].toCharArray();
            char a = types[0]; // 비동의 관련 선택지 선택시 받는 성격 유형
            char b = types[1]; // 동의 관련 선택지 선택시 받는 성격 유형

            int point = getPoint(choices[i]);
            if (point > 0) {
                map.put(a, map.get(a) + point);
            } else if (point < 0) {
                map.put(b, map.get(b) - point);
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        answer.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        answer.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        answer.append(map.get('A') >= map.get('N') ? 'A' : 'N');

        return answer.toString();
    }

    public static int getPoint(int choice) {
        if (choice == 1) return 3;
        else if (choice == 2) return 2;
        else if (choice == 3) return 1;
        else if (choice == 4) return 0;
        else if (choice == 5) return -1;
        else if (choice == 6) return -2;
        else return -3;
    }
}
