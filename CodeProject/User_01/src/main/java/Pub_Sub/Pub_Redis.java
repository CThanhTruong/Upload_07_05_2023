package Pub_Sub;

import redis.clients.jedis.Jedis;

public class Pub_Redis {
	public static void publisher(String msg) {
		try (Jedis pub = new Jedis()){
			pub.publish("test", msg);
		}
	}
}
