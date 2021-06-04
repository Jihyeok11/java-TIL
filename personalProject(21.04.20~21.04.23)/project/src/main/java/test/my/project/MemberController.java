package test.my.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	
	@Autowired
	MemberService service;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces ={"applcation/json;charset=utf-8" } )
	@ResponseBody
	public String loginResult(String id, String pw) {
		String result = null;
		System.out.println("id : " +id);
		System.out.println("pw : " +pw);
		String realPassword = service.login(id);
		if (pw.equals(realPassword)) {
			result = "{\"result\" : \"성공\" }";
		} else {
			result = "{\"result\" : \"실패\" }";
		}
		System.out.println(result);
		return result;
	}
	
	
	

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	

	@RequestMapping(value="/signup", method=RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public MemberDTO signupresult(String id, String pw, String username) {
		System.out.println(id + " | " + pw + " | " + username);
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(pw);
		dto.setUsername(username);
		service.signUp(dto);
		
		return dto;
	}
}
