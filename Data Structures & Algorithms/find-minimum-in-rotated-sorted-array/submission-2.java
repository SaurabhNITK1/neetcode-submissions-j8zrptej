class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int start=0, end=nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            min = Math.min(min, nums[mid]);

            if(nums[mid] >= nums[start]) {
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid - 1;
            }
        }
        return min;
    }
}
