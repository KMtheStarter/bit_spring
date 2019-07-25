package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;

@SessionAttributes({"loginVO"})
@Controller
public class LoginController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/login")
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		
		return "login/login";
	}
	
	// spring���� �����ϴ� ����
	@PostMapping("/login")
	public String login(MemberVO vo, Model model) {
		MemberVO member = service.loginMember(vo);

		if (member == null) {
			// �α��� ����
			model.addAttribute("msg", "���̵� �Ǵ� �н����尡 �߸��Ǿ����ϴ�.");
			return "redirect:/login";
		} else {
			// �α��� ����
			model.addAttribute("loginVO", member);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		System.out.println("before: " + status.isComplete());
		status.setComplete();
		System.out.println("after: " + status.isComplete());
		return "redirect:/";
	}
	
/* servlet jsp������ session

	@PostMapping("/login")
	public String login(MemberVO vo, Model model, HttpServletRequest req) {
		MemberVO member = service.loginMember(vo);

		if (member == null) {
			// �α��� ����
			model.addAttribute("msg", "���̵� �Ǵ� �н����尡 �߸��Ǿ����ϴ�.");
			return "redirect:/login";
		} else {
			// �α��� ����
			HttpSession session = req.getSession();
			session.setAttribute("loginVO", member);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginVO");
		return "redirect:/";
	}
*/
}
