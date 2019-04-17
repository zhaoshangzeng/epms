package cn.zengzhaoshang.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @Title: WebUtils
 * @Description web层或control层  工具类
 * @author zengzhaoshang
 * @date: 2019年3月28日 下午5:29:24  
 * @version v1.0
 */
public class WebUtils {

	/**
	 * 类中全部是静态方法，不建议提供对象
	 */
	private WebUtils() {}
	
	/**
	 * 产生UUID，为实体类提供id值
	 */
	public static String generateID(){
		UUID randomUUID = UUID.randomUUID();
		String uuid = randomUUID.toString().replace("-", "").toUpperCase();
		return uuid;
	}
	
	/**
	 * 获取上个月的日期
	 * @return
	 */
	public static String getLastMonth() {
		Date d = new Date();
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(d); // 设置为当前时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
		d = calendar.getTime(); //转为Date类型
		
		return new SimpleDateFormat("yyyy-MM").format(d); //清空具体日期
	}
	
	/**
	 * 给get方式获取的参数进行转换编码
	 * @param str
	 * @return
	 */
	public static String encoding(String str) {
		if(str == null || str == "") {
			return null;
		}
		try {
			str = new String(str.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
		return str;
	}
}
