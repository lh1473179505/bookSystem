package cn.sjxy.book.web.handler;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sjxy.book.domain.Admin;
import cn.sjxy.book.service.AdminService;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService aService;

	public AdminService getaService() {
		return aService;
	}

	public void setaService(AdminService aService) {
		this.aService = aService;
	}
	@RequestMapping(value="/addAdmin",method=RequestMethod.GET)
	public String addAdmin(Admin admin,HttpServletRequest request) {
		
		String msg="";
		String aid=request.getParameter("aid");
		String password=request.getParameter("password");
		
		
		if(aid!=null && aid!="" && password!=null && password!="") {
			if(aService.findA(aid)!=null) {
				msg = "用户名重复！";
			} else {
				admin.setAid(aid);
				admin.setPassword(password);
				aService.insertAdmin(admin);
				 msg = "管理员注册成功！";
			}
			
		}else {msg = "账号或密码不能为空";}
		
		request.setAttribute("msg",msg);
        request.setAttribute("url","addAdmin.jsp");
        return "forward";
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		String msg="";
		
	         //清除session
	        
	        //重定向到登录页面的跳转方法
	         msg="你还没登录，想干嘛？昂？？！";
	         request.setAttribute("msg",msg);
		        request.setAttribute("url","index1.jsp");
		        return "forward";
		
		
	}
    
	 
}
