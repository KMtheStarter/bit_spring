package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello/hello.do") // key�� �����ǰ�, value�� �� ���
	public ModelAndView Hello() {
		ModelAndView mav = new ModelAndView("hello/hello");
		mav.addObject("msg", "hi spring mvc");
		return mav;
	}
}
