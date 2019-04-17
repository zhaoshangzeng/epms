package cn.zengzhaoshang.exception;

/**
 * 
 * @Title: CustomAllException
 * @Description 全局异常，显示到统一页面
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午12:44:59  
 * @version v1.0
 */
public class CustomAllException extends Exception {
	
	private static final long serialVersionUID = 1L;
	//异常信息
	public String message;
	
	public CustomAllException(String message){
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
