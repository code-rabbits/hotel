package com.star.system.mapper;

import com.star.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 聂建强
 * @since 2022-01-08
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户ID查询角色列表
     * @param userId
     * @return
     */
    List<Role> selectRoleListByUserId(Integer userId);
}
