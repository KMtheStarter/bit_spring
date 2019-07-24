package kr.co.mlec.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/board")
	public ModelAndView list() {
		List<BoardVO> list = service.selectAllBoard();
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList", list);
		return mav;
		//return "board/list"; // <mvc:jsp prefix="/WEB-INF/jsp/" suffix=".jsp" /> �� �⺻ ��ΰ� �����ִ�.
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String writeForm(Model model) {
		// return Ÿ���� void�� value�� �ִ� uri�� ã�Ե�. �׷��� �ƹ��͵� ��� �ش� �������� �̵���.
		BoardVO vo = new BoardVO();
		model.addAttribute("boardVO", vo);
		
		return "board/write";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVO vo /* �ڵ����� */, BindingResult result) {
		System.out.println(vo);
		if(result.hasErrors()) {
			System.out.println("�� �ۼ� �� �����߻�");
			return "board/write";
		} else {
			service.insertBoard(vo);
			// �� �ۼ��� �Ϸ��ϰ� sendRedirect�� ���� �� ������� �����־�� �Ѵ�.
			return "redirect:/board";
		}
	}
	
	@RequestMapping(value="/board/write2", method=RequestMethod.GET)
	public String writeForm2() {
		// return Ÿ���� void�� value�� �ִ� uri�� ã�Ե�. �׷��� �ƹ��͵� ��� �ش� �������� �̵���.
		
		return "board/write2";
	}
	
	@RequestMapping(value="/board/write2", method=RequestMethod.POST)
	public String write2(BoardVO vo /* �ڵ����� */) {
		service.insertBoard(vo);
		
		// �� �ۼ��� �Ϸ��ϰ� sendRedirect�� ���� �� ������� �����־�� �Ѵ�.
		return "redirect:/board";
	}
	
	// restful
	@RequestMapping(value="/board/{no}", method=RequestMethod.GET)
	public String detail(@PathVariable("no")int no, Model model) {
		BoardVO vo = service.selectByNoBoard(no);
		model.addAttribute("boardVO", vo);
		System.out.println(vo);
		return "board/detail";
	}
	
	// ���� ���
	@RequestMapping(value="/board/detail")
	public String detail2(@RequestParam("no")int no, Model model) {
		BoardVO vo = service.selectByNoBoard(no);
		model.addAttribute("boardVO", vo);
		System.out.println(vo);
		return "board/detail";
	}
}
