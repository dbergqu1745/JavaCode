package toHex;

public class ToHex {
	public static String toHex(int num) {
		final String[] LETTS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		String hex = "";
		
		if (num == 0) return "0";
		
		while (num != 0) {
			hex = LETTS[num % 16] + hex; 
			num /= 16;
		}
		
		
		return hex;
	}
	
	public static void main(String[] args) {
		System.out.println("1000 -> " + toHex(1000));
		//System.out.println(Math.pow(2, 16));
	}
}
