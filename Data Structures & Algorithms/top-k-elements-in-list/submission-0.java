class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (Integer.compare(b.getValue(), a.getValue())));
        for(Map.Entry<Integer, Integer> x: map.entrySet())
        {
            pq.add(x);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().getKey();
        }
        return res;
    }
}