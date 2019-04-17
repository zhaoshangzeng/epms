package cn.zengzhaoshang.service;

import cn.zengzhaoshang.dto.EStaffCustom;
import cn.zengzhaoshang.dto.EStaffQueryVo;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EStaff;

/**
 * 
 * @Title: EStaffService
 * @Description 企业员工 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 上午11:30:09  
 * @version v1.0
 */
public interface EStaffService {
	/**
	 * 查询所有员工信息
	 * @return
	 * @throws Exception
	 */
	public PageBean<EStaffCustom> findStaffList(PageBean<EStaffCustom> pageBean) throws Exception;
	
	/**
	 * 根据id查找员工信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EStaffCustom findStaff(String id) throws Exception;
	
	/**
	 * 根据多条件查找员工信息
	 * @param eStaffCustom
	 * @return
	 * @throws Exception
	 */
	public PageBean<EStaffCustom> findStaffRequire(EStaffQueryVo eStaffQueryVo) throws Exception;
	
	/**
	 * 保存员工信息
	 * 因为页面<select>标签能存储部门id，所以能接收部门id，所以不用扩展类
	 * @throws Exception
	 */
	public void saveStaff(String id, EStaff eStaff) throws Exception;
	
	/**
	 * 修改员工信息
	 * 同上
	 * @throws Exception
	 */
	public void updateStaff(String id, EStaff eStaff) throws Exception;
	
	/**
	 * 删除员工信息
	 * @throws Exception
	 */
	public void deleteStaff(String id) throws Exception;

	/**
	 * 查找员工工号是否已经存在
	 * @param eStaff
	 * @throws Exception
	 */
	public void findStaffNum(EStaff eStaff) throws Exception;
}
