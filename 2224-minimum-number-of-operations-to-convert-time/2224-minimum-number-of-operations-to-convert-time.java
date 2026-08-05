class Solution {
    public int convertTime(String current, String correct) {
        char[] p = current.toCharArray();
        char[] c = correct.toCharArray();

        int cur = ((p[0] - '0') * 10 + (p[1] - '0')) * 60
                + ((p[3] - '0') * 10 + (p[4] - '0'));

        int cor = ((c[0] - '0') * 10 + (c[1] - '0')) * 60
                + ((c[3] - '0') * 10 + (c[4] - '0'));

        int diff = cor - cur;
        int cnt = 0;

        cnt += diff / 60;
        diff %= 60;

        cnt += diff / 15;
        diff %= 15;

        cnt += diff / 5;
        diff %= 5;

        cnt += diff;

        return cnt;
    }
}