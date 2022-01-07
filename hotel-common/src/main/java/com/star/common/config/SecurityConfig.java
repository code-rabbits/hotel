package com.star.common.config;

import com.star.system.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers()
                .hasRole("")
                //不需要被认证的html页面
                .antMatchers("/login").permitAll()
                .antMatchers("/error.html").permitAll()
                //静态资源的放行
                .antMatchers("/js/**","/css/**","/lib/**","/api/**","/images/**").permitAll()
                //所有请求都必须认证，必须登录后才能访问
                .anyRequest().authenticated()
                .and()
                .formLogin() //表单提交
                .loginPage("/login.html")  //自定义登录页面
                .loginProcessingUrl("/login") //自定义登录请求
                .defaultSuccessUrl("/home")   //登录成功后跳转的url
                .failureForwardUrl("/toError")  //登录失败后跳转的url
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")  //退出登录的url
                .logoutSuccessUrl("/login");  //退出登录后跳转的url
        http.csrf().disable();  //关闭csrf防护
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
