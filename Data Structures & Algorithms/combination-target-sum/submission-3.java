/*
✅ Core Idea
Use backtracking (DFS) to explore all possible combinations.
At each step, you decide:
✅ Take the current number
✅ Skip the current number

          (index, target)
             /        \
        TAKE         SKIP
  (same index)   (index+1)

Neetcode video is also a good solution



DFS Tree: nums = [2, 3, 5], target = 8

                            []
                ┌────────────┴────────────┐
              [2]                         []
        ┌─────┴─────┐             ┌──────┴──────┐
     [2,2]          [2]         [3]             []
   ┌──┴──┐           │       ┌───┴───┐           │
[2,2,2] [2,2]     [2,3]    [3,3]     [3]        [5]
  │        │        │        │         │         │
  │        │        │        │         │         │
[2,2,2,2] [2,2,3] [2,3,3]  [3,3,3]   [3,5]     [5,3]
   ✅        ❌        ✅        ❌        ✅        ✅
              │
            [2,2,5]
               ✅


✅ Valid Combinations Highlighted
[2,2,2,2]
[2,3,3]
[3,5]
[2,2,5]




###### Base conditions #####
✅ Case 1: Target becomes 0
        At every recursion call to the left side, you subtract nums[i], so target keeps on reducing
        A valid combination is found
        Add a copy of current list to result
        Return (stop exploring further)

✅ Case 2: Invalid path
        if (target < 0 || index >= nums.length)


###### Decision 1. : Pick current element ######
    curr.add(nums[index]);  // Include nums[index]
    backtrack(nums, target - nums[index], index, curr);  // Reduce target, Keep same index → allows reuse of same number (important)
     

##### Backtrack (undo choice) ######
     curr.removeLast(); // Remove last added element
                       // Restore state for next decision



###### Decision 2.Skip current element #######
backtrack(nums, target, index + 1, curr); // Do NOT include current number
                                          // Move to next index




*/

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
