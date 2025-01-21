package BruteForce;

import java.util.Arrays;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java
 */
public class MockExam {
    public static void main(String[] args) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answer1)));
        System.out.println(Arrays.toString(solution(answer2)));
    }

    public static int[] solution(int[] answers) {
        int[] sum = new int[3];

        // 1번 수포자
        int[] ans = {0, 1, 2, 3, 4};
        int j = 0;
        for (int i = 0; i < answers.length; i++) {
            int num = 1 + ans[j];
            if (num == answers[i]) sum[0]++;

            j++;
            if (j == ans.length) j = 0;
        }

        // 2번 수포자
        j = 0;
        int[] ans2 = {0, -1, 0, 1, 0, 2, 0, 3};
        for (int i = 0; i < answers.length; i++) {
            int num = 2 + ans2[j];
            if (num == answers[i]) sum[1]++;

            j++;
            if (j == ans2.length) j = 0;
        }

        // 3번 수포자
        j = 0;
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            int num = ans3[j];
            if (num == answers[i]) sum[2]++;

            j++;
            if (j == ans3.length) j = 0;
        }

        int length = 0;
        int max = Math.max(sum[0], Math.max(sum[1], sum[2]));
        if (max == sum[0]) length++;
        if (max == sum[1]) length++;
        if (max == sum[2]) length++;

        int[] result = new int[length];
        int l = 0;
        for (int i = 0; i < sum.length; i++) {
            if (max == sum[i]) {
                result[l++] = i + 1; // i + 1 번 학생
            }
        }

        return result;
    }
}
