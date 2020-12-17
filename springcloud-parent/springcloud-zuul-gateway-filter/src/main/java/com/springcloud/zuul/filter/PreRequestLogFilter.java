package com.springcloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 自定义 Pre Filter
 * @author 17542
 *
 */
public class PreRequestLogFilter extends ZuulFilter {
	private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class);
	@Override
	public int filterOrder() {
		return 1; // run before PreDecoration
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("send %s request to %s", request.getMethod(),request.getRequestURI().toString()));
        return null;
    }
}
