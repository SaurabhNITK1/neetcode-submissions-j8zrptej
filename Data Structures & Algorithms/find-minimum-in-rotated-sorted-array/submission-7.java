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
