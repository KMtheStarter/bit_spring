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
	private SqlSessionTemplate sst;
	
	public List<BoardVO> selectAll() {
		List<BoardVO> list = sst.selectList("board.dao.BoardDAO.selectAll");
		// .close()�� �ڵ����� ��;;;
		return list;
	}

}
