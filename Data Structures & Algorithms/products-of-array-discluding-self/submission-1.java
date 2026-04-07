/**
 * Solution for LeetCode "Product of Array Except Self" problem.
 * 
 * <p>Given an integer array nums, return an array answer such that answer[i] 
 * is equal to the product of all the elements of nums except nums[i].</p>
 * 
 * <p>The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.</p>
 * 
 * <p>You must write an algorithm that runs in O(n) time and without using the division operator.</p>
 */
class Solution {
    
    /**
     * APPROACH 1: Prefix and Postfix Arrays (O(n) auxiliary space)
     * 
     * <p>Computes the product of all elements except self by maintaining two separate arrays:</p>
     * <ul>
     *   <li><b>Prefix products (numsPre):</b> numsPre[i] contains the product of all elements before index i</li>
     *   <li><b>Postfix products (numsPost):</b> numsPost[i] contains the product of all elements after index i</li>
     * </ul>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Build prefix array: numsPre[i] = nums[0] * nums[1] * ... * nums[i-1]</li>
     *   <li>Build postfix array: numsPost[i] = nums[i+1] * nums[i+2] * ... * nums[n-1]</li>
     *   <li>Result: result[i] = numsPre[i] * numsPost[i]</li>
     * </ol>
     * 
     * <p><b>Example:</b> nums = [1, 2, 3, 4]</p>
     * <pre>
     * numsPre  = [1, 1, 2, 6]   // [1, 1*1, 1*2, 1*2*3]
     * numsPost = [24, 12, 4, 1] // [2*3*4, 3*4, 4, 1]
     * result   = [24, 12, 8, 6] // [1*24, 1*12, 2*4, 6*1]
     * </pre>
     * 
     * <p><b>Complexity Analysis:</b></p>
     * <ul>
     *   <li>Time Complexity: O(n) - Three passes through the array</li>
     *   <li>Space Complexity: O(n) - Two additional arrays of size n (auxiliary space)</li>
     * </ul>
     * 
     * <p><b>Pros:</b> Clear and easy to understand, separates concerns</p>
     * <p><b>Cons:</b> Uses extra O(n) space beyond the output array</p>
     * 
     * @param nums the input array of integers
     * @return array where each element is the product of all other elements
     */
    public int[] productExceptSelfWithExtraSpace(int[] nums) {
        int n = nums.length;
        
        // Build prefix products array
        int[] numsPre = new int[n];
        numsPre[0] = 1;
        for (int i = 1; i < n; i++) {
            numsPre[i] = numsPre[i-1] * nums[i-1];
        }
        
        // Build postfix products array
        int[] numsPost = new int[n];
        numsPost[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            numsPost[i] = numsPost[i+1] * nums[i+1];
        }
        
        // Combine prefix and postfix products
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = numsPre[i] * numsPost[i];
        }
        
        return result;
    }
    
    /**
     * APPROACH 2: Optimized with O(1) Auxiliary Space
     * 
     * <p>Optimizes the space complexity by:</p>
     * <ul>
     *   <li>Storing prefix products directly in the result array</li>
     *   <li>Computing postfix products on-the-fly using a single variable</li>
     * </ul>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>First pass (left to right): Build prefix products in result array</li>
     *   <li>Second pass (right to left): Multiply each result[i] by running postfix product</li>
     * </ol>
     * 
     * <p><b>Example:</b> nums = [1, 2, 3, 4]</p>
     * <pre>
     * After prefix pass:  result = [1, 1, 2, 6]
     * 
     * Postfix pass (right to left):
     *   i=3: result[3] = 6 * 1 = 6,   postfix = 1 * 4 = 4
     *   i=2: result[2] = 2 * 4 = 8,   postfix = 4 * 3 = 12
     *   i=1: result[1] = 1 * 12 = 12, postfix = 12 * 2 = 24
     *   i=0: result[0] = 1 * 24 = 24, postfix = 24 * 1 = 24
     * 
     * Final result = [24, 12, 8, 6]
     * </pre>
     * 
     * <p><b>Complexity Analysis:</b></p>
     * <ul>
     *   <li>Time Complexity: O(n) - Two passes through the array</li>
     *   <li>Space Complexity: O(1) - Only uses one variable for postfix (auxiliary space)</li>
     * </ul>
     * 
     * <p><b>Note:</b> The output array is not counted toward space complexity as it is 
     * required by the problem specification.</p>
     * 
     * <p><b>Pros:</b> Optimal space usage, still maintains O(n) time</p>
     * <p><b>Cons:</b> Slightly less intuitive than the two-array approach</p>
     * 
     * @param nums the input array of integers
     * @return array where each element is the product of all other elements
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Build prefix products directly into result array
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        
        // Multiply by postfix products on the fly
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        
        return result;
    }
}