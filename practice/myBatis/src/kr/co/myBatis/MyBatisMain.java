package kr.co.myBatis;

import kr.co.myBatis.dao.BoardDAO;

public class MyBatisMain {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		dao.work();
	}
}
