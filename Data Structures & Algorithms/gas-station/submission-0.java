class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = gas[0] - cost[0];
        int cur = min;
        int res = 0;
        for (int i = 1; i < gas.length; i++) {
            if (min > cur + gas[i] - cost[i]) {
                res = i;
            }
            min = Math.min(min, cur + gas[i] - cost[i]);
            cur += gas[i] - cost[i];
        }
        if (cur < 0) {
            return -1;
        }
        return res + 1 >= gas.length ? 0 : res + 1;
    }
}