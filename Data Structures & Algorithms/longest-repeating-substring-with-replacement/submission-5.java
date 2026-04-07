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
                // remove character from start
                hash.put(s.charAt(start), hash.getOrDefault(s.charAt(start), 0)-1);
                start++;
                end++; // If you dont do this same character will be added to hashmap twice.
            }
        }
        return maxLength;
    }
}
