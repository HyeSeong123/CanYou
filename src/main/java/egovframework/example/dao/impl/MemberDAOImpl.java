package egovframework.example.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.dao.MemberDAO;
import egovframework.example.dto.Member;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	@Resource(name="sqlSession")
	private SqlSession query;

	@Override
	public Map<String,Object> getMemberByMemberId(String memberId) {
		return query.selectOne("getMemberByMemberId", memberId);
	}

	@Override
	public List<Map> getMemberByMemberNames(String memberName) {
		return query.selectList("getMemberByMemberNames", memberName);
	}

	@Override
	public int getMemberByMemberEmailCount(String memberEmail) {
		return query.selectOne("getMemberByMemberEmailCount", memberEmail);
	}

	@Override
	public Map<String, Object> getMemberByMemberNickname(String memberNickname) {
		return query.selectOne("getMemberByMemberNickname", memberNickname);
	}

	@Override
	public void doJoin(Map<String, Object> param) {
		query.insert("doJoin" , param);
	}

	@Override
	public Member doLoginCheck(Map<String, Object> param) {
		return query.selectOne("doLoginCheck", param);
	}

	@Override
	public Map<String, Object> getMemberByMemberName(String memberName) {
		return query.selectOne("getMemberByMemberName", memberName);
	}
}
