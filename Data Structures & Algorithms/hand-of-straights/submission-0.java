class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        while (map.size() > 0) {
            Integer first = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(first + i)) {
                    return false; 
                } else {
                    if (map.get(first + i) > 1) {
                        map.put(first + i, map.get(first + i) - 1);
                    } else {
                        map.remove(first + i);
                    }
                }
            }
        }
        return map.size() == 0;
    }
}
