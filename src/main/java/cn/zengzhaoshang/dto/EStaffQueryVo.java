package cn.zengzhaoshang.dto;

/**
 * 
 * @Title: EStaffQueryVo
 * @Description 企业员工 包装类  包装查询条件和分页信息
 * @author zengzhaoshang
 * @date: 2019年4月5日 上午10:31:27  
 * @version v1.0
 */
public class EStaffQueryVo {

	/**
	 * 包含查询条件
	 */
	private EStaffCustom eStaffCustom;
	
	/**
	 * 包含分页信息
	 */
	private PageBean<EStaffCustom> pageBean;

	/**
	 * @return the eStaffCustom
	 */
	public EStaffCustom geteStaffCustom() {
		return eStaffCustom;
	}

	/**
	 * @param eStaffCustom the eStaffCustom to set
	 */
	public void seteStaffCustom(EStaffCustom eStaffCustom) {
		this.eStaffCustom = eStaffCustom;
	}

	/**
	 * @return the pageBean
	 */
	public PageBean<EStaffCustom> getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<EStaffCustom> pageBean) {
		this.pageBean = pageBean;
	}
	
}
