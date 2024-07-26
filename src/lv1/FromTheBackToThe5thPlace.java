package lv1;

/**
 * 뒤에서 5등 까지
 * https://school.programmers.co.kr/learn/courses/30/lessons/181853
 */
public class FromTheBackToThe5thPlace {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, 1, 14};
        int[] result = solution(num_list); // [1, 4, 12, 14, 15]
        for(int v : result) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] num_list) {

        // 1. sorting(삽입 정렬) -> 다섯개로 배열 만들기
        for (int i = 1; i < num_list.length; i++) {
            int val = num_list[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (num_list[j] > val) {
                    num_list[j + 1] = num_list[j];
                } else {
                    break;
                }
            }
            num_list[j + 1] = val;
        }

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = num_list[i];
        }

        return arr;
    }
}
