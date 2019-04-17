package cn.zengzhaoshang.dao;

import java.util.List;

import cn.zengzhaoshang.dto.ETrainCustom;
import cn.zengzhaoshang.dto.PageBean;

/**
 * 
 * @Title: ETrainMapper
 * @Description 培训计划  dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:11:37  
 * @version v1.0
 */
public interface ETrainQueryMapper {
	/**
	 * 根据id查询完整信息
	 * @param id
	 * @return
	 */
    ETrainCustom selectByPrimaryKey(String id);
    
    /**
     * 查询所有未完成计划的完整信息
     * @return
     */
    List<ETrainCustom> selectAllNotDo(PageBean<ETrainCustom> pageBean);
    
    /**
     * 查询未完成计划的数量
     * @return
     */
    int countAllNotDo();
    
    /**
     * 查询所有已完成计划的完整信息
     * @return
     */
    List<ETrainCustom> selectAllDo(PageBean<ETrainCustom> pageBean);
    
    /**
     * 查询已完成计划的数量
     * @return
     */
    int countAllDo();
}