/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.twj.demo.web;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.twj.demo.entity.Code;
import cn.twj.demo.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 合同生成Controller
 * 
 * @author Cody
 * @version 2017-04-12
 */
@Controller
@Api(description = "代码入口", tags = "Code-main")
@RequestMapping(value = "/code")
public class CodeController {

	@Autowired
	private CodeService codeService;

	@ApiOperation(value = "账户测试", notes = "URL参数测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "testName", value = "测试名称", paramType = "path", required = true)
    })
	@RequestMapping(value="/test/{testName}",method=RequestMethod.GET)
	@ResponseBody
	public String test(@PathVariable String testName){
		return testName;
	}
	
	@ApiOperation(value = "账户基本信息", notes = "对象参数测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "testName", value = "测试名称", paramType = "query", required = true),
            @ApiImplicitParam(name = "id", value = "测试ID", paramType = "query", required = true)
    })
	@RequestMapping(value="/test/object",method=RequestMethod.POST)
	@ResponseBody
	public List<Code> testSwagger(@RequestParam(value="testName",required=true) String testName,
							@RequestParam(value="id",required=true)Integer id){
		Code code=new Code();
		code.setAreacode("areacode");
		code.setCode(123);
		code.setDate("2017年8月9日16:09:14");
		code.setId("1");
		code.setYcode(5);
		List<Code> list=new ArrayList<Code>();
		list.add(code);
		return list;
	}


}