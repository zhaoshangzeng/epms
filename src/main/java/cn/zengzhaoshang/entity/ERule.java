package cn.zengzhaoshang.entity;

import java.io.Serializable;

/**
 * 
 * @Title: ERule
 * @Description 考勤达标规则 实体类
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:15:03  
 * @version v1.0
 */
public class ERule implements Serializable {
    /**
     * 主键 系统仅一个规则 仅修改不增加
     */
    private Byte id;

    /**
     * 最大迟到次数 TINYINT类型的值不大于127
     */
    private Byte maxLate;

    /**
     * 最大早退次数
     */
    private Byte maxEarly;

    /**
     * 最大旷工次数
     */
    private Byte maxAbsence;

    /**
     * 最大请假次数
     */
    private Byte maxLeave;

    /**
     * 用于乐观锁，防并发修改问题
     */
    private Integer version;

    private static final long serialVersionUID = 1L;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public Byte getMaxLate() {
        return maxLate;
    }

    public void setMaxLate(Byte maxLate) {
        this.maxLate = maxLate;
    }

    public Byte getMaxEarly() {
        return maxEarly;
    }

    public void setMaxEarly(Byte maxEarly) {
        this.maxEarly = maxEarly;
    }

    public Byte getMaxAbsence() {
        return maxAbsence;
    }

    public void setMaxAbsence(Byte maxAbsence) {
        this.maxAbsence = maxAbsence;
    }

    public Byte getMaxLeave() {
        return maxLeave;
    }

    public void setMaxLeave(Byte maxLeave) {
        this.maxLeave = maxLeave;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}