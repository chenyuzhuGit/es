package com.elasticsearch.root.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 设置跨域请求过滤
 * 
 * @author Administrator
 *
 */
@Component
public class CorsFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest reqs = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", reqs.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept,token,__sid");
		response.setHeader("Content-Security-Policy", "upgrade-insecure-requests");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}