package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.dto.BoardDto;
import com.lec.ch11.service.*;
import com.lec.ch11.util.Paging;

@Controller
@RequestMapping("mvcBoard") // 공통요청경로
public class MvcBoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="list")
	public String list(String pageNum, Model model) {
		// mvcBoard/list.do
		// mvcBard/list.do?pageNum=10
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.boardTotCnt(), pageNum, 10, 10));
		return "mvcBoard/list";
	}
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "mvcBoard/write";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(BoardDto boardDto, HttpServletRequest request, Model model) {
		// request : 서비스단에서 ip추출 용도
		try {
			model.addAttribute("request", request);
			model.addAttribute("writeResult", boardService.boardWrite(boardDto));
		} catch (Exception e) {
			model.addAttribute("writeResult", "필드값이 너무 길어 등록 불가");
			return "forward:write.do";
		}
		return "forward:list.do";
	}
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(int bid, Model model) {
		model.addAttribute("boardDto", boardService.boardDetail(bid));
		return "mvcBoard/content";
	}
	@RequestMapping(value="content", method=RequestMethod.POST)
	public String content_post(int bid, Model model) {
		model.addAttribute("boardDto", boardService.boardDetail(bid));
		return "mvcBoard/content";
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modify(int bid, Model model) {
		model.addAttribute("boardDto", boardService.boardDetail(bid));
		return "mvcBoard/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(BoardDto boardDto, HttpServletRequest request, Model model) {
		model.addAttribute("modifyResult", boardService.boardModify(boardDto));
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("boardDto", boardService.boardDetail(bid));
		return "mvcBoard/reply";
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(BoardDto boardDto, Model model, HttpServletRequest request) {
		model.addAttribute("replyResult", boardService.boardReply(boardDto));
		return "forward:list.do";
	}
}
