package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/method/method.do")
@Controller
public class MethodController {

//	@RequestMapping(value="/method/method.do", method=RequestMethod.GET) // value와 method가 들어간 모양
	@RequestMapping(method=RequestMethod.GET) // 가능
	public String callGet() {
		return "method/methodForm"; // String도 return 가능. ModelAndView가 아닌 포워드 시키려는 주소값만 넣어줘도 됨.
	}
	
	
//	@RequestMapping(value="/method/method.do", method=RequestMethod.POST)
	@RequestMapping(method=RequestMethod.POST) // 가능
	public String callPost() {
		return "method/methodProcess";
	}
}
