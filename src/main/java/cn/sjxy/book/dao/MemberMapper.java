package cn.sjxy.book.dao;

import java.util.List;

import cn.sjxy.book.domain.Member;

public interface MemberMapper {

	public void addMember(Member member);
	public List<Member> findAll();
	public Member findById(String mid);
}
