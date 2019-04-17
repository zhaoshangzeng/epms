package cn.zengzhaoshang.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zengzhaoshang.dto.EEmployCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.entity.EEmploy;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EDepartService;
import cn.zengzhaoshang.service.EEmployService;
import cn.zengzhaoshang.util.WebUtils;

/**
 * 
 * @Title: EAccountController
 * @Description 招聘计划  控制层
 * @author zengzhaoshang
 * @date: 2019年3月28日 下午1:49:21  
 * @version v1.0
 */
@Controller
@RequestMapping("/employ")
public class EEmployController {
	
	@Autowired
	private EEmployService eEmployService;
	
	@Autowired
	private EDepartService eDepartService;

	/**
	 * 进入添加招聘计划页面
	 */
	@RequestMapping("/entryAdd")
	public String entryAdd() throws Exception {
		return "employ/addEmploy";
	}
	
	/**
	 * 提供部门信息   用于添加部门信息时选择上级部门
	 * 通过返回值回显，显示到<select>标签，显示为部门名称，真正传到服务器的是部门id
	 * @return
	 * @throws Exception 
	 */
	@ModelAttribute("departs")
	public Map<String,String> getDeparts() throws Exception{
		Map<String, String> departs = new LinkedHashMap<String,String>();
		departs.put("", "--选择部门--");  //先添加一个不选的默认值
		List<EDepart> list = eDepartService.findDeparts();
		for(EDepart eDepart : list) {
			departs.put(eDepart.getId(),eDepart.getDeptName());
		}
		return departs;
	}
	
	/**
	 * 添加招聘计划后提交
	 */
	@RequestMapping(value="/submitAdd",method={RequestMethod.POST})
	public String submitAdd(String empDate2, EEmploy eEmploy, Model model) throws Exception {
		String id = WebUtils.generateID();
		Date empDate = new SimpleDateFormat("yyyy-MM-dd").parse(empDate2);
		eEmploy.setEmpDate(empDate);
		model.addAttribute("info", "操作提示：提交成功！");
		try {
			eEmployService.saveEmploy(id, eEmploy);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "employ/addEmploy";
	}
	
	/**
	 * 查看未完成招聘计划列表
	 */
	@RequestMapping("/entryList")
	public String entryList(Model model, Integer pc) throws Exception {
		//分页信息
		PageBean<EEmployCustom> pageBean = new PageBean<EEmployCustom>(); //分页类
		int ps = 16; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		//调用业务层方法，查询所有未完成招聘计划信息
		try {
			pageBean = eEmployService.findEmployListNotDo(pageBean);
			//给日期加中文
			for(EEmployCustom eEmployCustom : pageBean.getBeanList()) {
				String empDate2 = new SimpleDateFormat("yyyy年MM月dd日").format(eEmployCustom.getEmpDate());
				eEmployCustom.setEmpDate2(empDate2);
			}
			//显示到页面
			model.addAttribute("pageBean", pageBean);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "employ/showEmploy";
	}
	
	/**
	 * 查看已完成招聘计划列表
	 */
	@RequestMapping("/entryList2")
	public String entryList2(Model model, Integer pc) throws Exception {
		//分页信息
		PageBean<EEmployCustom> pageBean = new PageBean<EEmployCustom>(); //分页类
		int ps = 16; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		//调用业务层方法，查询所有已完成招聘计划信息
		try {
			pageBean = eEmployService.findEmployListDo(pageBean);
			//给日期加中文
			for(EEmployCustom eEmployCustom : pageBean.getBeanList()) {
				String empDate2 = new SimpleDateFormat("yyyy年MM月dd日").format(eEmployCustom.getEmpDate());
				eEmployCustom.setEmpDate2(empDate2);
			}
			//显示到页面
			model.addAttribute("pageBean", pageBean);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "employ/showEmploy2";
	}
	
	/**
	 * 查看未完成招聘计划的细节
	 */
	@RequestMapping("/entryDetail")
	public String entryDetail(String id, Model model) throws Exception {
		EEmployCustom eEmployCustom = eEmployService.findEmploy(id);
		String empDate2 = new SimpleDateFormat("yyyy年MM月dd日").format(eEmployCustom.getEmpDate());
		model.addAttribute("empDate2", empDate2);
		model.addAttribute("eEmployCustom", eEmployCustom);
		return "employ/showEmployDetail";
	}
	
	/**
	 * 查看已完成招聘计划的细节
	 */
	@RequestMapping("/entryDetail2")
	public String entryDetail2(String id, Model model) throws Exception {
		EEmployCustom eEmployCustom = eEmployService.findEmploy(id);
		String empDate2 = new SimpleDateFormat("yyyy年MM月dd日").format(eEmployCustom.getEmpDate());
		model.addAttribute("empDate2", empDate2);
		model.addAttribute("eEmployCustom", eEmployCustom);
		return "employ/showEmployDetail2";
	}
	
	/**
	 * 进入修改招聘计划页面
	 */
	@RequestMapping("/entryUpdate")
	public String entryUpdate(String id, Model model) throws Exception {
		EEmployCustom eEmployCustom = eEmployService.findEmploy(id);
		String empDate2 = new SimpleDateFormat("yyyy-MM-dd").format(eEmployCustom.getEmpDate());
		model.addAttribute("empDate2", empDate2);
		model.addAttribute("eEmploy", eEmployCustom); //起名eEmploy是为了方便修改后的回显
		return "employ/updateEmploy";
	}
	
	/**
	 * 提交修改
	 */
	@RequestMapping(value="/submitUpdate",method={RequestMethod.POST})
	public String submitUpdate(String id, String empDate2, EEmploy eEmploy, Model model) throws Exception {
		model.addAttribute("empDate2", empDate2);
		model.addAttribute("eEmploy", eEmploy); 
		Date empDate = new SimpleDateFormat("yyyy-MM-dd").parse(empDate2);
		eEmploy.setEmpDate(empDate);
		model.addAttribute("info", "操作提示：修改成功！");
		try {
			eEmployService.updateEmploy(id, eEmploy);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "employ/updateEmploy";
	}
	
	/**
	 * 设置为已完成
	 */
	@RequestMapping("/submitDo")
	public String submitDo(String id, Model model) throws Exception {
		try {
			eEmployService.updateEmployDo(id);
		} catch (CustomException ce) {
			model.addAttribute("alertInfo", "操作提示：" + ce.getMessage());
		}
		return entryList2(model, 1);  //到已完成列表中查看
	}
	
	/**
	 * 设置为未完成
	 */
	@RequestMapping("/submitNotDo")
	public String submitNotDo(String id, Model model) throws Exception {
		try {
			eEmployService.updateEmployNotDo(id);
		} catch (CustomException ce) {
			model.addAttribute("alertInfo", "操作提示：" + ce.getMessage());
		}
		return entryList(model, 1);  //到未完成列表中查看
	}
	
	/**
	 * 删除招聘计划
	 */
	@RequestMapping("/submitDelete")
	public String submitDelete(String id, Model model) throws Exception {
		model.addAttribute("delInfo", "deleteSuccess");
		EEmployCustom eEmployCustom = eEmployService.findEmploy(id);
		try {
			eEmployService.deleteEmploy(id);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		//判断是删除了已完成还是未完成计划，然后转到相应的页面
		if(eEmployCustom.getIsFinish() == 0) {
			return entryList(model, 1);  //到未完成列表中查看
		}else {
			return entryList2(model, 1);  //到已完成列表中查看
		}
	}
}
