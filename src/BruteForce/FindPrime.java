package BruteForce;

import java.util.*;

/**
 * 소수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class FindPrime {
    public static void main(String[] args) {
        String numbers = "17";
        String numbers2 = "011";

        System.out.println("[result1] " + solution(numbers));
        System.out.println("[result2] " + solution(numbers2));
    }

    public static int solution(String numbers) {
        Set<Integer> set = new HashSet<>();

        char[] charArr = numbers.toCharArray();

        for(int i = 0; i < charArr.length; i++) {
            boolean[] visited = new boolean[charArr.length];
            visited[i] = true;

            StringBuilder sb = new StringBuilder();
            sb.append(charArr[i]);
            set.add(Integer.parseInt(sb.toString()));
            combination(sb, visited, charArr, set);
        }

        Set<Integer> primes = new HashSet<>();
        for (int val : set) {
            if (val > 1 && isPrime(val)) {
                primes.add(val);
                System.out.println(val);
            }
        }

        return primes.size();
    }

    private static Set<Integer> combination(StringBuilder sb, boolean[] visited, char[] charArr, Set<Integer> set) {
        for (int i = 0; i < charArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(charArr[i]);

                set.add(Integer.parseInt(sb.toString()));
                combination(sb, visited, charArr, set);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return set;
    }

    private static boolean isPrime(int val) {
        if (val < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }
}
