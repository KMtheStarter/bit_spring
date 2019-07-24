package kr.co.mlec.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.board.vo.BoardVO;

/*
 * ����Ŭ�� �Խ��� CRUD(myBatis ����)
*/
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	public List<BoardVO> selectAll() {
		List<BoardVO> list = ss.selectList("board.dao.BoardDAO.selectAll");
		// .close()�� �ڵ����� ��;;;
		return list;
	}

	public void insert(BoardVO vo) {
		ss.insert("board.dao.BoardDAO.insert", vo);
	}

	@Override
	public BoardVO selectByNo(int no) {
		BoardVO vo = ss.selectOne("board.dao.BoardDAO.selectByNo", no);
		return vo;
	}
	
	
}
