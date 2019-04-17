package cn.zengzhaoshang.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zengzhaoshang.dto.EStaffCustom;
import cn.zengzhaoshang.dto.EStaffQueryVo;
import cn.zengzhaoshang.dto.PageBean;
import cn.zengzhaoshang.entity.EDepart;
import cn.zengzhaoshang.entity.EStaff;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EDepartService;
import cn.zengzhaoshang.service.EStaffService;
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
@RequestMapping("/staff")
public class EStaffController {
	
//	private static Logger logger = Logger.getLogger(EStaffController.class);

	@Autowired
	private EStaffService eStaffService;

	@Autowired
	private EDepartService eDepartService;

	/**
	 * 进入添加员工页面
	 */
	@RequestMapping("/entryAdd")
	public String entryAdd() throws Exception {
		return "staff/addStaff";
	}

	/**
	 * 提供部门信息 用于添加部门信息时选择上级部门 通过返回值回显，显示到<select>标签，显示为部门名称，真正传到服务器的是部门id
	 * 
	 * @return
	 * @throws Exception
	 */
	@ModelAttribute("departs")
	public Map<String, String> getDeparts() throws Exception {
		Map<String, String> departs = new LinkedHashMap<String, String>();
		departs.put("", "--选择部门--");  //先添加一个不选的默认值
		List<EDepart> list = eDepartService.findDeparts();
		for(EDepart eDepart : list) {
			departs.put(eDepart.getId(),eDepart.getDeptName());
		}
		return departs;
	}

