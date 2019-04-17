package cn.zengzhaoshang.controller;

import java.text.ParseException;
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

import cn.zengzhaoshang.dto.ETrainCustom;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.entity.ETrain;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EDepartService;
import cn.zengzhaoshang.service.ETrainService;
import cn.zengzhaoshang.util.WebUtils;

/**
 * 
 * @Title: EAccountController
 * @Description 登录账号 控制层
 * @author zengzhaoshang
 * @date: 2019年3月28日 下午1:49:21  
 * @version v1.0
 */
@Controller
@RequestMapping("/train")
public class ETrainController {
	
	@Autowired
	private ETrainService eTrainService;
	
	@Autowired
	private EDepartService eDepartService;

	/**
	 * 进入添加培训计划页面
	 */
	@RequestMapping("/entryAdd")
	public String entryAdd() throws Exception {
		return "train/addTrain";
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
	 * 添加培训计划后提交
	 */
	@RequestMapping(value="/submitAdd",method={RequestMethod.POST})
	public String submitAdd(String date2, ETrain eTrain, Model model) throws Exception {
		String id = WebUtils.generateID();
		//格式转换
		Date date = stringToDate(date2);
		eTrain.setDate(date);
		model.addAttribute("info", "操作提示：提交成功！");
		try {
			eTrainService.saveTrain(id, eTrain);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "train/addTrain";
	}
	
	/**
	 * 查看未完成培训计划列表
	 */
	@RequestMapping("/entryList")
	public String entryList(Model model, Integer pc) throws Exception {
		//分页信息
		PageBean<ETrainCustom> pageBean = new PageBean<ETrainCustom>(); //分页类
		int ps = 16; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		//调用业务层方法，查询所有未完成计划信息
		try {
			pageBean = eTrainService.findTrainListNotDo(pageBean);
			//给日期加中文
			for(ETrainCustom eTrainCustom : pageBean.getBeanList()) {
				String date2 = dateToString(eTrainCustom.getDate());
				eTrainCustom.setDate2(date2);
			}
			//显示到页面
			model.addAttribute("pageBean", pageBean);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "train/showTrain";
	}
	
	/**
	 * 查看已完成培训计划列表
	 */
	@RequestMapping("/entryList2")
	public String entryList2(Model model, Integer pc) throws Exception {
		//分页信息
		PageBean<ETrainCustom> pageBean = new PageBean<ETrainCustom>(); //分页类
		int ps = 16; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		//调用业务层方法，查询所有已完成计划信息
		try {
			pageBean = eTrainService.findTrainListDo(pageBean); //如果list长度为0，service层会抛异常
			//给日期加中文
			for(ETrainCustom eTrainCustom : pageBean.getBeanList()) {
				String date2 = dateToString(eTrainCustom.getDate());
				eTrainCustom.setDate2(date2);
			}
			//显示到页面
			model.addAttribute("pageBean", pageBean);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "train/showTrain2";
	}
	
	/**
	 * 查看未完成培训计划细节
	 */
	@RequestMapping("/entryDetail")
	public String entryDetail(String id, Model model) throws Exception {
		ETrainCustom eTrainCustom = eTrainService.findTrain(id);
		String date2 = dateToString(eTrainCustom.getDate());
		model.addAttribute("date2", date2);
		model.addAttribute("eTrainCustom", eTrainCustom);
		return "train/showTrainDetail";
	}
	
	/**
	 * 查看已完成培训计划细节
	 */
	@RequestMapping("/entryDetail2")
	public String entryDetail2(String id, Model model) throws Exception {
		ETrainCustom eTrainCustom = eTrainService.findTrain(id);
		String date2 = dateToString(eTrainCustom.getDate());
		model.addAttribute("date2", date2);
		model.addAttribute("eTrainCustom", eTrainCustom);
		return "train/showTrainDetail2";
	}
	
	/**
	 * 进入修改培训计划页面
	 */
	@RequestMapping("/entryUpdate")
	public String entryUpdate(String id, Model model) throws Exception {
		ETrainCustom eTrainCustom = eTrainService.findTrain(id);
		String date2 = new SimpleDateFormat("yyyy-MM-dd/HH:mm").format(eTrainCustom.getDate());
		model.addAttribute("date2", date2);
		model.addAttribute("eTrain", eTrainCustom); //起名eTrain是为了方便修改后的回显
		return "train/updateTrain";
	}
	
	/**
	 * 提交修改
	 */
	@RequestMapping(value="/submitUpdate",method={RequestMethod.POST})
	public String submitUpdate(String id, String date2, ETrain eTrain, Model model) throws Exception {
		model.addAttribute("date2", date2);
		model.addAttribute("eTrain", eTrain);
		//格式转换
		Date date = stringToDate(date2);
		eTrain.setDate(date);
		model.addAttribute("info", "操作提示：修改成功！");
		try {
			eTrainService.updateTrain(id, eTrain);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "train/updateTrain";
	}

	/**
	 * 设置为已完成
	 */
	@RequestMapping("/submitDo")
	public String submitDo(String id, Model model) throws Exception {
		try {
			eTrainService.updateTrainDo(id);
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
			eTrainService.updateTrainNotDo(id);
		} catch (CustomException ce) {
			model.addAttribute("alertInfo", "操作提示：" + ce.getMessage());
		}
		return entryList(model, 1);  //到未完成列表中查看
	}
	
	/**
	 * 删除培训计划
	 */
	@RequestMapping("/submitDelete")
	public String submitDelete(String id, Model model) throws Exception {
		model.addAttribute("delInfo", "deleteSuccess");
		ETrainCustom eTrainCustom = eTrainService.findTrain(id);
		try {
			eTrainService.deleteTrain(id);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		//判断是删除了已完成还是未完成计划，然后转到相应的页面
		if(eTrainCustom.getIsFinish() == 0) {
			return entryList(model, 1);  //到未完成列表中查看
		}else {
			return entryList2(model, 1);  //到已完成列表中查看
		}
	}
	
	/**
	 * 用于页面显示中文时间
	 * @param date
	 * @return
	 */
	public String dateToString(Date date) {
		String str = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分").format(date);
		return str;
	}
	
	/**
	 * 用于页面表单字符串转Date类型
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public Date stringToDate(String str) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd/HH:mm").parse(str);
		return date;
	}
}
