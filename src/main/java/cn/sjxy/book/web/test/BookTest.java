package cn.sjxy.book.web.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sjxy.book.domain.Admin;
import cn.sjxy.book.domain.Item;
import cn.sjxy.book.domain.Member;
import cn.sjxy.book.service.AdminService;
import cn.sjxy.book.service.ItemService;
import cn.sjxy.book.service.MemberService;

public class BookTest {

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Member member = new Member();
		member.setMid("10001");
		member.setName("zhangsan");
		member.setAge(15);
		member.setSex(1);
		member.setPhone("12345678977");
		
		MemberService mService=context.getBean("memberService",MemberService.class);
		mService.saveMember(member);
	}
	
	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Admin admin = new Admin();
		admin.setAid("gouzi");
		admin.setPassword("1292C16E82D2EA2AC8A7767BA29031E2");
		admin.setLastdate(null);
		admin.setFlag(2);
		admin.setStatus(1);
		AdminService aService=context.getBean("adminService",AdminService.class);
		//aService.insertAdmin(admin);
	}
	
	@Test
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Item item=new Item();
		item.setName("javaEE");
		item.setNote("from going into a door to abundon!");
		
		
		ItemService iService=context.getBean("itemService",ItemService.class);
		iService.addItem(item);
	}
	@Test
	public void testFindAllItem() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		
		
		ItemService iService=context.getBean("itemService",ItemService.class);
		List<Item> items=iService.selectAll();
		for(Item item : items ) {
			System.out.println(item);
		}
	}
	
	@Test
	public void testfenye() {
		PageHelper.startPage(3, 5);
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		
		
		ItemService iService=context.getBean("itemService",ItemService.class);
		List<Item> list=iService.selectAll();
		PageInfo pageInfo=new PageInfo(list);
		
		List<Item> items=pageInfo.getList();
		for(Item item : items ) {
			System.out.println(item);
		}
	}
}
