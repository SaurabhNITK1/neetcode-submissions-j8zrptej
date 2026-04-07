/*
Algo:
1. Use variable sliding window with start=0, end=0.
2. Start processing the window with end pointer. Update every char at end into hash.
3. Take a global maxFreq=0. In each iteration update maxFreq when a higher value is available. 
   no need to update lower values for maxFreq. This is because for any given window the maximum 
   size of valid window is 'maxFreq+k'.
4. if valid window (ie. currLength - maxFreq <= k), update the maxLength and expand window
5. if invalid window, remove the start element from hash
*/

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
            maxFreq = Math.max(maxFreq, hash.getOrDefault(currChar, 0)); /* currChar should strictly represent current window.
            There is no need to decrement maxFreq ie. no need to reset maxFreq for current window. Only need to make sure that hash is set only for current window.
            No need to reset maxFreq as it won't affect the maxLength. maxLength can go only upto "maxFreq + k". So lesser value of maxFreq wont update maxLength.
            Only need to update maxFreq when a greater maxFreq is available.
            See Neetcode video explanation.
            */
            if(currLength - maxFreq <= k) {
                if(maxFreq+k<s.length())maxLength = maxFreq+k;
                else maxLength = s.length();
               end++;
            } else {
                // window invalid, remove character from start, remove extra addition in hash at end
                hash.put(s.charAt(end), hash.getOrDefault(s.charAt(end), 0)-1); // remove extra element put outside window as it will be put again in next loop iteration 
                hash.put(s.charAt(start), hash.getOrDefault(s.charAt(start), 0)-1);
                start++;
            
            }
        }
        return maxLength;
    }
}
