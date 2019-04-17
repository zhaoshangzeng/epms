package cn.zengzhaoshang.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.EEmployMapper;
import cn.zengzhaoshang.dao.EEmployQueryMapper;
import cn.zengzhaoshang.dto.EEmployCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EEmploy;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EEmployService;

/**
 * 
 * @Title: EEmployServiceImpl
 * @Description 招聘计划 业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午3:17:26  
 * @version v1.0
 */
public class EEmployServiceImpl implements EEmployService{

	@Autowired
	private EEmployMapper eEmployMapper;
	
	@Autowired
	private EEmployQueryMapper eEmployQueryMapper;

	/**
	 * 查询所有未完成的招聘计划信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<EEmployCustom> findEmployListNotDo(PageBean<EEmployCustom> pageBean) throws Exception {
		//多表查询+分页查询
		List<EEmployCustom> list = eEmployQueryMapper.selectAllNotDo(pageBean);
		if(list.size() == 0) {
			throw new CustomException("无未完成招聘计划，请制定新的招聘计划！");
		}
		//设置到分页类中
		pageBean.setBeanList(list);
		//查询未完成招聘计划数量
		int count = eEmployQueryMapper.countAllNotDo();
		pageBean.setTr(count);
		
		return pageBean;
	}

	/**
	 * 查询所有已完成的招聘计划信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<EEmployCustom> findEmployListDo(PageBean<EEmployCustom> pageBean) throws Exception {
		//多表查询+分页查询
		List<EEmployCustom> list = eEmployQueryMapper.selectAllDo(pageBean);
		if(list.size() == 0) {
			throw new CustomException("无已完成招聘计划，请执行未完成的招聘计划或制定新计划！");
		}
		//设置到分页类中
		pageBean.setBeanList(list);
		//查询已完成招聘计划的数量
		int count = eEmployQueryMapper.countAllDo();
		//设置到分页类中
		pageBean.setTr(count);
		
		return pageBean;
	}

	/**
	 * 根据id查找招聘计划信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public EEmployCustom findEmploy(String id) throws Exception {
		return eEmployQueryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存招聘计划信息
	 * @throws Exception
	 */
	@Override
	public void saveEmploy(String id, EEmploy eEmploy) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eEmploy.setId(id);
		int value = eEmployMapper.insertSelective(eEmploy);
		if(value == 0) {
			throw new CustomException("保存失败！请重新提交！");
		}
	}

	/**
	 * 修改招聘计划信息
	 * @throws Exception
	 */
	@Override
	public void updateEmploy(String id, EEmploy eEmploy) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eEmploy.setId(id);
		int value = eEmployMapper.updateByPrimaryKeySelective(eEmploy);
		if(value == 0) {
			throw new CustomException("更新失败！其他管理员刚刚进行了更新，您现在获取的不是最新数据！请回到详细信息页面，重新更新！");
		}
	}

	/**
	 * 修改招聘计划信息为已完成
	 * @throws Exception
	 */
	@Override
	public void updateEmployDo(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		EEmploy eEmploy = new EEmploy();
		EEmployCustom eEmployCustom = findEmploy(id);
		BeanUtils.copyProperties(eEmployCustom, eEmploy);
		eEmploy.setIsFinish((byte) 1);
		int value = eEmployMapper.updateByPrimaryKeySelective(eEmploy);
		if(value == 0) {
			throw new CustomException("设置失败！其他管理员进行了同样设置！请到已完成列表查看！");
		}
	}

	/**
	 * 修改招聘计划信息为未完成
	 * @throws Exception
	 */
	@Override
	public void updateEmployNotDo(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		EEmploy eEmploy = new EEmploy();
		EEmployCustom eEmployCustom = findEmploy(id);
		BeanUtils.copyProperties(eEmployCustom, eEmploy);
		eEmploy.setIsFinish((byte) 0);
		int value = eEmployMapper.updateByPrimaryKeySelective(eEmploy);
		if(value == 0) {
			throw new CustomException("设置失败！其他管理员进行了同样设置！请到未完成列表查看！");
		}
	}

	/**
	 * 删除招聘计划信息
	 * @throws Exception
	 */
	@Override
	public void deleteEmploy(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		int value = eEmployMapper.deleteByPrimaryKey(id);
		if(value == 0) {
			throw new CustomException("删除失败！请重新删除！");
		}
	}

}
