package kr.co.myBatis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.co.myBatis.MyConfig;

public class BoardDAO {

	private SqlSession ss;
	
	public BoardDAO() {
		ss = MyConfig.getInstance().openSession();
		System.out.println("session: " + ss);
	}
	
	public void work() {
		// insert();
		// select();
		// selectOne();
		// selectNos();
		selectWhere();
	}
	
	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("즈에목2");
		board.setWriter("즈악성즈아2");
		board.setContent("느이애이용2");
		
		ss.insert("kr.co.myBatis.dao.BoardDAO.insertBoard", board);
		ss.commit();
		ss.close();
		System.out.println("등록 완료");
	}
	
	private void select() {
		List<BoardVO> list = ss.selectList("kr.co.myBatis.dao.BoardDAO.selectBoard");
		for(BoardVO e: list) {
			System.out.println(e.toString());
		}
		ss.close();
	}
	
	private void selectOne() {
		// n번 게시물 조회
		Scanner sc = new Scanner(System.in);
		// ss.selectOne("kr.co.myBatis.dao.BoardDAO.selectOneBoard", vo);
		System.out.println(ss.selectOne("kr.co.myBatis.dao.BoardDAO.selectOneBoard", Integer.parseInt(sc.nextLine())).toString());
		ss.close();
	}
	
	private void selectNos() {
		int [] nos = {1, 2, 5, 6};
		BoardVO vo = new BoardVO();
		vo.setNos(nos);
//		List<BoardVO> list = ss.selectList("kr.co.myBatis.dao.BoardDAO.selectNos", vo);
//		List<BoardVO> list = ss.selectList("kr.co.myBatis.dao.BoardDAO.selectNos2", nos);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(5);
		list2.add(6);
		List<BoardVO> list = ss.selectList("kr.co.myBatis.dao.BoardDAO.selectNos3", list2);
		for(BoardVO e: list) {
			System.out.println(e);
		}
	}
	
	private void selectWhere() {
		BoardVO vo = new BoardVO();
		vo.setTitle("aaa");
//		vo.setWriter("ccc");
		List<BoardVO> list = ss.selectList("kr.co.myBatis.dao.BoardDAO.selectWhere", vo);
		for(BoardVO e: list) {
			System.out.println(e);
		}
	}
}
