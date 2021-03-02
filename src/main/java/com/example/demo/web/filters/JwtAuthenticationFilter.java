package com.example.demo.web.filters;

import com.example.demo.data.entites.Auth;
import com.example.demo.data.models.dtos.AuthLoginDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthLoginDto authLoginDto = new ObjectMapper()
                    .readValue(request.getInputStream(), AuthLoginDto.class);

            return this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authLoginDto.getUsername(),
                            authLoginDto.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException ignored) {
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        Auth auth = ((Auth) authResult.getPrincipal());
        String authority = Objects.requireNonNull(auth.getAuthorities()
                .stream()
                .findFirst()
                .orElse(null))
                .getAuthority();

        String token = Jwts.builder()
                .setSubject(auth.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000))
                .claim("role", authority)
                .signWith(SignatureAlgorithm.HS256, "Secret".getBytes())
                .compact();

//        response.addHeader("Authorization", "Bearer " + token);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
                "{" +
                        "   \"Authorization\":{" +
                        "      \"Bearer\":"+"\""+token+"\"," +
                        "      \"user\":{" +
                        "         \"email\":"+"\""+auth.getUsername()+"\"," +
                        "         \"role\":"+"\""+authority+"\"" +
                        "      }" +
                        "   }" +
                        "}"
        );

//        response.getWriter().write(
//                "{" +
//                        "   \"Authorization\":{" +
//                        "      \"Bearer\":" + "\""+token+"\","+
//                        "      \"role\":" + "\""+authority+"\""+
//                        "   }" +
//                        "}"
//        );
    }
}
