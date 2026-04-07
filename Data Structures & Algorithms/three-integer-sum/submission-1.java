class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // fix one number then it becomes twoSum problem. Dont use hash as we need O(1) space.
        // use two pointers approach instead. We know that target sum pblm can be solved using two
        // pointers only if the array is sorted. sort the array as allowed complexity O(n^2)
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
