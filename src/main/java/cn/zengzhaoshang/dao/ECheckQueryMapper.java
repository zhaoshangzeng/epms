package cn.zengzhaoshang.dao;

import java.util.Date;
import java.util.List;

import cn.zengzhaoshang.dto.ECheckCustom;
import cn.zengzhaoshang.dto.ECheckQueryVo;

/**
 * 
 * @Title: ECheckMapper
 * @Description 考勤记录自定义查询 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:09:02  
 * @version v1.0
 */
public interface ECheckQueryMapper {
	/**
	 * 根据id查询完整信息
	 * @param id
	 * @return
	 */
    ECheckCustom selectByPrimaryKey(String id);
    
    /**
     * 根据某月查找全部考勤信息，不需要分页，仅用于计算达标率
     * @param month
     * @return
     */
    List<ECheckCustom> selectByMonth(Date month);
    
    /**
     * 根据某月查找全部考勤信息
     * @param month
     * @return
     */
    List<ECheckCustom> selectByMonthAndPage(ECheckQueryVo eCheckQueryVo);
    
    /**
     * 根据条件查找所有考勤信息
     * @return
     */
    List<ECheckCustom> selectRequire(ECheckQueryVo eCheckQueryVo);
    
    /**
     * 根据条件查找总记录数
     * @param eCheckQueryVo
     * @return
     */
    int countRequire(ECheckQueryVo eCheckQueryVo);
}