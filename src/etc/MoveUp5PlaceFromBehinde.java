package etc;

/**
 * 뒤에서 5등 위로
 * https://school.programmers.co.kr/learn/courses/30/lessons/181852
 */
public class MoveUp5PlaceFromBehinde {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
        int[] result = solution(num_list); // [15, 32, 38, 46, 56]
        for(int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];

//        num_list = selectionSort(num_list);
//        num_list = bubbleSort(num_list);
        num_list = insertSort(num_list);

        // answer = num_list.splice(5);
        for (int i = 5; i < num_list.length; i++) {
            answer[i - 5] = num_list[i];
        }

        return answer;
    }

    // 선택 정렬
    public static int[] selectionSort(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {

            int minIdx = i;
            for (int j = i; j < num_list.length; j++) {
                if (num_list[minIdx] > num_list[j]) {
                    minIdx = j;
                }
            }

            // 인덱스 0과 최솟값 교환
            int val = num_list[i];
            num_list[i] = num_list[minIdx];
            num_list[minIdx] = val;
        }

        return num_list;
    }

    // 버블 정렬
    public static int[] bubbleSort(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            for (int j = 0; j < num_list.length - 1; j++) {
                if (num_list[j] > num_list[j + 1]) {
                    int val = num_list[j + 1];
                    num_list[j + 1] = num_list[j];
                    num_list[j] = val;
                }
            }
        }

        return num_list;
    }

    // 삽입 정렬
    public static int[] insertSort(int[] num_list) {
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

        return num_list;
    }

    // 퀵 정렬

}
