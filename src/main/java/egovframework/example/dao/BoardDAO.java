package egovframework.example.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardDAO {

	List<Map> getBoards() throws Exception;

	List<Map> getBoardsByDepth(int depth);

	List<Map> getBoardsChildrenCnt();

}
