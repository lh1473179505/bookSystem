package cn.sjxy.book.web.handler;

import java.util.List;
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

import cn.sjxy.book.domain.Item;
import cn.sjxy.book.service.ItemService;

@Controller
public class ItemHandler {

	@Autowired
	private ItemService iService;

	public ItemService getiService() {
		return iService;
	}

	public void setiService(ItemService iService) {
		this.iService = iService;
	}
	
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public String showEmps(@RequestParam(value="pn",required=false,defaultValue="1")Integer pn,HttpServletRequest request,Map<String,Object>map) {
		PageHelper.startPage(pn, 9);
		PageInfo pageInfo = new PageInfo(iService.selectAll());
		
		
		map.put("pageInfo", pageInfo);
		return "item_list";
		
	}
	@RequestMapping(value="/addItem",method=RequestMethod.GET)
	public String addItem(Item item,HttpServletRequest request) {
		String msg="";
		String name=item.getName();
		String note=item.getNote();
		if(name!=null && name!="" && note!=null &note!="") {
			iService.addItem(item);
			msg="添加成功";
		}else {
			msg="名称和内容不能为空";
		}
		
		request.setAttribute("msg",msg);
        request.setAttribute("url","addItem.jsp");
        return "forward";
		
	}
	
	
	
	@RequestMapping(value="/addIM",method= RequestMethod.GET)
	public String addI(HttpServletRequest request){
		return "redirect:/addItem.jsp";
	}
	
	@RequestMapping(value="/deleteIM",method= RequestMethod.GET)
	public String deleteIM(@RequestParam(value="iid",required=false,defaultValue="1")Integer iid,HttpServletRequest request){
		String msg="";
		if(iid!=0) {
			iService.delete(iid);
			msg="删除成功！";
		}else {
			msg="删除失败！";
		}
		
		request.setAttribute("msg",msg);
        request.setAttribute("url","deleItem.jsp");
        return "forward";
	
	}
	
}
