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
@RequestMapping("/form") // ����!
public class MemberController {
	
	@RequestMapping("/joinForm.do") // @RequestMapping("/form/joinForm.do")�� ����.
	public String joinForm() {
		return "form/joinForm";
	}
	
	/*
	@RequestMapping("/join.do")
	public String join(HttpServletRequest req) {
		// ���� servlet���� ���� ��ü�� HttpServletRequest�� �ڹٿ��� �� �� �ְ� spring�� ��������.
		// DispatcherServlet�� �������ִ°�.
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
		// �� �������� �̹� ���������� vo�� �����. memberVO ��� �̸�����.
		return "form/memberInfo";
	}
	*/
	
	/*	
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("form/memberInfo"); //ModelAndView mav = new ModelAndView("form/memberInfo"); �� ����
		return mav;
	}
	*/
	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member")MemberVO member, Model model) {
		model.addAttribute("msg", "���ԿϷ�!");
//		return "form/memberInfo";
		return "redirect:/form/joinForm.do"; // redirect:�� spring-mvc/ ���� ��θ� ������ ����.
		// redirect�� ��Ű�� requestScope�� ������ �ִ� ���ڿ��� url�� ������.
		// �Ϲ����� ��ü�� �� ����.
	}
	
}
