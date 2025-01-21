package BruteForce;

import java.util.Arrays;

/**
 * 최소직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class MinimumRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 모든 명합의 가로, 세로 사이즈

        System.out.println(solution(sizes));
        System.out.println(solution2(sizes));
    }

    // 가장 작은 지갑의 크기(너비 x 높이) 반환
    private static int solution(int[][] sizes) {
        // 명함은 돌릴 수 있음
        int width = sizes[0][0];
        int height = sizes[0][1];
        for (int i = 1; i < sizes.length; i++) { //
            if (width >= sizes[i][0] && height >= sizes[i][1]) continue;
            else {
                int tmpW = Math.max(width, sizes[i][0]);
                int tmpH = Math.max(height, sizes[i][1]);
                int case1 = tmpW * tmpH;

                int tmpW2 = Math.max(width, sizes[i][1]);
                int tmpH2 = Math.max(height, sizes[i][0]);
                int case2 = tmpW2 * tmpH2;

                if (case1 >= case2) {
                    width = tmpW2;
                    height = tmpH2;
                } else {
                    width = tmpW;
                    height = tmpH;
                }
            }
        }

        return width * height;
    }

    private static int solution2(int[][] sizes) {
        int length = 0;
        int height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1])); // 큰 수 왼편에 몰기
            height = Math.max(height, Math.min(card[0], card[1])); // 작은 수 오른편에 몰기
        }
        return length * height;
    }
}
