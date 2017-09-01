/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.twj.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.twj.demo.HandTransactionException;
import cn.twj.demo.dao.CodeDao;
import cn.twj.demo.entity.Code;

/**
 * 合同生成Service
 * 
 * @author Cody
 * @version 2017-04-12
 */
@Service
@Transactional(readOnly = true)
public class CodeService {
	@Autowired
	private CodeDao c_CodeDao;

	public Code get(String id) {
		return c_CodeDao.get(id);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void update() throws Exception{
		Code code=new Code();
		code.setCode(33);
		code.setId("TXV001");
		c_CodeDao.update(code);
		
//		code=new Code();
//		code.setAreacode("456");
//		code.setId("TXV001");
//		c_CodeDao.update(code);
		
		
		
//		throw new HandTransactionException("sdfsadf");
		try {
			String a=null;
			a.length();
		} catch (Exception e) {
			 throw new Exception(e);
		}
		
	}

	public List<Code> findList(Code code) {
		return c_CodeDao.findList(code);
	}

	// public Page<Code> findPage(Page<Code> page, Code code) {
	// return super.findPage(page, code);
	// }

	@Transactional(readOnly = false)
	public void delete(Code code) {
		c_CodeDao.delete(code);
	}

}