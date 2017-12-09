package maxProfit121;

public class Solution {
	
	public static int maxProfit(int[] prices) {
		int profit = 0;
		int newProfit = 0;
		int passes = 0;
		int len = prices.length;
		
		/*
		 * On the leetcode solution, it says the time complexity of this is O(n^2)
		 * 	when both the loops are bounded by the length of the array.
		 */
		//My solution
		for (int i = len - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				
				newProfit = prices[i] - prices[j];
				if (newProfit > profit) {
					profit = newProfit;
				}
				
				System.out.println(++passes);
			}
		}
		// (n(n-1))/2 passes
		
		
		return profit;
	}
	
	public static void main(String[] args) {
		int[] prices = {7, 6, 4, 3, 1};
		System.out.println(Solution.maxProfit(prices));
	}
}
