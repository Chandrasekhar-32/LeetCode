class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // More than k ones -> shrink window
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // Remove unnecessary leading zeros
            while (ones == k && left < right && s.charAt(left) == '0') {
                left++;
            }

            // Exactly k ones
            if (ones == k) {
                String curr = s.substring(left, right + 1);

                if (ans.isEmpty()
                        || curr.length() < ans.length()
                        || (curr.length() == ans.length()
                            && curr.compareTo(ans) < 0)) {

                    ans = curr;
                }
            }
        }

        return ans;
    }
}