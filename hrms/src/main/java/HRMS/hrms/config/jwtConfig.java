package HRMS.hrms.config;


import HRMS.hrms.auth.model.authModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class jwtConfig {

    private static final Long EXPIRATION_TIME= 24*60*60*1000L; // 24 hours in milliseconds

    @Value("${jwt.secret}")
    private String secret;

    public String generateAccessToken(authModel user) {
        // Implementation for generating access token
        return Jwts.builder()
                .setSubject(
                        String.format("%s,%s", user.getId(), user.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

}
