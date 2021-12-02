package egovframework.example.service;

import java.util.List;
import java.util.Map;

import egovframework.example.dto.Member;

public interface MemberService {

	Map<String,Object> getMemberByMemberId(String memberId);

	List<Map> getMemberByMemberNames(String memberName);

	int getMemberByMemberEmailCount(String memberEmail);

	Map<String, Object> getMemberByMemberNickname(String memberNickname);

	void doJoin(Map<String, Object> param);

	Member doLoginCheck(Map<String, Object> param);

	Map<String, Object> getMemberByMemberName(String memberName);

	Map<String, Object> getMemberById(Integer changeMemberId);
}
