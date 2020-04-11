package org.zerock.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired )
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired )
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}
	
	@Transactional
	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		ReplyVO vo = mapper.read(rno);
		System.out.println(vo.getBno());
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return mapper.getlistWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return new ReplyPageDTO(
				mapper.getConutByBno(bno),
				mapper.getlistWithPaging(cri, bno));
	}


}
