package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		
//		// 거스름돈 동전 개수
//		int money = (int) (Math.random() * 500) * 10;
//		int[] coin = { 500, 100, 50, 10 };
//		System.out.println("거스름돈 : " + money);
//
//		/*
//		 * 거스름돈 동전의 단위이다. 몇 개의 동전이 필요한지 출력해주세요.
//		 * 
//		 * 거스름돈 : 2860원 500원 : 5개 100원 : 3개 50원 : 1개 10원 : 1개
//		 */
//		
//		for(int i = 0; i < coin.length; i++){
//			int count = money / coin[i];
//			money = money % coin[i];
//			System.out.println(coin[i] + "원 : " + count + "개");
//		}
//
//
		// 나누기를 안 썼음
//		for(int i = 0; i < coin.length; i++){
//			int cnt = 0;
//			while(cnt * coin[i] + money % coin[i] != money){
//				cnt++;
//			}
//			money -= cnt * coin[i];
//			System.out.println(coin[i] + "원 : " + cnt + "개");
//		}
		
		
		//그래프 그리기
//		int[] arr = new int[20];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		
//		/*
//		 * 1~5 사이의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
//		 * 
//		 * [4, 3, 2, 5, 4, 1, 4, 2, 2, 2, 2, 3, 3, 1, 5, 1, 1, 3, 1, 2]
//		 * 
//		 * 1 : ***** 5
//		 * 2 : **** 4
//		 * 3 : **** 4
//		 * 4 : **** 4
//		 * 5 : *** 3
//		 * 
//		 */
//		
//		int[] cnt = new int[5];
//		
//		for(int i=0; i < arr.length; i++){
//			switch(arr[i]){
//			case 1: cnt[0]++; break;
//			case 2: cnt[1]++; break;
//			case 3: cnt[2]++; break;
//			case 4: cnt[3]++; break;
//			case 5: cnt[4]++; break;
//			}
//		}
//		
//		
////		for(int i=0; i < cnt.length; i++){
////			System.out.print(cnt[i]);
////		}
//		
//		for (int i = 0; i < cnt.length; i++) {
//			System.out.print((i + 1) + " : ");
//			for (int j = 0; j < cnt[i]; j++) {
//				System.out.print("*");
//			}
//			System.out.println(" " + cnt[i]);
//		}
//		
//		
//		//
//		int[] counts = new int[5];
//		for(int i = 0; i < arr.length; i++){
//			counts[arr[i]-1]++;
//		} // BCoT /**/
//		for (int i = 0; i < counts.length; i++) {
//			System.out.print((i + 1) + " : ");
//			for (int j = 0; j < counts[i]; j++) {
//				System.out.print("*");
//			}
//			System.out.println(" " + counts[i]);
//		}
				
		
		//중복되지 않는 배열
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		/*
		 * 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		 * [2, 2, 2, 2, 1, 1, 4, 1, 1, 4]
		 * [2, 1, 4]
		 * 
		 */
		
		
		//
		int[] temp = new int[5];
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			boolean flag = true;
			for(int j = 0; j < temp.length; j++){
				if(arr[i] == temp[j]){
					flag = false;
				}
			}
			if(flag){
				temp[count++] = arr[i];
			}
		}
		int[] result = new int[count];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));		
		
	}

}
