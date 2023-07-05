package Pub_Sub;

import GUI_user_02.gui_user_02;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Sub_Redis {
	public static void subscriber() {
		try (Jedis sub = new Jedis()){
			sub.subscribe(new JedisPubSub() {
			
				@Override
				public void onMessage(String channel,String message) {
					gui_user_02.textarea.append(message);
					System.out.println(message);
				}
			}, "test" );
		}
	}
}
