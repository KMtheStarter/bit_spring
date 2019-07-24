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
	public void �Խñ۵���׽�Ʈ() throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setWriter("������");
		vo.setTitle("�׽�Ʈ");
		vo.setContent("����");
		
		// Ʈ������� ���� �׽�Ʈ������ ������ �ȵǰ� �ؾ�������... �׳� ��.
		ss.insert("board.dao.BoardDAO.insert", vo);
	}
	
	@Ignore
	@Test
	public void �Խñ���ȸ�׽�Ʈ() throws Exception{
		BoardVO vo = ss.selectOne("board.dao.BoardDAO.selectByNo", 1);
		System.out.println(vo);
	}
	
	@Test
	public void �Խñ���ȸDAO�׽�Ʈ() throws Exception{
		BoardVO vo = boardDAO.selectByNo(5);
		System.out.println(vo);
	}
}
