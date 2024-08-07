package Heap;

/**
 * 더 맵게(배열) - 배열으로 구현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 *
 * scoville은 정렬되어서 들어온다는 전제가 없기 때문에 처음부터 heapify 과정을 거쳐야 한다.
 *
 * [시도 흔적]
 * 1. 합한 값을 root에 올리고, 두번째 노드 자리에는 마지막 노드 값을 가져오기(실패)
 * 2. 두번의 delete 후에 합한 값을 새 노드로 추가(성공)
 *
 * Cf. 테스트 케이스 18번만 실패하는 경우, 처음부터 모든 노드의 key값이 K를 넘는 경우를 고려하지 않아서일 가능성이 크다.
 */
public class MoreSpicy_Array {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        boolean success = false;
        int size = scoville.length;

        for (int i = (scoville.length - 1) / 2; i >= 0; i--) {
            heapify(scoville, i, size - 1);
        }

        // 처음부터 통과될 경우
        if (scoville[0] >= K) {
            success = true;
        }

        // 하향식 heapify 실행
        // 이 때, 최소힙이기 때문에 정렬된 이후의 루트 노드값이 K보다 클 때까지 cnt 상승하며 반복
        while (!success && size > 1) {
            // 섞을 자식 노드 찾기(좌우 노드 중 더 작은값)
            int childIdx = 1;
            if (size > 2 && scoville[2] < scoville[1]) {
                childIdx = 2;
            }

            int val = scoville[0] + scoville[childIdx] * 2;

            delete(scoville, size - 1); // root 삭제
            size--;
            delete(scoville, size - 1);
            size--;
            add(scoville, val, size - 1);
            size++;

            heapify(scoville, childIdx, size - 1);
            heapify(scoville, 0, size - 1);

            cnt++;

            if (scoville[0] >= K) {
                success = true;
                break;
            }
        }

        if (!success) return -1;

        return cnt;
    }

    void heapify(int[] list, int idx, int lastIdx) {
        int child1 = idx * 2 + 1;
        int child2 = idx * 2 + 2;

        int targetIdx = idx;
        if (child1 <= lastIdx && list[child1] < list[targetIdx]) {
            targetIdx = child1;
        }

        if (child2 <= lastIdx && list[child2] < list[targetIdx]) {
            targetIdx = child2;
        }

        if (targetIdx != idx) {
            swap(list, targetIdx, idx);
            heapify(list, targetIdx, lastIdx);
        }
    }

    void swap(int[] list, int idx1, int idx2) {
        int val = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = val;
    }

    int delete(int[] list, int lastIdx) {
        int val = list[0];

        list[0] = list[lastIdx];
        heapify(list, 0, lastIdx - 1);

        return val;
    }

    void add(int[] list, int node, int lastIdx) {
        // 노드 수가 줄어들기 때문에 resize는 신경쓰지 않음
        list[lastIdx + 1] = node;

        int idx = lastIdx + 1;
        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;

            if (list[parentIdx] > node) {
                swap(list, parentIdx, idx);
                idx = parentIdx;
            } else {
                break;
            }
        }
    }
}