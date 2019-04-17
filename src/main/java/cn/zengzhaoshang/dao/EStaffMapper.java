package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.EStaff;
import cn.zengzhaoshang.entity.EStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EStaffMapper {
    long countByExample(EStaffExample example);

    int deleteByExample(EStaffExample example);

    int deleteByPrimaryKey(String id);

    int insert(EStaff record);

    int insertSelective(EStaff record);

    List<EStaff> selectByExample(EStaffExample example);

    EStaff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EStaff record, @Param("example") EStaffExample example);

    int updateByExample(@Param("record") EStaff record, @Param("example") EStaffExample example);

    int updateByPrimaryKeySelective(EStaff record);

    int updateByPrimaryKey(EStaff record);
}