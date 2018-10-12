package FacebookApi;

import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Main {

	public  List<String> main(String[] args) {
		String stringAccess="EAACMZBrHD01YBAM5QgJBZA6X4kqkj3o1VRQKZBKwTGXUpWOQRTXzLpEFlZCZBBY4XYTNJ9WjlfL1wBnTOvTeEfs9BRh5wMX79srbMLeLaA4dVagDGLJ1FQnZCUE5ZCn0MBwsAEGXZA3uudyxbjzB1xmec1ZA4b8dpzUNhhu9OhNWbDgZDZD";
		
		FacebookClient fbClient = new DefaultFacebookClient(stringAccess,Version.VERSION_3_1);
		User me =fbClient.fetchObject("me", User.class);
		AccessToken exAccessToken =fbClient.obtainExtendedAccessToken("155008352113494","ec53c601d70c654bb93ab389fbb75e20");
		Connection <Post> results=fbClient.fetchConnection("me/feed", Post.class);
		
		List<String> posts=new ArrayList<String>();
		for(List<Post> page:results)
		
		{for(Post aPost:page)
		{ 
		 posts.add(aPost.getMessage()+" "+"fb.com/"+aPost.getId());
		
			
		}
		
		
			
		}
		return posts;
		
		
		
		
	//System.out.println(exAccessToken.getAccessToken());
		
	//System.out.println(exAccessToken.getExpires());
	//System.out.println(me.getName());
	//System.out.println(me.getGender());
		
	}

}
