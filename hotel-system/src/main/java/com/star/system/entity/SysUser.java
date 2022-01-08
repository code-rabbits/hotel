package com.star.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 聂建强
 * @since 2022-01-08
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUser {

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 真实姓名	
     */
    @TableField("realname")
    private String realname;

    /**
     * 性别（0-男 1-女）
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 所属部门，对应部门表主键
     */
    @TableField("deptid")
    private Integer deptid;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户类型（0-超级管理员1-管理员 2-普通用户）
     */
    @TableField("usertype")
    private Integer usertype;

    /**
     * 入职日期
     */
    @TableField("hiredate")
    private LocalDateTime hiredate;

    /**
     * 所属领导
     */
    @TableField("mgr")
    private Integer mgr;

    /**
     * 状态（1-可用 0-禁用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 用户地址
     */
    @TableField("address")
    private String address;

    //一个用户有多个角色
    private List<Role> roleList;


}
