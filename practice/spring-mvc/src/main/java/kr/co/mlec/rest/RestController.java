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
		return "Ok, ����"; // ResponseBody�� �Ⱥ����� Ok, ����.jsp�� ���� �Ѵ�.
		// ������ �ѱ��� ����...�Ф� -> spring-mvc.xml�� mvc:message-converters �߰�
	}
	
	@RequestMapping("/restBody.json")
	public Map<String, String> restJsonBody(){
		Map<String, String> result = new HashMap<>();
		result.put("id", "hong");
		result.put("name", "ȫ�浿");
		result.put("addr", "����� ���ʱ�");
		
		return result; // json converter ���� �߰��� �־�� �Ѵ�.
		// 1. pom.xml�� jackson core, databind, annotation �� �� �߰�.
		// 2. spring-mvc ����
		// 3. .json�� ȣ���ϹǷ�, web.xml���� mapping �߰�
	}
	
	@RequestMapping("/restVOBody.json")
	public MemberVO restJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPassword("���");
		vo.setName("ȫ�浿");
		return vo;
	}
	
	@RequestMapping("/restStringListBody.json")
	public List<String> restJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++) {
			list.add(i + ""); // �ļ� ����
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
