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
		//return "board/list"; // <mvc:jsp prefix="/WEB-INF/jsp/" suffix=".jsp" /> 로 기본 경로가 잡혀있다.
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String writeForm(Model model) {
		// return 타입이 void면 value에 있는 uri를 찾게됨. 그래서 아무것도 없어도 해당 페이지로 이동함.
		BoardVO vo = new BoardVO();
		model.addAttribute("boardVO", vo);
		
		return "board/write";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVO vo /* 자동주입 */, BindingResult result) {
		System.out.println(vo);
		if(result.hasErrors()) {
			System.out.println("글 작성 중 에러발생");
			return "board/write";
		} else {
			service.insertBoard(vo);
			// 글 작성을 완료하고 sendRedirect를 통해 글 목록으로 보내주어야 한다.
			return "redirect:/board";
		}
	}
	
	@RequestMapping(value="/board/write2", method=RequestMethod.GET)
	public String writeForm2() {
		// return 타입이 void면 value에 있는 uri를 찾게됨. 그래서 아무것도 없어도 해당 페이지로 이동함.
		
		return "board/write2";
	}
	
	@RequestMapping(value="/board/write2", method=RequestMethod.POST)
	public String write2(BoardVO vo /* 자동주입 */) {
		service.insertBoard(vo);
		
		// 글 작성을 완료하고 sendRedirect를 통해 글 목록으로 보내주어야 한다.
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
	
	// 기존 방식
	@RequestMapping(value="/board/detail")
	public String detail2(@RequestParam("no")int no, Model model) {
		BoardVO vo = service.selectByNoBoard(no);
		model.addAttribute("boardVO", vo);
		System.out.println(vo);
		return "board/detail";
	}
}
