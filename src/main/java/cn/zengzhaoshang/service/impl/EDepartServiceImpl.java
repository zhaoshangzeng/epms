package cn.zengzhaoshang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.EDepartMapper;
import cn.zengzhaoshang.dao.EDepartQueryMapper;
import cn.zengzhaoshang.dto.EDepartCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.entity.EDepartExample;
import cn.zengzhaoshang.entity.EDepartExample.Criteria;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EDepartService;

/**
 * 
 * @Title: EDepartServiceImpl
 * @Description 企业部门 业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午2:26:41  
 * @version v1.0
 */
public class EDepartServiceImpl implements EDepartService{

	@Autowired
	private EDepartQueryMapper eDepartQueryMapper;
	
	@Autowired
	private EDepartMapper eDepartMapper;
	
	/**
	 * 查询所有部门信息（分页查找）
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<EDepartCustom> findDepartList(PageBean<EDepartCustom> pageBean) throws Exception {
		List<EDepartCustom> list = eDepartQueryMapper.selectAll(pageBean); //多表查询+分页查询
		long count = eDepartMapper.countByExample(new EDepartExample());
		pageBean.setBeanList(list);
		pageBean.setTr((int) count);
		return pageBean;
	}

	/**
	 * 根据id查找部门信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public EDepartCustom findDepart(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		return eDepartQueryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存部门信息
	 * @throws Exception
	 */
	@Override
	public void saveDepart(String id, EDepart eDepart) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eDepart.setId(id);
		int value = eDepartMapper.insertSelective(eDepart);
		if(value == 0) {
			throw new CustomException("保存失败！请重新提交！");
		}
	}

	/**
	 * 修改部门信息
	 * @throws Exception
	 */
	@Override
	public void updateDepart(String id, EDepart eDepart) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		eDepart.setId(id);
		int value = eDepartMapper.updateByPrimaryKeySelective(eDepart);
		if(value == 0) {
			throw new CustomException("更新失败！其他管理员刚刚进行了更新，您现在获取的不是最新数据！请从左侧导航重新进入，重新更新！");
		}
	}

	/**
	 * 删除部门信息
	 * @throws Exception
	 */
	@Override
	public void deleteDepart(String id) throws Exception {
		if(id == null || id == "") {
			throw new CustomAllException("id不能为空！");
		}
		int value = eDepartMapper.deleteByPrimaryKey(id);
		if(value == 0) {
			throw new CustomException("删除失败！请重新删除！");
		}
	}

	/**
	 * 查找部门号是否存在
	 * @param eDepart
	 * @throws Exception
	 */
	@Override
	public void findDepartNum(EDepart eDepart) throws Exception {
		EDepartExample eDepartExample = new EDepartExample();
		Criteria criteria = eDepartExample.createCriteria();
		criteria.andDeptNumEqualTo(eDepart.getDeptNum());
		List<EDepart> list = eDepartMapper.selectByExample(eDepartExample);
		if(list.size() != 0) {
			throw new CustomException("该部门号已经存在，请使用其他部门号！");
		}
	}

	/**
	 * 查询所有部门信息，不含上级部门名称，仅含上级部门外键，即单表查询
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EDepart> findDeparts() throws Exception {
		 return eDepartMapper.selectByExample(new EDepartExample());
	}

}
