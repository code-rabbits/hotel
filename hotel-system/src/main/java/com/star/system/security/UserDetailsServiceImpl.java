package com.star.system.security;

import com.star.system.mapper.SysUserMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        //1.查询数据库判断用户名是否存在，如果不存在抛出UsernameNotFoundException异常
        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2.把查询出来的密码（注册时已经加密过）进行解析，或直接把密码放入构造方法中

        String password = passwordEncoder.encode("123");
        return new User(username,password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }

    
}
