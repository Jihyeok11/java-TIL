package test.my.project;

import java.util.List;

public interface MemberService {
	/* public List*/
	
	public void signUp(MemberDTO dto);
	
	public String login(String id);
	
	public int idCheck(String id);
	
	public void insertBoard(BoardDTO dto);
	
	public List<BoardDTO> getAllBoard();
}
