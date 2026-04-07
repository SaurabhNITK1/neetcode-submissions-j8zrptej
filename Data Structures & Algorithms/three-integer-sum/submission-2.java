/**
 * Finds all unique triplets in the array whose sum is zero.
 *
 * Algorithm:
 * 1. Sort the input array to enable the two-pointer technique. 
      (Two pointer for two sum works only on sorted array)
 * 2. Iterate through the array and fix one element at a time.
 * 3. Skip duplicate values for the fixed element to avoid repeated triplets.
 * 4. For the remaining part of the array, use two pointers (start, end)
 *    to find pairs whose sum with fixed number at step2. equals 0.
 * 5. If the sum is less than zero, move the start pointer right.
 *    If the sum is greater than zero, move the end pointer left.
 * 6. When a valid triplet is found, add it to the result and
 *    move both pointers while skipping duplicates.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) extra space (excluding output)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
          
        for (int i=0; i<nums.length; i++) {
            // handle duplicates for first number which you are fixing
            if (i>0 && nums[i]==nums[i-1]) continue;
            
            // calculate two sum for i+1 to nums.length
            int start = i+1, end=nums.length-1;
            while(start < end) {
               int currentSum = nums[i] + nums[start] + nums[end];

               if (currentSum < 0) {
                  start++;
               } else if (currentSum > 0) {
                  end--;
               } else {
                  // one solution found. save and iterate to next avoiding duplicates.
                  List<Integer> solution = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                  result.add(solution);
                  start++;
                  end--;
                  // handle duplicates for two sum
                  while (start < end && nums[start]==nums[start-1] && nums[end] == nums[end+1]) {
                     start++;
                     end--;
                  }
               } 
            }   
        }
        return result;
    }
}
