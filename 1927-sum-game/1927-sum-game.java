class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            if (i < n / 2) {
                if (c == '?') leftQ++;
                else leftSum += c - '0';
            } else {
                if (c == '?') rightQ++;
                else rightSum += c - '0';
            }
        }

        // Alice gets one extra move
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // Alice wins unless Bob can perfectly balance both sides
        return 2 * (leftSum - rightSum) !=
               9 * (rightQ - leftQ);
    }
}