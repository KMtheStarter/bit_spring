package kr.co.mlec.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insert(vo);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> list = memberDAO.selectAll();
		return list;
	}

	@Override
	public MemberVO selectByIdMember(String id) {
		MemberVO vo = memberDAO.selectById(id);
		return vo;
	}

	
	
}
