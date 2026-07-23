class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        int l = 1;
        for (int i : piles) {
            r = Math.max(r, i);
        }
        int m = 0; 
        while (l <= r) {
            System.out.println(l +" " + r);
            m = l + (r - l) / 2;
            long time = 0;
            for (int x : piles) {
                time += x / m;
                if (x % m != 0)
                    time++;
            }
            if (time > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;

        
    }
}