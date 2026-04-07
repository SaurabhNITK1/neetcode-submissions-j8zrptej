//[5,6,1,2,3,4]

class Solution {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1;
        
        while (start <= end) {
            if (start == end) {
                // last element reached, search space shrinked to last element
                if (target == nums[start]) return start;
                else return -1;
            }

            int mid = start + (end - start)/2;
            /* 
               We can't apply binary search in whole array but we can find the sorted part within the array
               and apply binary search in that. Based on this we can determine whether the target lies
               in the sorted part or unsorted part and shrink our search
            */

            if (nums[start] <= nums[mid]) {
                // left part is sorted. Check if target lies within the sorted part or non-sorted part 
                // and shrink the search space accordingly
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                // right side is sorted
                if (target == nums[mid]) return mid;
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
        
}
