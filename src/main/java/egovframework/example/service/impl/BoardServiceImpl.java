package egovframework.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.dao.BoardDAO;
import egovframework.example.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<Map> getBoards() throws Exception {
		return boardDAO.getBoards();
	}

	@Override
	public List<Map> getBoardsByDepth(int depth) {
		return boardDAO.getBoardsByDepth(depth);
	}

	@Override
	public List<Map> getBoardsChildrenCnt() {
		return boardDAO.getBoardsChildrenCnt();
	}

}
