class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) {
        return false;
      }  
      int[] arr1 = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        arr1[s1.charAt(i)-97]++;
      }
      int[] arr2 = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        arr2[s2.charAt(i)-97]++;
      }
      for (int i = s1.length(); i < s2.length(); i++) {
        if (Arrays.equals(arr1, arr2)) return true;
        arr2[s2.charAt(i-s1.length())-97]--;
        arr2[s2.charAt(i)-97]++;
      }
      return Arrays.equals(arr1, arr2);
    }
}