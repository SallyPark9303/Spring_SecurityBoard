package org.zerock.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.MemberMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private MemberMapper Mmapper; //

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.insertSelectKey(board);
		
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return mapper.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.modify(board) == 1;
		
	}

	@Override
	public boolean delete(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getCount(cri);
	}
@Transactional
@Override
	public void insert(MemberVO member) {
		// TODO Auto-generated method stub
		
		Mmapper.insert(member);
		Mmapper.authInsert(member.getUserid(),"ROLE_USER");  //암호화하는거와 회원가이봐는거는 같이 동작해야함.
		
		
	}




}
