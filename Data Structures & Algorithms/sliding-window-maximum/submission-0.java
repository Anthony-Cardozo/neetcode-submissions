class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for (int r = k; r < nums.length; r++) {
            res[r-k] = map.lastKey();
            if (map.get(nums[r-k]) == 1) {
                map.remove(nums[r-k]);
            } else {
                map.put(nums[r-k], map.get(nums[r-k])-1);
            }
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
        }
        res[res.length-1] = map.lastKey();
        return res;
    }
}