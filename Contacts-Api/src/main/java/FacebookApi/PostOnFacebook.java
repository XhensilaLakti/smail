package FacebookApi;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.User;

public class PostOnFacebook {

	public static void main(String[] args) {
	String stringAccess="EAACMZBrHD01YBAM5QgJBZA6X4kqkj3o1VRQKZBKwTGXUpWOQRTXzLpEFlZCZBBY4XYTNJ9WjlfL1wBnTOvTeEfs9BRh5wMX79srbMLeLaA4dVagDGLJ1FQnZCUE5ZCn0MBwsAEGXZA3uudyxbjzB1xmec1ZA4b8dpzUNhhu9OhNWbDgZDZD";
	
	FacebookClient fbClient = new DefaultFacebookClient(stringAccess,Version.VERSION_3_1);
	FacebookType  rezultati=fbClient.publish("me/feed", FacebookType.class,Parameter.with("message", "xhensila"));
	System.out.println("fb.com/"+rezultati.getId());
		
	}

}
