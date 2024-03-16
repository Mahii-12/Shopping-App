package com.example.demo.configurations;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenManager {

	private String jwtSecret="daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb";
	private long expirationTime=678902890;
	
	 public String generateToken(Authentication authentication){

	        String username = authentication.getName();

	        Date currentDate = new Date();

	        Date expireDate = new Date(currentDate.getTime() + expirationTime);

	        String token = Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(expireDate)
	                .signWith(key())
	                .compact();

	        return token;
	}
	 
	 public String getUsername(String token){
		 Claims claim = Jwts.parserBuilder()
		            .setSigningKey(key())
		            .build()
		            .parseClaimsJws(token)
		            .getBody();
		    return claim.getSubject();
//	       Claims claim=Jwts.parserBuilder()
//	    		   .setSigningKey(key())
//	    		   .build()
//	    		   .parseClaimsJwt(token)
//	    		   .getBody();
//	       return claim.getSubject();
	 }
	 
	 public boolean validateToken(String token){
		 try {
		        Jwts.parserBuilder()
		                .setSigningKey((SecretKey) key())
		                .build()
		                .parseClaimsJws(token);
		        return true;
		    } catch (JwtException | IllegalArgumentException e) {
		        // Exception occurred, token is not valid
		        return false;
		    }
//	    	Jwts.parserBuilder()
//	        .setSigningKey((SecretKey) key())
//	        .build()
//	        .parseClaimsJws(token);
//	            return true;

	    }
	    
	    private Key key(){
	        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	    }
	    
}
