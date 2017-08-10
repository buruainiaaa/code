package cn.twj.demo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.twj.demo.config.CodyConfig;
import cn.twj.demo.entity.Code;
import cn.twj.demo.service.FreeMarkerService;
import cn.twj.demo.util.FreeMarkerUtil;

/**
 * FreeMarker 框架
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/flt")
public class FreeMarkerController {
	
	@Value("${cody.freemarker.template-path}")
	private String template;
	
	@Autowired
	private FreeMarkerService freeMarkerService;
										  
	@RequestMapping(value="/")
    @ResponseBody
    public String testFreeMarker(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "【我是名字】");
        String s=FreeMarkerUtil.instance().geneFileStr(request, "testFreeMarker.flt", map,template);
        
        return s;
    }
}
