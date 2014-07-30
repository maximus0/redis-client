package com.cxy.redisclient.integration.key;

import com.cxy.redisclient.domain.RedisVersion;
import com.cxy.redisclient.integration.JedisCommand;

public class Expire extends JedisCommand {
	private int db;
	private String key;
	private int second;
	
	public Expire(int id, int db, String key, int l) {
		super(id);
		this.db = db;
		this.key = key;
		this.second = l;
	}

	@Override
	protected void command() {
		jedis.select(db);
		if(second != -1)
			jedis.expire(key, second);
		else
			jedis.persist(key);
		
	}

	@Override
	public RedisVersion getVersion() {
		return RedisVersion.REDIS_1_0;
	}

}
