//[5,1,2,3,4]

class Solution {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1;
        
        while(start <= end) {
            if (target == nums[start])
                return start;
            int mid = start + (end - start)/2;
            if (target == nums[mid]) 
                return mid;
            if (target == nums[end])
                return end;

            if (nums[start] <= nums[mid]) {
                // left array is sorted
                if (target > nums[start] && target < nums[mid])
                    end = mid;
                else
                    start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                // right array is sorted
                if (target > nums[mid] && target < nums[end])
                    start = mid + 1;
                else
                    end = mid;
            }
        }
        return -1;
    }
}
