package com.example.servicebackend.configuration.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {
    private final String secretKey = "secretskdfghasdilkrjtgheiwrutywaiouerhgksdhjgaskljdhfglkasjhdflkajshdfkljashdlfkjhasldkfhjaslkdjfhlk";
    private final String expirationTimeForAccessToken = "86400000";
    private String expirationTimeForRefreshToken = "86400000";

    public String extractUserEmail(String token) {
        var claims = extractAllClaims(token);
        var userMap = claims.get("User", Map.class);
        return userMap.get("username").toString();
    }

    public String generateAccessToken(UserDetails userDetails) {
        return generateTokenUtils(new HashMap<>(), userDetails, expirationTimeForAccessToken);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return generateTokenUtils(new HashMap<>(), userDetails, expirationTimeForRefreshToken);
    }

    public Boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            String userEmail = extractUserEmail(token);
            return (userEmail.equals(userDetails.getUsername()) && !isTokenExpired(token));
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        var claims = extractAllClaims(token);
        Date expiration = claims.getExpiration();
        return expiration.before(new Date());
    }

    private String generateTokenUtils(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            String expirationTimeType) {
        extraClaims.put("User", userDetails);

        return Jwts.builder()
                .setClaims(extraClaims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationTimeType)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(String token) throws SecurityException {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build();
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        if(claims.getExpiration().before(new Date())) {
            throw new SecurityException("Token expired");
        }
        return claims;
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
