package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller
public class SecondController {
	@RequestMapping("/first")
	protected String firstPage() {
		return "/WEB-INF/views/first.jsp";
	}
	
	@RequestMapping("/second")
	public ModelAndView secondPage(HttpServletRequest req) {
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/second.jsp");
		mv.addObject("param1", p1);
		mv.addObject("param2", p2);
		
		return mv;
	}
	
	//@RequestMapping(value="/third", method=RequestMethod.POST)
	/*
	@PostMapping("/third")
	public String thirdPage(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String point = req.getParameter("point");
		
		System.out.println(name + ", " + age + ", " + point);
		return "/WEB-INF/views/third.jsp";
	}
	*/
	
	@PostMapping("/third")
	//public String thirdPage(String name, int age, double point) {
	public String thirdPage(@RequestParam("name") String irum, 
							@RequestParam int age, 
							@RequestParam double point) {
		System.out.println(irum + ", " + age + ", " + point);
		return "/WEB-INF/views/third.jsp";
	}
	
	/*
	@GetMapping("/fourth")
	public String fourthPage(String name, int age, double point, Model model) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setPoint(point);
		
		model.addAttribute("user", user);
		
		return "/WEB-INF/views/fourth.jsp";
	}
	*/
	
	/*
	@GetMapping("/fourth")
	public ModelAndView fourthPage(String name, int age, double point) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setPoint(point);
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", user);
		
		return mv;
	}
	*/
	
	@GetMapping("/fourth")
	public ModelAndView fourthPage(@ModelAttribute User user, 
									@RequestParam String chk) {	
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", user);
		mv.addObject("chk", chk);
		return mv;
	}
}








