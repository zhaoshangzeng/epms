package cn.zengzhaoshang.service;

import cn.zengzhaoshang.dto.ETrainCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.ETrain;

/**
 * 
 * @Title: ETrainService
 * @Description 培训计划 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 下午12:14:48  
 * @version v1.0
 */
public interface ETrainService {
	/**
	 * 查询所有未完成的培训计划信息，带分页
	 * @return
	 * @throws Exception
	 */
	public PageBean<ETrainCustom> findTrainListNotDo(PageBean<ETrainCustom> pageBean) throws Exception;
	
	/**
	 * 查询所有已经完成的培训计划信息，带分页
	 * @return
	 * @throws Exception
	 */
	public PageBean<ETrainCustom> findTrainListDo(PageBean<ETrainCustom> pageBean) throws Exception;
	
	/**
	 * 根据id查找培训计划信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ETrainCustom findTrain(String id) throws Exception;
	
	/**
	 * 保存培训计划信息
	 * 因为页面<select>标签能存储部门id，所以能接收部门id，所以不用扩展类
	 * @throws Exception
	 */
	public void saveTrain(String id, ETrain eTrain) throws Exception;
	
	/**
	 * 修改培训计划信息
	 * 同上
	 * @throws Exception
	 */
	public void updateTrain(String id, ETrain eTrain) throws Exception;
	
	/**
	 * 修改培训计划信息为已完成
	 * @throws Exception
	 */
	public void updateTrainDo(String id) throws Exception;
	
	/**
	 * 修改培训计划信息为未完成
	 * @throws Exception
	 */
	public void updateTrainNotDo(String id) throws Exception;
	
	/**
	 * 删除培训计划信息
	 * @throws Exception
	 */
	public void deleteTrain(String id) throws Exception;
}
