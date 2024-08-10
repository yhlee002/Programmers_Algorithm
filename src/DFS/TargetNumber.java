package DFS;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
    private static int[] numbers;
    private static int cnt = 0;
    private static int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, numbers[0]);
        dfs(0, -1 * numbers[0]);
        return cnt;
    }

    public void dfs(int idx, int sum) {
        if (sum == target && idx == numbers.length - 1) {
            cnt++;
        } else {
            if (idx < numbers.length - 1) {
                idx++;
                dfs(idx, sum - numbers[idx]);
                dfs(idx, sum + numbers[idx]);
            }
        }
    }
}
