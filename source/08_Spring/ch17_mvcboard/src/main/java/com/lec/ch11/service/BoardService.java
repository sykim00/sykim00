package com.lec.ch11.service;
import java.util.List;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;
public interface BoardService {
	public List<BoardDto> boardList(String pageNum);
	public int boardTotCnt();
	public int boardWrite(BoardDto boardDto);
	public void boardHitUp(int bid);
	public BoardDto boardDetail(int bid);
	public int boardReplyPreStep(BoardDto boardDto);
	public int boardReply(BoardDto boardDto);
	public int boardModify(BoardDto boardDto);
	public int boardDelete(int bid);
}
