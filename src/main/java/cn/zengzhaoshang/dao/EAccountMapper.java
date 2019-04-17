package cn.zengzhaoshang.dao;

import cn.zengzhaoshang.entity.EAccount;
import cn.zengzhaoshang.entity.EAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @Title: EAccountMapper
 * @Description 登录账号 dao接口
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:08:35  
 * @version v1.0
 */
public interface EAccountMapper {
    long countByExample(EAccountExample example);

    int deleteByExample(EAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(EAccount record);

    int insertSelective(EAccount record);

    List<EAccount> selectByExample(EAccountExample example);

    EAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EAccount record, @Param("example") EAccountExample example);

    int updateByExample(@Param("record") EAccount record, @Param("example") EAccountExample example);

    int updateByPrimaryKeySelective(EAccount record);

    int updateByPrimaryKey(EAccount record);
}