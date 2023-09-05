package com.bootcamp.securitydemo.config;

import com.bootcamp.securitydemo.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private static final String BEARER = "Bearer ";
    // Step 1
    // private final UserDetailsService userDetailsService;

    // step 2
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    public JwtAuthFilter(@Lazy UserDao userDao, JwtUtils jwtUtils) {
        this.userDao = userDao;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION);
        final String userEmail;
        final String jwtToken;

        if(authHeader == null || !authHeader.startsWith(BEARER)){
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);
        userEmail = jwtUtils.extractUsername(jwtToken);

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // Step 1
            // UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);

            // step 2
            UserDetails userDetails = userDao.findUserByEmail(userEmail);
            if(jwtUtils.isTokenValid(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken autToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null
                );
            }
        }

    }
}
