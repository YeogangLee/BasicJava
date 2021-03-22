package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		// 다차원 배열
		// : 배열 안에 배열
		
		//2차원배열
		int[][] array2;
		
		//3차원배열
		int[][][] array3;
		
		
		int[][] arr = new int[2][3];
		//2차원배열 초기화 방법
		/*
		 * 변수 = 주소1(100번지)
		 * 
		 * 100번지
		 * {주소2(200번지), 주소3(300번지)}
		 * 
		 * 200번지
		 * {0, 0, 0}
		 * 
		 * 300번지
		 * {0, 0, 0}
		 * 
		 */

		int arr2[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		int[] arr3[] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; //선언과 초기화를 반드시 동시에 해야 하는 방법
		// 특이한 대괄호 -> 괄호를 나눠쓰더라도 상관X, 개수만 맞으면 되지만
		// 일반적으로 타입 뒤에, int[][] 형태로 많이 쓴다
		
		//가변배열로 초기화 하기
		//아래의 가변 배열 : 2차원 배열은 없는 상태 -> 이 배열을 사용하려면 2차원 배열을 만들어야 함
		int[][] arr4 = new int[3][];  
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr4[2] = new int[10];
		
		System.out.println(arr[0][1]);
		
		//값 저장도 마찬가지로 2차원 인덱스까지 접근해야 함
		//만약 1차원 인덱스까지만 접근시, 값 저장 불가
		
		//arr[0] = 10; //값 저장 불가
		arr[0] = new int[5]; //배열을 저장해야 한다
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;
		arr[1] = new int[7];
		
		System.out.println(arr.length); //1차원 배열의 길이
		System.out.println(arr[0].length); //2차원 배열의 길이
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("배열은 ");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " "); 
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] scores = new int[3][5]; //학생 3명의 5과목
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random()*101);
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		
		//합계와 평균
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];  
			}
			avg[i] = (double)sum[i]/scores[i].length;
		}
		for(int i = 0; i < scores.length; i++){
			System.out.println("학생"+(i+1)+"의 합계 : "+sum[i]+ " / 평균 : "+avg[i]);
		}
		
		//지금부터 내는 문제 내일 시험
			
		
		
		
		
		
			
		
	}

}
