/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.twj.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Array;

import cn.twj.demo.HandTransactionException;
import cn.twj.demo.entity.Code;
import cn.twj.demo.service.CodeService;

/**
 * 合同生成Controller
 * 
 * @author Cody
 * @version 2017-04-12
 */
@Controller
@RequestMapping(value = "/code")
public class CodeController {

	@Autowired
	private CodeService codeService;

	// @ModelAttribute
	// public Code get(@RequestParam(required = false) String id) {
	// Code entity = null;
	// if (StringUtils.isNotBlank(id)) {
	// entity = codeService.get(id);
	// }
	// if (entity == null) {
	// entity = new Code();
	// }
	// return entity;
	// }

	@RequestMapping(value = "/")
	public String showPage(String viewName, Model model) {
		model.addAttribute("message", "");
		return viewName;
	}

	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String msg = "";
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
		token.setRememberMe(true);
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				model.addAttribute("loginName", loginName);
				return "index";
			} else {
				return "codeList";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			model.addAttribute("message", msg);
			System.out.println(msg);
		}
		return "codeList";
	}

	/**
	 * 测试事物机制
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public String update(HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			codeService.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "OK";
	}

	/**
	 * 合同生成列表页面
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public List<Code> list(Code code, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Code> page = codeService.findList(code);
		// model.addAttribute("page", page);
		return page;
	}

	/**
	 * 合同生成列表页面
	 */
	@RequestMapping(value = "testEncode")
	@ResponseBody
	public List<String> testEncode(Code code, HttpServletRequest request, HttpServletResponse response, Model model) {
		// List<Code> page = codeService.findList(code);
		String s = "唐文金";
		// model.addAttribute("page", page);
		List<String> list = new ArrayList<String>();
		list.add(s);
		return list;
	}

	/**
	 * 查看，增加，编辑合同生成表单页面
	 */
	@RequestMapping(value = "form")
	public String form(Code code, Model model) {
		model.addAttribute("code", code);
		return "modules/code/codeForm";
	}

}