import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[] numbers;
	static ArrayList<int[]> pairs = new ArrayList<int[]>();;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		numbers = new int[n];
		for (int i = 0; i < n; i ++) 
			numbers[i] = scan.nextInt();
		quicksort(0, n-1);
		search();
		String str = "";
		for (int i = 0; i < pairs.size(); i ++) {
			str += pairs.get(i)[0] + " " + pairs.get(i)[1] + " ";
		}
		System.out.println(str.substring(0, str.length()-1));
	}

	public static void search() {
		for (int i = 0; i < n-1; i ++) {
			check(i, i+1);
		}
	}

	public static void check(int x, int y) {
		int[] tmp = new int[2];
		tmp[0] = numbers[x];
		tmp[1] = numbers[y];
		if (pairs.size() < 1) {
			pairs.add(tmp);
		}
		else if (difference(numbers[x], numbers[y]) < difference(pairs.get(0)[0], pairs.get(0)[1])) {
			//remove(pairs.get(0)[0], pairs.get(0)[1]);
			pairs.clear();
			pairs.add(tmp);
		}
		else if (difference(numbers[x], numbers[y]) == difference(pairs.get(0)[0], pairs.get(0)[1])) {
			pairs.add(tmp);
		}
	}

	public static int difference(int x, int y) {
		int tmp = x - y;
		tmp = (tmp < 0 ? -tmp : tmp);
		return tmp;
	}

	public static void remove(int x, int y) {
		for (int i = 0; i < pairs.size(); i ++) {
			if (difference(x, y) == difference(pairs.get(i)[0], pairs.get(i)[1])) {
				pairs.remove(i);
			}
		}
	}

	public static void quicksort(int start, int end) {
		int left = start;
		int right = end;
		int mid = numbers[start];
		while (left <= right) {
			while (numbers[left] < mid) {
				left ++;
			}
			while (numbers[right] > mid) {
				right --;
			}
			if (left <= right) {
				int tmp = numbers[right];
				numbers[right] = numbers[left];
				numbers[left] = tmp;
				left ++;
				right --;
			}
		}
		if (right > start)
			quicksort(start, right);
		if (left < end)
			quicksort(left, end);
	}
}