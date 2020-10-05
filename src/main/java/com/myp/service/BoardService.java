package com.myp.service;

import java.util.List;

import com.myp.domain.BoardVO;

//서비스를 위한 인터페이스
public interface BoardService {
	  public void regist(BoardVO board) throws Exception;
	  public BoardVO read(Integer bno) throws Exception;
	  public void modify(BoardVO board) throws Exception;
	  public void remove(Integer bno) throws Exception;
	  public List<BoardVO> listAll() throws Exception;
}
