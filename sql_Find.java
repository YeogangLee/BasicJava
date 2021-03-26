
public class sql_Find {
	public static void main(String[] args) {
		int[] not_ordered_array = {4, 10, 5, 9, 2, 1, 0, 13, 15};
		
		int index = sql_Find.Find_not_ordered_array(not_ordered_array, 0);
		System.out.println(index);
		index = sql_Find.Find_not_ordered_array(not_ordered_array, 20);
		System.out.println(index);
		
		//int[] ordered_array = {0, 1, 2, 4, 5, 9, 13, 15};
			
	}
		//첫 번째 인자로 들어온 배열에서 (정렬되지 않은 배열)
		//두 번째 인자에 해당하는 값이 있을 경우 : 배열의 인덱스를 반환
	    //					값이 없을 경우 : -1을 리턴
	public static int Find_not_ordered_array(int[] findArray, int findValue){
		for(int i = 0; i < findArray.length; i++){
			if(findValue == findArray[i]){
				return i;
			} 
		}
		return 0;
	}
}
