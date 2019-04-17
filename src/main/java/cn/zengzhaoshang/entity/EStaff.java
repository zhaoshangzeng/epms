package cn.zengzhaoshang.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Title: EStaff
 * @Description 企业员工信息 实体类
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午3:04:30  
 * @version v1.0
 */
public class EStaff implements Serializable {
    /**
     * uuid格式的主键
     */
    private String id;

    /**
     * 工号  不大于19个字符
     */
    private String jobNum;

    /**
     * 姓名 不大于19个字符
     */
    private String name;

    /**
     * 性别 男0女1
     */
    private Byte sex;

    /**
     * 名族 不大于9个字符
     */
    private String nations;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 政治面貌 不大于14个字符
     */
    private String political;

    /**
     * 婚姻状况 未婚0已婚1
     */
    private Byte marriage;

    /**
     * 毕业院校 不大于59个字符
     */
    private String school;

    /**
     * 学历 不大于5个字符
     */
    private String education;

    /**
     * 籍贯 不大于19个字符
     */
    private String birthPlace;

    /**
     * 住址 不大于99个字符
     */
    private String home;

    /**
     * 手机号码 固长11个字符
     */
    private String mobile;

    /**
     * 微信号 不大于20个字符
     */
    private String wechat;

    /**
     * qq号 不大于15个字符
     */
    private String qq;

    /**
     * 外键，指向部门id
     */
    private String deptId;

    /**
     * 职务 不大于29个字符
     */
    private String job;

    /**
     * 入职日期
     */
    private Date entryDate;

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

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum == null ? null : jobNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getNations() {
        return nations;
    }

    public void setNations(String nations) {
        this.nations = nations == null ? null : nations.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public Byte getMarriage() {
        return marriage;
    }

    public void setMarriage(Byte marriage) {
        this.marriage = marriage;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home == null ? null : home.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}