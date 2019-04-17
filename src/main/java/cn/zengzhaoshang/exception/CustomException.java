package cn.zengzhaoshang.exception;

/**
 * 
 * @Title: UpdateException
 * @Description 局部异常，显示到用户当前页面
 * @author zengzhaoshang
 * @date: 2019年3月27日 下午12:00:26  
 * @version v1.0
 */
public class CustomException extends Exception {
	
	private static final long serialVersionUID = 1L;
	//异常信息
	public String message;
	
	public CustomException(String message){
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
