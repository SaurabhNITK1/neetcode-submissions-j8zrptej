class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] numsPre = new int[nums.length];
        numsPre[0] = 1;
        int[] numsPost = new int[nums.length];
        numsPost[nums.length-1] = 1;

        for(int i=1; i < nums.length; i++) {
           numsPre[i] = numsPre[i-1]*nums[i-1];
        }

        for(int i=nums.length-2; i >= 0; i--) {
           numsPost[i] = numsPost[i+1]*nums[i+1];
        }

        int[] result = new int[nums.length];

        for(int i=0; i < nums.length; i++) {
            result[i] = numsPre[i]*numsPost[i];
        }

        return result;
    }
}  
