class Solution {
    public int convertTime(String current, String correct) {

        int cur = Integer.parseInt(current.substring(0, 2)) * 60
                + Integer.parseInt(current.substring(3));

        int cor = Integer.parseInt(correct.substring(0, 2)) * 60
                + Integer.parseInt(correct.substring(3));

        int diff = cor - cur;
        int ans = 0;

        int[] ops = {60, 15, 5, 1};

        for (int op : ops) {
            ans += diff / op;
            diff %= op;
        }

        return ans;
    }
}