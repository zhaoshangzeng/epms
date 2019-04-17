package cn.zengzhaoshang.dto;

import cn.zengzhaoshang.entity.EDepart;

/**
 * 
 * @Title: EDepartCustom
 * @Description 部门扩展类 包含上级部门信息
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午1:25:05  
 * @version v1.0
 */
public class EDepartCustom extends EDepart {
	private static final long serialVersionUID = 1L;
	/**
	 * 上级部门名称
	 */
	private String deptTopName;

	/**
	 * @return the deptTopName
	 */
	public String getDeptTopName() {
		return deptTopName;
	}

	/**
	 * @param deptTopName the deptTopName to set
	 */
	public void setDeptTopName(String deptTopName) {
		this.deptTopName = deptTopName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptTopName == null) ? 0 : deptTopName.hashCode());
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
		if (!(obj instanceof EDepartCustom)) {
			return false;
		}
		EDepartCustom other = (EDepartCustom) obj;
		if (deptTopName == null) {
			if (other.deptTopName != null) {
				return false;
			}
		} else if (!deptTopName.equals(other.deptTopName)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EDepartCustom [deptTopName=" + deptTopName + ", getId()=" + getId() + ", getDeptNum()=" + getDeptNum()
				+ ", getDeptName()=" + getDeptName() + ", getDeptDesc()=" + getDeptDesc() + ", getDeptTop()="
				+ getDeptTop() + ", getVersion()=" + getVersion() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
}
