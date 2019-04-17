package cn.zengzhaoshang.service;

import java.util.Date;

import cn.zengzhaoshang.dto.ECheckCount;
import cn.zengzhaoshang.dto.ECheckCustom;
import cn.zengzhaoshang.dto.ECheckQueryVo;
import cn.zengzhaoshang.dto.PageBean;

/**
 * 
 * @Title: ECheckService
 * @Description 考勤记录 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 上午11:32:34  
 * @version v1.0
 */
public interface ECheckService {
	/**
	 * 查询上个月所有考勤信息，并计算是否达标
	 * @return
	 * @throws Exception
	 */
	public PageBean<ECheckCustom> findCheckListLast(ECheckQueryVo eCheckQueryVo) throws Exception;
	
	/**
	 * 查询上个月所有考勤信息，并进行统计
	 * @return
	 * @throws Exception
	 */
	public ECheckCount findCheckCount() throws Exception;
	
	/**
	 * 查询某个月所有考勤信息，并进行统计
	 * @return
	 * @throws Exception
	 */
	public ECheckCount findCheckCount(Date month) throws Exception;
	
	/**
	 * 根据id查找考勤信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ECheckCustom findCheck(String id) throws Exception;
	
	/**
	 * 根据多条件查找考勤信息
	 * @param checkCustom
	 * @return
	 * @throws Exception
	 */
	public PageBean<ECheckCustom> findCheckRequire(ECheckQueryVo eCheckQueryVo) throws Exception;
	
	/**
	 * 保存考勤信息
	 * 因为添加考勤信息时，需要填写工号和员工姓名，没法填写员工id，这里需要接收扩展类，并且方法体内要根据工号和员工姓名找出员工id
	 * @throws Exception
	 */
	public void saveCheck(String id, ECheckCustom checkCustom) throws Exception;
	
	/**
	 * 修改考勤信息
	 * 同上
	 * @throws Exception
	 */
	public void updateCheck(String id, ECheckCustom checkCustom) throws Exception;
	
	/**
	 * 删除考勤信息
	 * @throws Exception
	 */
	public void deleteCheck(String id) throws Exception;
}
