package test.my.project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	//아이디 체크
	public int idCheck(String userId) {
		System.out.println("===> Mybatis로 idCheck");
		int result = session.selectOne("project.idCheck",userId);
		return result;
	}
	
	// 비밀번호 체크
	public String pwCheck(String userId) {
		System.out.println("===> Mybatis로 pwCheck");
		String result = null;
		int idcheck = session.selectOne("project.idCheck", userId);
		System.out.println(idcheck);
		if (idcheck==1) {
			result = session.selectOne("project.login",userId);
		}else {
			result = null;
		}
		System.out.println("dao작업, 진짜비번 : " + result);
		return result;
	}
	
	//회원가입
	public void signUp(MemberDTO dto) {
		System.out.println("회원가입(signUp)");
		session.insert("project.signUp",dto);
	}
	
	public void insertBoard(BoardDTO dto) {
		session.insert("project.insertBoard",dto);
	}
	
	public List<BoardDTO> getAllBoard(){
		List<BoardDTO> list = session.selectList("project.getAllBoard");
		return list;
	}
}
