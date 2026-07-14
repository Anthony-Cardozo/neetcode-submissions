class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        String min = "";
        int l = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int r = 0; r < s.length(); r++) {
            mapS.put(s.charAt(r), mapS.getOrDefault(s.charAt(r), 0) + 1);
            while (isValid(mapS, mapT)) {
                if (min.isEmpty() || min.length() > r - l + 1) {
                    min = s.substring(l, r + 1);
                }
                mapS.put(s.charAt(l), mapS.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return min;
    }

    private boolean isValid(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (Character entry : map2.keySet()) {
            if (map1.getOrDefault(entry, 0) < map2.get(entry)) {
                return false;
            }
        }
        return true;
    }
}