/*

Approach 1:
Water at index[i] = min(maxLeftSoFar, maxRightSoFar) - h[i];
Water at index[i] = min(maxLeftSoFar, maxRightSoFar) - h[i]; , See neetcode video
Calculate this for every element in height in 3 passes and you are done.


Two pointer algorithm:
Using two pointers move the pointer in such a way that you dont need to calculate min(maxLeftSoFar, maxRightSoFar)

At every step, look at height[start] and height[end].
⭐ The taller one is the boss in all the iterated values so far.
⭐ The shorter one is the weak shop.
We always move (process/remove) the weaker side.
Why?
Because:

The boss is tall enough to guarantee that every building we remove on the weaker side is shorter than the boss.
So the weaker side’s water can be calculated safely. 
Here min(maxLeftSoFar, maxRightSoFar) becomes maxLeftSoFar in case you are calculating for left pointer.
and min(maxLeftSoFar, maxRightSoFar) = maxRightSoFar in case you are calculating for right pointer.
The stronger side stays where it is and remains the boss until someone taller appears.

The moment more taller side is discovered, we start processing from the shorter side to evade calculating entire 
min(maxLeftSoFar, maxRightSoFar) 

If a taller building appears on the weak side,
a new boss enters the market and the power flips —
now we process the other side.
✅ Question -> “Every new boss is bigger than all the previous bosses?”
🎯 YES - every new boss is always taller than all previous bosses.
    We only change bosses when:
            1. the shorter side grows tall enough
            2. to challenge the current boss
            3. and becomes the new taller side.
🎯 One‑sentence summary
If you are incrementing start, the biggest boss is sitting at end.
If you are decrementing end, the biggest boss os sitting at start.

We always remove the shorter side because the taller side acts as the current “boss”,
guaranteeing that everything processed on the short side is below that boss — so its water 
can be safely finalized.



###############################################################################################

 Water at index[i] = min(maxLeftSoFar, maxRightSoFar) - h[i]; , See neetcode video
Calculate this for every element in height in 3 passes and you are done.

correlation of this with two pointer approach: 
if (height[start] < height[end]) :
    If you keep on moving the height[start], you already know there is a value height[end] which is greater. So at this point, min(maxLeftSoFar, RightSoFar) = maxLeftSoFar. So u just need to calculate maxLeftSoFar - heights[i]
else:
    Similarly When you move the height[end], you already know there is a value height[start] which is greater. So at this point min(LeftSoFar, maxRightSoFar) = maxRightSoFar. So u just need to calculate maxRightSoFar - heights[i]
*/
class Solution {
    public int trap(int[] height) {
      int start = 0, end = height.length - 1;
      int result = 0;

      int maxLeftSoFar = 0, maxRightSoFar = 0;
      while(start <= end) {
         if (height[start] < height[end]) {
            // calculate water trapped by start and remove start from consideration
            int waterTrapped = maxLeftSoFar - height[start];
            if (waterTrapped > 0) {
                result += waterTrapped;
            }
            maxLeftSoFar = Math.max(maxLeftSoFar, height[start]);
            start++;
         } else {
            int waterTrapped = maxRightSoFar - height[end];
            if(waterTrapped > 0) {
                result += waterTrapped;
            }
            maxRightSoFar = Math.max(maxRightSoFar, height[end]);
            end--;
         }
      }
      return result;
    }
}