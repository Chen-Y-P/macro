package com.macro.cloud.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * Created by zhenghong on 2017/12/5.
 */
@Component
public class ErrorExtFilter extends SendErrorFilter{
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        ZuulFilter zuulFilter = (ZuulFilter) context.get("failed.filter");
        if(zuulFilter!=null&&zuulFilter.filterType().equals("post")){
            return true;
        }
        return false;
    }
}
