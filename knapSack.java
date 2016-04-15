import java.util.*;
import java.io.*;
import java.lang.*;
public class knapSack{
	//W -> capacity, n -> no. of items
	//O(2^n) recursive
	public int knapSack(int w, int[] wt, int val[], int n){
		if(n == 0 || w == 0) return 0;
		if(wt[n - 1] > w){
			return knapSack(w, wt, val, n - 1);
		}
		else return Math.max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1), knapSack(w, wt, val, n - 1));

	}
	//O(nW)
	public int knapSack2(int w, int[] wt, int val[], int n){
		int[][] k = new int[n + 1][w + 1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= w; j++){
				if(i == 0 || j == 0){
					k[i][j] = 0;
				}else if(wt[i - 1] <= j){
					k[i][j] = Math.max(val[i - 1] + k[i - 1][j - wt[i - 1]], k[i - 1][j]);
				}else k[i][j] = k[i - 1][j];
			}
		}
		return k[n][w];
	}
	public static void main(String[] args){
		int val[] = {60, 100, 120};
		int wt[] = {10, 20, 30};
		int w = 50;
		int n = 3;
		knapSack k = new knapSack();
		int res = k.knapSack2(w,wt,val,n);
		System.out.println("Maximum value is: " + res);
	}

}