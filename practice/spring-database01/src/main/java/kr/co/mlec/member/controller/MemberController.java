package kr.co.mlec.member.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView signupForm() {
		MemberVO vo = new MemberVO();
		ModelAndView mav = new ModelAndView("member/signup");
		mav.addObject("memberVO", vo);
		return mav;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String signup(@Valid MemberVO vo, BindingResult result) {
		System.out.println(vo);
		if(result.hasErrors()) {
			System.out.println("회원가입중 에러 발생");
			return "member/signup";
		} else {
			service.insertMember(vo);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/member")
	public String allMember(Model model) {
		List<MemberVO> list = service.selectAllMember();
		model.addAttribute("memberList", list);
		return "member/members";
	}
	
	@RequestMapping("/member/{id}")
	public String detailMember(@PathVariable("id")String id, Model model) {
		MemberVO vo = service.selectByIdMember(id);
		model.addAttribute("member", vo);
		return "member/detail";
	}
}
