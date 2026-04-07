/*
1. Insert all numbers into a HashSet.
   This allows O(1) lookup for checking whether a number exists.
2. Iterate over each number in the array.
   For each number, check if it is the start of a sequence, i.e., num - 1 is not present in the set.
3. If it is a starting point:
   Begin counting the length of the consecutive sequence starting from this number.
4. Keep checking next numbers:
   While num + 1 exists in the set, keep increasing the count.
5. Track the maximum length found.
   Update the longest value whenever you find a longer sequence.
6. Return the longest consecutive sequence length
   After processing all numbers, return the maximum sequence length computed.
*/

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
