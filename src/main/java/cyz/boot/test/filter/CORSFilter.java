package cyz.boot.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cyz.boot.test.http.common.RequestWrapper;

@Component
public class CORSFilter implements Filter {

	private final Logger log = LoggerFactory.getLogger(CORSFilter.class);

	public CORSFilter() {
		log.info("=================================CORSFilter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = new RequestWrapper((HttpServletRequest)req);
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		// response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		// response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT,
		// OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
		/**
		 * Set Cache-Control, Pragma for IE ajax request caching disablement
		 * Custom item X-Session-Token for myself.
		 */
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}

}
