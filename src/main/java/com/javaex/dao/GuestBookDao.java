package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// guestbook 삭제
	public int delete(GuestBookVo vo) {
		System.out.println("dao"+vo);
		int count = sqlSession.delete("guestbook.delete", vo);
		return count;
	}
	
	// guestbook 저장
	public int insert(GuestBookVo guestBookVo) {
		System.out.println(guestBookVo.toString());
		int count = sqlSession.insert("guestbook.insert", guestBookVo);
		return count;
	}
	
	// guestbook 리스트
	public List<GuestBookVo> getList() {
		List<GuestBookVo> guestList = sqlSession.selectList("guestbook.selectList");
		System.out.println(guestList.toString());
		return guestList;
	}
	
}
