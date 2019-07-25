package kr.co.mlec;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/**/*.xml"})
public class MemberTest {
	@Autowired
	private SqlSessionTemplate ss;
	
	@Ignore
	@Test
	public void selectAllMember() throws Exception {
		System.out.println(ss.selectList("member.dao.MemberDAO.selectAll"));
	}
	
	
	@Test
	public void 로그인테스트() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId("susu11");
		vo.setPassword("123");
		vo = ss.selectOne("member.dao.MemberDAO.login", vo);
		System.out.println(vo);
	}
}
