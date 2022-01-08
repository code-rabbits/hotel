package com.star.system.security;

import com.star.system.entity.Role;
import com.star.system.entity.SysUser;
import com.star.system.mapper.SysUserMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private SysUserMapper sysUserMapper;


    /**
     * 用户认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //创建集合保存角色列表
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();

        //调用根据用户名查询用户信息的方法
        SysUser sysUser = sysUserMapper.selectUserByUserName(username);

        //循环遍历角色列表
        for (Role role:sysUser.getRoleList()){
            //将角色编码添加到角色列表集合中
            authorities.add(new SimpleGrantedAuthority(role.getRolecode()));
        }

        //创建认证用户对象
        /**
         * 参数1：用户名
         * 参数2：密码
         * 参数3：角色列表
         */
        //注意，该User对象是SpringSecurity的User
        User user=new User(sysUser.getUsername(), sysUser.getPassword(), authorities);

        return user;


        // String password = passwordEncoder.encode("123");
        // return new User(username,password,
        //         AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }

    
}
