/**
Use bucket sort algorithm. See neetcode video explanation. Its good
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
