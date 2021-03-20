package d_array;

import java.util.Arrays;

public class Array_home_Division {

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
		 * 
		 */

		// 2~5 사이의 랜덤한 수 생성
		int num = (int)(Math.random()*4)+2;
		System.out.println(num);

		// 공배수로만 이루어진 배열 생성
		int count = 0;
		int[] reduplication = new int[100];
		for(int i = 0; i < arr.length; i++){
			if(arr[i]%num == 0){
				reduplication[count++] = arr[i];
			}
		}
		
		// 공배수 배열에서 중복값 제거
		count = 0;
		int[] temp = new int[(arr.length)/num];
		for(int i = 0; i < reduplication.length; i++){
			boolean flag = true;
			for(int j = 0; j < (arr.length)/num; j++){
				if(reduplication[i] == temp[j]){
					flag = false;
				}
			}
			if(flag){
				temp[count++] = reduplication[i];
			}
		}
		
		// 만들어진 공배수 배열을 결과물 배열에 값 대입
		int tmp = 0;
		int[] result = new int[count];
		for(int i = 0; i < count; i++){
			result[i] = temp[i];
		}

		// 결과물 배열 값 오름차순 정렬 - 선택정렬
		for (int i = 0; i < result.length; i++) {
			int min = i; 
			for (int j = i + 1; j < result.length; j++) { 
				if (result[j] < result[min]) {
					min = j; 
				}
			}
			tmp = result[i];
			result[i] = result[min];
			result[min] = tmp;
		}
		
		System.out.println(Arrays.toString(result));

	}

}
