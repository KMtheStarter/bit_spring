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
		return "Ok, ����"; // ResponseBody�� �Ⱥ����� Ok, ����.jsp�� ���� �Ѵ�.
		// ������ �ѱ��� ����...�Ф� -> spring-mvc.xml�� mvc:message-converters �߰�
	}
	
	@ResponseBody
	@RequestMapping("/resBody.json")
	public Map<String, String> resJsonBody(){
		Map<String, String> result = new HashMap<>();
		result.put("id", "hong");
		result.put("name", "ȫ�浿");
		result.put("addr", "����� ���ʱ�");
		
		return result; // json converter ���� �߰��� �־�� �Ѵ�.
		// 1. pom.xml�� jackson core, databind, annotation �� �� �߰�.
		// 2. spring-mvc ����
		// 3. .json�� ȣ���ϹǷ�, web.xml���� mapping �߰�
	}
	
	@ResponseBody
	@RequestMapping("/resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPassword("���");
		vo.setName("ȫ�浿");
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/resStringListBody.json")
	public List<String> resJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++) {
			list.add(i + ""); // �ļ� ����
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
