package com.myp.service;

import java.util.List;

import com.myp.domain.BoardVO;
import com.myp.domain.Criteria;

//서비스를 위한 인터페이스
public interface BoardService {
	  public void regist(BoardVO board) throws Exception;
	  public BoardVO read(Integer bno) throws Exception;
	  public void modify(BoardVO board) throws Exception;
	  public void remove(Integer bno) throws Exception;
	  public List<BoardVO> listAll() throws Exception;
	  public List<BoardVO> listCriteria(Criteria cri) throws Exception; // 페이징 계산용
	  public int listCountCriteria(Criteria cri) throws Exception; // DB의 데이터 카운팅을 위한 메소드
}
