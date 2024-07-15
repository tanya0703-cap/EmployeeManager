package com.example.employee.utils;

public class JwtUtils {
	public static String trimBearerToken(String token) {
        String prefix = "Bearer ";
        if (token.startsWith(prefix)) {
            return token.substring(prefix.length()).trim();
        } else {
            return token;
        }
    }
}
