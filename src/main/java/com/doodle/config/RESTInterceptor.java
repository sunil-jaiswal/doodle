package com.doodle.config;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RESTInterceptor extends HandlerInterceptorAdapter {


	static List<String> whiteList = new ArrayList<>();

	static {
		//whiteList.add("welcome");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {


		final String ctxPath = request.getContextPath();
		final String reqURI = request.getRequestURI().substring(ctxPath.length() + 1);

		if (!whiteList.contains(reqURI)) {
		}

		return super.preHandle(request, response, handler);

	}
}
