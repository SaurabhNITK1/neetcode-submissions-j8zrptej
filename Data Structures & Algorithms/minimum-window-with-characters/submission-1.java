class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqS = new HashMap<>();
        
        // create a hash for String t
        for(int i=0; i<t.length(); i++) {
            int count = freqT.getOrDefault(t.charAt(i), 0);
            count++;
            freqT.put(t.charAt(i), count);
        }

        // create a variable window starting from 1st index for String s
        // expand if valid window, contract for invalid window
        int start=0, end=0;
        int smallestWindowLength = Integer.MAX_VALUE;
        String smallestWindowString = "";
        /* 
           If found the atleast one matching character, start the window
           and keep expanding till you find valid window. 
           once valid window is found, contract to find smaller size
           of valid window.
           keep a track of smallest valid window and return
        */
        while(end<s.length()) {
           char c = s.charAt(end);
           int count2 = freqS.getOrDefault(c, 0);
           count2++;
           freqS.put(c, count2);
           while(isValidWindow(freqT, freqS)) {
              // found a valid window, contract to find smaller valid window
              // Remove entry at start from freqS. Entries in freqS should represent a valid window entries
              if(freqS.containsKey(s.charAt(start))) {
                char startChar = s.charAt(start);
                freqS.put(startChar, freqS.get(startChar) - 1);
                if (freqS.get(startChar) == 0) {
                    freqS.remove(startChar);
                }
              }
             if(end-start+1 < smallestWindowLength) {
                smallestWindowLength = end-start+1;
                smallestWindowString = s.substring(start, end+1);
             }
             start++;
           }
           // Keep expanding to find a valid window and create/update freqS
           end++;
        }
        return smallestWindowString;
    }

    private boolean isValidWindow(Map<Character, Integer> freqT, Map<Character, Integer> freqS) {
        if(freqS.size()<freqT.size()) return false;

        for(Map.Entry<Character, Integer> mapEntry : freqT.entrySet()) {
            Character key = mapEntry.getKey();
            Integer value = mapEntry.getValue();
           if(freqS.containsKey(key)) {
               if(freqS.get(key) >= value) continue;
           }
           return false;
        }
        return true;
    }
}
