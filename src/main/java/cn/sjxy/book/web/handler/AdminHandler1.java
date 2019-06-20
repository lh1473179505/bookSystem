package cn.sjxy.book.web.handler;


import java.awt.Window;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sjxy.book.domain.Admin;
import cn.sjxy.book.service.AdminService;
import cn.sjxy.book.service.AdminService1;


@Controller
public class AdminHandler1 {

	@Autowired
	private AdminService aService;
	
	public AdminService getaService() {
		return aService;
	}

	public void setaService(AdminService aService) {
		this.aService = aService;
	}

	@Autowired
	private AdminService1 adminService;

	public AdminService1 getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService1 adminService) {
		this.adminService = adminService;
	}
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "redirect:/login.jsp";
       
	}
	
	 @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
	 public String login(Admin admin, HttpSession session,Map<String,Object> map,HttpServletRequest request) throws Exception {
		 String msg="";
		 
		String aid=request.getParameter("aid");
		String password=request.getParameter("password");
		admin.setAid(aid);
		admin.setPassword(password);
		
		 if( adminService.getLogin(admin)==null) {
			 msg="连用户名和密码都能输错，有什么用！？？";
			 request.setAttribute("msg",msg);
			 request.setAttribute("url","login.jsp");
		        return "forward";
			
			 
			 
		 }else {
			 admin=aService.findA(aid);
			 adminService.findStatus(admin);
			 int status=admin.getStatus();
			 Date lastdate=admin.getLastdate();
			 int flag=admin.getFlag();
			 session.setAttribute("admin",admin);
			 if(aid!=null)session.setAttribute("aid",aid );
			 if(status==1)session.setAttribute("status",status );
			 if(lastdate!=null)session.setAttribute("lastdate", lastdate);
			 else {session.setAttribute("lastdate", "首次登录");}
			 if(flag==1)session.setAttribute("flag",flag );
			 adminService.updateTime(aid);
			 
			 msg="登陆成功，你还敢来！？？";
			 request.setAttribute("msg",msg);
		        request.setAttribute("url","index1.jsp");
		        return "forward";
			
		 }
		 
		 
    }
	 
	 @RequestMapping(value = "/logout",method = RequestMethod.GET)
	     public String logout(Admin admin,HttpSession session,HttpServletRequest request){
		String msg="";
		adminService.logoutStatus(admin.getAid());
	         //清除session
	         session.invalidate();
	        //重定向到登录页面的跳转方法
	         msg="退出成功！再来打死你！";
	         request.setAttribute("msg",msg);
		        request.setAttribute("url","login.jsp");
		        return "forward";
	         
	      }
	 
	
	
}
