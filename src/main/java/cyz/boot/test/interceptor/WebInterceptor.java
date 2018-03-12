package cyz.boot.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cyz.boot.test.http.common.RequestWrapper;
import cyz.boot.test.http.utils.IpAdrressUtil;

public class WebInterceptor implements HandlerInterceptor{
	private final Logger log = LoggerFactory.getLogger(WebInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		request = new RequestWrapper((HttpServletRequest) request);
		request.setAttribute("InterceptorStartTime", startTime);
		;
		log.info("=================================request interceptor");
		log.info("=================================IpAdrressUtil.getIpAdrress(request):"+IpAdrressUtil.getIpAdrress(request));
		return true;
	}

}
