package com.lec.ch11.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch11.dto.BoardDto;

@Mapper
public interface BoardDao {
	public List<BoardDto> boardList(BoardDto boardDto);
	public int boardTotCnt();
	public int boardWrite(BoardDto boardDto);
	public void boardHitUp(int bid);
	public BoardDto boardDetail(int bid);
	public int boardReplyPreStep(BoardDto boardDto);
	public int boardReply(BoardDto boardDto);
	public int boardModify(BoardDto boardDto);
	public int boardDelete(int bid);
}
