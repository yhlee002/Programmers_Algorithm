package lv1;

import java.util.*;

/**
 * 개인정보수집 유효기간
 */
public class PersonalInformationCollectionValidityPeriod {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] result = solution(today, terms, privacies);
        for (int n : result) {
            System.out.println(n);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        // 오늘 날짜 String -> LocalDate 변환
        String[] str = today.split("[.]");
        int todayYear = Integer.parseInt(str[0]);
        int todayMonth = Integer.parseInt(str[1]);
        int todayDay = Integer.parseInt(str[2]);

        // terms 정리
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] strings = terms[i].split(" ");
            map.put(strings[0], Integer.parseInt(strings[1]));
        }

        // 개인 정보 처리
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];

            String[] arr = privacy.split(" ");
            String d = arr[0];
            String term = arr[1];

            // 가입날짜 String -> LocalDate
            String[] dArr = d.split("[.]");
            int year = Integer.parseInt(dArr[0]);
            int month = Integer.parseInt(dArr[1]);
            int day = Integer.parseInt(dArr[2]);

            // 적용되는 term의 기한에 비교
            int td = map.get(term);
            month += td;

            int t = getDays(todayYear, todayMonth, todayDay);
            int deadline = getDays(year, month, day - 1);

            if (deadline < t) {
                answer.add(i + 1);
            }
        }

        int idx = 0;
        int[] a = new int[answer.size()];
        for (int v : answer) {
            a[idx++] = v;
        }
        return a;
    }

    public static int getDays(int year, int month, int day) {
        return (28 * 12) * year
                + 28 * month
                + day;
    }
}
