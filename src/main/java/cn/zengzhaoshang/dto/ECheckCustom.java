package cn.zengzhaoshang.dto;

import cn.zengzhaoshang.entity.ECheck;

/**
 * 
 * @Title: ECheckCustom
 * @Description 考勤信息 扩展类 增加考勤员工信息
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午5:12:55  
 * @version v1.0
 */
public class ECheckCustom extends ECheck{
	private static final long serialVersionUID = 1L;

	/**
     * 工号
     */
    private String jobNum;

    /**
     * 姓名 不大于19个字符
     */
    private String staffName;

    /**
     * 性别 男0女1
     */
    private Byte sex;
    
    /**
     * 职务 不大于29个字符
     */
    private String job;
    
    /**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 是否达标 0否1是
	 */
	private int isDaBiao;

	/**
	 * @return the isDaBiao
	 */
	public int getIsDaBiao() {
		return isDaBiao;
	}

	/**
	 * @param isDaBiao the isDaBiao to set
	 */
	public void setIsDaBiao(int isDaBiao) {
		this.isDaBiao = isDaBiao;
	}

	/**
	 * @return the jobNum
	 */
	public String getJobNum() {
		return jobNum;
	}

	/**
	 * @param jobNum the jobNum to set
	 */
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * @return the sex
	 */
	public Byte getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
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
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((jobNum == null) ? 0 : jobNum.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((staffName == null) ? 0 : staffName.hashCode());
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
		if (!(obj instanceof ECheckCustom)) {
			return false;
		}
		ECheckCustom other = (ECheckCustom) obj;
		if (deptName == null) {
			if (other.deptName != null) {
				return false;
			}
		} else if (!deptName.equals(other.deptName)) {
			return false;
		}
		if (job == null) {
			if (other.job != null) {
				return false;
			}
		} else if (!job.equals(other.job)) {
			return false;
		}
		if (jobNum == null) {
			if (other.jobNum != null) {
				return false;
			}
		} else if (!jobNum.equals(other.jobNum)) {
			return false;
		}
		if (sex == null) {
			if (other.sex != null) {
				return false;
			}
		} else if (!sex.equals(other.sex)) {
			return false;
		}
		if (staffName == null) {
			if (other.staffName != null) {
				return false;
			}
		} else if (!staffName.equals(other.staffName)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ECheckCustom [jobNum=" + jobNum + ", staffName=" + staffName + ", sex=" + sex + ", job=" + job
				+ ", deptName=" + deptName + ", getId()=" + getId() + ", getStaffId()=" + getStaffId()
				+ ", getCheckDate()=" + getCheckDate() + ", getLateNum()=" + getLateNum() + ", getEarlyNum()="
				+ getEarlyNum() + ", getAbsenceNum()=" + getAbsenceNum() + ", getLeaveNum()=" + getLeaveNum()
				+ ", getTripNum()=" + getTripNum() + ", getVersion()=" + getVersion() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
