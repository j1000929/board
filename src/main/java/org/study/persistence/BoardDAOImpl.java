package org.study.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	private static String namespace="org.study.mappers.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception{
		
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return session.selectOne(namespace+".read", bno);
	}
	
	@Override
	public void update(BoardVO vo) throws Exception{
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(Integer bno) throws Exception{
		session.delete(namespace+".delete", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}
}
