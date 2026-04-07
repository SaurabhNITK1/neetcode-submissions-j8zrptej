class Solution {
    public int trap(int[] height) {
        int totalWaterTrappedSoFar = 0;
        int leftMaxSoFar=0, rightMaxSoFar=0;
        int start = 0, end = height.length-1;

        while(start <= end) {
            if (height[start] < height[end]) {
                // calculate the water trapped by position 'start' and move start pointer
                int waterTrapped = leftMaxSoFar - height[start];
                if (waterTrapped>0) {
                    totalWaterTrappedSoFar += waterTrapped;
                }

                if (height[start] > leftMaxSoFar) {
                    leftMaxSoFar = height[start];
                }
                start++;
            } else {
                int waterTrapped = rightMaxSoFar - height[end];
                if (waterTrapped>0) {
                    totalWaterTrappedSoFar += waterTrapped;
                }

                if (height[end] > rightMaxSoFar) {
                    rightMaxSoFar = height[end];
                }
                end--;
            }
        }
        return totalWaterTrappedSoFar;
    }
}