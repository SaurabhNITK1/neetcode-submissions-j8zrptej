/**
This question is same as two sum but since the input is sorted in ascending order
We can use two pointer approach and no need of using hashMap
**/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0, end=numbers.length-1; // nums[] is a 0 indexed array
        int[] result = new int[2];
        
        while(start < end) {
            int startVal = numbers[start];
            int endVal = numbers[end];

            if(startVal+endVal == target) {
                result[0] = start+1; // We need to return a 1 indexed array thats why +1
                result[1] = end+1;
                break;
            } else if(startVal+endVal < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
