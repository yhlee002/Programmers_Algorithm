package lv2;

import java.util.Arrays;

/**
 * 해시 - 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumberList_Hash {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean result = solution(phone_book);
        System.out.println("result : " + result);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String val = phone_book[i].replace(" ", "");
            String targetVal = phone_book[i + 1].replace(" ", "");

            if (targetVal.indexOf(val) == 0) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
