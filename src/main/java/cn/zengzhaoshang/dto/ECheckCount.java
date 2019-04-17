package cn.zengzhaoshang.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 
 * @Title: ECheckCount
 * @Description 考勤信息统计类
 * @author zengzhaoshang
 * @date: 2019年3月27日 上午9:27:54  
 * @version v1.0
 */
public class ECheckCount implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
     * 考勤的年月
     */
    private Date checkDate;
    
    /**
     * 考勤总人数
     */
    private int staffNum;
    
    /**
     * 达标总人数
     */
    private int staffDaBiaoNum;
    
    /**
     * 未达标总人数
     */
    private int staffNotDaBiaoNum;
    
    /**
     * 总达标比例
     */
    private String ratio;
    
    /**
     * 各部门未达标的人员情况
     */
    private Map<String, String> deptRatio;

	/**
	 * @return the checkDate
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * @param checkDate the checkDate to set
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * @return the staffNum
	 */
	public int getStaffNum() {
		return staffNum;
	}

	/**
	 * @param staffNum the staffNum to set
	 */
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}

	/**
	 * @return the staffDaBiaoNum
	 */
	public int getStaffDaBiaoNum() {
		return staffDaBiaoNum;
	}

	/**
	 * @param staffDaBiaoNum the staffDaBiaoNum to set
	 */
	public void setStaffDaBiaoNum(int staffDaBiaoNum) {
		this.staffDaBiaoNum = staffDaBiaoNum;
	}

	/**
	 * @return the staffNotDaBiaoNum
	 */
	public int getStaffNotDaBiaoNum() {
		return staffNotDaBiaoNum;
	}

	/**
	 * @param staffNotDaBiaoNum the staffNotDaBiaoNum to set
	 */
	public void setStaffNotDaBiaoNum(int staffNotDaBiaoNum) {
		this.staffNotDaBiaoNum = staffNotDaBiaoNum;
	}

	/**
	 * @return the ratio
	 */
	public String getRatio() {
		return ratio;
	}

	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	/**
	 * @return the deptRatio
	 */
	public Map<String, String> getDeptRatio() {
		return deptRatio;
	}

	/**
	 * @param deptRatio the deptRatio to set
	 */
	public void setDeptRatio(Map<String, String> deptRatio) {
		this.deptRatio = deptRatio;
	}
    
    
}
