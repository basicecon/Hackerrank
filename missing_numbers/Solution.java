import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int m;
	static int[] all_num = new int[20001];
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for (int i = 0; i < n; i ++) { 
			int curr = scan.nextInt();
			all_num[curr+10000] ++;
		}
		m = scan.nextInt();
		for (int j = 0; j < m; j ++) {
			int tmp = scan.nextInt();
			all_num[tmp+10000] --;
		}
		String sol = "";
		for (int k = 0; k < 20001; k ++) {
			if (all_num[k] < 0 || all_num[k] > 0) {
				sol += (k-10000) + " ";
			}
		}
		System.out.println(sol.substring(0, sol.length()-1)); 
	}
}