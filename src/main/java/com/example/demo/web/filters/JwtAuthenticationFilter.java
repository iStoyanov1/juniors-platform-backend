package com.example.demo.web.filters;

import com.example.demo.data.entites.Auth;
import com.example.demo.data.models.dtos.AuthLoginDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.fileupload.MultipartStream;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
        System.out.println();
        try {
            AuthLoginDto authLoginDto = new ObjectMapper()
                    .readValue(request.getInputStream(), AuthLoginDto.class);

            Authentication authenticate = null;

            try {

                authenticate = this.authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authLoginDto.getUsername(),
                                authLoginDto.getPassword(),
                                new ArrayList<>()));
                return authenticate;

            }catch (AuthenticationException e){
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{" +
                        "   \"Няма намерен потребител\"}");
                throw new IllegalArgumentException("Няма намерен потребител");
            }
        } catch (IOException ignored) {

            throw new IllegalArgumentException("Няма намерен потребител.");
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

        String token = "";
        try {
           token = Jwts.builder()
                    .setSubject(auth.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + 21600000))
                    .claim("role", authority)
                    .signWith(SignatureAlgorithm.HS256, "Secret".getBytes())
                    .compact();
        }catch (ExpiredJwtException jwt){
            throw new IllegalArgumentException("Сесията Ви е изтекла. Моля влезте отново в профила си.");
        }
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
