/**
Option 1: 
Algo:
1. Hash all the numbers to know the frequency of each number
2. Iterate over this hash in multiple passes. In each pass extract the number corresponding to max frequency.
3. You need to go atmost k passes in step 2. pushing complexity to O(k.n) ~ O(n) as k is contant. Space is O(n) for hashing
**/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[k];

        for(int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        int flag=0;
        while(flag<k) {
            int mostFrequentKey = 0;
            int mostFrequentVal = 0;
            for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
               if(mostFrequentVal < entry.getValue()) {
                  mostFrequentVal = entry.getValue();
                  mostFrequentKey = entry.getKey();
               }
            }
            hash.remove(mostFrequentKey);
            result[flag] = mostFrequentKey;
            flag++;
        }
        return result;
    }
}
