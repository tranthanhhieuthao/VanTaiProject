package com.tranhieu.oder_car.ConfigJWT;

import com.tranhieu.oder_car.Model.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    private final String JWT_SECRET ="NguyenThiXuanHai";
    private final Long JWT_EXPIRATION = 604800000L;

    public String genarateToken(CustomUserDetails customUserDetails) {
        Date dateNow = new Date();
        Date expiryDate = new Date(dateNow.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(Long.toString(customUserDetails.getUsers().getIdUser()))
                .setIssuedAt(dateNow)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.ES512, JWT_SECRET)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
