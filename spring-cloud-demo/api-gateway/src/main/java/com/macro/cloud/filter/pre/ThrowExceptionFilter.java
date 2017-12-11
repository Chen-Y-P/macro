package com.macro.cloud.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by zhenghong on 2017/12/5.
 */
//@Component
public class ThrowExceptionFilter extends ZuulFilter {
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
        log.info("This is a pre filter,it will throw a RuntimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
//        try {
            doSomeThing();
//        } catch (Exception e) {
//            e.printStackTrace();
//            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            ctx.set("error.exception", e);
//        }
        return null;
    }

    private void doSomeThing() {
        throw new RuntimeException("This is a RuntimeException");
    }
}
