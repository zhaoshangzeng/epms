package cn.zengzhaoshang.service;

import cn.zengzhaoshang.entity.ERule;

/**
 * 
 * @Title: ERuleService
 * @Description 考勤规则 业务层接口
 * @author zengzhaoshang
 * @date: 2019年3月26日 下午12:12:10  
 * @version v1.0
 */
public interface ERuleService {
	
	/**
	 * 查找考勤规则信息
	 * @return
	 * @throws Exception
	 */
	public ERule findRule() throws Exception;
	
	/**
	 * 修改考勤规则信息
	 * @throws Exception
	 */
	public void updateRule(Byte id, ERule eRule) throws Exception;
	
}
