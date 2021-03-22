package d_array;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리 반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100 사이의 랜덤값으로 생성하고, 아래와 같이 출력해주세요.
		 * 
		 * 이름		국어		영어		수학		사회		과학		Oracle		Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90			90		630		90.0	1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0	1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0	1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0	1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0	1 
		 * 과목 합계 	450		450		450		450		450		450			450
		 * 과목 평균	90.0	90.0	90.0	90.0	90.0	90.0		90.0
		 * 
		 */
		
		int students = 25;
		int[][] scores = new int[students][7];
		int[] rank = new int[students];
		int[] sum = new int[students];
		double[] avg = new double[students];
		String[] names = {"강유진", "강지수", "곽재우", "구본성", "권수연", "김보영", "김소희", "김지수", "백지혜", "송유경", "신희철", "심선주",
				"오수연", "윤희중", "이경준", "이석호", "이승구", "이여강", "이영민", "이영우", "이용석", "이정범", "최기문", "최소은", "최윤지"};
		
		// 랜덤 값으로 점수 생성
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
		}
		
		// 합계, 평균 구하기
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}
			avg[i] = (double)sum[i]/scores[i].length;
		}
		
		// 석차 구하기
		for(int i = 0; i < rank.length; i++){
			rank[i] = 1;			
		} // 1등부터 시작할 거라서 배열을 전부 다 1로 채워줌
		
		for(int i = 0; i < sum.length; i++){
			for(int j = 0; j < sum.length; j++){
				if(sum[i] < sum[j]){
					rank[i]++;
				}
			}
		}
		
		// 결과물 배열 값 오름차순 정렬 - 선택정렬
		int tempInt = 0;
		double tempDouble = 0;
		String tempString = "";
		for (int i = 0; i < rank.length - 1; i++) {
			int min = i; 
			for (int j = i + 1; j < rank.length; j++) { 
				if (rank[j] < rank[min]) {
					min = j;
				}
			}
			
			//행 단위로 이동시켜주기 위해 동일한 배열 인덱스를 모든 배열에 다같이 변경
			//석차 배열
			tempInt = rank[i];
			rank[i] = rank[min];
			rank[min] = tempInt;
			
			//합계 배열
			tempInt = sum[i];
			sum[i] = sum[min];
			sum[min] = tempInt;
			
			//평균 배열
			tempDouble = avg[i];
			avg[i] = avg[min];
			avg[min] = tempDouble;
			
			//이름 배열
			tempString = names[i];
			names[i] = names[min];
			names[min] = tempString;
			
			//점수 배열
			//2차원 배열이므로 행 뿐만 아니라, 열 정보를 포함한다
			//따라서 점수 열에 따라 변경시켜주기 위해 과목 개수 만큼의 반복문 사용 
			for(int k = 0; k < scores[i].length; k++){
				tempInt = scores[i][k];
				scores[i][k] = scores[min][k];
				scores[min][k] = tempInt;				
			}
		}
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차\t");
		for(int i = 0; i < scores.length; i++){
			System.out.print(names[i]+"\t");
			for(int j = 0; j < scores[i].length; j++){
				System.out.print(scores[i][j]+"\t");
			}
			System.out.print(sum[i]+"\t"+Math.round(avg[i]*10)/10.0+"\t"+rank[i]);
			System.out.println();
		}
		
	}

}
