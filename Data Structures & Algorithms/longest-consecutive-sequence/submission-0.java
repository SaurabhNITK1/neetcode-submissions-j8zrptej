class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int longest = 0;
        for (int num : nums) {
            // put in hashSet to make search O(1)
            hashSet.add(num);
        }

        for (int i=0; i<nums.length; i++) {
           int itr = nums[i]; 
           if (!hashSet.contains(itr-1)) {
             // find a strating . If num-1 does not exist in the set, it means num is the starting of a sequence.
             int length = 1;
             while(hashSet.contains(itr+1)) {
               itr++;
               length++;
             }
             longest = Math.max(longest, length);
           }
        }
    return longest;
    }
}
