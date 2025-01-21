package etc.PCCP;

/**
 * 공원
 * https://school.programmers.co.kr/learn/courses/30/lessons/340198
 */
public class PCCP_10_Park {
    public static void main(String[] args) {
        int[] mats = {5, 3, 2};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        System.out.println(solution(mats, park));
    }

    public static int solution(int[] mats, String[][] park) {
        int max = 0;

        int[] matsNew = new int[mats.length];
        int k = 0;
        for (int i = mats.length - 1; i >= 0; i--) {
            matsNew[k++] = mats[i];
        }

        mats = matsNew;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {

                // 돗자리 반복
                for (int size : mats) {
                    if (canPlaceMat(i, j, size, park)) {
                        max = Math.max(max, size);
                    }
                }
            }
        }
        return max;
    }

    public static boolean canPlaceMat (int x, int y, int size, String[][] park) {
        if (y + size > park.length || x + size > park[y].length) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!park[y + i][x + j].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}
