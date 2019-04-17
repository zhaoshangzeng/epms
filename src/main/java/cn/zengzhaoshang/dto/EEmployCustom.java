package cn.zengzhaoshang.dto;

import cn.zengzhaoshang.entity.EEmploy;

/**
 * 
 * @Title: EEmployCustom
 * @Description 招聘计划 扩展类 增加部门信息
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午8:56:24  
 * @version v1.0
 */
public class EEmployCustom extends EEmploy {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 用于页面中文显示的时间
	 */
	private String empDate2;
	
	/**
	 * @return the empDate2
	 */
	public String getEmpDate2() {
		return empDate2;
	}

	/**
	 * @param empDate2 the empDate2 to set
	 */
	public void setEmpDate2(String empDate2) {
		this.empDate2 = empDate2;
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
		if (!(obj instanceof EEmployCustom)) {
			return false;
		}
		EEmployCustom other = (EEmployCustom) obj;
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
		return "EEmployCustom [deptName=" + deptName + ", getId()=" + getId() + ", getDeptId()=" + getDeptId()
				+ ", getJobName()=" + getJobName() + ", getEmpNum()=" + getEmpNum() + ", getJobPay()=" + getJobPay()
				+ ", getEmpDate()=" + getEmpDate() + ", getIsNowEmp()=" + getIsNowEmp() + ", getVersion()="
				+ getVersion() + ", getJobRequire()=" + getJobRequire() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
}
