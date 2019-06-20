package cn.sjxy.book.web.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sjxy.book.domain.Books;
import cn.sjxy.book.service.AdminService;
import cn.sjxy.book.service.BooksService;
import cn.sjxy.book.service.ItemService;

@Controller
public class BooksHandler {

	@Autowired
	private ItemService iService;

	public ItemService getiService() {
		return iService;
	}

	public void setiService(ItemService iService) {
		this.iService = iService;
	}
	
	@Autowired
	private AdminService aService;

	public AdminService getaService() {
		return aService;
	}

	public void setaService(AdminService aService) {
		this.aService = aService;
	}
	
	
	@Autowired
	private BooksService bService;

	public BooksService getbService() {
		return bService;
	}

	public void setbService(BooksService bService) {
		this.bService = bService;
	}
	
	@RequestMapping(value="/addB",method= RequestMethod.GET)
	public String addB(Map<String,Object> map,HttpServletRequest request) {
		map.put("admins",aService.selectAll() );
		map.put("items",iService.selectAll() );
		return "addB";
	}
	@RequestMapping(value="/addBook",method= RequestMethod.GET)
	public String showEmps(Books books,HttpServletRequest request) {
		String msg="";
		String name=books.getName();
		String note=books.getNote();
		Integer iid=books.getIid();
		String aid=books.getAid();
		if(name!=null && name!="" && note!=null && note!="" && iid!=0 && aid!=null && aid!="") {
			 bService.saveBook(books);
			 msg="添加成功！";
		}else {
			msg="存在未填信息！";
		}
		request.setAttribute("msg",msg);
        request.setAttribute("url","addB1.jsp");
        return "forward";
		 
	}
	
	@RequestMapping(value="/showBooks",method=RequestMethod.GET)
	public String showEmps(@RequestParam(value="pn",required=false,defaultValue="1")Integer pn,HttpServletRequest request,Map<String,Object>map) {
		PageHelper.startPage(pn, 9);
		PageInfo pageInfo = new PageInfo(bService.selectB());
		
		
		map.put("pageInfo", pageInfo);
		return "showBooks";
	
	}
	
	
	@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
	public String deleteBook(@RequestParam(value="bid",required=false,defaultValue="1")Integer bid,HttpServletRequest request) {
		String msg="";
		if(bid!=0) {
			bService.deleteB(bid);
			msg="删除成功！";
		}else {
			msg="删除失败！";
		}
		
		request.setAttribute("msg",msg);
        request.setAttribute("url","deleBook.jsp");
        return "forward";
	
	}
}
