/* Algo:
1. The array is split into two parts and there's a pivot in between
2. At least one part is always sorted
3. We can't apply binary search on whole array so we detect the sorted part and decide whether 
   the target lies inside it or outside it.
4. Then we shrink the search space accordingly

Testcase to consider : [5,6,1,2,3,4]

-------------------------------------------------------------

2️⃣ Why do we explicitly handle start == end?
Javaif (start == end) {    if (target == nums[start]) return start;    else return -1;}
Why this matters

This is the last remaining element
Calculating mid again would not shrink the search further
Prevents infinite loops
Makes the algorithm safe and terminating

✅ This handles 1‑element arrays cleanly


-----------------------------------------------

Most important line (Handle 2 elements base case):

if (nums[start] <= nums[mid]) {

Equal to is required for base case last two elemnts remaining.

Two‑element base case (this is the key)
Consider this subarray during execution:

[2, 3]     => [start == mid == 2, end==3] here both 2 and 3 are sorted, Suppose the target is 2 and we dont have
              '=' check in      if (nums[start] <= nums[mid]  then the algorithm wrongly chose the search space as 3.
*/

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

            if (nums[start] <= nums[mid]) { // when 2 elements are left then start == mid
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
