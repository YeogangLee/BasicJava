package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * 석차 구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * 삽입정렬 : 두 번째 숫자부터 앞의 숫자들과 비교해서 큰 수를 뒤로 밀고 중간에 삽입하는 방식
		 * 
		 */
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));

		
		// 석차 구하기
		int[] rank = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			rank[i] = 1;	
			for(int j = 0; j < arr.length; j++){
				if(arr[i] < arr[j]){
					rank[i]++;
				}
			}
		}
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i] + " : " + rank[i] + "등 ");
		}
		System.out.println();

		
		
		// 선택정렬 - 최솟값을 찾는 과정, 최솟값 뽑고, 나머지에서 또 최솟값 뽑고, ...
		
		/*
		 * ij
		 * 
		 * 01   02	03	04	05	06	07	08	09
		 * 12	13	14	15	16	17	18	19
		 * 23	24	25	26	27	28	29
		 * 34	35	36	37	38	39
		 * 45	46	47	48	49
		 * 56	57	58	59
		 * 67	68	69
		 * 78	79
		 * 89
		 * 
		 */
		
//		int tmp = 0;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			int min = i; 
//			// 첫 번째 값을 넣는 게 아니라 첫 번째 인덱스를 넣고 시작, 최솟값의 위치를 알아야 바꾸니까
//			
//				// j는 항상 i다음부터 비교하므로 i+1
//			for (int j = i + 1; j < arr.length; j++) { 
//				if (arr[j] < arr[min]) {
//					min = j;
//					// arr[min] 이 개념 하나로, 
//					// 최솟값의 인덱스를 카운트 할 수도 있고, 그 인덱스로 값에 접근할 수도 있다 
//				}
//			}
//			tmp = arr[i];
//			arr[i] = arr[min];
//			arr[min] = tmp;
//			// 이 과정-최솟값을 찾은 후의 자리 변경-을 위해 위의 j값을 min에 대입한 것이고
//			// 따라서 min은 i의 for문 안쪽에 있어도 된다.
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		// 주석 빼고 정리
//		int tmp = 0;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			int min = i; 
//			for (int j = i + 1; j < arr.length; j++) { 
//				if (arr[j] < arr[min]) {
//					min = j;
//				}
//			}
//			tmp = arr[i];
//			arr[i] = arr[min];
//			arr[min] = tmp;
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		
		
		// 버블정렬 : 앞 뒤로 비교 후 큰 수를 찾아 제일 뒤로 보내기, 비교마다 자리변경이 일어난다
		// 		       중간에 정렬이 끝날 수 있다. -> 자리 변경 이후에 남은 뒤의 배열들이 정렬이 필요 없을 경우 
		
		/*
		 * ij
		 * 01 12 23 34 45 56 67 78 89
		 * 01 12 23 34 45 56 67 78
		 * 01 12 23 34 45 56 67
		 * 01 12 23 34 45 56
		 * 01 12 23 34 45
		 * 01 12 23 34
		 * 01 12 23
		 * 01 12
		 * 01
		 */
		
		
		// [1, 2, 3, 4]
		// 어려우면 짧은 배열로 생각해보기
		
		int tmp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length -1 -i; j++) {
				if (arr[j] > arr[j + 1]) { // 등호 상관 없음
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = false;
				}
			}
			if(flag){
				// 값 교환 후 그 값 뒤의 배열 속 데이터 순서가 정렬된 순서라면 정렬 필요 X
				// 정렬 그만하기 -> 반복문 탈출  
				break;
			}
		}
		//System.out.println(i + "번 : " + Arrays.toString(arr));
		
		System.out.println("끝 : " + Arrays.toString(arr));
		
		
		// 삽입정렬
		
		/*
		 * ij
		 * 
		 * 10
		 * 21 20
		 * 32 31 30
		 * 43 42 41 40
		 * 54 53 52 51 50
		 * 65 64 63 62 61 60
		 * 76 75 74 73 72 71 70
		 * 87 86 85 84 83 82 81 80
		 * 98 97 96 95 94 93 92 91 90
		 * 
		 */

		// 두번째 숫자부터 앞의 숫자들과 비교,
		// 비교 전에 두번째 값 보관을 하고 값 비교, 비교대상과 가까운 값부터 비교
		// 작은 숫자를 만났다 -> 그 앞은 정렬되어 있는 상태
		
		
//		for (int i = 0; i < arr.length; i++) {
//			int tmp = arr[i];
//			int j = 0;
//			for (j = i - 1; j >= 0; j--) {
//				if (tmp < arr[j]) {
//					arr[j + 1] = arr[j];
//					
//					// 빈칸을 채우는 경우 2가지
//					// 1. 자기보다 작은 값을 만났을 때
//					// 2. 반복문을 종료하고 자기보다 작은 값이 없어서 제일 앞으로 갈 때
//				}else{
//					break;
//				}
//			}
//			arr[j+1] = tmp;
//		}
//		System.out.println(Arrays.toString(arr));
		
		// 코드를 알고 나서 -> 코드 원리대로 코드를 작성할 수 있는가
		// 지금 많이 사용하는 정렬은 퀵 정렬, 현재 공부로는 구현할 수 X

		// 1. 문법을 알 것
		// 2. 그 문법을 통해 내 생각을 구체화시키고 나타낼 수 있느냐
		
		// 코드를 보고 동작 방식을 이해 -> 이제 방법은 습득
		// 그 상태에서 코드를 안 보고 다시 작성해보는 것
		// 계속 공부해서, 코드를, 표현을 내것으로
	}
}
