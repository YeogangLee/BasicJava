package d_array;

import java.util.Arrays;

public class Array_min_max {

	public static void main(String[] args) {
		
		//배열의 모든 인덱스에 1~100 사이의 랜덤한 값을 저장해주세요.
				for (int i = 0; i < arr.length; i++) {
					arr[i] = (int)(Math.random() * 100) + 1;
				}
		
		//배열에 저장된 값들 중 최소값과 최대값을 출력해 주세요.
		
				//배열 안의 모든 값 조회  : Arrays.toString(배열이름)
				System.out.println(Arrays.toString(arr));
				
				int min = 0;
				int max = 0;
				int tmp = 0;
				
				int m1 = 0, M1 = 0; 
				
//				for(int i=0; i<arr.length-1; i++){
//					if(i==0 && (arr[i] > arr[i+1])){
//						m1 = arr[i+1];
//						M1 = arr[i];
//					} 
//				}
				
				for(int i = 0; i<arr.length; i++){
					for(int j = 0; j<arr.length-1; j++){
						if(arr[j] > arr[j+1]){
							tmp = arr[j];
							arr[j] = arr[j+1];
							arr[j+1] = tmp;
						}
					}
				}
				
				min = arr[0];
				max = arr[9];
				
				System.out.println(Arrays.toString(arr));
				System.out.println("최소값은 " + min + " 최대값은 " + max);
				
				
				//
				int Min = arr[0];
				int Max = arr[0];
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] < Min) {
						Min = arr[i];
					}
					if (Max < arr[i]) {
						Max = arr[i];
					}
				}
				System.out.println("min : " + Min + "  / max :" + Max);

				int[] shuffle = new int[10];
				for (int i = 0; i < shuffle.length; i++) {
					shuffle[i] = i + 1;
				}
				System.out.println(Arrays.toString(shuffle));
		
	}

}
