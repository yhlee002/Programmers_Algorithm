package etc;

/**
 * 덧칠하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */
public class ApplyMorePaint {
    public static int Solution(int n, int m, int[] section) {
        int answer = 0;

        int[] arr = new int[m];
        int start = section[0];
        int end = start + m - 1;
        answer++;
        for(int i = 0; i < section.length; i++) {
            int val = section[i];

            if (start <= val && val <= end) {
                continue;
            } else if (val > end) {
                start = val;
                end = start + m - 1;

                answer++;
            }
        }

        return answer;
    }
}
