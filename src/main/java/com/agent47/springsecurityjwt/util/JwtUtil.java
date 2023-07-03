package com.agent47.springsecurityjwt.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    @Value("${app.secret}")
    private static String secret ;

    // **6.Validate user name in token and database, expDate
    public boolean validateToken(String token , String unsername){
        String tokenUsername = getUserName(token);
        return (unsername.equals(tokenUsername) && !isTokenExp(token));

    }
    //**5.Validate Exp Date
    public boolean isTokenExp(String token){
        Date expDate = getExpDate(token);
        return expDate.before(new Date(System.currentTimeMillis()));
    }

    //**4.Read Subject /username
    public String getUserName(String token){
        return getClaims(token).getSubject();
    }

    //**3.Read Exp Date
    public Date getExpDate(String token){
        return getClaims(token).getExpiration();
    }

    //**2.Read Claims
    public Claims getClaims(String token){
        return Jwts.parserBuilder()
                    .setSigningKey(secret.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    //**1.Generate Token
    public  String generateToken(String subject){

        return Jwts.builder()
                    .setSubject(subject)
                    .setIssuer("Jkbhai")
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
                    .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256))
                    .compact();
    }
    
}
