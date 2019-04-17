package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.ETrain;
import cn.zengzhaoshang.entity.ETrainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @Title: ETrainMapper
 * @Description 培训计划 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 下午3:42:25  
 * @version v1.0
 */
public interface ETrainMapper {
    long countByExample(ETrainExample example);

    int deleteByExample(ETrainExample example);

    int deleteByPrimaryKey(String id);

    int insert(ETrain record);

    int insertSelective(ETrain record);

    List<ETrain> selectByExampleWithBLOBs(ETrainExample example);

    List<ETrain> selectByExample(ETrainExample example);

    ETrain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ETrain record, @Param("example") ETrainExample example);

    int updateByExampleWithBLOBs(@Param("record") ETrain record, @Param("example") ETrainExample example);

    int updateByExample(@Param("record") ETrain record, @Param("example") ETrainExample example);

    int updateByPrimaryKeySelective(ETrain record);

    int updateByPrimaryKeyWithBLOBs(ETrain record);

    int updateByPrimaryKey(ETrain record);
}