import java.util.*;

class Solution {
    private static final int[][] FACTOR_COUNTS = {
        {0,0,0,0}, {0,0,0,0}, {1,0,0,0}, {0,1,0,0},
        {2,0,0,0}, {0,0,1,0}, {1,1,0,0}, {0,0,0,1},
        {3,0,0,0}, {0,2,0,0}
    }; // factors of 2, 3, 5, 7 for digits 0..9

    public String smallestNumber(String num, long t) {
        long tempT = t;
        int[] req = new int[4];
        int[] primes = {2, 3, 5, 7};
        
        for (int i = 0; i < 4; i++) {
            while (tempT % primes[i] == 0) {
                req[i]++;
                tempT /= primes[i];
            }
        }
        if (tempT > 1) return "-1"; // Unreachable prime factors

        int n = num.length();
        int firstZero = num.indexOf('0');
        int limit = (firstZero == -1) ? n : firstZero;

        // Check original num
        if (firstZero == -1) {
            int[] cur = new int[4];
            for (char c : num.toCharArray()) {
                int d = c - '0';
                for (int p = 0; p < 4; p++) cur[p] += FACTOR_COUNTS[d][p];
            }
            if (isSatisfied(cur, req)) return num;
        }

        // Compute prefix factors
        int[][] pref = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            System.arraycopy(pref[i], 0, pref[i + 1], 0, 4);
            if (d > 0) {
                for (int p = 0; p < 4; p++) pref[i + 1][p] += FACTOR_COUNTS[d][p];
            }
        }

        // Try replacing num[i] with a larger digit
        for (int i = n - 1; i >= 0; i--) {
            if (i > limit) continue;
            int curDigit = num.charAt(i) - '0';

            for (int nextDigit = curDigit + 1; nextDigit <= 9; nextDigit++) {
                int[] remReq = new int[4];
                for (int p = 0; p < 4; p++) {
                    remReq[p] = Math.max(0, req[p] - pref[i][p] - FACTOR_COUNTS[nextDigit][p]);
                }

                String minSuffixDigits = getMinDigits(remReq);
                int availSpace = n - 1 - i;

                if (minSuffixDigits.length() <= availSpace) {
                    int ones = availSpace - minSuffixDigits.length();
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i).append(nextDigit);
                    sb.append("1".repeat(ones)).append(minSuffixDigits);
                    return sb.toString();
                }
            }
        }

        // Extended length
        String minDigits = getMinDigits(req);
        int targetLen = Math.max(n + 1, minDigits.length());
        int ones = targetLen - minDigits.length();
        return "1".repeat(ones) + minDigits;
    }

    private boolean isSatisfied(int[] cur, int[] req) {
        for (int i = 0; i < 4; i++) {
            if (cur[i] < req[i]) return false;
        }
        return true;
    }

    private String getMinDigits(int[] req) {
    int c2 = req[0], c3 = req[1], c5 = req[2], c7 = req[3];
    
    int d9 = c3 / 2; 
    c3 %= 2;

    int d7 = c7;
    int d5 = c5;
    int d6 = 0;

    // KEY FIX: If c3 == 1 and c2 > 0, pairing a 2 and 3 into 6 
    // gives a smaller leading digit than an 8 and a 3.
    if (c3 == 1 && c2 % 3 != 0) {
        d6 = 1;
        c3 = 0;
        c2 -= 1;
    }

    int d8 = c2 / 3; 
    c2 %= 3;
    
    int d4 = c2 / 2; 
    c2 %= 2;
    
    int d3 = c3;
    int d2 = c2;

    StringBuilder sb = new StringBuilder();
    sb.append("2".repeat(d2))
      .append("3".repeat(d3))
      .append("4".repeat(d4))
      .append("5".repeat(d5))
      .append("6".repeat(d6))
      .append("7".repeat(d7))
      .append("8".repeat(d8))
      .append("9".repeat(d9));
    
    char[] chars = sb.toString().toCharArray();
    Arrays.sort(chars);
    return new String(chars);
}
}