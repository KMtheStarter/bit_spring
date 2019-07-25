package kr.co.mlec.member.service;

import java.util.List;

import kr.co.mlec.member.vo.MemberVO;

public interface MemberService {

	public void insertMember(MemberVO vo);
	public List<MemberVO> selectAllMember();
	public MemberVO selectByIdMember(String id);
	public MemberVO loginMember(MemberVO vo);
}
