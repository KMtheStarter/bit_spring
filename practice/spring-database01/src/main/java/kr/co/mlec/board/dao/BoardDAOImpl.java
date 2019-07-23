package kr.co.mlec.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.board.vo.BoardVO;

/*
 * 오라클용 게시판 CRUD(myBatis 적용)
*/
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public List<BoardVO> selectAll() {
		List<BoardVO> list = sst.selectList("board.dao.BoardDAO.selectAll");
		// .close()도 자동으로 됨;;;
		return list;
	}

}
