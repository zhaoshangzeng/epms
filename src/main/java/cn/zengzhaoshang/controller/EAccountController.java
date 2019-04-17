package cn.zengzhaoshang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zengzhaoshang.entity.EAccount;
import cn.zengzhaoshang.exception.CustomException;
import cn.zengzhaoshang.service.EAccountService;
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
@RequestMapping("/account")
public class EAccountController {
	
	@Autowired
	private EAccountService eAccountService;

	/**
	 * 进入添加账号页面
	 */
	@RequestMapping("/entryAdd")
	public String entryAdd() throws Exception {
		return "account/addAccount";
	}
	
	/**
	 * 添加账号后提交
	 * @throws Exception 
	 */
	@RequestMapping(value="/submitAdd",method={RequestMethod.POST})
	public String submitAdd(String password2, EAccount eAccount, Model model) throws Exception {
		model.addAttribute("password2", password2);
		if(!eAccount.getPassword().equals(password2)) {
			model.addAttribute("info", "操作提示：两次密码不一致！请重新填写密码！");
			return "account/addAccount";
		}
		String id = WebUtils.generateID();
		model.addAttribute("info", "操作提示：提交成功！");
		try {
			//校验是否存在相同账户名，保证账号唯一性
			eAccountService.findAccountByNotName(eAccount);
			//存储账户信息
			eAccountService.saveAccount(id, eAccount);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "account/addAccount";
	}
	
	/**
	 * 查看账号列表
	 */
	@RequestMapping("/entryList")
	public String entryList(Model model) throws Exception {
		List<EAccount> list = eAccountService.findAccountList();
		model.addAttribute("list", list);
		return "account/showAccount";
	}
	
	/**
	 * 进入修改账号页面
	 */
	@RequestMapping("/entryUpdate")
	public String entryUpdate(String id, Model model) throws Exception {
		EAccount eAccount = eAccountService.findAccount(id);
		model.addAttribute("eAccount", eAccount);
		return "account/updateAccount";
	}
	
	/**
	 * 提交修改
	 */
	@RequestMapping(value="/submitUpdate",method={RequestMethod.POST})
	public String submitUpdate(String id, String password2, EAccount eAccount, Model model) throws Exception {
		model.addAttribute("password2", password2);
		model.addAttribute("eAccount", eAccount);
		if(!eAccount.getPassword().equals(password2)) {
			model.addAttribute("info", "操作提示：两次密码不一致！请重新填写密码！");
			return "account/updateAccount";
		}
		model.addAttribute("info", "操作提示：修改成功！");
		try {
			//校验是否存在相同账户名，避免修改了账号名，导致又不知道账户名，无法登陆的可怕事件。不能修改账号名，应该添加新账号名。
			eAccountService.findAccountByName(eAccount);
			//修改数据库数据
			eAccountService.updateAccount(id, eAccount);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return "account/updateAccount";
	}
	
	/**
	 * 删除账号
	 */
	@RequestMapping("/submitDelete")
	public String submitDelete(String id, Model model) throws Exception {
		model.addAttribute("info", "deleteSuccess");
		try {
			eAccountService.deleteAccount(id);
		} catch (CustomException ce) {
			model.addAttribute("info", "操作提示：" + ce.getMessage());
		}
		return entryList(model); //回到账号列表，查看删除效果
	}
	
	/**
	 * 回到主管理界面
	 */
	@RequestMapping("/entryAdmin")
	public String entryAdmin() throws Exception {
		return "admin";
	}
	
	/**
	 * 处理登录
	 */
	@RequestMapping("/submitLogin")
	public void submitLogin(EAccount eAccount, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			//校验账户和密码是否存在
			eAccountService.findAccount(eAccount);
		} catch (CustomException ce) {
			//校验失败的跳转 和 回显提示信息
			request.setAttribute("info", "操作提示：" + ce.getMessage());
			request.setAttribute("eAccount", eAccount);  //用于回显错误账号，方便修改
			request.getRequestDispatcher("/").forward(request, response);
			return;
		}
		//根据账号查找管理权限
		Byte power = eAccountService.findPower(eAccount);
		session.setAttribute("power", power+""); //存到session中，让拦截器获取，让其他页面获取
		//校验成功的跳转 和 让拦截器通过
		request.getRequestDispatcher("/WEB-INF/jsps/admin.jsp").forward(request, response);
	}
	
	/**
	 * 安全退出
	 */
	@RequestMapping("/submitLogout")
	public void submitLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		//清空session的用户名，让拦截器拦截
		session.removeAttribute("power");
		//退出到登录页面
		request.setAttribute("info", "操作提示：账号安全退出成功！");
		request.getRequestDispatcher("/").forward(request, response);
	}
}
