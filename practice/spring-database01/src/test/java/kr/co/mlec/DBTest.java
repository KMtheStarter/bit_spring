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

//Junit �׽�Ʈ
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/**/*.xml"})
public class DBTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Ignore // ��� �׽�Ʈ �Ÿ��ڴ�.
	@Test
	public void DB�׽�Ʈ() throws Exception{
		System.out.println("ds: " + ds);
		System.out.println("sqlSessionTemplate: " + sqlSessionTemplate);
		
		assertNotNull(ds); // ds�� null�̸� ����
	}
	
	@Ignore
	@Test
	public void �Խ��ǻ���ȸ() throws Exception{
		List<BoardVO> list = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAll");
		assertNotNull(list);
		for (BoardVO e: list) {
			System.out.println(e.toString());
		}
	}
}
