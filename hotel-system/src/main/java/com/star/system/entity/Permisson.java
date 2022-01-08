package com.star.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_permisson")
public class Permisson {

    /**
     * 权限菜单编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级菜单编号
     */
    @TableField("pid")
    private Integer pid;

    /**
     * 菜单类型(菜单为menu，权限为permission)
     */
    @TableField("type")
    private String type;

    /**
     * 菜单名称
     */
    @TableField("title")
    private String title;

    /**
     * 权限编码
     */
    @TableField("percode")
    private String percode;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 菜单地址
     */
    @TableField("href")
    private String href;

    /**
     * 是否展开（1-展开 0-折叠）
     */
    @TableField("spread")
    private Integer spread;

    /**
     * 状态（0：不可以 1：可以）
     */
    @TableField("status")
    private Integer status;


}