	/**
	 * 添加员工后提交
	 */
	@RequestMapping(value = "/submitAdd", method = { RequestMethod.POST })
	public String submitAdd(String birthday2, String entryDate2, EStaff eStaff, Model model) throws Exception {
		String id = WebUtils.generateID();
		Date birthday = stringToDate(birthday2);
		Date entryDate = stringToDate(entryDate2);
		eStaff.setBirthday(birthday);
		eStaff.setEntryDate(entryDate);
		model.addAttribute("info", "操作提示：提交成功！");
		try {
			// 校验工号是否重复添加
			eStaffService.findStaffNum(eStaff);
			// 保存员工信息
			eStaffService.saveStaff(id, eStaff);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "staff/addStaff";
	}

	/**
	 * 查看员工列表
	 */
	@RequestMapping("/entryList")
	public String entryList(Model model, Integer pc) throws Exception {
		//分页信息
		PageBean<EStaffCustom> pageBean = new PageBean<EStaffCustom>(); //分页类
		int ps = 16; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		//查找所有员工信息
		pageBean = eStaffService.findStaffList(pageBean);
		for (EStaffCustom eStaffCustom : pageBean.getBeanList()) {
			// 日期格式转换成字符串
			String entryDate2 = dateToString(eStaffCustom.getEntryDate());
			eStaffCustom.setEntryDate2(entryDate2);
		}
		model.addAttribute("pageBean", pageBean);
		return "staff/showStaff";
	}

	/**
	 * 进入条件查找员工页面
	 */
	@RequestMapping("/entryRequire")
	public String entryRequire() throws Exception {
		return "staff/showStaffByOne";
	}

	/**
	 * 根据条件查找员工
	 */
	@RequestMapping(value = "/submitRequire", method = { RequestMethod.GET }) //get方式可方便分页操作获得url后缀的条件部分
	public String submitRequire(String date, EStaffCustom eStaffCustom, Model model, Integer pc, HttpServletRequest request) throws Exception {
		//回显表单内容
		model.addAttribute("date", date);
		model.addAttribute("eStaffCustom", eStaffCustom);
//		System.out.println(eStaffCustom);
//		logger.debug("以上是查找员工所用的条件"); //日志debug测试
		//处理表单的条件信息
		if(eStaffCustom.getSex() == 3) {  //判断是否选择了性别
			eStaffCustom.setSex(null);
		}
		Date entryDate = null;			  // 因为数据库使用Date类型，所以要日期格式转换
		if (date != null && date != "") { //如果为空，则不给转型，直接set为null
			entryDate = stringToDate(date);
		}
		eStaffCustom.setEntryDate(entryDate);
		//get方式乱码解决
		eStaffCustom.setId(WebUtils.encoding(eStaffCustom.getId()));
		eStaffCustom.setName(WebUtils.encoding(eStaffCustom.getName()));
		eStaffCustom.setJob(WebUtils.encoding(eStaffCustom.getJob()));
		eStaffCustom.setDeptName(WebUtils.encoding(eStaffCustom.getDeptName()));
		//分页信息
		EStaffQueryVo eStaffQueryVo = new EStaffQueryVo(); //存储分页类和条件信息的包装类
		PageBean<EStaffCustom> pageBean = new PageBean<EStaffCustom>(); //分页类
		int ps = 14; //定义一页展示记录数
		if(pc == null) { //当前页码
			pc = 1;
		}
		pageBean.setPs(ps);
		pageBean.setPc(pc);
		eStaffQueryVo.setPageBean(pageBean);
		eStaffQueryVo.seteStaffCustom(eStaffCustom);
		//开始根据条件进行查找员工信息
		try {
			pageBean = eStaffService.findStaffRequire(eStaffQueryVo);
			for (EStaffCustom eStaffCustom2 : pageBean.getBeanList()) {
				// 日期格式转换
				String entryDate2 = dateToString(eStaffCustom2.getEntryDate());
				eStaffCustom2.setEntryDate2(entryDate2);
			}
			pageBean.setUrl(getUrl(request));
			model.addAttribute("pageBean", pageBean);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "staff/showStaffByOne";
	}

	/**
	 * 查看员工细节
	 */
	@RequestMapping("/entryDetail")
	public String entryDetail(String id, Model model) throws Exception {
		EStaffCustom eStaffCustom = eStaffService.findStaff(id);
		String birthday2 = dateToString(eStaffCustom.getBirthday());
		String entryDate2 = dateToString(eStaffCustom.getEntryDate());
		model.addAttribute("birthday2", birthday2);
		model.addAttribute("entryDate2", entryDate2);
		model.addAttribute("eStaffCustom", eStaffCustom);
		return "staff/showStaffDetail";
	}

	/**
	 * 进入修改员工页面
	 */
	@RequestMapping("/entryUpdate")
	public String entryUpdate(String id, Model model) throws Exception {
		EStaffCustom eStaffCustom = eStaffService.findStaff(id);
		String birthday2 = dateToString2(eStaffCustom.getBirthday());
		String entryDate2 = new SimpleDateFormat("yyyy-MM-dd").format(eStaffCustom.getEntryDate());
		model.addAttribute("birthday2", birthday2);
		model.addAttribute("entryDate2", entryDate2);
		model.addAttribute("eStaff", eStaffCustom); // 起名eStaff是为了方便修改后的回显数据，提交修改后还会回到修改页面，底部会提示成功修改的信息。
		return "staff/updateStaff";
	}

	/**
	 * 提交修改
	 */
	@RequestMapping(value = "/submitUpdate", method = { RequestMethod.POST })
	public String submitUpdate(String id, String birthday2, String entryDate2, EStaff eStaff, Model model)
			throws Exception {
		model.addAttribute("birthday2", birthday2);
		model.addAttribute("entryDate2", entryDate2);
		model.addAttribute("eStaff", eStaff);
		Date birthday = stringToDate(birthday2);
		Date entryDate = stringToDate(entryDate2);
		eStaff.setBirthday(birthday);
		eStaff.setEntryDate(entryDate);
		model.addAttribute("info", "操作提示：修改成功！");
		try {
			// 修改数据库数据
			eStaffService.updateStaff(id, eStaff);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "staff/updateStaff";
	}

	/**
	 * 删除员工
	 */
	@RequestMapping("/submitDelete")
	public String submitDelete(String id, Model model) throws Exception {
		model.addAttribute("info", "deleteSuccess");
		try {
			eStaffService.deleteStaff(id);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return entryList(model, 1);  //进入员工列表中查看删除效果
	}

	/**
	 * 字符串转日期类型，仅在员工控制层使用
	 * 
	 * @param birthday2
	 * @return
	 * @throws ParseException
	 */
	public Date stringToDate(String str) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		return date;
	}

	/**
	 * 日期类型转字符串类型，仅在员工控制层使用
	 * 
	 * @param eStaffCustom
	 * @return
	 */
	public String dateToString(Date date) {
		String str = new SimpleDateFormat("yyyy年MM月dd日").format(date);
		return str;
	}

	/**
	 * 日期格式转字符串，没有中文，用于员工修改页面
	 * 
	 * @param date
	 * @return
	 */
	public String dateToString2(Date date) {
		String str = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return str;
	}

	/**
	 * 保留原条件查询的url后缀
	 */
	private String getUrl(HttpServletRequest request){
		String contextPath = request.getContextPath(); //项目地址
		String servletPath = request.getServletPath(); //servlet地址
		String queryString = request.getQueryString(); //参数
		
		//去掉原来的pc，在页面重新加
		if(queryString.contains("&pc=")){
			int index = queryString.lastIndexOf("&pc=");
			queryString= queryString.substring(0,index);
		}
		return contextPath + servletPath + "?" +queryString;
	}
}
