package cn.zengzhaoshang.dto;

import java.util.Date;

/**
 * 
 * @Title: ECheckQueryVo
 * @Description 员工考勤 包装类 包装查询条件信息和分页信息
 * @author zengzhaoshang
 * @date: 2019年4月4日 下午9:48:53  
 * @version v1.0
 */
public class ECheckQueryVo {
	/**
	 * 包含查询条件（多条件查询）
	 */
	private ECheckCustom eCheckCustom;
	
	/**
	 * 包含分页信息
	 */
	private PageBean<ECheckCustom> pageBean;
	
	/**
	 * 考勤月份
	 */
	private Date month;

	/**
	 * @return the month
	 */
	public Date getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(Date month) {
		this.month = month;
	}

	/**
	 * @return the eCheckCustom
	 */
	public ECheckCustom geteCheckCustom() {
		return eCheckCustom;
	}

	/**
	 * @param eCheckCustom the eCheckCustom to set
	 */
	public void seteCheckCustom(ECheckCustom eCheckCustom) {
		this.eCheckCustom = eCheckCustom;
	}

	/**
	 * @return the pageBean
	 */
	public PageBean<ECheckCustom> getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<ECheckCustom> pageBean) {
		this.pageBean = pageBean;
	}
	
}
