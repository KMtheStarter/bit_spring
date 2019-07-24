package kr.co.mlec;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/**/*.xml"})
public class BoardTest {

	@Autowired
	private SqlSessionTemplate ss;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Ignore
	@Test
	public void 게시글등록테스트() throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setWriter("관리자");
		vo.setTitle("테스트");
		vo.setContent("내용");
		
		// 트랜잭션을 통해 테스트에서는 삽입이 안되게 해야하지만... 그냥 함.
		ss.insert("board.dao.BoardDAO.insert", vo);
	}
	
	@Ignore
	@Test
	public void 게시글조회테스트() throws Exception{
		BoardVO vo = ss.selectOne("board.dao.BoardDAO.selectByNo", 1);
		System.out.println(vo);
	}
	
	@Test
	public void 게시글조회DAO테스트() throws Exception{
		BoardVO vo = boardDAO.selectByNo(5);
		System.out.println(vo);
	}
}
