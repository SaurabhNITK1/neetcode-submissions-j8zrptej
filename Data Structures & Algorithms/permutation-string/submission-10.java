/* Algo:
   We make use of a hashmap s1map which stores the frequency of occurence of all the characters in the short string s1. 
   We consider every possible substring of s2 of the same length as that of s1, find its corresponding hashmap as well, namely hashS2. 
   Thus, the substrings considered can be viewed as a window of length as that of s1 iterating over s2. 
   If the two hashmaps obtained are identical for any such window, we can conclude that s1's permutation is a substring of s2, otherwise not.
*/


public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start=0;
        int end = s1.length()-1; // window size, fixed window, index starts from 0 thats why -1
        Map<Character, Integer> hashS1 = new HashMap<>();
        Map<Character, Integer> hashS2 = new HashMap<>();
        // save the freq of characters appearing in s1 in a hashMap
        for(int i=0; i<s1.length(); i++) {
            hashS1.put(s1.charAt(i), hashS1.getOrDefault(s1.charAt(i), 0)+1);
        }
        // save the freq of characters appearing in s2 in another hashMap for intial window
        for(int i=start; i<end; i++) {
            hashS2.put(s2.charAt(i), hashS2.getOrDefault(s2.charAt(i), 0)+1);
        }

        while (end < s2.length()) {
            hashS2.put(s2.charAt(end), hashS2.getOrDefault(s2.charAt(end), 0)+1);
            if(isPermutation(hashS1, hashS2)) {
                return true;
            } else {
                // Modify the hashMap to be valid for next window. Remove at start, add at end in next iteration
                hashS2.put(s2.charAt(start), hashS2.getOrDefault(s2.charAt(start), 0)-1);
                start++;
                end++;
            }
        }
        return false;
    }

    private boolean isPermutation(Map<Character, Integer> hashS1, Map<Character, Integer> hashS2) {
        for(Map.Entry<Character, Integer> entry : hashS1.entrySet()) {
            Character characterS1 = entry.getKey();
            if(entry.getValue() - hashS2.getOrDefault(characterS1, -1) != 0) { // The correct way of two map comparision. Here entry.getValue() != hashS2.get(characterS1) check will fail when hashS2.get(characterS1) == null bcz entry.getValue() != null will be always true
                return false;
            }
        }
        return true;
    }
}
