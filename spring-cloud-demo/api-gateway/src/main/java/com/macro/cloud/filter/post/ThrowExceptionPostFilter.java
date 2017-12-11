package com.macro.cloud.filter.post;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * Created by zhenghong on 2017/12/5.
 */
//@Component
public class ThrowExceptionPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        doSomeThing();
        return null;
    }

    private void doSomeThing() {
        throw new RuntimeException("This is a RuntimeException");
    }
}
