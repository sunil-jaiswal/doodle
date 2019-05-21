package com.doodle.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebInterceptor extends HandlerInterceptorAdapter {

	private final Log logger = LogFactory.getLog(WebInterceptor.class);

	static List<String> whiteList = new ArrayList<>();

	static {
		whiteList.add("welcome");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("WebInterceptor called");
		final String ctxPath = request.getContextPath();
		final String reqURI = request.getRequestURI().substring(ctxPath.length() + 1);


		if (whiteList.contains(reqURI)) {
			return super.preHandle(request, response, handler);
		}/*else if (1 == 2) { // User is logged in 

			return super.preHandle(request, response, handler);
		}*/ else {
			response.setHeader("REQUEST_STATUS", "401");
			response.setStatus(401);
			request.getRequestDispatcher("login?code=7").forward(request, response);
			return false;
		}

	}

}
