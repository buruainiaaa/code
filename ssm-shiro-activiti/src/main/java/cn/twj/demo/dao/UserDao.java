package cn.twj.demo.dao;

import java.util.List;

import cn.twj.demo.entity.Code;
import cn.twj.demo.entity.User;

public interface UserDao {
	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public Code get(String id);

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	public Code get(Code entity);
	
	/**
	 * 根据登录名/手机号码/邮箱/真实姓名 获取用户信息
	 * 
	 * @param entity
	 * @return
	 */
	public User getUserByName(String name);
	

	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * 
	 * @param entity
	 * @return
	 */
	public List<Code> findList(Code entity);

	/**
	 * 查询所有数据列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<Code> findAllList(Code entity);

	/**
	 * 查询所有数据列表
	 * 
	 * @see public List<T> findAllList(T entity)
	 * @return
	 */
	@Deprecated
	public List<Code> findAllList();

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(Code entity);

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @return
	 */
	public int update(Code entity);

	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * 
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Deprecated
	public int delete(String id);

	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * 
	 * @param entity
	 * @return
	 */
	public int delete(Code entity);
}
