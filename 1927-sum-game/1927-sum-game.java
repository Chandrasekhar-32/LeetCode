class Solution {
    public boolean sumGame(String num) {
        int cnt = 0;
        int n = num.length();

        int left = 0;
        int right = 0;

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                cnt++;

                if (i < n / 2) {
                    leftQ++;
                } else {
                    rightQ++;
                }
            } else {
                if (i < n / 2) {
                    left += c - '0';
                } else {
                    right += c - '0';
                }
            }
        }

        if (cnt % 2 == 1) {
            return true;
        }

        return 2 * (left - right) != 9 * (rightQ - leftQ);
    }
}