package cn.twj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.twj.demo.dao.UserDao;
import cn.twj.demo.entity.User;

/**
 * 用户Service
 * @author Administrator
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据登录名/手机号码/邮箱/真实姓名 获取用户信息
	 * 
	 * @param entity
	 * @return
	 */
	public User getUserByName(String name){
		return userDao.getUserByName(name);
	}
	
}
