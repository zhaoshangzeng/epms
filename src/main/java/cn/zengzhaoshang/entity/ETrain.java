package cn.zengzhaoshang.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Title: ETrain
 * @Description 培训计划 实体类
 * @author zengzhaoshang
 * @date: 2019年3月26日 下午3:41:33  
 * @version v1.0
 */
public class ETrain implements Serializable {
    /**
     * uuid格式的主键 支持以后扩展为分布式数据库
     */
    private String id;

    /**
     * 培训部门 执行部门的外键
     */
    private String deptId;

    /**
     * 培训主题 不大于99个字符
     */
    private String name;

    /**
     * 培训时间
     */
    private Date date;

    /**
     * 培训场所 不大于49个字符
     */
    private String place;

    /**
     * 培训讲师 不大于19个字符
     */
    private String teacher;

    /**
     * 培训人数
     */
    private Short number;

    /**
     * 培训经费 不大于14个字符
     */
    private String outlay;

    /**
     * 是否完成 1是0否
     */
    private Byte isFinish;

    /**
     * 用于乐观锁，防并发修改问题
     */
    private Integer version;

    /**
     * 培训具体内容
     */
    private String content;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public String getOutlay() {
        return outlay;
    }

    public void setOutlay(String outlay) {
        this.outlay = outlay == null ? null : outlay.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}