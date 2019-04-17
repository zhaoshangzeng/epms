package cn.zengzhaoshang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zengzhaoshang.dao.ERuleMapper;
import cn.zengzhaoshang.entity.ERule;
import cn.zengzhaoshang.entity.ERuleExample;
import cn.zengzhaoshang.exception.CustomAllException;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.ERuleService;

/**
 * 
 * @Title: ERuleServiceImpl
 * @Description 考勤达标规则 业务层实现类
 * @author zengzhaoshang
 * @date: 2019年3月27日 上午11:42:06  
 * @version v1.0
 */
public class ERuleServiceImpl implements ERuleService {

	@Autowired
	private ERuleMapper eRuleMapper;
	
	/**
	 * 查找考勤规则信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public ERule findRule() throws Exception {
		List<ERule> list = eRuleMapper.selectByExample(new ERuleExample());
		return list.get(0);
	}

	/**
	 * 修改考勤规则信息
	 * @throws Exception
	 */
	@Override
	public void updateRule(Byte id, ERule eRule) throws Exception {
		if(id == null) {
			throw new CustomAllException("id值不能为空！");
		}
		eRule.setId(id);
		int value = eRuleMapper.updateByPrimaryKeySelective(eRule);
		if(value == 0) {
			throw new CustomException("更新失败!其他管理员刚刚进行了更新，您现在获取的不是最新数据！请在左侧导航重新进入，重新更新！");
		}
	}

}
