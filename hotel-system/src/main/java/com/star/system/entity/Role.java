package com.star.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("sys_role")
public class Role {

    /**
     * 角色编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色代码
     */
    @TableField("rolecode")
    private String rolecode;

    /**
     * 角色名称
     */
    @TableField("rolename")
    private String rolename;

    /**
     * 角色描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
