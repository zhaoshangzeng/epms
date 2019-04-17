package cn.zengzhaoshang.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Title: EEmploy
 * @Description 招聘计划 实体类
 * @author zengzhaoshang
 * @date: 2019年3月26日 下午3:41:55  
 * @version v1.0
 */
public class EEmploy implements Serializable {
    /**
     * uuid格式的主键 支持以后扩展为分布式数据库
     */
    private String id;

    /**
     * 招聘部门 执行部门的外键
     */
    private String deptId;

    /**
     * 招聘岗位 不大于29个字符
     */
    private String jobName;

    /**
     * 招聘人数
     */
    private Short empNum;

    /**
     * 预定薪资 不大于14个字符
     */
    private String jobPay;

    /**
     * 招聘日期
     */
    private Date empDate;

    /**
     * 是否急招 1是0否
     */
    private Byte isNowEmp;

    /**
     * 是否完成 1是0否  默认为0
     */
    private Byte isFinish;

    /**
     * 用于乐观锁，防并发修改问题
     */
    private Integer version;

    /**
     * 招聘要求
     */
    private String jobRequire;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public Short getEmpNum() {
        return empNum;
    }

    public void setEmpNum(Short empNum) {
        this.empNum = empNum;
    }

    public String getJobPay() {
        return jobPay;
    }

    public void setJobPay(String jobPay) {
        this.jobPay = jobPay == null ? null : jobPay.trim();
    }

    public Date getEmpDate() {
        return empDate;
    }

    public void setEmpDate(Date empDate) {
        this.empDate = empDate;
    }

    public Byte getIsNowEmp() {
        return isNowEmp;
    }

    public void setIsNowEmp(Byte isNowEmp) {
        this.isNowEmp = isNowEmp;
    }

    public Byte getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Byte isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire == null ? null : jobRequire.trim();
    }
}