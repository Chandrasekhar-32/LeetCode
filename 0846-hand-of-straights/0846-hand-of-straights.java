class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int num = first + i;

                if (!map.containsKey(num)) {
                    return false;
                }

                int count = map.get(num);

                if (count == 1) {
                    map.remove(num);
                } else {
                    map.put(num, count - 1);
                }
            }
        }

        return true;
    }
}