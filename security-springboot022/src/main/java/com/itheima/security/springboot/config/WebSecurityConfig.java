package com.itheima.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.ForwardLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    //实现用户身份认证
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String pswd = encoder.encode("111");
//        auth.inMemoryAuthentication().withUser("zhangsan").password(pswd).authorities("p1");
//    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable()
        		.authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                .anyRequest().permitAll()//除了/r/**，其它的请求可以访问
                // 默认登录页
//                .and()
//                .formLogin()
//                .successForwardUrl("/login-success")//自定义登录成功的页面地址
//                .and()
//                .httpBasic()
//                ;
                // 自定义登录页
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login.html")//登陆页面
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success02")//自定义登录成功的页面地址 01 rest 02 html
                // 会话管理
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // 退出
        		.and()
        		.logout()
        		.logoutUrl("/logout")
        		.logoutSuccessUrl("/")
                //.logoutSuccessHandler('参考 https://github.com/liuminglei/SpringSecurityLearning/tree/master/08');
        ;


    }

}
