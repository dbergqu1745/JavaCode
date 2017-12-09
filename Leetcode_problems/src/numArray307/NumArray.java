package numArray307;

class NumArray {
	int[] numbers;
	
	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * obj.update(i,val);
	 * int param_2 = obj.sumRange(i,j);
	 */
	public NumArray(int[] nums) {
        numbers = nums;
    }
    
    public void update(int i, int val) {
        this.numbers[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        
        for (int a = i; a < j; a++) {
        		sum += this.numbers[a];
        }
        
        return sum;
    }
    
    public void printNums() {
    		for (int i = 0; i < this.numbers.length; i++) {
    			System.out.print(this.numbers[i] + " ");
    		}
    		System.out.println();
    }
    
    public static void main(String[] args) {
    		int[] ints = {1, 3, 5, 6, 8, 9, 2, 4, 7};
		NumArray nums = new NumArray(ints);
		
		nums.printNums();
		System.out.println(nums.sumRange(2, 5));
		nums.update(5, 999);
		nums.printNums();
	}
}
