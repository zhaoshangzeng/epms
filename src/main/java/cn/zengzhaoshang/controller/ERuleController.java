package cn.zengzhaoshang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zengzhaoshang.entity.ERule;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.ERuleService;

/**
 * 
 * @Title: EAccountController
 * @Description 考勤达标规则  控制层
 * @author zengzhaoshang
 * @date: 2019年3月28日 下午1:49:21  
 * @version v1.0
 */
@Controller
@RequestMapping("/rule")
public class ERuleController {
	
	@Autowired
	private ERuleService eRuleService;
	
	/**
	 * 查看考勤达标规则页面
	 */
	@RequestMapping("/entryShow")
	public String entryList(Model model) throws Exception {
		ERule eRule = eRuleService.findRule();
		model.addAttribute("eRule", eRule);
		return "rule/showRule";
	}
	
	/**
	 * 进入修改账号页面
	 */
	@RequestMapping("/entryUpdate")
	public String entryUpdate(Model model) throws Exception {
		ERule eRule = eRuleService.findRule();
		model.addAttribute("eRule", eRule);
		return "rule/updateRule";
	}
	
	/**
	 * 提交修改
	 */
	@RequestMapping(value="/submitUpdate",method={RequestMethod.POST})
	public String submitUpdate(Byte id, ERule eRule, Model model) throws Exception {
		model.addAttribute("eRule", eRule);
		model.addAttribute("info", "操作提示：修改成功！");
		try {
			eRuleService.updateRule(id, eRule);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "rule/updateRule";
	}
}
