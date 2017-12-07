package com.shuqi;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager localCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        //用户缓存一天
        GuavaCache ONE_DAY = new GuavaCache(
                "ONE_DAY",
                CacheBuilder
                        .newBuilder()
                        .expireAfterWrite(1, TimeUnit.DAYS)
                        .build()
        );

        simpleCacheManager.setCaches(Arrays.asList(ONE_DAY));
        return simpleCacheManager;
    }
}
