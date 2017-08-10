package cn.twj.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("beetl")
@Controller
public class BeetleController {

	@RequestMapping("/testBeetl")
	@ResponseBody
	public String testBeetle(String testName){
		
		return testName;
	}
}
