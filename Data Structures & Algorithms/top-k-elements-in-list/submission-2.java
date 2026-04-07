/**
Option : 
Algo (use bucket sort):
1. Hash all the numbers to know the frequency of each number
2. Iterate over this hash and create buckets using this hash. 
   To create bucket use ArrayList and use index to denote the count 
   and value to denote the actual numbers belonging to that count. 
   Bucket size should be equal to length of nums array.
3. Iterate on this bucket from end as u have to find most frequent element
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
