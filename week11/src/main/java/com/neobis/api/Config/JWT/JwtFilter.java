package com.neobis.api.Config.JWT;

import com.neobis.api.Entity.User;
import com.neobis.api.Exception.UserUnauthorizedException;
import com.neobis.api.Service.Impl.UserServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Log
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain
    ) throws IOException, ServletException {
        //logger.info("do filter...");

        String token = getTokenFromRequest((HttpServletRequest) servletRequest);

        if (token != null) {
            String username = jwtProvider.extractUsername(token);
            User user = null;

            if (username != null) {
                user = userService.loadUserByUsername(username);
            }

            if (user != null && jwtProvider.validateToken(token, user)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        if (request != null) {
            String bearer = request.getHeader(AUTHORIZATION);
            if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
                return bearer.substring(7);
            }
        }
        return null;
    }
}
