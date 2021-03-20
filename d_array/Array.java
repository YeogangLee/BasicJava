package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러 개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 *   ㄴ 변수에 값을 저장하는 게 아니라, 변수 바깥 공간에 데이터를 저장한 후 주소를 담고 있는 자료형 
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다. - 길이를 정하고 시작한다
		 * 
		 */
		
//		// 초기화 방법 1 - 선언과 값을 따로 초기화
//		// int array[]; - 이렇게 해도 상관없으나 보통은 타입 뒤에 붙여서 사용 - int[]
//		int[] array;		
//		array = new int[5];  // new 예약어 사용, [저장할 값의 크기]
//							 // 특징 - 기본값이 들어가 있는 상태, int의 기본값 0
//		
//		/*
//		 * 변수 = 주소(ex.100번지)
//		 * 
//		 * 100번지 - 정확히 말하면 첫 번째 데이터의 주소가 100번지
//		 * {0, 0, 0, 0, 0}
//		 * 
//		 */
//		
//		// 초기화 방법2 - 길이를 정하지 않고, 값 넣기
//		array = new int[]{1, 2, 3, 4, 5};
//		
//		// array = {1, 2, 3, 4, 5};
//		int[] array2 = {1, 2, 3, 4, 5};	
//		// 초기화 방법3 - 이 방법은 선언과 초기화를 동시에
//		
//		int[] array3 = new int[5];
//		
//		System.out.println(array[0]);
//		System.out.println(array[1]);
//		System.out.println(array[2]);
//		System.out.println(array[3]);
//		System.out.println(array[4]);
//		
//		array[0] = 10;
//		array[1] = 20;
//		array[2] = 30;
//		array[3] = 40;
//		array[4] = 50;
//		
//		
//		// 배열.length : 배열의 길이를 알려준다.
//		for(int i = 0; i < array.length; i++){
//			System.out.println(array[i]);
//		}
//		
//		for(int i = 0; i < array.length; i++){
//			array[i] = (i + 1) * 10;
//		}
//		
//		
		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] arr = new int[10];
		
		
		//배열의 모든 인덱스에 1~100 사이의 랜덤한 값을 저장해주세요.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		
		//배열 데이터 오름차순
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr.length-1; j++){
				int temp=0;
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]+"  ");
		}
		
		//System.out.println(Arrays.toString(arr));
		
//		
//		
//		//배열에 저장된 모든 값의 합계와 평균을 출력해주세요.
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//		    sum += arr[i];
//		}
//		
//
//		// avg = avg2 = avg3
//		// 피제수 또는 제수가 double일 때 double 변수에 값 대입 가능
//		double avg = (double)sum / arr.length;
//		double avg2 = (double)Math.round(sum)/arr.length;
//		double avg3 = Math.round(sum)/10.0;
//		
//		
//		System.out.println("합계 : "+sum+" 평균1 : "+avg);
//		System.out.println("합계 : "+sum+" 평균2 : "+avg2);
//		System.out.println("합계 : "+sum+" 평균3 : "+avg3);
//		
//		
//		//배열에 저장된 값들 중 최소값과 최대값을 출력해 주세요.
//		
//		//배열 안의 모든 값 조회  : Arrays.toString(배열이름)
//		System.out.println(Arrays.toString(arr));
//		
//		int min = 0;
//		int max = 0;
//		int tmp = 0;
//		
//		int m1 = 0, M1 = 0; 
//		
////		for(int i=0; i<arr.length-1; i++){
////			if(i==0 && (arr[i] > arr[i+1])){
////				m1 = arr[i+1];
////				M1 = arr[i];
////			} 
////		}
//		
//		for(int i = 0; i<arr.length; i++){
//			for(int j = 0; j<arr.length-1; j++){
//				if(arr[j] > arr[j+1]){
//					tmp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = tmp;
//				}
//			}
//		}
//		
//		min = arr[0];
//		max = arr[9];
//		
//		System.out.println(Arrays.toString(arr));
//		System.out.println("최소값은 " + min + " 최대값은 " + max);
//		
//		
//		//
//		int Min = arr[0];
//		int Max = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] < Min) {
//				Min = arr[i];
//			}
//			if (Max < arr[i]) {
//				Max = arr[i];
//			}
//		}
//		System.out.println("min : " + Min + "  / max :" + Max);
//
//		int[] shuffle = new int[10];
//		for (int i = 0; i < shuffle.length; i++) {
//			shuffle[i] = i + 1;
//		}
//		System.out.println(Arrays.toString(shuffle));
//
//		
//		// 배열의 값을 섞어주세요.
//
//		// 2. 반복문으로 반복 실행
//		for (int i = 0; i < shuffle.length * 10; i++) { // 10을 곱해주는 이유는 많이 실행하기 위해
//			// 1. 랜덤값 발생
//			int random = (int) (Math.random() * shuffle.length);
//			int temp = shuffle[0];
//			shuffle[0] = shuffle[random];
//			shuffle[random] = temp;
//		}
//		System.out.println(Arrays.toString(shuffle));
//
//		
//		// 1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
//
//		int[] cnt = new int[10];
//				
//		for (int i = 0; i < 500; i++) {
//			
//			switch((int) (Math.random() * 10) + 1){
//			case 1 : cnt[0]++; break;
//			case 2 : cnt[1]++; break;
//			case 3 : cnt[2]++; break;
//			case 4 : cnt[3]++; break;
//			case 5 : cnt[4]++; break;
//			case 6 : cnt[5]++; break;
//			case 7 : cnt[6]++; break;
//			case 8 : cnt[7]++; break;
//			case 9 : cnt[8]++; break;
//			case 10 : cnt[9]++; break;
//			}
//			
//		}
//		
//		System.out.println("1 = " + cnt[0] + "개 " + cnt[0]);
//		System.out.println("2 = " + cnt[1] + "개 " + (cnt[0] + cnt[1]));
//		System.out.println("3 = " + cnt[2] + "개 " + (cnt[0] + cnt[1] + cnt[2]));
//		System.out.println("4 = " + cnt[3] + "개 " + (cnt[0] + cnt[1] + cnt[2] + cnt[3]));
//		System.out.println("5 = " + cnt[4] + "개 " + (cnt[0] + cnt[1] + cnt[2] + cnt[3] + cnt[4]));
//		System.out.println("6 = " + cnt[5] + "개 " + (cnt[0] + cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5]));
//		System.out.println("7 = " + cnt[6] + "개 " + (cnt[0] + cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5] + cnt[6]));
//		System.out.println("8 = " + cnt[7] + "개 " + (cnt[0] + cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5] + cnt[6] + cnt[7]));
//		System.out.println("9 = " + cnt[8] + "개 " + (cnt[0] + cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5] + cnt[6] + cnt[7] + cnt[8]));
//		System.out.println("10 = " + cnt[9] + "개 "+ (cnt[0] + cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5] + cnt[6] + cnt[7] + cnt[8] + cnt[9]));
//	
//		
//		
//		// _
//		int[] counts = new int[10];
//		
//		for(int i = 0; i < 500; i++){
//			int random = (int)(Math.random() * 10) + 1;
//			
//			//if(random == 1) counts[0]++;
//			//if(random == 2) counts[1]++;
//			//if(random == 3) counts[2]++;
//			counts[random - 1]++;			
//		}
//		System.out.println(Arrays.toString(counts));		
//		
	}

}
