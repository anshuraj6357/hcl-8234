package HRMS.hrms.config;


import HRMS.hrms.auth.model.authModelUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtConfig {

    private static final Long EXPIRATION_TIME= 24*60*60*1000L; // 24 hours in milliseconds

    @Value("${jwt.secret}")
    private String secret;

    public String generateAccessToken(authModelUser user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public Claims parseAccessToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
