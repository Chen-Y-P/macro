package com.taotao.rest.dao;

public interface JedisClient {
    /**
     * 根据key获取存储的值
     */
    String get(String key);

    /**
     * 根据key设置存储的值
     */
    String set(String key, String value);

    /**
     * 使指定key的值自增1
     */
    long incr(String key);

    /**
     * 相当于往hkey为key的HashMap中存储一个键值对
     */
    Long hset(String hkey, String key, String value);

    /**
     * 相当于从hkey为key的HashMap中获取一个键值对
     */
    String hget(String hkey, String key);

    /**
     * 删除指定key的值
     */
    Long del(String key);

    /**
     * 相当于从hkey为key的HashMap中删除一个键值对
     */
    Long hdel(String hkey, String key);

    /**
     * 设置某个键值对的超期时间
     */
    Long expire(String key, int second);
}
