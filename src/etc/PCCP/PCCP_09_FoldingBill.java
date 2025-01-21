package etc.PCCP;

/**
 * 지폐 접기
 * https://school.programmers.co.kr/learn/courses/30/lessons/340199
 */

public class PCCP_09_FoldingBill {
    public static void main(String[] args) {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};
        System.out.println(solution(wallet, bill));
    }

    public static int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        while (wallet[0] < bill[0] || wallet[1] < bill[1]) {
            if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                break;
            }

            // 지폐를 접어야 할 때는 항상 길이가 긴 쪽을 접음
            if (bill[0] < bill[1]) bill[1] /= 2;
            else bill[0] /= 2;

            cnt++;
        }
        return cnt;
    }
}