package kr.co.mlec.board.dao;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

/*
 * database�� ���� �Խñ� CRUD
*/
public interface BoardDAO {

	/* 
	 * ��ü �Խñ� ��ȸ����
	 * return ��ü�Խñ� 
	 */
	public List<BoardVO> selectAll();
	
	/*
	 * �Խñ� ��� ����
	*/
	public void insert(BoardVO vo);
	
	/*
	 * �Խñ� ��ȸ ����
	*/
	public BoardVO selectByNo(int no);
}
