package com.maodun.udf;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * @author tongjian
 * @date 2020/9/21 18:35
 */
public class UdfCacheManger implements CacheManager {
    @Override
    public Cache getCache(String s) {
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return null;
    }
}
