package com.macro.cloud.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhenghong on 2017/12/5.
 */
@Component
public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("sender {} request to {}",request.getMethod(),request.getRequestURI().toString());
        String accessToken = request.getParameter("accessToken");
        if(accessToken==null){
            log.warn("access token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
