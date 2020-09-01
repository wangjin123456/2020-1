package com.taotao.mt_auth_resources.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/15 0015 20:28
 *
 */
@Component
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单提交
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // appid
                .withClient("mayikt")
                // appsecret
                .secret(passwordEncoder.encode("mayikt_secret"))
                // 授权码
                .authorizedGrantTypes("authorization_code")
                // 作用域
                .scopes("all")
                // 资源的id
                .resourceIds("mayikt_resource")
                // 回调地址
                .redirectUris("http://www.mayikt.com/callback");

    }
}
