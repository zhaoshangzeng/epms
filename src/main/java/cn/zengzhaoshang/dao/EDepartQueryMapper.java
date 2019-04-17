package cn.zengzhaoshang.dao;

import java.util.List;

import cn.zengzhaoshang.dto.EDepartCustom;
import cn.zengzhaoshang.dto.PageBean;

/**
 * 
 * @Title: EDepartMapper
 * @Description 部门信息自定义查询 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:09:27  
 * @version v1.0
 */
public interface EDepartQueryMapper {
	/**
	 * 根据id查询完整信息
	 * @param id
	 * @return
	 */
    EDepartCustom selectByPrimaryKey(String id);
    
    /**
     * 查找所有完整信息
     * @return
     */
    List<EDepartCustom> selectAll(PageBean<EDepartCustom> pPageBean);
}