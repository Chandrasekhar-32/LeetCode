import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] totalCounts = new int[26];
        int[] prefixCounts = new int[26];

        for (int i = 0; i < n; i++) {
            totalCounts[s.charAt(i) - 'a']++;
            prefixCounts[target.charAt(i) - 'a']++;
        }

        // Iterate backward to find the longest valid matching prefix
        for (int i = n - 1; i >= 0; i--) {
            prefixCounts[target.charAt(i) - 'a']--;

            // 1. Check if s contains enough characters to form target[0...i-1]
            if (canFormPrefix(prefixCounts, totalCounts)) {
                // Calculate remaining available characters for index i and beyond
                int[] remaining = new int[26];
                for (int c = 0; c < 26; c++) {
                    remaining[c] = totalCounts[c] - prefixCounts[c];
                }

                // 2. Try the smallest character strictly greater than target[i]
                int targetCharIdx = target.charAt(i) - 'a';
                for (int nextChar = targetCharIdx + 1; nextChar < 26; nextChar++) {
                    if (remaining[nextChar] > 0) {
                        remaining[nextChar]--;

                        // Build the result string
                        StringBuilder result = new StringBuilder();
                        result.append(target, 0, i);
                        result.append((char) ('a' + nextChar));

                        // Append remaining available characters in ascending order
                        for (int c = 0; c < 26; c++) {
                            while (remaining[c] > 0) {
                                result.append((char) ('a' + c));
                                remaining[c]--;
                            }
                        }

                        return result.toString();
                    }
                }
            }
        }

        return "";
    }

    private boolean canFormPrefix(int[] prefixCounts, int[] totalCounts) {
        for (int c = 0; c < 26; c++) {
            if (prefixCounts[c] > totalCounts[c]) {
                return false;
            }
        }
        return true;
    }
}