package labtest1B;

//  Completed and tested, all methods work fine.

public class Utility2B {

	public static void main(String[] args) {
		System.out.print(isPalindrome("racecar"));
	}
	
	private Utility2B() {
		
	}
	
	public static String join(String s, String t, String sep) {
		return s + sep + t;
	}
	
	public static int distance(String s, String t) {
		if(s.length() != t.length()) {
			throw new IllegalArgumentException();
		}
		int counter = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != t.charAt(i)) {
				counter++;
			}
		}
		return counter;
	}
	
	public static boolean isPalindrome(String s) {
		String rev = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			rev += s.charAt(i);
		}
		boolean result = false;
		if(s.equals(rev))
			result = true;
		return result;
	}

}
