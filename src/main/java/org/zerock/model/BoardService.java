package org.zerock.model;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;

public interface BoardService {
	
	public void register(BoardVO board);
	public List<BoardVO> getList(Criteria cri);
	public BoardVO get(Long bno);
	public boolean modify(BoardVO board);
	public boolean delete(Long bno);
	
	
	public int getTotal(Criteria cri);

	public void insert(MemberVO member);
	
}
