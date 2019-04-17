package cn.zengzhaoshang.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Title: CustomAllExceptionResolver
 * @Description 全局异常处理器
 * @author zengzhaoshang
 * @date: 2019年4月6日 上午11:41:54  
 * @version v1.0
 */
public class CustomAllExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		//解析异常
		//如果是自定义异常，则直接获取，如果是系统异常，则设为未知异常
		CustomAllException customAllException = null;
		if(arg3 instanceof CustomAllException){
			customAllException = (CustomAllException) arg3;
		}else{
			customAllException = new CustomAllException("未知错误！");
		}
		//获取异常信息
		String message = customAllException.getMessage() + "\n内部错误，请联系系统负责人！";
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("info", message);
		modelAndView.setViewName("/errors/error");
		return modelAndView;
	}
}
