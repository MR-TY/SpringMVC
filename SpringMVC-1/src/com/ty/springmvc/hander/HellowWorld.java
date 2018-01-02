package com.ty.springmvc.hander;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springmvc.entitys.User;
@SessionAttributes({"user"})
@RequestMapping("/hi")
@Controller
public class HellowWorld {
	/**
	 * 1.使用requestMapping来映射请求
	 * 2.返回值会通过视图解析器解析为实际的视图，对于InternalResourceViewResolver视图解析器，会做如下的解析：
	 * <1:通过prefix+returnVal+后缀这样的方式得到实际的物理视图，然后做转发操作
	 * /WEB-INF/views/Success.jsp
	 */
	@RequestMapping("/helloWorld")
	public String helloWorld(){
		System.out.println("hello World");
		return "Success";
	}
	
	@RequestMapping(value="/helloWorld2",method=RequestMethod.POST)
	public String helloWorld1(){
		System.out.println("hello World");
		return "Success";
	}
	
	@RequestMapping(value="/helloWorld1/{id}")
	public String helloWorld1(@PathVariable("id") Integer id){
		System.out.println("hello World"+id);
		return "Success";
	}
	
	
	//--------------测试rest--------------------
	
	@RequestMapping(value="/TestREST/{id}", method = RequestMethod.PUT)
	public String helloWorld3(@PathVariable Integer id){
		System.out.println("this is PUT: "+id);
		return "Success";
	}
	
	@RequestMapping(value="/TestREST/{id}", method = RequestMethod.DELETE)
	public String helloWorld4(@PathVariable Integer id){
		System.out.println("this is DELETE: "+id);
		return "Success";
	}
	@RequestMapping(value="/TestREST", method = RequestMethod.POST)
	public String helloWorld5(){
		System.out.println("this is POST ");
		return "Success";
	}
	
	@RequestMapping(value="/TestREST/{id}",method = RequestMethod.GET)
	public String helloWorld6(@PathVariable Integer id){
		System.out.println("this is get: "+id);
		return "Success";
	}
	
	
	@RequestMapping(value="/RequestParam")
	public String helloWorld7(@RequestParam("username") String username,@RequestParam("age")Integer age){
		System.out.println("this is RequestParam: ");
		System.out.println("username="+username+"--------"+"age="+age);
		return "Success";
	}

	@RequestMapping(value="/CookieValue")
	public String helloWorld7(@CookieValue("JSESSIONID") String JSESSIONID){
		System.out.println("this is Cookie: "+ JSESSIONID);
		return "Success";
	}
	
	@RequestMapping(value="/TestPOJO")
	public String helloWorld8(User user){
		System.out.println("TestPojo:"+user);
		return "Success";
	}
	
	@RequestMapping(value="/TestServlet")
	public String helloWorld9(HttpServletRequest request,HttpServletResponse response){
		System.out.println("TestServlet, "+request+","+response);
		return "Success";
	}
	
	@RequestMapping(value="/TestModelAndView")
	public ModelAndView helloWorld10(){
		//包含视图信息，也包含模型数据
		ModelAndView modelAndView = new ModelAndView("Success");
		modelAndView.addObject("time",new Date());
		return modelAndView;
	}
	
	@RequestMapping(value="/TestMap")
	public String helloWorld11(Map<String, Object> map){
		map.put("name", Arrays.asList("tom","mike"));
		return "Success";
	}
	
//	@RequestMapping(value="/TestsessionAtrribute")
//	public String helloWorld12(Map<String, Object> map){
//		User user = new User("ty", "123", "1@11", 12);
//		map.put("user", user);
//		return "Success";
//	}
	/**
	 * 新创建了一个对象，没有进行修改的属性，就变成了空值
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/TestModelAttribute")
	public String helloWorld12(User user){
		System.out.println("修改："+user);
		return "Success";
	}
	
	/**
	 * 所以从数据库中获取的数据进行修改
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false)Integer id,Map<String, Object> map){
		if (id!=null) {
			//从数据库中获取数据
			User user = new User(1, "TOM", "123456", "@q123", 12);
			System.out.println("从数据库中获取一个对象"+user);
			map.put("user", user);
		}
	}
	
	
	@RequestMapping(value="/TestView")
	public String TestView(){
		System.out.println("测试view");
		return "helloView";//类名的第一个字母小写
	}
	
	@RequestMapping(value="/TestPage")
	public String TestView1(){
		System.out.println("测试重定向");
		return "forward:/NewFile.jsp";//类名的第一个字母小写
	}
	
}
