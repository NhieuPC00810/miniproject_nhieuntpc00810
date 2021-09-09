package com.example.demo.service;

import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Service
public class CookieService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

public Cookie get(String name) {
	Cookie[] cookie = request.getCookies();
	if(cookie !=null) {
		for(Cookie cookies: cookie) {
			if(cookies.getName().equalsIgnoreCase(name)) {
				return cookies;
			}
		}
	}
	return null;
}


public String getValue(String name, String defaultValue) {
	Cookie cookie = get(name);
	if(cookie !=null) {
		return cookie.getValue();
	}
	return defaultValue;
}

public Cookie add(String name, String value, int hours) {
	Cookie cookie = new Cookie(name, value);
	cookie.setMaxAge(hours*60*60);
	cookie.setPath("/");
	response.addCookie(cookie);
	return cookie;
	
}

public void remove(String name) {
	add(name,"",0);
}
}
