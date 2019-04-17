package cn.zengzhaoshang.entity;

import java.io.Serializable;

/**
 * 
 * @Title: EDepart
 * @Description 部门信息 实体类
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午3:04:08  
 * @version v1.0
 */
public class EDepart implements Serializable {
    /**
     * uuid格式的主键 支持以后扩展为分布式数据库
     */
    private String id;

    /**
     * 部门号  不大于19个字
     */
    private String deptNum;

    /**
     * 部门名称 不大于19个字符
     */
    private String deptName;

    /**
     * 部门描述 不大于99个字符
     */
    private String deptDesc;

    /**
     * 上级部门 外键 指向同表另一条记录的主键
     */
    private String deptTop;

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

    public String getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum == null ? null : deptNum.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc == null ? null : deptDesc.trim();
    }

    public String getDeptTop() {
        return deptTop;
    }

    public void setDeptTop(String deptTop) {
        this.deptTop = deptTop == null ? null : deptTop.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}