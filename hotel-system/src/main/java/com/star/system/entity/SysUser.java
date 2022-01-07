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
 * @since 2022-01-07
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
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 真实姓名	
     */
    @TableField("realName")
    private String realName;

    /**
     * 性别（1-男 2-女）
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 所属部门，对应部门表主键
     */
    @TableField("deptId")
    private Integer deptId;

    /**
     * 状态（1-可用 2-禁用）
     */
    @TableField("status")
    private Integer status;

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
     * 用户类型（1-超级管理员 2-普通用户）
     */
    @TableField("userType")
    private Integer userType;

    /**
     * 入职日期
     */
    @TableField("hireDate")
    private LocalDateTime hireDate;

    /**
     * 创建人
     */
    @TableField("createdBy")
    private Integer createdBy;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 修改人
     */
    @TableField("modifyBy")
    private Integer modifyBy;

    /**
     * 修改时间
     */
    @TableField("modifyDate")
    private LocalDateTime modifyDate;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    //一个用户有多个角色
    private List<Role> roleList;


}
