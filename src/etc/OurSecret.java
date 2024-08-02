package etc;

import java.util.HashSet;
import java.util.Set;

/**
 * 둘만의 비밀
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */
public class OurSecret {
    public static void main(String[] args) {
        String str = solution("aukks", "wbqd", 5);
        System.out.println("str : " + str);
    }

    // ascii code: 41(A), 61(a)
    public static String solution(String s, String skip, int index) {
        char[] skipArr = skip.toCharArray();
        Set<Integer> asciiSet = new HashSet<>();
        for (char c : skipArr) {
            asciiSet.add((int) c);
        }

        StringBuilder builder = new StringBuilder();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];

            int k = 0;
            while (k < index) {
                if (c == 'z') {
                    c = 'a';
                } else {
                    c += 1;
                }

                if (!asciiSet.contains((int) c)) {
                    k++;
                }
            }

            builder.append(c);
        }

        return builder.toString();
    }
}
