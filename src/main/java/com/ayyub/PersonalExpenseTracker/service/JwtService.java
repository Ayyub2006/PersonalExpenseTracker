package com.ayyub.PersonalExpenseTracker.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private long expiration;
	
	private SecretKey getSignKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(String email) {
		return Jwts.builder()
				.subject(email)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(getSignKey())
				.compact();
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(getSignKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> resolve) {
		Claims claims = extractAllClaims(token);
		return resolve.apply(claims);
	}
	
	public boolean isTokenValid(String token, String email) {
		String username = extractUsername(token);
		return username.equals(email) && !isTokenExpired(token);
	}
	
	private  boolean isTokenExpired(String token) {
		return extractAllClaims(token)
				.getExpiration()
				.before(new Date());
	}
	
}
