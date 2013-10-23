import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[] numbers;
	static ArrayList<Integer> lonely = new ArrayList<Integer>();;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		numbers = new int[n];
		for (int i = 0; i < n; i ++) 
			numbers[i] = scan.nextInt();

		for (int i = 0; i < n; i ++) {
			if (lonely.contains(numbers[i])) {
				remove(numbers[i]);
				//System.out.println("remove " + numbers[i]);
			}
			else {
				lonely.add(numbers[i]);
				//System.out.println("add " + numbers[i]);
			}
		}
		if (lonely.size() > 0)
			System.out.println(lonely.get(0));
	}

	public static void remove(int num) {	
		for (int i = 0; i < lonely.size(); i ++) {
			if (lonely.get(i) == num)
				lonely.remove(i);
		}
	}
}