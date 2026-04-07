class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqS = new HashMap<>();
        
        // create a hash for String t
        for (int i = 0; i < t.length(); i++) {
            int count = freqT.getOrDefault(t.charAt(i), 0);
            count++;
            freqT.put(t.charAt(i), count);
        }

        int start = 0, end = 0;
        int smallestWindowLength = Integer.MAX_VALUE;
        int smallestWindowStart = 0;
        int matchedCharacters = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (freqT.containsKey(c)) {
                int count = freqS.getOrDefault(c, 0);
                count++;
                freqS.put(c, count);
                if (count == freqT.get(c)) {
                    matchedCharacters++;
                }
            }
            end++;

            while (matchedCharacters == freqT.size()) {
                if (end - start < smallestWindowLength) {
                    smallestWindowLength = end - start;
                    smallestWindowStart = start;
                }
                char startChar = s.charAt(start);
                if (freqT.containsKey(startChar)) {
                    int count = freqS.get(startChar);
                    count--;
                    if (count < freqT.get(startChar)) {
                        matchedCharacters--;
                    }
                    freqS.put(startChar, count);
                }
                start++;
            }
        }

        return smallestWindowLength == Integer.MAX_VALUE ? "" : s.substring(smallestWindowStart, smallestWindowStart + smallestWindowLength);
    }

    private boolean isValidWindow(Map<Character, Integer> freqT, Map<Character, Integer> freqS) {
        for (Map.Entry<Character, Integer> entry : freqT.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (freqS.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
