/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.twj.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * 合同生成列表页面
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public List<Code> list(Code code, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Code> page = codeService.findList(code);
		// model.addAttribute("page", page);
		return page;
	}

	/**
	 * 查看，增加，编辑合同生成表单页面
	 */
	@RequestMapping(value = "form")
	public String form(Code code, Model model) {
		model.addAttribute("code", code);
		return "modules/code/codeForm";
	}

	// /**
	// * 保存合同生成
	// */
	// @RequiresPermissions(value = { "code:code:add", "code:code:edit" },
	// logical = Logical.OR)
	// @RequestMapping(value = "save")
	// public String save(Code code, Model model, RedirectAttributes
	// redirectAttributes) throws Exception {
	// if (!beanValidator(model, code)) {
	// return form(code, model);
	// }
	// if (!code.getIsNewRecord()) {// 编辑表单保存
	// Code t = codeService.get(code.getId());// 从数据库取出记录的值
	// MyBeanUtils.copyBeanNotNull2Bean(code, t);// 将编辑表单中的非NULL值覆盖数据库记录中的值
	// codeService.save(t);// 保存
	// } else {// 新增表单保存
	// codeService.save(code);// 保存
	// }
	// addMessage(redirectAttributes, "保存合同生成成功");
	// return "redirect:" + Global.getAdminPath() + "/code/code/?repage";
	// }

	// /**
	// * 删除合同生成
	// */
	// @RequiresPermissions("code:code:del")
	// @RequestMapping(value = "delete")
	// public String delete(Code code, RedirectAttributes redirectAttributes) {
	// codeService.delete(code);
	// addMessage(redirectAttributes, "删除合同生成成功");
	// return "redirect:" + Global.getAdminPath() + "/code/code/?repage";
	// }
	//
	// /**
	// * 批量删除合同生成
	// */
	// @RequiresPermissions("code:code:del")
	// @RequestMapping(value = "deleteAll")
	// public String deleteAll(String ids, RedirectAttributes
	// redirectAttributes) {
	// String idArray[] = ids.split(",");
	// for (String id : idArray) {
	// codeService.delete(codeService.get(id));
	// }
	// addMessage(redirectAttributes, "删除合同生成成功");
	// return "redirect:" + Global.getAdminPath() + "/code/code/?repage";
	// }
	//
	// /**
	// * 导出excel文件
	// */
	// @RequiresPermissions("code:code:export")
	// @RequestMapping(value = "export", method = RequestMethod.POST)
	// public String exportFile(Code code, HttpServletRequest request,
	// HttpServletResponse response,
	// RedirectAttributes redirectAttributes) {
	// try {
	// String fileName = "合同生成" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
	// Page<Code> page = codeService.findPage(new Page<Code>(request, response,
	// -1), code);
	// new ExportExcel("合同生成",
	// Code.class).setDataList(page.getList()).write(response,
	// fileName).dispose();
	// return null;
	// } catch (Exception e) {
	// addMessage(redirectAttributes, "导出合同生成记录失败！失败信息：" + e.getMessage());
	// }
	// return "redirect:" + Global.getAdminPath() + "/code/code/?repage";
	// }
	//
	// /**
	// * 导入Excel数据
	// *
	// */
	// @RequiresPermissions("code:code:import")
	// @RequestMapping(value = "import", method = RequestMethod.POST)
	// public String importFile(MultipartFile file, RedirectAttributes
	// redirectAttributes) {
	// try {
	// int successNum = 0;
	// int failureNum = 0;
	// StringBuilder failureMsg = new StringBuilder();
	// ImportExcel ei = new ImportExcel(file, 1, 0);
	// List<Code> list = ei.getDataList(Code.class);
	// for (Code code : list) {
	// try {
	// codeService.save(code);
	// successNum++;
	// } catch (ConstraintViolationException ex) {
	// failureNum++;
	// } catch (Exception ex) {
	// failureNum++;
	// }
	// }
	// if (failureNum > 0) {
	// failureMsg.insert(0, "，失败 " + failureNum + " 条合同生成记录。");
	// }
	// addMessage(redirectAttributes, "已成功导入 " + successNum + " 条合同生成记录" +
	// failureMsg);
	// } catch (Exception e) {
	// addMessage(redirectAttributes, "导入合同生成失败！失败信息：" + e.getMessage());
	// }
	// return "redirect:" + Global.getAdminPath() + "/code/code/?repage";
	// }
	//
	// /**
	// * 下载导入合同生成数据模板
	// */
	// @RequiresPermissions("code:code:import")
	// @RequestMapping(value = "import/template")
	// public String importFileTemplate(HttpServletResponse response,
	// RedirectAttributes redirectAttributes) {
	// try {
	// String fileName = "合同生成数据导入模板.xlsx";
	// List<Code> list = Lists.newArrayList();
	// new ExportExcel("合同生成数据", Code.class,
	// 1).setDataList(list).write(response, fileName).dispose();
	// return null;
	// } catch (Exception e) {
	// addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
	// }
	// return "redirect:" + Global.getAdminPath() + "/code/code/?repage";
	// }

}