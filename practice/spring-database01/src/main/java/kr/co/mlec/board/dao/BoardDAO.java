package kr.co.mlec.board.dao;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

/*
 * database을 통한 게시글 CRUD
*/
public interface BoardDAO {

	/* 
	 * 전체 게시글 조회서비스
	 * return 전체게시글 
	 */
	public List<BoardVO> selectAll();
}
