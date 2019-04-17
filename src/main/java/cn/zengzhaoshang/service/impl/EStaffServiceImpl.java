package cn.zengzhaoshang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.EStaffMapper;
import cn.zengzhaoshang.dao.EStaffQueryMapper;
import cn.zengzhaoshang.dto.EStaffCustom;
import cn.zengzhaoshang.dto.EStaffQueryVo;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EStaff;
import cn.zengzhaoshang.entity.EStaffExample;
import cn.zengzhaoshang.entity.EStaffExample.Criteria;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EStaffService;

/**
 * 
 * @Title: EStaffServiceImpl
 * @Description 企业员工  业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午2:27:00  
 * @version v1.0
 */
public class EStaffServiceImpl implements EStaffService {

	@Autowired
	private EStaffMapper eStaffMapper;
	
	@Autowired
	private EStaffQueryMapper eStaffQueryMapper;

	/**
	 * 查询所有员工信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<EStaffCustom> findStaffList(PageBean<EStaffCustom> pageBean) throws Exception {
		//多表查询+分页查询
		List<EStaffCustom> list = eStaffQueryMapper.selectAll(pageBean);
		pageBean.setBeanList(list); //将查询结果存到分页类中
		//查询总记录数
		long count = eStaffMapper.countByExample(new EStaffExample());
		pageBean.setTr((int) count); //将总记录数存到分页类中
		
		return pageBean;
	}

	/**
	 * 根据id查找员工信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public EStaffCustom findStaff(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		return eStaffQueryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据多条件查找员工信息
	 * @param eStaffCustom
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<EStaffCustom> findStaffRequire(EStaffQueryVo eStaffQueryVo) throws Exception {
		//带条件进行多表查询+分页查询
		List<EStaffCustom> list = eStaffQueryMapper.selectRequire(eStaffQueryVo);
		if(list.size() == 0) {
			throw new CustomException("未匹配到员工信息，请更换查找条件！");
		}
		PageBean<EStaffCustom> pageBean = eStaffQueryVo.getPageBean();
		pageBean.setBeanList(list); //将查询结果存到分页类中
		//带条件查询总记录数
		int count = eStaffQueryMapper.countRequire(eStaffQueryVo);
		pageBean.setTr(count); //将总记录数存到分页类中
		
		return pageBean;
	}
	
	/**
	 * 保存员工信息
	 * @throws Exception
	 */
	@Override
	public void saveStaff(String id, EStaff eStaff) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eStaff.setId(id);
		int value = eStaffMapper.insertSelective(eStaff);
		if(value == 0) {
			throw new CustomException("保存失败！请重新提交！");
		}
	}

	/**
	 * 修改员工信息
	 * @throws Exception
	 */
	@Override
	public void updateStaff(String id, EStaff eStaff) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eStaff.setId(id);
		int value = eStaffMapper.updateByPrimaryKeySelective(eStaff);
		if(value == 0) {
			throw new CustomException("更新失败！其他管理员刚刚进行了更新，您现在获取的不是最新数据！请回到详细信息页面，重新更新！");
		}
	}

	/**
	 * 删除员工信息
	 * @throws Exception
	 */
	@Override
	public void deleteStaff(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		int value = eStaffMapper.deleteByPrimaryKey(id);
		if(value == 0) {
			throw new CustomException("删除失败！请重新删除！");
		}
	}

	/**
	 * 查找员工工号是否已经存在
	 * @param eStaff
	 * @throws Exception
	 */
	@Override
	public void findStaffNum(EStaff eStaff) throws Exception {
		EStaffExample eStaffExample = new EStaffExample();
		Criteria criteria = eStaffExample.createCriteria();
		criteria.andJobNumEqualTo(eStaff.getJobNum());
		List<EStaff> list = eStaffMapper.selectByExample(eStaffExample);
		if(list.size() != 0) {
			throw new CustomException("该工号已经存在，请使用其他工号!");
		}
	}

}
