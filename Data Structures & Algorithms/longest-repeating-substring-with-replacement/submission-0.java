class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int l = 0;
        int[] arr = new int[26];
        int maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            maxFreq = Math.max(maxFreq, ++arr[s.charAt(r)-65]);
            if (!(max - maxFreq < k)) {
                arr[s.charAt(l)-65]--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}