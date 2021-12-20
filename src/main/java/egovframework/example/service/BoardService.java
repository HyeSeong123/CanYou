package egovframework.example.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map> getBoards() throws Exception;

	List<Map> getBoardsByDepth(int depth);

	List<Map> getBoardsChildrenCnt();

}
