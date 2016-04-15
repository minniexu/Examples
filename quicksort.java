import java.lang.*;
import java.util.*;
public class quicksort{
	public static void quicksort(int arr[], int i, int j){
		int index = partition(arr, i, j);
		if(i < index - 1) quicksort(arr, i, index - 1);
		if(index < j) quicksort(arr, index, j);
		
		//return arr;

	}
	public static int partition(int arr[], int i, int j){
		int tmp;
		int pivot = arr[(i + j)/2];
		while(i <= j){
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			if(i <= j){
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}
	public static void main(String[] args){
		int[] arr = {2,3,5,3,1,4,6,7,10};
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}