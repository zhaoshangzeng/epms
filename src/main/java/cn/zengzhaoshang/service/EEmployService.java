package cn.zengzhaoshang.service;

import cn.zengzhaoshang.dto.EEmployCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EEmploy;

/**
 * 
 * @Title: EEmployService
 * @Description 招聘计划 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 上午11:45:56  
 * @version v1.0
 */
public interface EEmployService {
	/**
	 * 查询所有未完成的招聘计划信息，带分页
	 * @return
	 * @throws Exception
	 */
	public PageBean<EEmployCustom> findEmployListNotDo(PageBean<EEmployCustom> pageBean) throws Exception;
	
	/**
	 * 查询所有已完成的招聘计划信息，带分页
	 * @return
	 * @throws Exception
	 */
	public PageBean<EEmployCustom> findEmployListDo(PageBean<EEmployCustom> pageBean) throws Exception;
	
	/**
	 * 根据id查找招聘计划信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EEmployCustom findEmploy(String id) throws Exception;
	
	/**
	 * 保存招聘计划信息
	 * 因为页面<select>标签能存储部门id，所以能接收部门id，所以不用扩展类
	 * @throws Exception
	 */
	public void saveEmploy(String id, EEmploy eEmploy) throws Exception;
	
	/**
	 * 修改招聘计划信息
	 * 同上
	 * @throws Exception
	 */
	public void updateEmploy(String id, EEmploy eEmploy) throws Exception;
	
	/**
	 * 修改招聘计划信息为已完成
	 * @throws Exception
	 */
	public void updateEmployDo(String id) throws Exception;
	
	/**
	 * 修改招聘计划信息为未完成
	 * @throws Exception
	 */
	public void updateEmployNotDo(String id) throws Exception;
	
	/**
	 * 删除招聘计划信息
	 * @throws Exception
	 */
	public void deleteEmploy(String id) throws Exception;
}
