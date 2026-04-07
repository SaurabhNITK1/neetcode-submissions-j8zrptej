class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int start = 0, end = 0;
        Map<Character, Integer> hash = new HashMap<>();
        int maxFreq = 0;

        while (end < s.length()) {
            char currentCharacter = s.charAt(end);
            hash.merge(currentCharacter, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, hash.get(currentCharacter));

            int currLength = end - start + 1;
            if (currLength - maxFreq > k) {
                char startChar = s.charAt(start);
                hash.put(startChar, hash.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
