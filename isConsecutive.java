import java.util.*;
public class isConsecutive{
	public boolean isConsecutive(int[] array, int k){
		HashMap<Integer, Integer> map = new HashMap<>();
		if(array.length % k != 0) return false;
		Arrays.sort(array);
		for(int a : array){
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a) + 1);
		}
		for(int a : array){
			if(map.get(a) == 0) continue;
			for(int i = a + 1; i < a + k; i++){
				if(map.containsKey(i)) map.put(i, map.get(i) - 1);
				else return false;
			}
			map.put(a, map.get(a) - 1);
		}
		for(int key : map.keySet()){
			if(map.get(key) != 0) return false;
		}
		return true;
	}
	public static void main(String[] args){
		int[] res = {1,2,3,4,5,1,2,3,4,5};
		isConsecutive con = new isConsecutive();
		if(con.isConsecutive(res, 8)) System.out.println("True");
		else System.out.println("False");
	}

}