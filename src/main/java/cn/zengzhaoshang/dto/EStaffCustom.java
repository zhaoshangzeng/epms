package cn.zengzhaoshang.dto;

import cn.zengzhaoshang.entity.EStaff;

/**
 * 
 * @Title: EStaffCustom
 * @Description 企业员工 扩展类 增加所属部门名称
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午4:26:17  
 * @version v1.0
 */
public class EStaffCustom extends EStaff {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 用于页面中文显示的时间
	 */
	private String entryDate2;

	/**
	 * @return the entryDate2
	 */
	public String getEntryDate2() {
		return entryDate2;
	}

	/**
	 * @param entryDate2 the entryDate2 to set
	 */
	public void setEntryDate2(String entryDate2) {
		this.entryDate2 = entryDate2;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EStaffCustom)) {
			return false;
		}
		EStaffCustom other = (EStaffCustom) obj;
		if (deptName == null) {
			if (other.deptName != null) {
				return false;
			}
		} else if (!deptName.equals(other.deptName)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EStaffCustom [deptName=" + deptName + ", entryDate2=" + entryDate2 + ", getId()=" + getId()
				+ ", getJobNum()=" + getJobNum() + ", getName()=" + getName() + ", getSex()=" + getSex()
				+ ", getNations()=" + getNations() + ", getBirthday()=" + getBirthday() + ", getPolitical()="
				+ getPolitical() + ", getMarriage()=" + getMarriage() + ", getSchool()=" + getSchool()
				+ ", getEducation()=" + getEducation() + ", getBirthPlace()=" + getBirthPlace() + ", getHome()="
				+ getHome() + ", getMobile()=" + getMobile() + ", getWechat()=" + getWechat() + ", getQq()=" + getQq()
				+ ", getDeptId()=" + getDeptId() + ", getJob()=" + getJob() + ", getEntryDate()=" + getEntryDate()
				+ ", getVersion()=" + getVersion() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

}
