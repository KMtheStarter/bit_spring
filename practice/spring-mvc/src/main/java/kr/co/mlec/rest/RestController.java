package kr.co.mlec.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mlec.form.MemberVO;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/ajax")
public class RestController {

	@RequestMapping("/restBody.do")
	public String restStringBody() {
		return "Ok, 성공"; // ResponseBody가 안붙으면 Ok, 성공.jsp로 들어가려 한다.
		// 하지만 한글이 깨짐...ㅠㅠ -> spring-mvc.xml에 mvc:message-converters 추가
	}
	
	@RequestMapping("/restBody.json")
	public Map<String, String> restJsonBody(){
		Map<String, String> result = new HashMap<>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울시 서초구");
		
		return result; // json converter 역시 추가해 주어야 한다.
		// 1. pom.xml에 jackson core, databind, annotation 세 개 추가.
		// 2. spring-mvc 수정
		// 3. .json을 호출하므로, web.xml에서 mapping 추가
	}
	
	@RequestMapping("/restVOBody.json")
	public MemberVO restJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPassword("요시");
		vo.setName("홍길동");
		return vo;
	}
	
	@RequestMapping("/restStringListBody.json")
	public List<String> restJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++) {
			list.add(i + ""); // 꼼수 ㅋㅋ
		}
		
		return list;
	}
	
	@RequestMapping("/restVOListBody.json")
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
