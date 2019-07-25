package kr.co.mlec.member.dao;

import java.util.List;

import kr.co.mlec.member.vo.MemberVO;

public interface MemberDAO {

	public void insert(MemberVO vo);
	public List<MemberVO> selectAll();
	public MemberVO selectById(String id);
	public MemberVO login(MemberVO vo);
}
