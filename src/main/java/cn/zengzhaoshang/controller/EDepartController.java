package cn.zengzhaoshang.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zengzhaoshang.dto.EDepartCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EDepartService;
import cn.zengzhaoshang.util.WebUtils;

/**
 * 
 * @Title: EAccountController
 * @Description 部门  控制层
 * @author zengzhaoshang
 * @date: 2019年3月28日 下午1:49:21  
 * @version v1.0
 */
@Controller
@RequestMapping("/depart")
public class EDepartController {

	@Autowired
	private EDepartService eDepartService;
	
	/**
	 * 进入添加部门页面
	 */
	@RequestMapping("/entryAdd")
	public String entryAdd() throws Exception {
		return "depart/addDepart";
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
			departs.put(eDepart.getId(), eDepart.getDeptName());
		}
		return departs;
	}
	
	/**
	 * 添加部门后提交
	 */
	@RequestMapping(value="/submitAdd",method={RequestMethod.POST})
	public String submitAdd(EDepart eDepart, Model model) throws Exception {
		String id = WebUtils.generateID();
		model.addAttribute("info", "操作提示：提交成功！");
		try {
			//校验部门号是否重复
			eDepartService.findDepartNum(eDepart);
			//保存部门信息
			eDepartService.saveDepart(id, eDepart);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "depart/addDepart";
	}
	
	/**
	 * 查看部门列表
	 */
	@RequestMapping("/entryList")
	public String entryList(Model model, Integer pc) throws Exception {
		//分页信息
		PageBean<EDepartCustom> pageBean = new PageBean<EDepartCustom>(); //分页类
		int ps = 16; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		//调用业务层方法，查询所有部门信息
		PageBean<EDepartCustom> pageBean2 = eDepartService.findDepartList(pageBean);
		model.addAttribute("pageBean", pageBean2);
		return "depart/showDepart";
	}
	
	/**
	 * 进入修改部门页面
	 */
	@RequestMapping("/entryUpdate")
	public String entryUpdate(String id, Model model) throws Exception {
		EDepartCustom eDepartCustom = eDepartService.findDepart(id);
		model.addAttribute("eDepart", eDepartCustom); //起名eDepart是为了方便修改后的回显
		return "depart/updateDepart";
	}
	
	/**
	 * 提交修改
	 */
	@RequestMapping(value="/submitUpdate",method={RequestMethod.POST})
	public String submitUpdate(String id, EDepart eDepart, Model model) throws Exception {
		model.addAttribute("eDepart", eDepart);
		model.addAttribute("info", "操作提示：修改成功！");
		try {
			//修改数据库数据
			eDepartService.updateDepart(id, eDepart);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "depart/updateDepart";
	}
	
	/**
	 * 删除部门
	 */
	@RequestMapping("/submitDelete")
	public String submitDelete(String id, Model model) throws Exception {
		model.addAttribute("info", "deleteSuccess");
		try {
			eDepartService.deleteDepart(id);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return entryList(model, 1);  //回到查询部门列表
	}
}
