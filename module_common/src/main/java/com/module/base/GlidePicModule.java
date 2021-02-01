package com.module.base;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

/**
 * Glide的配置类
 * On 2020/10/20
 */
public class GlidePicModule implements GlideModule
{
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        String internalCachePath = "glide_cache";
        //设置格式
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //缓存到data目录下最大50M
        //缓存目录为程序内部缓存目录/data/data/your_package_name/glide_cache/(不能被其它应用访问)且缓存最大为250MB
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, internalCachePath, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE));
        //设置内存缓存大小
        //MemoryCache和BitmapPool的默认大小由MemorySizeCalculator类决定，MemorySizeCalculator会根据给定屏幕大小可用内存算出合适的缓存大小，这也是推荐的缓存大小
        // 目前根据这个推荐大小做出调整，推荐大小乘以1.2倍
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        //采用Glide结合OkHttp的方式
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new OkHttpClient()));
    }
}
