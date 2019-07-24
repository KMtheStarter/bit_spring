package kr.co.mlec;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.member.vo.MemberVO;

//Junit 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/**/*.xml"})
public class DBTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Ignore // 얘는 테스트 거르겠다.
	@Test
	public void DB테스트() throws Exception{
		System.out.println("ds: " + ds);
		System.out.println("sqlSessionTemplate: " + sqlSessionTemplate);
		
		assertNotNull(ds); // ds가 null이면 실패
	}
	
	@Ignore
	@Test
	public void 게시판상세조회() throws Exception{
		List<BoardVO> list = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAll");
		assertNotNull(list);
		for (BoardVO e: list) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void 회원가입() throws Exception{
		MemberVO vo = new MemberVO();
		// ${id}, ${password}, ${name}, ${emailId}, ${emailDomain}, ${tel1}, ${tel2}, ${tel3}, ${post}, ${basicAddr}, ${detailAddr}
		vo.setId("aa");
		vo.setPassword("aa");
		vo.setName("aa");
		vo.setEmailId("aa");
		vo.setEmailDomain("aa");
		vo.setTel1("010");
		vo.setTel2("010");
		vo.setTel3("010");
		vo.setPost("aa");
		vo.setBasicAddr("aa");
		vo.setDetailAddr("aa");
		sqlSessionTemplate.insert("member.dao.MemberDAO.insert", vo);
	}
}
