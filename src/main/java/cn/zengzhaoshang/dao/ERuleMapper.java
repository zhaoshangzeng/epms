package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.ERule;
import cn.zengzhaoshang.entity.ERuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @Title: ERuleMapper
 * @Description 考勤达标规则 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:10:40  
 * @version v1.0
 */
public interface ERuleMapper {
    long countByExample(ERuleExample example);

    int deleteByExample(ERuleExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(ERule record);

    int insertSelective(ERule record);

    List<ERule> selectByExample(ERuleExample example);

    ERule selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") ERule record, @Param("example") ERuleExample example);

    int updateByExample(@Param("record") ERule record, @Param("example") ERuleExample example);

    int updateByPrimaryKeySelective(ERule record);

    int updateByPrimaryKey(ERule record);
}