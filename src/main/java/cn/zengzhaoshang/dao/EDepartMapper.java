package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.entity.EDepartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EDepartMapper {
    long countByExample(EDepartExample example);

    int deleteByExample(EDepartExample example);

    int deleteByPrimaryKey(String id);

    int insert(EDepart record);

    int insertSelective(EDepart record);

    List<EDepart> selectByExample(EDepartExample example);

    EDepart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EDepart record, @Param("example") EDepartExample example);

    int updateByExample(@Param("record") EDepart record, @Param("example") EDepartExample example);

    int updateByPrimaryKeySelective(EDepart record);

    int updateByPrimaryKey(EDepart record);
}