package com.demo2do.core.cache;

/**
 * Interface for cache accessor
 */
public interface CacheAccessor {

    /**
     * whether cache contains key
     *
     * @param key
     * @return
     */
    public boolean contains(String key);

    /**
     * get key from cache
     *
     * @param key
     * @return
     */
    public Object evaluate(String key);
}
