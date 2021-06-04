package test.my.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService {

	@Autowired(required = false)
	MemberDAO dao;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		dao.insertBoard(dto);
	}
	
	@Override
	public void signUp(MemberDTO dto) {
		dao.signUp(dto);
	}

	@Override
	public List<BoardDTO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public int idCheck(String id) {
		int result = dao.idCheck(id);
		return result;
	}

	@Override
	public String login(String id) {
		String result = dao.pwCheck(id);
		return result;
	}
	
}
