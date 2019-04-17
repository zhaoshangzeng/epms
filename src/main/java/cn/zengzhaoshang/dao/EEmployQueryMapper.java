package cn.zengzhaoshang.dao;

import java.util.List;

import cn.zengzhaoshang.dto.EEmployCustom;
import cn.zengzhaoshang.dto.PageBean;

/**
 * 
 * @Title: EEmployMapper
 * @Description 招聘计划 自定义查询 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:10:20  
 * @version v1.0
 */
public interface EEmployQueryMapper {
	/**
	 * 根据id查询完整信息
	 * @param id
	 * @return
	 */
    EEmployCustom selectByPrimaryKey(String id);
    
    /**
     * 查找所有未完成招聘的完整信息
     * @return
     */
    List<EEmployCustom> selectAllNotDo(PageBean<EEmployCustom> pPageBean);
    
    /**
     * 查找所有未完成招聘的数量
     * @return
     */
    int countAllNotDo();
    
    /**
     * 查找所有已经完成招聘的完整信息
     * @return
     */
    List<EEmployCustom> selectAllDo(PageBean<EEmployCustom> pPageBean);
    
    /**
     * 查找所有已经完成招聘的数量
     * @return
     */
    int countAllDo();
}