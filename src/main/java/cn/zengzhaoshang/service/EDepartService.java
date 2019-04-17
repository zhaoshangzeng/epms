package cn.zengzhaoshang.service;

import java.util.List;

import cn.zengzhaoshang.dto.EDepartCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EDepart;

/**
 * 
 * @Title: EDepartService
 * @Description 企业部门 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 上午11:33:11  
 * @version v1.0
 */
public interface EDepartService {
	/**
	 * 查询所有部门信息（分页查找）
	 * @return
	 * @throws Exception
	 */
	public PageBean<EDepartCustom> findDepartList(PageBean<EDepartCustom> pageBean) throws Exception;
	
	/**
	 * 查询所有部门信息
	 * @return
	 * @throws Exception
	 */
	public List<EDepart> findDeparts() throws Exception;
	
	/**
	 * 根据id查找部门信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EDepartCustom findDepart(String id) throws Exception;
	
	/**
	 * 保存部门信息
	 * 因为页面<select>标签能存储部门id，所以能接收部门id，所以不用部门扩展类
	 * @throws Exception
	 */
	public void saveDepart(String id, EDepart eDepart) throws Exception;
	
	/**
	 * 修改部门信息
	 * 同上
	 * @throws Exception
	 */
	public void updateDepart(String id, EDepart eDepart) throws Exception;
	
	/**
	 * 删除部门信息
	 * @throws Exception
	 */
	public void deleteDepart(String id) throws Exception;

	/**
	 * 查找部门号是否存在
	 * @param eDepart
	 * @throws Exception
	 */
	public void findDepartNum(EDepart eDepart) throws Exception;
}
