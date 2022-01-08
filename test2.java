/*
You are given an array A of N integers and an integer K. You want to remove K consecutive
elements from A in a such a way that the amplitude of the remaining elements will be minimal.
The amplitude is the difference between the maximal and minimal elements.
*/

class Solution {
    public int solution(int[] nums, int k) {
        int[][] left = new int[nums.length][2];
        
        int leftMin = nums[0];
        int leftMax = nums[0];
        
        left[0][0] = Integer.MAX_VALUE;
        left[0][1] = Integer.MIN_VALUE;
        
        for(int i = 1; i < nums.length; i++) {
            left[i][0] = leftMin;
            left[i][1] = leftMax;
            leftMin = Math.min(leftMin, nums[i]);
            leftMax = Math.max(leftMax, nums[i]);
        }
        
        int[][] right = new int[nums.length][2];
        
        int rightMin = nums[nums.length - 1];
        int rightMax = nums[nums.length - 1];
        
        right[nums.length - 1][0] = Integer.MAX_VALUE;
        right[nums.length - 1][1] = Integer.MIN_VALUE;

        for(int i = nums.length - 2; i >= 0; i--) {
            right[i][0] = rightMin;
            right[i][1] = rightMax;
            rightMin = Math.min(rightMin, nums[i]);
            rightMax = Math.max(rightMax, nums[i]);
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++) {
            int min = Math.min(left[i][0], right[i + k - 1][0]);
            int max = Math.max(left[i][1], right[i + k - 1][1]);
            result = Math.min(result, max - min);
        }

        return result;
    }
}