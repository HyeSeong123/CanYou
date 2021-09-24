package egovframework.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.dao.MemberDAO;
import egovframework.example.dto.Member;
import egovframework.example.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDAO")
	private MemberDAO memberDAO;

	@Override
	public Map<String,Object> getMemberByMemberId(String memberId) {
		return memberDAO.getMemberByMemberId(memberId);
	}

	@Override
	public List<Map> getMemberByMemberName(String memberName) {
		return memberDAO.getMemberByMemberName(memberName);
	}

	@Override
	public int getMemberByMemberEmailCount(String memberEmail) {
		return memberDAO.getMemberByMemberEmailCount(memberEmail);
	}

	@Override
	public Map<String, Object> getMemberByMemberNickname(String memberNickname) {
		return memberDAO.getMemberByMemberNickname(memberNickname);
	}

	@Override
	public void doJoin(Map<String, Object> param) {
		memberDAO.doJoin(param);
	}

	@Override
	public Member doLoginCheck(Map<String, Object> param) {
		return memberDAO.doLoginCheck(param);
	}
	
}