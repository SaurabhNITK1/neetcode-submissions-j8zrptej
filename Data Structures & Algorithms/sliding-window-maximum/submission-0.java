class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1]; // Maximum no. of slides in a fixed sliding window

        int start=0, end=k-1; // fixed sliding window
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // by default heap is minHeap. To create a custom heap, we need to intaniate using constructor 

        // populate heap with initial window
        for(int i=0; i<=end; i++) {
            maxHeap.offer(nums[i]);
        }
        

        while(end < nums.length) {
            result[start] = maxHeap.peek();
            maxHeap.remove(nums[start]);
            start++;
            end++;
            
          if (end < nums.length) {
            maxHeap.offer(nums[end]);
          }
        }
     return result;
    }
}
