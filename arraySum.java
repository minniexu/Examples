import java.lang.*;
import java.util.*;
import java.io.*;
public class arraySum{
	public int[] arraySum(int[] a, int[] b){
		if(a.length > b.length) return arraySum(b, a);
		int[] res = new int[b.length + 1];
		res[0] = 0;
		boolean morethan9 = false;
		for(int i = 1; i <= b.length; i++){
			if(i <= a.length){
				res[res.length - i] = a[a.length - i] + b[b.length - i];
			}else res[res.length - i] = b[b.length - i];
			if(morethan9){
				res[res.length - i]++;
				morethan9 = true;
			}
			if(res[res.length - i] > 9){
				res[res.length - i] %= 10;
				morethan9 = true;
			}
		}
		if(morethan9) res[0] = 1;
		return res;
	}
	/*public static int[] arraySum(int[] a, int[] b){
		int m = a.length, n = b.length;
		if(m < n) return sum(b, a);
		int[] sum = new int[m + 1];
		int carry = 0;
		int s;
		for(int i = m - 1; i >= 0; i--){
			s = carry;
			if(i - m + n >= 0) s += b[i - m + n];
			s += a[i];
			sum[i + 1] = s%10;
			carry = s/10;
		}
		sum[0] = carry;
		return sum;
	}*/
	public static void main(String[] args){
		int[] a = {9,2,3};
		int[] b = {4,4};
		arraySum array = new arraySum();
		int[] res = array.arraySum(a, b);
		System.out.println(Arrays.toString(res));
	}
}