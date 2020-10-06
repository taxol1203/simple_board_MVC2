package com.myp.persistence;

import java.util.List;
import com.myp.domain.BoardVO;
import com.myp.domain.Criteria;

// DAO (Data Access Object) : 데이터 접근 객체 
// 서비스 <-> DAO <-> Mapper
public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;
	
	public void updateViewCnt(Integer bno) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;

}


