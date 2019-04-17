package cn.zengzhaoshang.dao;

import java.util.List;

import cn.zengzhaoshang.dto.EStaffCustom;
import cn.zengzhaoshang.dto.EStaffQueryVo;
import cn.zengzhaoshang.dto.PageBean;

/**
 * 
 * @Title: EStaffQueryMapper
 * @Description 企业员工信息自定义查询dao
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午4:41:37  
 * @version v1.0
 */
public interface EStaffQueryMapper {
	/**
	 * 根据id查询完整信息
	 * @param id
	 * @return
	 */
    EStaffCustom selectByPrimaryKey(String id);
    
    /**
     * 查找所有完整信息
     * @return
     */
    List<EStaffCustom> selectAll(PageBean<EStaffCustom> pageBean);
    
    /**
     * 根据条件查找所有完整信息
     * @return
     */
    List<EStaffCustom> selectRequire(EStaffQueryVo eStaffQueryVo);
    
    /**
     * 根据条件查找总记录数
     * @param eStaffQueryVo
     * @return
     */
    int countRequire(EStaffQueryVo eStaffQueryVo);
}