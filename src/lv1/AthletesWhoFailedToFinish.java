package lv1;

import java.util.*;
/**
 * 해시 - 완주하지 못한 선수
 * 효율성 향상을 위해 Map 수 최소화, Set/Iterator 사용 로직 제거
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class AthletesWhoFailedToFinish {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = solution(participant, completion);
        System.out.println("result : " + result);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);
        }

        // 이름 map의 값(최소 1)에서 1씩 감소시킴
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        // 이름 map의 값이 0이면 해당 이름의 사람(동명이인 포함) 완주로 침
        for (String name : participant) {
            if (map.get(name) > 0) {
                answer = name;
                break;
            }
        }

        return answer;
    }
}
