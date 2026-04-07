class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            int otherPair = target - nums[i];
            if(hash.containsKey(otherPair)) {
                result[0] = hash.get(otherPair);
                result[1] = i;
            } else {
                hash.put(nums[i], i);
            }
        }
        return result;
    }
}
