package com.dcnetworkdisk.core.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCacheUtils {
	private static JedisPool pool = null;
	
	public RedisCacheUtils(String url, int port) {
		// TODO Auto-generated constructor stub
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxWaitMillis(5000);
		pool = new JedisPool(config, url, port);
	}
	
	public RedisCacheUtils(String url){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxWaitMillis(5000);
		pool = new JedisPool(config, url);
	}
	
	public String get(String key){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.get(key);
		} finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	public String put(String key, String value, int seconds){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.setex(key, seconds, value);
		} finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}
}
