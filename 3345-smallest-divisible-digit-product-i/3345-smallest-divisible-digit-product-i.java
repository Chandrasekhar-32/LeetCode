class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;

        while (true) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));

            int product = 1;
            for (int j = 0; j < sb.length(); j++) {
                product *= (sb.charAt(j) - '0');
            }

            if (product % t == 0) {
                return i;
            }

            i++;
        }
    }
}