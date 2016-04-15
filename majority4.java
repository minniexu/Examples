import java.lang.*;
import java.util.*;
import java.io.*;
public class majority4{
	public List<Integer> majority4(int[] nums){
		int n = nums.length;
		List<Integer> res = new ArrayList<>();
		if(n == 0) return res;
		int count1 = 0, count2 = 0, count3 = 0;
		int x1 = 0, x2 = 0, x3 = 0;
		for(int num : nums){
			if(x1 == num) count1++;
			else if(x2 == num) count2++;
			else if(x3 == num) count3++;
			else if(count1 == 0){
				x1 = num;
				count1 = 1;
			}
			else if(count2 == 0){
				x2 = num;
				count2 = 1;
			}
			else if(count3 == 0){
				x3 = num;
				count3 = 1;
			}else{
				count1--;
				count2--;
				count3--;
			}
		}
		count1 = 0;
		count2 = 0;
		count3 = 0;

		for(int num : nums){
			if(num == x1) count1++;
			else if(num == x2) count2++;
			else if(num == x3) count3++;
		}
		if(count1 > n/4 && !res.contains(x1)) res.add(x1);
		if(count2 > n/4 && !res.contains(x2)) res.add(x2);
		if(count3 > n/4 && !res.contains(x3)) res.add(x3);

		return res;
	}
	public static void main(String[] args){
		int[] res = {1,2,3,4,5,5,5,4,3,5,3,3};
		majority4 m = new majority4();
		List<Integer> list = m.majority4(res);
		for(int l : list){
			System.out.print(l);
			System.out.print(" ");
		}
	}
}