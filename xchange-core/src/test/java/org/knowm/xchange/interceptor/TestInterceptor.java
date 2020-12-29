package org.knowm.xchange.interceptor;

import si.mazi.rescu.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInterceptor implements Interceptor {

    @Override
    public Object aroundInvoke(
            InvocationHandler invocationHandler, Object proxy, Method method, Object[] args)
            throws Throwable {
        return invocationHandler.invoke(proxy, method, args);
    }
}
