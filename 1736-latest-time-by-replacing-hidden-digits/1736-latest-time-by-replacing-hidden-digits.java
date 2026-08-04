class Solution {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder(time);

        // First hour digit
        if (sb.charAt(0) == '?') {
            if (sb.charAt(1) == '?' || sb.charAt(1) <= '3') {
                sb.setCharAt(0, '2');
            } else {
                sb.setCharAt(0, '1');
            }
        }

        // Second hour digit
        if (sb.charAt(1) == '?') {
            if (sb.charAt(0) == '2') {
                sb.setCharAt(1, '3');
            } else {
                sb.setCharAt(1, '9');
            }
        }

        // First minute digit
        if (sb.charAt(3) == '?') {
            sb.setCharAt(3, '5');
        }

        // Second minute digit
        if (sb.charAt(4) == '?') {
            sb.setCharAt(4, '9');
        }

        return sb.toString();
    }
}