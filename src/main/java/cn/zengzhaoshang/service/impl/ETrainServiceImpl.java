package cn.zengzhaoshang.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.ETrainMapper;
import cn.zengzhaoshang.dao.ETrainQueryMapper;
import cn.zengzhaoshang.dto.ETrainCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.ETrain;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.ETrainService;

/**
 * 
 * @Title: ETrainServiceImpl
 * @Description 培训计划 业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午2:58:57  
 * @version v1.0
 */
public class ETrainServiceImpl implements ETrainService {

	@Autowired
	private ETrainMapper eTrainMapper;
	
	@Autowired
	private ETrainQueryMapper eTrainQueryMapper;
	
	/**
	 * 查询所有未完成的培训计划信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<ETrainCustom> findTrainListNotDo(PageBean<ETrainCustom> pageBean) throws Exception {
		//分页查询未完成的培训计划信息+多表查询
		List<ETrainCustom> list = eTrainQueryMapper.selectAllNotDo(pageBean);
		if(list.size() == 0) {
			throw new CustomException("无未完成培训计划，请指定新的培训计划！");
		}
		//设置到分页类中
		pageBean.setBeanList(list);
		//查找未完成的培训计划信息的数量
		int count = eTrainQueryMapper.countAllNotDo();
		//设置到分页类中
		pageBean.setTr(count);
		
		return pageBean;
	}

	/**
	 * 查询所有已经完成的培训计划信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<ETrainCustom> findTrainListDo(PageBean<ETrainCustom> pageBean) throws Exception {
		//分页查询已完成培训计划信息+多表查询
		List<ETrainCustom> list = eTrainQueryMapper.selectAllDo(pageBean);
		if(list.size() == 0) {
			throw new CustomException("无已完成培训计划，请执行未完成的培训计划或制定新计划！");
		}
		//设置到分页类中
		pageBean.setBeanList(list);
		//查询已完成培训计划的数量
		int count = eTrainQueryMapper.countAllDo();
		//设置到分页类中
		pageBean.setTr(count);
		
		return pageBean;
	}

	/**
	 * 根据id查找培训计划信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ETrainCustom findTrain(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		return eTrainQueryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存培训计划信息
	 * @throws Exception
	 */
	@Override
	public void saveTrain(String id, ETrain eTrain) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eTrain.setId(id);
		int value = eTrainMapper.insertSelective(eTrain);
		if(value == 0) {
			throw new CustomException("保存失败！请重新提交！");
		}
	}

	/**
	 * 修改培训计划信息
	 * @throws Exception
	 */
	@Override
	public void updateTrain(String id, ETrain eTrain) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eTrain.setId(id);
		int value = eTrainMapper.updateByPrimaryKeySelective(eTrain);
		if(value == 0) {
			throw new CustomException("更新失败！其他管理员刚刚进行了更新，您现在获取的不是最新数据！请回到详细信息页面，重新更新！");
		}
	}

	/**
	 * 修改培训计划信息为已完成
	 * @throws Exception
	 */
	@Override
	public void updateTrainDo(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		ETrainCustom eTrainCustom = findTrain(id);
		ETrain eTrain = new ETrain();
		BeanUtils.copyProperties(eTrainCustom, eTrain);
		eTrain.setIsFinish((byte) 1);
		int value = eTrainMapper.updateByPrimaryKeySelective(eTrain);
		if(value == 0) {
			throw new CustomException("设置失败！其他管理员进行了同样设置！请在已完成列表查看！");
		}
	}

	/**
	 * 修改培训计划信息为未完成
	 * @throws Exception
	 */
	@Override
	public void updateTrainNotDo(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		ETrainCustom eTrainCustom = findTrain(id);
		ETrain eTrain = new ETrain();
		BeanUtils.copyProperties(eTrainCustom, eTrain);
		eTrain.setIsFinish((byte) 0);
		int value = eTrainMapper.updateByPrimaryKeySelective(eTrain);
		if(value == 0) {
			throw new CustomException("设置失败！其他管理员进行了同样设置！请在未完成列表查看！");
		}
	}

	/**
	 * 删除培训计划信息
	 * @throws Exception
	 */
	@Override
	public void deleteTrain(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		int value = eTrainMapper.deleteByPrimaryKey(id);
		if(value == 0) {
			throw new CustomException("删除失败！请重新删除！");
		}
	}

}
