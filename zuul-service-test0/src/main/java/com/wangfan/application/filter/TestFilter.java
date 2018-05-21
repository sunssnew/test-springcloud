package com.wangfan.application.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TestFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(TestFilter.class);
	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
            	currentContext.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
