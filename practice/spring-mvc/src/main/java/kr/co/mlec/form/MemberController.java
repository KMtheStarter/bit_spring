package kr.co.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form") // 결합!
public class MemberController {
	
	@RequestMapping("/joinForm.do") // @RequestMapping("/form/joinForm.do")와 같음.
	public String joinForm() {
		return "form/joinForm";
	}
	
	/*
	@RequestMapping("/join.do")
	public String join(HttpServletRequest req) {
		// 원래 servlet에서 쓰는 객체인 HttpServletRequest를 자바에서 쓸 수 있게 spring이 제어해줌.
		// DispatcherServlet이 주입해주는것.
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		
		req.setAttribute("member", vo);
		
		return "form/memberInfo";
	}
	*/
	
	/*	
	@RequestMapping("/join.do")
	public String join(@RequestParam("id")String id,
			@RequestParam("password")String password,
			@RequestParam("name")String name,
			HttpServletRequest req) {
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		
		req.setAttribute("member", vo);
		
		return "form/memberInfo";
	}
	*/
	
	/*	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member")MemberVO vo) {
		// 이 시점에서 이미 공유영역에 vo가 저장됨. memberVO 라는 이름으로.
		return "form/memberInfo";
	}
	*/
	
	/*	
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("form/memberInfo"); //ModelAndView mav = new ModelAndView("form/memberInfo"); 와 동일
		return mav;
	}
	*/
	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member")MemberVO member, Model model) {
		model.addAttribute("msg", "가입완료!");
//		return "form/memberInfo";
		return "redirect:/form/joinForm.do"; // redirect:는 spring-mvc/ 까지 경로를 가지고 있음.
		// redirect를 시키면 requestScope에 가지고 있는 문자열을 url에 전달함.
		// 일반적인 객체는 다 날라감.
	}
	
}
