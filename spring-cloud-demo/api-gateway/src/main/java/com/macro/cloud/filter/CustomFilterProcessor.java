package com.macro.cloud.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created by zhenghong on 2017/12/5.
 */
public class CustomFilterProcessor extends FilterProcessor {
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            e.printStackTrace();
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.set("failed.filter",filter);
            throw e;
        }
    }
}
