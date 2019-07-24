package kr.co.mlec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/**/*.xml"})
public class MemberTest {
	@Autowired
	private SqlSessionTemplate ss;
	
	@Test
	public void selectAllMember() {
		System.out.println(ss.selectList("member.dao.MemberDAO.selectAll"));
	}
}
