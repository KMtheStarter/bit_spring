package kr.co.mlec.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void insert(MemberVO vo) {
		ss.insert("member.dao.MemberDAO.insert", vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = ss.selectList("member.dao.MemberDAO.selectAll");
		return list;
	}

	@Override
	public MemberVO selectById(String id) {
		MemberVO vo = ss.selectOne("member.dao.MemberDAO.selectById", id);
		return vo;
	}

	
	
}
