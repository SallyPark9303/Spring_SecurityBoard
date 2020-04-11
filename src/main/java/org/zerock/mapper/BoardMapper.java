package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;

public interface BoardMapper {
	//추가
	//전체보기
	//상세보기
	//수정
	//삭제
	//개수
	public void insert(BoardVO board);
	//@Select("select *form tbl_board where bno>0")
	public Integer insertSelectKey(BoardVO board);
	public List<BoardVO> getListWithPaging(Criteria cri);
	public List<BoardVO> getList();
	public BoardVO get(Long bno);
	public int modify(BoardVO board);
	public int delete(Long bno);
	public int getCount(Criteria cri);
	public MemberVO insert(MemberVO member);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
