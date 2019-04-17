package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.EEmploy;
import cn.zengzhaoshang.entity.EEmployExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @Title: EEmployMapper
 * @Description 招聘计划 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 下午3:42:53  
 * @version v1.0
 */
public interface EEmployMapper {
    long countByExample(EEmployExample example);

    int deleteByExample(EEmployExample example);

    int deleteByPrimaryKey(String id);

    int insert(EEmploy record);

    int insertSelective(EEmploy record);

    List<EEmploy> selectByExampleWithBLOBs(EEmployExample example);

    List<EEmploy> selectByExample(EEmployExample example);

    EEmploy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EEmploy record, @Param("example") EEmployExample example);

    int updateByExampleWithBLOBs(@Param("record") EEmploy record, @Param("example") EEmployExample example);

    int updateByExample(@Param("record") EEmploy record, @Param("example") EEmployExample example);

    int updateByPrimaryKeySelective(EEmploy record);

    int updateByPrimaryKeyWithBLOBs(EEmploy record);

    int updateByPrimaryKey(EEmploy record);
}