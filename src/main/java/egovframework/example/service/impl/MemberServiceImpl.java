package egovframework.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import egovframework.example.dao.MemberDAO;
import egovframework.example.dto.Member;
import egovframework.example.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDAO")
	private MemberDAO memberDAO;

	@Override
	public Map<String, Object> getMemberByMemberId(String memberId) {
		return memberDAO.getMemberByMemberId(memberId);
	}

	@Override
	public List<Map> getMemberByMemberNames(String memberName) {
		return memberDAO.getMemberByMemberNames(memberName);
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

		String memberPw = (String) param.get("member_pw");

		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();

		String securityPassword = pwEncoder.encode(memberPw);

		param.put("member_pw", securityPassword);

		memberDAO.doJoin(param);
	}

	@Override
	public Member doLoginCheck(Map<String, Object> param) {
		return memberDAO.doLoginCheck(param);
	}

	@Override
	public Map<String, Object> getMemberByMemberName(String memberName) {
		return memberDAO.getMemberByMemberName(memberName);
	}

	@Override
	public Map<String, Object> getMemberById(Integer changeMemberId) {
		return memberDAO.getMemberById(changeMemberId);
	}
}
