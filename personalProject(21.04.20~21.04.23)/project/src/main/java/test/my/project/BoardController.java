package test.my.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main() {
		List<BoardDTO> list = service.getAllBoard();
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardlist", list);
		mv.setViewName("/home");
		return mv;
	}
	
	@RequestMapping(value="/createboard", method=RequestMethod.GET)
	public String GotoAdd() {
		return "createboard";
	}
	
	@RequestMapping(value="createboard", method=RequestMethod.POST, produces ={"application/json;charset=utf-8" } )
	@ResponseBody
	public BoardDTO CreateBoard(String board_item, String board_contents, String board_price) {
		BoardDTO dto = new BoardDTO();
		dto.setItem(board_item);
		dto.setContents(board_contents);
		dto.setPrice(Integer.parseInt(board_price));
		System.out.println(board_item +" : "+ board_contents + " : " + board_price);
		service.insertBoard(dto); //redirect 테스트를 위해 잠시 막아둠
		return dto;
	}
	
	
}
