import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] fibArray(int n) {
		/* Your Task. */
		if (n == 2) {
			int[] seq = { 1, 1 };
			return seq;
		} else {
			int[] seq = new int[n];
			seq[0] = 1;
			seq[1] = 1;
			fibArrayFiller(2, seq);
			return seq;
		}

	}

	// Private helper method for the above fibArray
	private void fibArrayFiller(int i, int[] seq) {
		if (i < seq.length) {
			seq[i] = seq[i - 1] + seq[i - 2];
			fibArrayFiller(i + 1, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> fibList(int n) {
		/* Your Task. */
		if (n == 2) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
			return list;
		} else {
			List<Integer> list = new ArrayList<Integer>(n);
			list.add(1);
			list.add(1);
			fibListFiller(2, list, n);
			return list;
		}

	}

	// Private helper method for the above fibList
	private void fibListFiller(int i, List<Integer> list, int size) {
		if (i < size) {
			list.add((list.get(i - 1) + list.get(i - 2)));
			fibListFiller(i + 1, list, size);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibArray({1, 2}) returns false and
	 * isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input array a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibArray(int[] a) {
		/* Your Task. */
		if (a.length == 1 && a[0] == 1)
			return true;
		if (a.length == 0 || a[0] != 1 || a[1] != 1) {
			return false;
		} else {
			return isFibHelper(2, a);
		}
	}

	// Private helper method for the above isFibArray
	private boolean isFibHelper(int i, int[] a) {
		if (i < a.length) {
			if (a[i] != (a[i - 1] + a[i - 2])) {
				return false;
			} else {
				return isFibHelper(i + 1, a);
			}
		}
		return true;
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibList({1, 2}) returns false and
	 * isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input list a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibList(List<Integer> list) {
		/* Your Task. */
		if (list.size() == 1 && list.get(0) == 1)
			return true;
		if (list.size() == 0 || list.get(0) != 1 || list.get(1) != 1) {
			return false;
		} else {
			return isFibListHelper(2, list);
		}

	}

	// Private helper method for above isFibList
	private boolean isFibListHelper(int i, List<Integer> list) {
		if (i < list.size()) {
			if (list.get(i) != (list.get(i - 1) + list.get(i - 2))) {
				return false;
			} else {
				return isFibListHelper(i + 1, list);
			}
		}
		return true;
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a
	 *            an array that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/* Your Task. */
		int[] res = new int[a.length + 1];
		int j = 0;
		if (a.length == 0) {
			res = new int[1];
			res[0] = i;
			return res;
		}
		if (i > a[a.length - 1])
			res[res.length - 1] = i;
		if (i > a[j]) {
			insertArrayHelper(i, j, a, res);
		} else {
			res[0] = i;
			System.arraycopy(a, j, res, j + 1, res.length - j - 1);
		}

		return res;
	}

	// Private helper method for above insertIntoSortedArray
	private void insertArrayHelper(int value, int j, int[] arr, int[] res) {
		if (j < arr.length && value > arr[j]) {
			res[j] = arr[j];
			insertArrayHelper(value, j + 1, arr, res);
		} else {
			res[j] = value;
			System.arraycopy(arr, j, res, j + 1, res.length - j - 1);
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list
	 *            a list that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/* Your Task. */
		List<Integer> res = new ArrayList<>(list.size() + 1);
		int j = 0;
		if (list.size() == 0) {
			res = new ArrayList<>();
			res.add(i);
			return res;
		}

		if (i > list.get(j)) {
			insertListHelper(i, j, list, res);
		} else {
			res.add(i);
			res.addAll(list);
		}

		if (i > list.get(list.size() - 1))
			res.set(res.size() - 1, i);

		return res;
	}

	// Private helper method for above insertIntoSortedList
	private void insertListHelper(int value, int j, List<Integer> list, List<Integer> res) {
		if (j < list.size() && value > list.get(j)) {
			res.add(list.get(j));
			insertListHelper(value, j + 1, list, res);
		} else {
			res.add(value);
			res.addAll(j + 1, list.subList(j, list.size()));
		}
	}

	/**
	 * Given two sorted arrays left and right, return a sorted array of size
	 * left.length + right.length, consisting of all elements of arrays left and
	 * right.
	 * 
	 * @param left
	 *            a sorted array
	 * @param right
	 *            a sorted array
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArrays({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedLists method below to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/* Your Task. */
		int[] res = new int[0];
		int i = 0;
		if (right.length == 0) {
			res = new int[left.length];
			System.arraycopy(left, 0, res, 0, left.length);
			mergeArraysHelper(i, res, right);
		} else {
			res = new int[right.length];
			System.arraycopy(right, 0, res, 0, right.length);
			mergeArraysHelper(i, res, left);
		}

		return res;
	}

	private void mergeArraysHelper(int i, int[] res, int[] right) {
		if (i < right.length) {
			res = insertIntoSortedArray(res, right[i]);
			mergeArraysHelper(i + 1, res, right);
		}

	}

	/**
	 * Given two sorted lists left and right, return a sorted list of size
	 * left.size() + right.size(), consisting of all elements of lists left and
	 * right.
	 * 
	 * @param left
	 *            a sorted list
	 * @param right
	 *            a sorted list
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedLists({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedArrays method above to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> list = new ArrayList<>();
		if (list.size() < (left.size() + right.size())) {
			list = insertIntoSortedList(left, right.get(0));
			right.remove(0);
			mergeSortedLists(left, right);
		}
		return list;

	}
}
