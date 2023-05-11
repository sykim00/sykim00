package com.lec.ch11.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;
import com.lec.ch11.util.Paging;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardDto> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.boardTotCnt(), pageNum, 10, 10);
		BoardDto board = new BoardDto();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}
	@Override
	public int boardTotCnt() {
		return boardDao.boardTotCnt();
	}
	@Override
	public int boardWrite(BoardDto boardDto) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		boardDto.setBip(request.getRemoteAddr());
		return boardDao.boardWrite(boardDto);
	}
	@Override
	public void boardHitUp(int bid) {
		boardDao.boardHitUp(bid);
	}
	@Override
	public BoardDto boardDetail(int bid) {
		boardHitUp(bid);
		return boardDao.boardDetail(bid);
	}
	@Override
	public int boardReplyPreStep(BoardDto boardDto) {
		return boardDao.boardReplyPreStep(boardDto);
	}
	@Override
	public int boardReply(BoardDto boardDto) {
		boardReplyPreStep(boardDto);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		boardDto.setBip(request.getRemoteAddr());
		return boardDao.boardReply(boardDto);
	}
	@Override
	public int boardModify(BoardDto boardDto) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		boardDto.setBip(request.getRemoteAddr());
		return boardDao.boardModify(boardDto);
	}
	@Override
	public int boardDelete(int bid) {
		return boardDao.boardDelete(bid);
	}
}
