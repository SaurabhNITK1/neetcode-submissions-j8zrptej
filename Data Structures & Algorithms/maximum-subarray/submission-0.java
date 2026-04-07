class Solution {
    public int maxSubArray(int[] nums) { 
        int MAX_SUM = Integer.MIN_VALUE;
        int currentSum =0;
        for(int i =0; i<nums.length; i++) {
           currentSum += nums[i];
           MAX_SUM = Math.max(currentSum, MAX_SUM);

           if(currentSum<0) {
              currentSum = 0;
           }
        }
        return MAX_SUM;
    }
}
