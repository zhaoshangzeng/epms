package cn.zengzhaoshang.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Title: ECheck
 * @Description 考勤信息 实体类
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:13:27  
 * @version v1.0
 */
public class ECheck implements Serializable {
    /**
     * uuid格式的主键 支持以后扩展为分布式数据库
     */
    private String id;

    /**
     * 考勤员工 指向员工表的外键
     */
    private String staffId;

    /**
     * 考勤的年月
     */
    private Date checkDate;

    /**
     * 该月迟到次数
     */
    private Byte lateNum;

    /**
     * 该月早退次数
     */
    private Byte earlyNum;

    /**
     * 该月旷工次数
     */
    private Byte absenceNum;

    /**
     * 该月请假次数
     */
    private Byte leaveNum;

    /**
     * 该月出差次数
     */
    private Byte tripNum;

    /**
     * 用于乐观锁，防并发修改问题
     */
    private Integer version;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Byte getLateNum() {
        return lateNum;
    }

    public void setLateNum(Byte lateNum) {
        this.lateNum = lateNum;
    }

    public Byte getEarlyNum() {
        return earlyNum;
    }

    public void setEarlyNum(Byte earlyNum) {
        this.earlyNum = earlyNum;
    }

    public Byte getAbsenceNum() {
        return absenceNum;
    }

    public void setAbsenceNum(Byte absenceNum) {
        this.absenceNum = absenceNum;
    }

    public Byte getLeaveNum() {
        return leaveNum;
    }

    public void setLeaveNum(Byte leaveNum) {
        this.leaveNum = leaveNum;
    }

    public Byte getTripNum() {
        return tripNum;
    }

    public void setTripNum(Byte tripNum) {
        this.tripNum = tripNum;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}