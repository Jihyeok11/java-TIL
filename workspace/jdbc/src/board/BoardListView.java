package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardListView {
	void input(){
		Scanner sc = new Scanner(System.in);
		System.out.println("페이지번호:");
		int pagenum = sc.nextInt();
		System.out.println("한페이지당출력게시물갯수:");
		int cntPerPage = sc.nextInt();
		//BoardMain 하도록 하겠다
		//int [] all = new int[2];
		//all[0] = pagenum;
		//all[1] = cntPerPage;
		//return all;
		//- BoardDAO 객체 생성 -  getBoardList 호출
		BoardDAO dao = new BoardDAO();
		if(pagenum == 0) {
			ArrayList<BoardDTO> list = dao.getBoardList();
			for(BoardDTO one : list) {
				System.out.println
				(one.getSeq() + " | " + one.getTitle() + " | " + one.getWriter()  + " | " + one.getViewcount() );
			}
		}
		else if(pagenum > 0) {
			ArrayList<BoardDTO> list = dao.getBoardList(pagenum, cntPerPage);
			for(BoardDTO one : list) {
				System.out.println
				(one.getSeq() + " | " + one.getTitle() + " | " + one.getWriter()  + " | " + one.getViewcount() );
			}
		}
	}
}
