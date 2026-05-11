class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int target, int index, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr)); // found a solution, moving further will make target negative
            return;
        }
        if (target < 0 || index >= nums.length)
           return;
        curr.add(nums[index]);
        backtrack(nums, target - nums[index], index, curr);
        curr.removeLast();
        backtrack(nums, target, index + 1, curr);
    }
}
