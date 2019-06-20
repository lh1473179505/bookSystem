package cn.sjxy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.book.dao.MemberMapper;
import cn.sjxy.book.domain.Member;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	public void saveMember(Member member) {
		
		memberMapper.addMember(member);
	}
	
	public List<Member> findM(){
		return memberMapper.findAll();
	}
	
	public Member findMember(String mid) {
		return memberMapper.findById(mid);
	}
}
