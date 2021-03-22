package d_array;

import java.util.Arrays;

public class home_array_division_ {

	public static void main(String[] args) {
				
		//과제
				int[] arr = new int[100];
				for(int i = 0; i < arr.length; i++){
					arr[i] = (int)(Math.random() * 100) + 1;
				}

				/*
				 * 2~5 사이의 랜덤한 수로 나누어 떨어지는 숫자로만 이루어진 배열을 정렬하여 출력해주세요.
				 * 5
				 * [5, 10, 15, 20, 25, 30]
				 * 
				 */
				
				int[] tempArr = new int[100];
				int n = (int)(Math.random() * 4) + 2;
				int count = 0;
				for(int i = 0; i < arr.length; i++){
					if(arr[i] % n == 0){
						tempArr[count++] = arr[i];
					}
				}
				
				int[] resultArr = new int[count];
				for(int i = 0; i < resultArr.length; i++){
					resultArr[i] = tempArr[i];
				}
				
				for(int i  = 0; i < resultArr.length - 1; i++){
					int min = i;
					for(int j = i + 1; j < resultArr.length; j++){
						if(resultArr[j] < resultArr[min]){
							min = j;
						}
					}
					int tmp = resultArr[i];
					resultArr[i] = resultArr[min];
					resultArr[min] = tmp;
				}
				System.out.println("n : " + n);
				System.out.println(Arrays.toString(resultArr));
	}

}
