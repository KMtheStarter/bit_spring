package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.form.MemberVO;

@Controller
@RequestMapping("/ajax")
public class ResBodyController {
	@ResponseBody
	@RequestMapping("/resBody.do")
	public String resStringBody() {
		return "Ok, 성공"; // ResponseBody가 안붙으면 Ok, 성공.jsp로 들어가려 한다.
		// 하지만 한글이 깨짐...ㅠㅠ -> spring-mvc.xml에 mvc:message-converters 추가
	}
	
	@ResponseBody
	@RequestMapping("/resBody.json")
	public Map<String, String> resJsonBody(){
		Map<String, String> result = new HashMap<>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울시 서초구");
		
		return result; // json converter 역시 추가해 주어야 한다.
		// 1. pom.xml에 jackson core, databind, annotation 세 개 추가.
		// 2. spring-mvc 수정
		// 3. .json을 호출하므로, web.xml에서 mapping 추가
	}
	
	@ResponseBody
	@RequestMapping("/resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPassword("요시");
		vo.setName("홍길동");
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/resStringListBody.json")
	public List<String> resJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++) {
			list.add(i + ""); // 꼼수 ㅋㅋ
		}
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/resVOListBody.json")
	public List<MemberVO> resVOListBody(){
		List<MemberVO> list = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setPassword("ho");
			vo.setName(i+"");
			list.add(vo);
		}
		
		return list;
	}
}
