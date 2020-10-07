package com.myp.controller;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.domain.BoardVO;
import com.myp.domain.Criteria;
import com.myp.domain.PageMaker;
import com.myp.domain.SearchCriteria;
import com.myp.service.BoardService;

@Controller
@RequestMapping(value = "/")
public class BoardController {
	@Inject
	private BoardService service;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		//System.out.println(service.listAll());
		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET) // GET 방식으로 페이지 호출
	public void registerGET(BoardVO board, Model model) throws Exception {
	}

	@RequestMapping(value = "/regist_proc", method = RequestMethod.POST) // POST방식으로 내용 전송
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용
		//System.out.println(board.getTitle() + " " + board.getWriter() + " " + board.getContent());
		/*SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = format1.format(time);
		
		board.setRegdate(time1);
		board.setViewcnt(1);*/
		
		board.setRegdate(new Date());
		service.regist(board); // 글작성 서비스 호출
		return "redirect:/listPage"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	//글 읽기
	@RequestMapping(value = "/read", method = RequestMethod.GET) // GET 방식으로 페이지 호출
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	//글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET) // GET 방식으로 페이지 호출
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	@RequestMapping(value = "/modify_ok", method = RequestMethod.POST) // POST 방식으로 데이터 전송
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		service.modify(board);
		
		return "redirect:/listPage";
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)// POST방식으로 데이터 전송
	public String removePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno); // 글삭제 서비스 호출
		return "redirect:/listPage"; // 삭제가 완료된 후, 목록페이지로 리턴
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
	    model.addAttribute("list", service.listCriteria(cri)); // JSP에 계산된 페이징 출력
	    PageMaker pageMaker = new PageMaker(); // 객체생성
	    pageMaker.setCri(cri); // setCri 메소드 사용
	    pageMaker.setTotalCount(service.listCountCriteria(cri)); // 전체 게시글 갯수 카운트
	    model.addAttribute("pageMaker", pageMaker);
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	  public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
	    model.addAttribute("list", service.listSearchCriteria(cri)); //전체목록에 검색페이징 기능+
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(service.listSearchCount(cri));//전체목록에 검색페이징 카운트+
	    model.addAttribute("pageMaker", pageMaker);
	  }
}
