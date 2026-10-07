package HighestPalindrome;

import java.util.Scanner;

public class Palindrome {

    private static int makePalindrome(char[] chars, int k, int left, int right) {
        if (left >= right) {
            return k;
        }

        if (chars[left] != chars[right]) {
            char maxChar = chars[left] > chars[right] ? chars[left] : chars[right];
            chars[left] = maxChar;
            chars[right] = maxChar;
            k--;

            if (k < 0) {
                return -1;
            }
        }

        return makePalindrome(chars, k, left + 1, right - 1);
    }

    private static int maximizeDigits(char[] chars, int k, int left, int right) {
        if (left > right) {
            return k;
        }

        if (chars[left] != '9' && k >= 2) {
            chars[left] = '9';
            chars[right] = '9';
            k -= 2;
        }

        return maximizeDigits(chars, k, left + 1, right - 1);
    }

    private static boolean isAllZeros(String s, int index) {
        if (index >= s.length()) {
            return true;
        }

        if (s.charAt(index) != '0') {
            return false;
        }

        return isAllZeros(s, index + 1);
    }

    public static String highestPalindrome(String s, int k) {
        if (s == null || s.isEmpty()) {
            return "-1";
        }

        if (k >= s.length()) {
            k = s.length();
        }

        char[] chars = s.toCharArray();

        k = makePalindrome(chars, k, 0, chars.length - 1);

        if (k < 0) {
            return "-1";
        }

        maximizeDigits(chars, k, 0, chars.length - 1);

        String result = new String(chars);

        if (isAllZeros(result, 0)) {
            return "0";
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Highest Palindrome ===\n");

        System.out.print("Input string: ");
        String s = scanner.nextLine().trim();

        System.out.print("Input k: ");
        int k = scanner.nextInt();

        String result = highestPalindrome(s, k);

        System.out.println("\n=== Result ===");
        System.out.println("Output: " + result);

        scanner.close();
    }
}