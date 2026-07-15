class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            q.add(stones[i]);
        }
        while (q.size() > 1) {
            int a = q.remove();
            int b = q.remove();
            if (a == b) {
                continue;
            }
            q.add(a-b);
        }
        if (q.size()==0) return 0;
        return q.peek();
    }
}