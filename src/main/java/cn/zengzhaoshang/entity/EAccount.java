package cn.zengzhaoshang.entity;

import java.io.Serializable;

/**
 * 
 * @Title: EAccount
 * @Description 登录账号 实体类
 * @author zengzhaoshang
 * @date: 2019年3月24日 下午12:13:07  
 * @version v1.0
 */
public class EAccount implements Serializable {
    /**
     * uuid格式的主键 支持以后扩展为分布式数据库
     */
    private String id;

    /**
     * 账号 不大于20个字符
     */
    private String name;

    /**
     * 权限 0是管理员权限 1是领导视察权限
     */
    private Byte power;

    /**
     * 登录密码 不大于15个字符
     */
    private String password;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}