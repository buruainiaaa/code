package cn.twj.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("beetl")
@Controller
public class BeetleController {

	@RequestMapping("/testBeetl")
	@ResponseBody
	public ModelAndView testBeetle(String testName){
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("testBeetl");
		return mav;
	}
}
