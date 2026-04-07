/**
Option : See the prevsubmitted solution using multiple passes in hashing. that is easy and same time complexity

For this Algo (use bucket sort, see neetcode video):
1. Hash all the numbers to know the frequency of each number
2. Iterate over this hash and create buckets using this hash. 
   To create bucket use ArrayList of List<Integer> type and use index to denote the count
   and value to denote the actual numbers belonging to that count. Key to the bucket is value 
   in the hash(count of chars) while value to the bucket is the actual numbers
   Bucket size should be equal to length of nums array.
3. Iterate on this bucket from end as u have to find most frequent element
**/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[k]; // To return the result
        List<Integer>[] bucket = new ArrayList[nums.length+1]; // The bucket
        for(int i=0; i < bucket.length; i++) {
           bucket[i] = new ArrayList<>();
        }

        // Hash the nums to get frequency of each number
        for(int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        // create buckets. Key to bucket is value of hash and vice versa
        for(Map.Entry<Integer, Integer> entry: hash.entrySet()) {
           bucket[entry.getValue()].add(entry.getKey());
        }

        // Extract result from bucket. Since u need to get maxFreq, start iterating bucket from last index
        int j = 0; // this is index for filling result
        for (int i = bucket.length - 1; i >= 0 && j < k; i--) {
           if(!bucket[i].isEmpty()) {
              for (int num : bucket[i]) {
                result[j++] = num;
                if (j == k) break;
             }
           }
        }
        
        return result;
    }
}
