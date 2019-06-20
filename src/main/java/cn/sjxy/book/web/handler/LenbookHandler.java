package cn.sjxy.book.web.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sjxy.book.domain.Books;
import cn.sjxy.book.domain.Lenbook;
import cn.sjxy.book.domain.Member;
import cn.sjxy.book.service.BooksService;
import cn.sjxy.book.service.LenbookService;
import cn.sjxy.book.service.MemberService;
@Controller
public class LenbookHandler {

	@Autowired
	private MemberService mService;
	public MemberService getmService() {
		return mService;
	}
	public void setmService(MemberService mService) {
		this.mService = mService;
	}
	@Autowired
	private BooksService bService;

	public BooksService getbService() {
		return bService;
	}

	public void setbService(BooksService bService) {
		this.bService = bService;
	}
	@Autowired
	private LenbookService Lservice;

	public LenbookService getLservice() {
		return Lservice;
	}

	public void setLservice(LenbookService lservice) {
		Lservice = lservice;
	}
	
	@RequestMapping(value="/addL",method=RequestMethod.GET)
	public String addL(Map<String,Object> map,HttpServletRequest request) {
		
		
		map.put("books",bService.selectB());
		
		map.put("members",mService.findM());
		
	return "lenbook_insert";	
	}
	
	@RequestMapping(value="/addLen",method=RequestMethod.GET)
	public String addLen(Lenbook lenbook,HttpServletRequest request) {
		String msg="";
		Integer bid=lenbook.getBid();
		String mid=lenbook.getMid();
		if(bid!=0 && mid!=null && mid!="") {
			Lservice.addLenbook(lenbook);
			msg="增加成功！";
		}else {
			msg="信息不能为空！";
		}
		request.setAttribute("msg",msg);
        request.setAttribute("url","addL.jsp");
        return "forward";
		
		
		
	}
	
	@RequestMapping(value="/findLen",method=RequestMethod.GET)
	public String showEmps(@RequestParam(value="pn",required=false,defaultValue="1")Integer pn,Map<String,Object>map,HttpServletRequest request) {
	
		PageHelper.startPage(pn, 9);
		PageInfo pageInfo = new PageInfo(Lservice.select());
		map.put("pageInfo", pageInfo);
		return "lenbook_list";
	}
	
	@RequestMapping(value="/updateL",method=RequestMethod.GET)
	public String updateLen(@RequestParam(value="leid",required=false,defaultValue="1")Integer leid,Map<String,Object>map,HttpServletRequest request) {
		String msg="";
		if(leid!=0) {
			
			Lservice.updateL(leid);
			msg="还书成功！";
		}else {
			msg="还书失败！";
		}
		request.setAttribute("msg",msg);
        request.setAttribute("url","showL.jsp");
        return "forward";
		
		
	}
}
