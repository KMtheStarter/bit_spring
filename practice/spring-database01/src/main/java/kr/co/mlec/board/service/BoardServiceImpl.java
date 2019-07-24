package kr.co.mlec.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = boardDAO.selectAll(); // BoardDAO가 BoardDAOImple 이라는걸 어떻게 아는건가.
		return list;
	}

	public void insertBoard(BoardVO vo) {
		boardDAO.insert(vo);
	}

	@Override
	public BoardVO selectByNoBoard(int no) {
		BoardVO vo = boardDAO.selectByNo(no);
		return vo;
	}

	
	
}