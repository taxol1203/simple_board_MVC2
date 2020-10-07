package com.myp.service;

import java.util.List;

import com.myp.domain.BoardVO;
import com.myp.domain.Criteria;
import com.myp.domain.SearchCriteria;
import com.myp.persistence.BoardDAO;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/*
 Service : 유지보수와 로직프로세스를 유연하게 처리하기 위한 중간 단계.
  프레임워크 디자인패턴에 들어가며, 프로젝트 규모가 커질수록 관리하기 용이함
 controller -> service(interface) -> ServiceImpl -> dao 
*/
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
}
