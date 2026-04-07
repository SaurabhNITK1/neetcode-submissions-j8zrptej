class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int maxLength = 0;
        int start=0, end=0;
        if (s.length() == 1) return 1;

        while (end < s.length()) {
           if (hash.containsKey(s.charAt(end))) {
                  hash.remove(s.charAt(start));
                  start++;
           } else {
            // Not a duplicate
            hash.put(s.charAt(end), 1); // Put before incrementing , put dummy val of count as one
            maxLength = Math.max(maxLength, end-start+1); // calculate curr max before incrementing
            end++;
           }
        }
        return maxLength;
    }
}