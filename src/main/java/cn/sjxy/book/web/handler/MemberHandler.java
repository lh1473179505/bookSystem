package cn.sjxy.book.web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cn.sjxy.book.domain.Member;
import cn.sjxy.book.service.MemberService;

@Controller

public class MemberHandler {

	@Autowired
	private MemberService mService;
	public MemberService getmService() {
		return mService;
	}
	public void setmService(MemberService mService) {
		this.mService = mService;
	}
	@RequestMapping(value="/addMember",method= RequestMethod.GET)
	
	public String addM(Member member,HttpServletRequest request) {
		String msg="";

		String mid=member.getMid();
		String name=member.getName();
		Integer age=member.getAge();
		Integer sex=member.getSex();
		String phone=member.getPhone();
		
		if(mid!=null && mid!="" && name!=null && name!="" && age!=0 && (sex==1 || sex==2) && phone!=null && phone!="") {
			if(mService.findMember(mid)!=null) {msg = "用户名重复！";}
			else {
				mService.saveMember(member);
				msg = "成员添加成功！";
			}
			
		}else {
			msg = "存在未填信息！";
		}	
		request.setAttribute("msg",msg);
        request.setAttribute("url","addMember.jsp");
        return "forward";
	
	}
	
	@RequestMapping(value="/addMem",method= RequestMethod.GET)
	public String add(HttpServletRequest request) {
		return "redirect:/addMember.jsp";
	}
	
}
