package egovframework.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import egovframework.example.dao.MemberDAO;
import egovframework.example.dto.Member;
import egovframework.example.service.MemberService;
import egovframework.example.util.Util;

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

		String memberPw = (String) param.get("memberPw");

		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();

		String securityPassword = pwEncoder.encode(memberPw);

		param.put("memberPw", securityPassword);

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

	@Override
	public Map<String, Object> getMemberByMemberNameAndEmail(Map<String, Object> param) {
		return memberDAO.getMemberByMemberNameAndEmail(param);
	}

	@Override
	public String checkJoinMember(Map<String, Object> param) {
		
		String memberName = (String) param.get("memberName");
		String memberPhoneNumber = (String) param.get("memberPhoneNumber");
		String memberId = (String) param.get("memberId");
		String memberPw = (String) param.get("memberPw");
		String memberPwConfirm = (String) param.get("memberPwConfirm");
		String memberEmail = (String) param.get("memberEmail");
		String memberBirth = (String) param.get("memberBirth");
		String gender = (String) param.get("gender");
		
		memberPhoneNumber.replaceAll("-", "");
		memberPhoneNumber.replaceAll(" ", "");
		
		if(memberName == null || memberName.equals("") ) {
			return "성명을 입력해주세요.";
		} else if(memberPhoneNumber == null || memberPhoneNumber.equals("")) {
			return "휴대폰 번호를 입력해주세요.";
		} else if(memberId == null || memberId.equals("")) {
			return "아이디를 입력해주세요.";
		} else if(memberPw == null || memberPw.equals("")) {
			return "패스워드를 입력해주세요.";
		} else if(memberPwConfirm == null || memberPwConfirm.equals("")) {
			return "패스워드 확인을 입력해주세요.";
		} else if(memberEmail == null || memberEmail.equals("")) {
			return "이메일을 입력해주세요.";
		} else if(memberBirth == null || memberBirth.equals("")) {
			return "생일을 입력해주세요.";
		} else if(gender == null || gender.equals("")) {
			return "성별을 입력해주세요.";
		} 
		
		boolean isName = memberName.matches("^[a-zA-Z가-힣]*$");
		boolean isPhoneNumber = memberPhoneNumber.matches("\\d{11}");
		boolean isId = memberId.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{5,13}$");
		boolean isPassword = memberPw.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,19}$");
		boolean isEmail = memberEmail.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
		
		if ( isName == false ) {
			return  "성명에는 이름, 영어 외 문자가 들어갈 수 없습니다.";
		} else if(isPhoneNumber == false) {
			return  "휴대전화 번호 양식을 지켜주세요(- 제외)";
		} else if(isId == false) {
			return  "아이디에는 특수문자가 포함되지 않은 영어 및 숫자로 6자 이상이어야 합니다.(숫자로 시작 불가능)";
		} else if(isPassword == false) {
			return  "비밀번호는 영문과 특수문자 숫자를 포함하며 8자 이상 18자 이하여야 합니다.";
		} else if(isEmail == false) {
			return  "이메일 양식을 지켜주세요.";
		}
		
		Map<String, Object> member = memberDAO.getMemberByMemberId(memberId);
		
		if ( member != null ) {
			return "이미 사용중인 아이디 입니다.";
		}
		
		return "S-1, 회원가입을 축하합니다.";
	}

	@Override
	public Map<String, Object> getMemberByIdAndEmailAndBirth(Map<String, Object> param) {
		return memberDAO.getMemberByIdAndEmailAndBirth(param);
	}
}
