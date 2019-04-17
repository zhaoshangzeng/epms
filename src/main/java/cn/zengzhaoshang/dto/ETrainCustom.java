package cn.zengzhaoshang.dto;

import cn.zengzhaoshang.entity.ETrain;

/**
 * 
 * @Title: ETrainCustom
 * @Description 培训计划 扩展类 增加部门信息
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午10:14:29  
 * @version v1.0
 */
public class ETrainCustom extends ETrain {
	private static final long serialVersionUID = 1L;

	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 用于页面中文显示的时间
	 */
	private String date2;

	/**
	 * @return the date2
	 */
	public String getDate2() {
		return date2;
	}

	/**
	 * @param date2 the date2 to set
	 */
	public void setDate2(String date2) {
		this.date2 = date2;
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
		if (!(obj instanceof ETrainCustom)) {
			return false;
		}
		ETrainCustom other = (ETrainCustom) obj;
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
		return "ETrainCustom [deptName=" + deptName + ", getId()=" + getId() + ", getDeptId()=" + getDeptId()
				+ ", getName()=" + getName() + ", getDate()=" + getDate() + ", getPlace()=" + getPlace()
				+ ", getTeacher()=" + getTeacher() + ", getNumber()=" + getNumber() + ", getOutlay()=" + getOutlay()
				+ ", getVersion()=" + getVersion() + ", getContent()=" + getContent() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
