package com.nibado.example.jwtangspr;

import io.jsonwebtoken.Claims;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public Boolean login(@PathVariable final String role,
			final HttpServletRequest request) throws ServletException {
		final Claims claims = (Claims) request.getAttribute("claims");

		return ((List<String>) claims.get("roles")).contains(role);
	}

	@RequestMapping(value = "teststatus", method = RequestMethod.GET)
	public List<String> checkStatus(final HttpServletRequest request) throws ServletException {
		final Claims claims = (Claims) request.getAttribute("claims");

		List<String> names = new ArrayList<String>();
		names.add("Chandan");
		names.add("Arijit");
		return names;
	}

}
