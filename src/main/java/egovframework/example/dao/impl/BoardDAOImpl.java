package egovframework.example.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.dao.BoardDAO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	@Resource(name="sqlSession")
	private SqlSession query;
	
	@Override
	public List<Map> getBoards() throws Exception {
		return query.selectList("getBoards");
	}

	@Override
	public List<Map> getBoardsByDepth(int depth) {
		return query.selectList("getBoardsByDepth", depth);
	}
}
