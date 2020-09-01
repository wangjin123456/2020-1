package com.taotao.mayikt_security2.filter;

import com.taotao.mayikt_security2.utils.MayiktJwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *@author tom
 *Date  2020/6/14 0014 9:06
 *
 */
public class JWTValidationFilter  extends BasicAuthenticationFilter {
    public JWTValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * 过滤请求验证
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(setAuthentication(request.getHeader("token")));
        super.doFilterInternal(request, response, chain);
    }

    /**
     * 验证token 并且验证权限
     * @param token
     * @return
     */
    private UsernamePasswordAuthenticationToken setAuthentication(String token) {
        String username = MayiktJwtUtils.getUsername(token);
        if (username == null) {
            return null;
        }
        List<SimpleGrantedAuthority> userRoleList = MayiktJwtUtils.getUserRole(token);
        return new UsernamePasswordAuthenticationToken(username, null, userRoleList);
    }
}

