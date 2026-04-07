/*Algo:
  1. Two pointers approach : take two pointers start = 0 and end = length -1
  2. When start=0 and end = length-1, the width is highest.
  3. At this point of time, the smaller height b/w start and end would sweep maximum area
  4. Calculate the max area and remove smaller height from consideration as we already calculated
     maximum possible area by that.
  5. Keep repaeting this and keep saving the max area calculated so far in a variable 
*/
class Solution {
    public int maxArea(int[] heights) {
        int result =0;
        int start = 0, end = heights.length -1;

        while (start < end) {
            int area = (end-start)*Math.min(heights[start], heights[end]);
            result = Math.max(result, area);

            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
