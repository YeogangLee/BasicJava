package j_collection;

import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {
	
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
		
		ArrayList<HashMap<String, Object>> board = new ArrayList<>();		
		HashMap<String, Object> row = new HashMap<>();
		
		row.put("num", 1);
		row.put("title", "안녕하세요");
		row.put("writer", "홍길동");
		row.put("date", "4/7");
		row.put("writing", "글내용1");
		board.add(row);
		
		row = new HashMap<>();
		row.put("num", 2);
		row.put("title", "안녕하세요");
		row.put("writer", "홍길동");
		row.put("date", "4/7");
		row.put("writing", "글내용2");
		board.add(row);
		
		row = new HashMap<>();
		row.put("num", 3);
		row.put("title", "안녕하세요");
		row.put("writer", "홍길동");
		row.put("date", "4/7");
		row.put("writing", "글내용3");
		board.add(row);
		
		row = new HashMap<>();
		row.put("num", 4);
		row.put("title", "안녕하세요");
		row.put("writer", "홍길동");
		row.put("date", "4/7");
		row.put("writing", "글내용4");
		board.add(row);
		
		
		while(true){
			System.out.println("--------------------------------");
			System.out.println("번호\t제목\t    작성자\t    작성일");
			System.out.println("--------------------------------");
			for (int i = board.size() - 1; 0 <= i; i--) {
				System.out.print(board.get(i).get("num")+"\t");
				System.out.print(board.get(i).get("title")+"\t    ");
				System.out.print(board.get(i).get("writer")+"\t  ");
				System.out.print(board.get(i).get("date")+"\t");
				System.out.println();
			}
			System.out.println("--------------------------------");
			System.out.println("1.조회\t2.등록\t0.종료");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				//System.out.println("보드 사이즈 : "+board.size());
				System.out.println("조회할 글 번호 입력>");
				int numW = ScanUtil.nextInt() - 1;
				if(numW==1){ //0 입력시
					System.out.println("잘못된 숫자 입력"); break;
				}
				System.out.println("--------------------------------");
				System.out.println("번호\t| " + board.get(numW).get("num"));
				System.out.println("제목\t| " + board.get(numW).get("title"));
				System.out.println("작성자\t| " + board.get(numW).get("writer"));
				System.out.println("작성일\t| " + board.get(numW).get("date"));
				System.out.println("내용\t| " + board.get(numW).get("writing"));
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println("1.수정\t2.삭제\t0.처음으로");
				int numMR = ScanUtil.nextInt();
					switch (numMR) {
					case 1:
						System.out.println("수정할 항목>");
						System.out.println("1.제목\t2.내용\t0.처음으로");
						int numM = ScanUtil.nextInt();
							switch (numM) {
							case 1: 
								System.out.println("변경할 제목 입력>");
								String title = ScanUtil.nextLine();
								board.get(numW).put("title", title);
								break;
							case 2:
								System.out.println("변경할 내용 입력>");
								String writing = ScanUtil.nextLine();
								board.get(numW).put("writing", writing);
								break;
							case 0: break;
							default: 
								System.out.println("잘못된 숫자 입력"); break;
							}
						break;
					case 2:
						System.out.println("글을 정말로 삭제하시겠습니까?(y/n)");
						String yesno = ScanUtil.nextLine();
						if(yesno.equals("y")){
							/*
							 * 아래처럼 하면, board의 행 자체가 삭제되는 게 아니라
							 * board의 numW행의 데이터가 삭제되므로,
							 * 행은 남아있고 그자리에 null값이 채워진다 ->
							 * board의 size 변화X
							 */
							
//							board.get(numW).remove("num");
//							board.get(numW).remove("title");
//							board.get(numW).remove("writer");
//							board.get(numW).remove("date");
//							board.get(numW).remove("writing");
							
							board.remove(numW);
							//System.out.println("보드 사이즈 : "+board.size());
							//글 번호 수정
							for(int i = numW; i < board.size(); i++){
								board.get(i).put("num", ((int)board.get(i).get("num"))-1);
							}
							System.out.println("글이 정상적으로 삭제되었습니다.");
						}
						else if(yesno.equals("n")){
							System.out.println("이전 화면으로 돌아갑니다.");
						}
						break;
					case 0:
						break;
					default:
						System.out.println("잘못된 숫자 입력");
						break;
					}
				break;
				
			case 2:
				row = new HashMap<>();
				System.out.println("제목 입력>");
				String title = ScanUtil.nextLine();
				System.out.println("작성자 입력>");
				String writer = ScanUtil.nextLine();
				System.out.println("작성일 입력>");
				String date = ScanUtil.nextLine();
				System.out.println("내용 입력>");
				String writing = ScanUtil.nextLine();
				
				row.put("num", (board.size())+1);
				row.put("title", title);
				row.put("writer", writer);
				row.put("date", date);
				row.put("writing", writing);
				board.add(row);
				
				System.out.println("글이 정상적으로 등록되었습니다.");
				break;
				
			default:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}
}

