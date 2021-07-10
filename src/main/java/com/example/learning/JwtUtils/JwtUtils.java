package com.example.learning.JwtUtils;

import com.example.learning.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    //@Value("${bezkoder.app.jwtSecret}");
    private String jwtSecret = "bezKoderSecretKey";

  //  @Value("${bezkoder.app.jwtExpirationMs}");
    private int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNAmeFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e){
            logger.error("invalid JWT signature: {}" + e.getMessage());
        }catch (MalformedJwtException e){
            logger.error("invalid JWT signture: {}" + e.getMessage());
        }catch (ExpiredJwtException e){
            logger.error("invalid JWT signture: {}" + e.getMessage());
        }catch (UnsupportedJwtException e){
            logger.error("invalid JWT signture: {}" + e.getMessage());
        }catch (IllegalArgumentException e){
            logger.error("invalid JWT signture: {}" + e.getMessage());
        }
        return false;
    }

}
