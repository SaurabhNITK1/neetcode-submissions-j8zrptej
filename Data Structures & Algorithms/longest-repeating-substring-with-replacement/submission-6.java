class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int start = 0, end = 0;
        Map<Character, Integer> hash = new HashMap<>();
        int maxFreq = 0;

        while (end < s.length()) {
            int currLength = end-start+1;
            char currChar = s.charAt(end);
            hash.put(currChar, hash.getOrDefault(currChar, 0)+1); 
            maxFreq = Math.max(maxFreq, hash.getOrDefault(currChar, 0)); // should strictly represent current window
            if(currLength - maxFreq <= k) {
               maxLength = Math.max(maxLength, currLength);
               end++;
            } else {
                // window invalid, remove character from start, remove extra addition in hash at end
                hash.put(s.charAt(end), hash.getOrDefault(s.charAt(end), 0)-1); // extra element put outside window
                hash.put(s.charAt(start), hash.getOrDefault(s.charAt(start), 0)-1);
                start++;
            }
        }
        return maxLength;
    }
}
