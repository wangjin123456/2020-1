package com.taotao.mayikt_security2.config;

import com.taotao.mayikt_security2.entity.PermissionEntity;
import com.taotao.mayikt_security2.filter.JWTLoginFilter;
import com.taotao.mayikt_security2.filter.JWTValidationFilter;
import com.taotao.mayikt_security2.mapper.PermissionMapper;
import com.taotao.mayikt_security2.service.MemberUserDetailsService;
import com.taotao.mayikt_security2.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@author tom
 *Date  2020/6/9 0009 12:45
 *
 */
// Security 配置
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MemberUserDetailsService memberUserDetailsService;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置用户账号信息和权限
      /*  auth.inMemoryAuthentication().withUser("taotao_show").password("123456").authorities("addMember","delMember","updateMember","showMember");
        auth.inMemoryAuthentication().withUser("taotao_add").password("123456").authorities("addMember");
        auth.inMemoryAuthentication().withUser("mayikt_admin").password("mayikt").authorities("/");
*/
        auth.userDetailsService(memberUserDetailsService).passwordEncoder(new PasswordEncoder() {
            /**
             * 对密码MD5
             * @param rawPassword
             * @return
             */
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            /**
             * rawPassword 用户输入的密码
             * encodedPassword 数据库DB的密码
             * @param rawPassword
             * @param encodedPassword
             * @return
             */
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String rawPass = MD5Util.encode((String) rawPassword);
                boolean result = rawPass.equals(encodedPassword);
                return result;
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置httpBasic
        //  http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
     /*   http.authorizeRequests().antMatchers("/addMember").hasAnyAuthority("addMember")
                .antMatchers("/delMember").hasAnyAuthority("delMember")
                .antMatchers("/updateMember").hasAnyAuthority("updateMember")
                .antMatchers("/showMember").hasAnyAuthority("showMember")
                // .antMatchers("/**").fullyAuthenticated().and()
                //   .formLogin();
                .antMatchers("/login").permitAll()
                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login");
*/
        List<PermissionEntity> allPermission = permissionMapper.findAllPermission();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                expressionInterceptUrlRegistry = http.authorizeRequests();
        allPermission.forEach((permission) -> {
            expressionInterceptUrlRegistry.antMatchers(permission.getUrl()).
                    hasAnyAuthority(permission.getPermTag());

        });
        expressionInterceptUrlRegistry.antMatchers("/auth/login").permitAll()
                .antMatchers("/**").fullyAuthenticated()
                // .and().formLogin().loginPage("/login").and().csrf().disable();
                //.antMatchers("/addMember") 配置addMember请求权限 hasAnyAuthority("addMember")
                .and()
                .addFilter(new JWTValidationFilter(authenticationManager()))
               .addFilter(new JWTLoginFilter(authenticationManager())).csrf().disable()
                //删除session
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }

    /**
     * There is no PasswordEncoder mapped for the id "null"
     * 原因:升级为Security5.0以上密码支持多中加密方式，恢复以前模式
     *
     * @return
     */

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
