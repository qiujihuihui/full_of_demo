package com.module.demo.proxy_pattern;

import com.module.demo.MetricsCollector;
import com.module.demo.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shenh
 * On 2020/7/15
 * Description: 动态代理
 */
public class MetricsCollectorProxy
{
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy()
    {
        this.metricsCollector = new MetricsCollector(null);
    }

    public Object createProxy(Object proxiesObject){
        Class<?>[] interfaces = proxiesObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiesObject);
        return Proxy.newProxyInstance(proxiesObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler{

        private Object proxiesObject;

        public DynamicProxyHandler(Object proxiesObject)
        {
            this.proxiesObject = proxiesObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiesObject, args);
            long endTimestamp = System.currentTimeMillis();
            long responseTime = endTimestamp - startTimestamp;
            String apiName = proxiesObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(/*apiName, responseTime, startTimestamp*/);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }
}
