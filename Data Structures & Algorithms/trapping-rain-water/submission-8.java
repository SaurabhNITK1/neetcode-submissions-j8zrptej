/*
Water at index[i] = min(maxLeftSoFar, maxRightSoFar) - h[i];

Two pointer algorithm:
At every step, look at height[start] and height[end].
⭐ The taller one is the boss in all the iterated values so far.
⭐ The shorter one is the weak shop.
We always move (process/remove) the weaker side.
Why?
Because:

The boss is tall enough to guarantee that every building we remove on the weaker side is shorter than the boss.
So the weaker side’s water can be calculated safely. Here min(maxLeftSoFar, maxRightSoFar) becomes maxLeftSoFar 
for left pointer and maxRightSoFar in case you are calculating for right pointer.
The stronger side stays where it is and remains the boss until someone taller appears.
The moment more taller side is discovered, we start processing from the shorter side.

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

Other approach: Water at index[i] = min(maxLeftSoFar, maxRightSoFar) - h[i]; , See neetcode video
Calculate this for every element in height in 3 passes and you are done.

correlation of this with two pointer approach: 
if (height[start] < height[end]) :
    If you keep on moving the height[start], you already know there is a value height[end] which is greater. So at this point, min(maxLeftSoFar, RightSoFar) = maxLeftSoFar. So u just need to calculate maxLeftSoFar - heights[i]
else:
    Similarly When you move the height[end], you already know there is a value height[start] which is greater. So at this point min(LeftSoFar, maxRightSoFar) = maxRightSoFar. So u just need to calculate maxRightSoFar - heights[i]
*/
class Solution {
    public int trap(int[] height) {
        int totalWaterTrappedSoFar = 0;
        int leftMaxSoFar=0, rightMaxSoFar=0;
        int start = 0, end = height.length-1;

        while(start < end) {
            if (height[start] < height[end]) {
                /* calculate the water trapped by position 'start' and move start pointer.
                
                if (waterTrapped>0) {
                    totalWaterTrappedSoFar += waterTrapped;
                }
                is equivalent to : Math.max(0, leftMaxSoFar - height[start]);

                if (height[start] > leftMaxSoFar) {
                   leftMaxSoFar = height[start]
                }
                is equivalent to: Math.max(leftMaxSoFar, height[start]);
                */
                int waterTrapped = Math.max(0, leftMaxSoFar - height[start]);
                totalWaterTrappedSoFar += waterTrapped;
                leftMaxSoFar = Math.max(leftMaxSoFar, height[start]);
                start++;
            } else {
                int waterTrapped = Math.max(0, rightMaxSoFar - height[end]);
                totalWaterTrappedSoFar += waterTrapped;
                rightMaxSoFar = Math.max(rightMaxSoFar, height[end]);
                end--;
            }
        }
        return totalWaterTrappedSoFar;
    }
}