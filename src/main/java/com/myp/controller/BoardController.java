package com.myp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.domain.BoardVO;
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
		return "redirect:/listAll"; // 작성이 완료된 후, 목록페이지로 리턴
	}
}
