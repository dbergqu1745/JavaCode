package twoSum;

/*
 * Given an array of integers, return INDICES of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example: 
 * Given nums = [2, 7, 11, 15], target = 9
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] indices = {0,0};
		int[] failCase = {0,0};
		int len = nums.length;
		int inLen = len - 1;
		
		for (int i = 0; i < len; i++) {
			
			if (nums[i] <= target) {
				indices[0] = i;
				
				for (int j = inLen; j >= 0; j--) {
					
					if ((nums[j] + nums[i]) == target) {
						
						indices[1] = j;
						return indices;
					}
				}
			}
		}
		return failCase;
	}
}
