package cn.zengzhaoshang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Title: LoginByPower
 * @Description 登录权限拦截器
 * @author zengzhaoshang
 * @date: 2019年4月6日 上午11:42:26  
 * @version v1.0
 */
public class LoginByPower implements HandlerInterceptor {

	/**
	 * 执行完handler便执行该方法
	 * 应用：统一异常处理、统一的日志处理
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object handler, Exception arg3)
			throws Exception {
		System.out.println("刚从handler出来");
	}

	/**
	 * 进入handler方法之后，在返回modelandview之前执行
	 * 应用：将公用模型数据（如菜单导航）在这里传给视图
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object handler, ModelAndView arg3) throws Exception {
		System.out.println("进入handler内部");
	}

	/**
	 * 进入handler方法之前执行
	 * 应用：身份认证、身份授权
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println("拦截器开始拦截");
//		String requestURI = arg0.getRequestURI();
		//给进入登录页面的客户放行
//		if(requestURI.indexOf("/user/showLogin.action")>=0){
//			return true;
//		}
		//给json放行
//		if(requestURI.indexOf("/user/requestKV.action")>=0){
//			return true;
//		}
		//给有session的客户进入所有页面
		HttpSession session = request.getSession();
		String power = (String) session.getAttribute("power");
		if(power != null){
			System.out.println("拦截器放行");
			return true; //存在用户名，则放行
		}
		//给没有session的客户回到登录页面 
		request.getRequestDispatcher("/WEB-INF/jsps/errors/errorAdmin.jsp").forward(request, response);
		return false; //false拦截，不向下执行，true为放行
	}

}
