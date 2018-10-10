/* Practice Labtest 1 question 1
 * complete and finished, all methods working fine. 
 */

package labtest1;

import java.util.*;

public class Utility2A {
	
	private Utility2A() {
		
	}
	
	public static Integer last(List<Integer> t) {
		return t.get(t.size() - 1);
	}
	
	public static int totalArea(List<Integer> widths, List<Integer> heights) {
		if(widths.size() != heights.size()) {
			throw new IllegalArgumentException();
		}
		int sum = 0;
		if(widths.size() != 0 && heights.size() != 0) {
			for(int i = 0; i < widths.size(); i++) {
				if(widths.get(i) >= 0 && heights.get(i) >= 0) {
					sum += widths.get(i) * heights.get(i);
				}
			}
		}
		
			
		return sum;
	}
	
	public static int alternatingSum(List<Integer> t) {
		int sum = 0;
		if(t.size() != 0) {
			for(int i = 0; i < t.size(); i++) {
				if(i % 2 == 0) {
					sum += t.get(i);
				}
				else {
					sum -= t.get(i);
				}
			}
		}
		return sum;
	}
	
}
