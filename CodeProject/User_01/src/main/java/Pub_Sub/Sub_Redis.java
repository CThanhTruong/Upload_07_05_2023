package Pub_Sub;

import GUI_user_01.gui_user_01;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Sub_Redis {
	public static void subscriber() {
		try (Jedis sub = new Jedis()){
			sub.subscribe(new JedisPubSub() {
			
				@Override
				public void onMessage(String channel,String message) {
					gui_user_01.textarea.append(message);
					System.out.println(message);
				}
			}, "test" );
		}
	}
}
