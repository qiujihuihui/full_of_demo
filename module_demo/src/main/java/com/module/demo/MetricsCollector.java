package com.module.demo;

import android.text.TextUtils;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executors;

/**
 * Created by shenh
 * On 2020/5/18
 * Description: 取和存异步进行
 */
public class MetricsCollector
{
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;

    private MetricsStorage metricsStorage;
    private EventBus eventBus;

    public MetricsCollector(MetricsStorage metricsStorage){
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    private MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData){
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    public void recordRequest(RequestInfo requestInfo)
    {
        if (requestInfo == null || TextUtils.isEmpty(requestInfo.getApiName()))
        {
            return;
        }
        eventBus.post(requestInfo);
    }

    public class EventListener{
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo){
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
}
