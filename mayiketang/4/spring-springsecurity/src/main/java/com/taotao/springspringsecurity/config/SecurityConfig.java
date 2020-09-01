package com.taotao.springspringsecurity.config;

import com.taotao.springspringsecurity.entity.Permission;
import com.taotao.springspringsecurity.handler.MyAuthenticationFailureHandler;
import com.taotao.springspringsecurity.handler.MyAuthenticationSuccessHandler;
import com.taotao.springspringsecurity.mapper.PermissionMapper;
import com.taotao.springspringsecurity.security.MyUserDetailsService;
import com.taotao.springspringsecurity.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


// Security 配置
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private MyAuthenticationFailureHandler failureHandler;
  @Autowired
  private MyAuthenticationSuccessHandler successHandler;
  @Autowired
  private MyUserDetailsService myUserDetailsService;
	// 配置认证用户信息和权限
    @Autowired
    private PermissionMapper permissionMapper;
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*	// 添加admin账号
		auth.inMemoryAuthentication().withUser("admin").password("123456").
		authorities("showOrder","addOrder","updateOrder","deleteOrder");
		// 添加userAdd账号
		auth.inMemoryAuthentication().withUser("userAdd").password("123456").authorities("showOrder","addOrder");
		// 如果想实现动态账号与数据库关联 在该地方改为查询数据库*/
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new PasswordEncoder() {

           //对表单密码进行加密
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String)charSequence);
            }
            //对加密的密码进行比对
            @Override
            public boolean matches(CharSequence charSequence, String encodepassword) {
                //encodepassword 数据库查询到的密码
                //charSequence 输入的密码
                return   MD5Util.encode((String)charSequence).equals(encodepassword);
            }
        });
	}

	// 配置拦截请求资源
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		// 如何权限控制 给每一个请求路径 分配一个权限名称 让后账号只要关联该名称，就可以有访问权限
	/*	http.authorizeRequests()
		// 配置查询订单权限
		.antMatchers("/showOrder").hasAnyAuthority("showOrder")
		.antMatchers("/addOrder").hasAnyAuthority("addOrder")
		.antMatchers("/login").permitAll()
		.antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
		.antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
		.antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login").
		successHandler(successHandler).failureHandler(failureHandler)
		.and().csrf().disable();*/

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequest= http.authorizeRequests();
        //1.读取数据库参数列表字段
        List<Permission> listPermission=permissionMapper.findAllPermission();
        for (Permission permission: listPermission) {
             //设置qaunx
            authorizeRequest.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());

        }
        authorizeRequest.antMatchers("/login").permitAll().antMatchers("/**").fullyAuthenticated().and().formLogin()
                .loginPage("/login").successHandler(successHandler).and().csrf().disable();

	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
