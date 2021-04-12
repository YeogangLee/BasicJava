package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board2 {
	/*
	 * !! 수정할 것
	 * - 메인 메서드에서 기능 별로 개별 메서드 만들기
	 * - 아까 삭제 오류 고치기
	 * - 2차원 ArrayList를 매개변수로 받는 메서드 생성 문법 알기
	 * - 날짜 자료형 변경
	 * 
	 * => 수정한 것
	 * - 같은 클래스 안에 static 메서드로 선언
	 * static void insert(ArrayList<HashMap<String, Object>> boardList)
	 * static void read(ArrayList<HashMap<String, Object>> boardList)
	 * static void update(int numW, ArrayList<HashMap<String, Object>> boardList)
	 * static void delete(int numW, ArrayList<HashMap<String, Object>> boardList)
	 * 
	 * - 삭제 오류 고침
	 * : 삭제 오류가 아니라 조회 오류였다
	 * input - 1 = 0 입력시 조건 -> if(numW == 1)에서 if(numW == -1)로 변경
	 * 조건이 numW == 1 이었어서 2번째 글 조회가 불가능했었다.
	 * 
	 * - 2차원 ArrayList를 매개변수로 전달
	 *  static void read(ArrayList<HashMap<String, Object>> boardList)
	 * 
	 *  
	 * - 날짜 자료형 : new Date(), SimpleDateFormat 클래스 이용
	 * -- 날짜 저장
	 * 		board.put("date", new Date());
	 * -- 출력할 때
	 * 		System.out.print(formatDate.format(boardList.get(i).get("date"))+"\t");
	 * 		System.out.println("작성일\t| " + formatDate.format(boardList.get(numW).get("date")));
	 *  
	 *  
	 *  // HashMap생성, ArrayList생성 정리
	 *  
	 *  ArrayList notGeneric = new ArrayList();
	 *  ArrayList<Integer> list = new ArrayList<>();
	 *  HashMap<String, Object> board = new HashMap<>();
	 *  ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
	 */
	
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 * -------------------------------------------
		 * 번호		제목			작성자	작성일
		 * -------------------------------------------
		 * 4		안녕하세요		홍길동	4/7
		 * 3		안녕하세요		홍길동	4/7
		 * 2		안녕하세요		홍길동	4/7
		 * 1		안녕하세요		홍길동	4/7
		 * -------------------------------------------
		 * 1.조회	2.등록		0.종료
		 * 
		 * 
		 * - 가장 먼저 목록 띄우기
		 * - 조회 후 수정 및 삭제 가능
		 */
		
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();		
		HashMap<String, Object> board = new HashMap<>();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		
		board.put("num", 1);
		board.put("title", "안녕하세요");
		board.put("writer", "홍길동");
		board.put("date", new Date());
		board.put("writing", "글내용1");
		boardList.add(board);
		
		board = new HashMap<>();
		board.put("num", 2);
		board.put("title", "안녕하세요");
		board.put("writer", "홍길동");
		board.put("date", new Date());
		board.put("writing", "글내용2");
		boardList.add(board);
		
		
		while(true){
			System.out.println("-------------------------------------");
			System.out.println("번호\t제목\t    작성자\t    작성일");
			System.out.println("-------------------------------------");
			for (int i = boardList.size() - 1; 0 <= i; i--) {
				System.out.print(boardList.get(i).get("num")+"\t");
				System.out.print(boardList.get(i).get("title")+"\t    ");
				System.out.print(boardList.get(i).get("writer")+"\t  ");
				System.out.print(formatDate.format(boardList.get(i).get("date"))+"\t");
				System.out.println();
			}
			System.out.println("-------------------------------------");
			System.out.println("1.조회\t2.등록\t0.종료");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				read(boardList);
				break;
				
			case 2:
				insert(boardList);
				break;
				
			default:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
				
			}
		}
	}
	
	//등록
	static void insert(ArrayList<HashMap<String, Object>> boardList)
	{
		HashMap<String, Object> board = new HashMap<>();
		
		board = new HashMap<>();
		System.out.println("제목 입력>");
		String title = ScanUtil.nextLine();
		System.out.println("작성자 입력>");
		String writer = ScanUtil.nextLine();
//		System.out.println("작성일 입력>");
//		String date = ScanUtil.nextLine();
		System.out.println("내용 입력>");
		String writing = ScanUtil.nextLine();
		
		board.put("num", (boardList.size())+1);
		board.put("title", title);
		board.put("writer", writer);
		board.put("date", new Date());
		board.put("writing", writing);
		boardList.add(board);
		
		System.out.println("글이 정상적으로 등록되었습니다.");
	}
	
	//조회
	static void read(ArrayList<HashMap<String, Object>> boardList)
	{
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		
		//System.out.println("보드 사이즈 : "+boardList.size()); //보드 전체 크기 확인
		System.out.println("조회할 글 번호 입력>");
		int numW = ScanUtil.nextInt() - 1;
		if(numW == -1){ //0 입력시
			System.out.println("잘못된 숫자 입력");
		}
		System.out.println("-------------------------------------");
		System.out.println("번호\t| " + boardList.get(numW).get("num"));
		System.out.println("제목\t| " + boardList.get(numW).get("title"));
		System.out.println("작성자\t| " + boardList.get(numW).get("writer"));
		System.out.println("작성일\t| " + formatDate.format(boardList.get(numW).get("date")));
		System.out.println("내용\t| " + boardList.get(numW).get("writing"));
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("1.수정\t2.삭제\t0.처음으로");
		int numMR = ScanUtil.nextInt();
			switch (numMR) {
			case 1:
				update(numW, boardList);
				break;
				
			case 2:
				delete(numW, boardList);
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("잘못된 숫자 입력");
				break;
			}
	}
	
	//수정
	static void update(int numW, ArrayList<HashMap<String, Object>> boardList)
	{
		System.out.println("수정할 항목>");
		System.out.println("1.제목\t2.내용\t0.처음으로");
		int numM = ScanUtil.nextInt();
			switch (numM) {
			case 1:
				System.out.println("변경할 제목 입력>");
				String title = ScanUtil.nextLine();
				boardList.get(numW).put("title", title);
				System.out.println("제목이 정상적으로 변경되었습니다.");
				break;
			case 2:
				System.out.println("변경할 내용 입력>");
				String writing = ScanUtil.nextLine();
				boardList.get(numW).put("writing", writing);
				System.out.println("내용이 정상적으로 변경되었습니다.");
				break;
			case 0: break;
			default: 
				System.out.println("잘못된 숫자 입력"); break;
			}
	}
	
	//삭제
	static void delete(int numW, ArrayList<HashMap<String, Object>> boardList)
	{
		System.out.println("글을 정말로 삭제하시겠습니까?(y/n)");
		String yesno = ScanUtil.nextLine();
		if(yesno.equals("y")){
			/*
			 * 아래처럼 하면, boardList의 글 자체가 삭제되는 게 아니라
			 * boardList의 numW번째 글이 삭제되므로,
			 * 글은 남아있고 그자리에 null값이 채워진다 ->
			 * boardList의 size 변화X
			 */
			
//			board.get(numW).remove("num");
//			board.get(numW).remove("title");
//			board.get(numW).remove("writer");
//			board.get(numW).remove("date");
//			board.get(numW).remove("writing");
			
			boardList.remove(numW);
			//System.out.println("보드 사이즈 : "+boardList.size());
			
			//글 번호 수정
			for(int i = numW; i < boardList.size(); i++){
				boardList.get(i).put("num", ((int)boardList.get(i).get("num"))-1);
				//삭제된 글 이후의 글들만 인덱스 번호를 감소시켜야 하므로,
				//반복문의 시작값은 삭제된 글의 인덱스 번호이고,
				//이 번호가 보드리스트의 끝 글까지 비교하여 수정하도록 조건은 boardList.size()
				//글이 삭제된 이후에 실행되는 for문이라 numW에는 현재 삭제된 글의 다음 글을 가리키고 있다
			}
			System.out.println("글이 정상적으로 삭제되었습니다.");
		}
		else if(yesno.equals("n")){
			System.out.println("이전 화면으로 돌아갑니다.");
		}
	}
	
}

