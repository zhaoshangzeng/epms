package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.ECheck;
import cn.zengzhaoshang.entity.ECheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @Title: ECheckMapper
 * @Description 考勤记录 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:09:02  
 * @version v1.0
 */
public interface ECheckMapper {
    long countByExample(ECheckExample example);

    int deleteByExample(ECheckExample example);

    int deleteByPrimaryKey(String id);

    int insert(ECheck record);

    int insertSelective(ECheck record);

    List<ECheck> selectByExample(ECheckExample example);

    ECheck selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ECheck record, @Param("example") ECheckExample example);

    int updateByExample(@Param("record") ECheck record, @Param("example") ECheckExample example);

    int updateByPrimaryKeySelective(ECheck record);

    int updateByPrimaryKey(ECheck record);
}