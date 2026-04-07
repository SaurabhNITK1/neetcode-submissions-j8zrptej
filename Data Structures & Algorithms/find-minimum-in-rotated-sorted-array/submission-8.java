/* 1. So basically you have to find the pivot element here. Pivot element will be the smallest.
   2. Use binary search
   3. At each step, detect the sorted half, discard it if it cannot contain the minimum, 
      and continue searching in the remaining half. 
   4. In Binary search every iteration must shrink the search space. think of last two remaining
      elements. Think of in last two remaining elements mid is always equals to start.
*/
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int start=0, end=nums.length - 1;

        while(start <= end) {
            if (nums[start] <= nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            min = Math.min(min, nums[mid]);

            if(nums[mid] >= nums[start]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            }
        }
        return min;
    }
}
