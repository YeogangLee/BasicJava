package d_array;

import java.util.Arrays;

public class Array_Nonredundant {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++){
			arr[i] = (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int count = 0;
		int[] temp = new int[5];
		for(int i = 0; i < arr.length; i++){
			boolean flag = true;
			for(int j = 0; j < temp.length; j++){
				if(arr[i] == temp[j]){	//=> 두 배열의 값이 하나라도 같으면
					flag = false;		//	  값을 대입하지 않겠다. 
				}				
			}
			if(flag){
				temp[count++] = arr[i];
			}
		}
		
		int[] result = new int[count];
		for(int i = 0; i < count; i++){
			result[i] = temp[i]; 
		}
		
		System.out.println(Arrays.toString(result)+" 정렬 끝");
	}

}
