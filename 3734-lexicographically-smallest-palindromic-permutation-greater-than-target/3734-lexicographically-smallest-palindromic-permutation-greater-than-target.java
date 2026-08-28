import java.util.*;

public class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Validate palindrome condition
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }
        if (oddCount > 1) return "";

        int m = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        // Search for the longest matching prefix in the first half of length 'm'
        for (int i = m; i >= 0; i--) {
            int[] currentHalfCount = halfCount.clone();
            boolean possible = true;
            StringBuilder prefix = new StringBuilder();

            // Match prefix with target up to index i - 1
            for (int j = 0; j < i; j++) {
                char tChar = target.charAt(j);
                if (currentHalfCount[tChar - 'a'] > 0) {
                    prefix.append(tChar);
                    currentHalfCount[tChar - 'a']--;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            // Case 1: i == m (Matched the full first half)
            if (i == m) {
                StringBuilder full = new StringBuilder(prefix);
                if (n % 2 != 0) full.append(midChar);
                full.append(new StringBuilder(prefix).reverse());
                
                if (full.toString().compareTo(target) > 0) {
                    return full.toString();
                }
                continue;
            }

            // Case 2: i < m, pick a character strictly greater than target[i] at position i
            char tChar = target.charAt(i);
            for (int c = tChar - 'a' + 1; c < 26; c++) {
                if (currentHalfCount[c] > 0) {
                    int[] tempCount = currentHalfCount.clone();
                    StringBuilder cand = new StringBuilder(prefix);
                    cand.append((char) ('a' + c));
                    tempCount[c]--;

                    // Fill remaining half greedily with smallest available characters
                    for (int k = 0; k < 26; k++) {
                        while (tempCount[k] > 0) {
                            cand.append((char) ('a' + k));
                            tempCount[k]--;
                        }
                    }

                    // Build full palindrome
                    StringBuilder full = new StringBuilder(cand);
                    if (n % 2 != 0) full.append(midChar);
                    full.append(new StringBuilder(cand).reverse());

                    if (full.toString().compareTo(target) > 0) {
                        return full.toString();
                    }
                }
            }
        }

        return "";
    }
}