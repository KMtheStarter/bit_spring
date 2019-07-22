package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello/hello.do") // key가 생략되고, value만 들어간 모양
	public ModelAndView Hello() {
		ModelAndView mav = new ModelAndView("hello/hello");
		mav.addObject("msg", "hi spring mvc");
		return mav;
	}
}
