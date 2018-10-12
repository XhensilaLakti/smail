package contacts.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

import contacts.model.ListaEKontakteve;
import contacts.service.RegisterNumbers;


@RestController
public class ContactController {
	
	
	@Autowired
	private RegisterNumbers registerNumbers;
	
	
	@RequestMapping("/contact")
	public List<ListaEKontakteve> getContacts() throws FileNotFoundException
	{
		return registerNumbers.getContact();
	}
	
	@RequestMapping("/contact/{name}")
    public ListaEKontakteve getName(@PathVariable String name ) throws FileNotFoundException

	{
		return registerNumbers.getContact(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addContact")
	public void setName(@RequestBody ListaEKontakteve kontakt) 
	{
		registerNumbers.setContact(kontakt);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/updateContact/{name}")
	public void  updateContact(@RequestBody ListaEKontakteve kontakt,@PathVariable String name) throws FileNotFoundException 
	{
		registerNumbers.updateContact(kontakt,name);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteContact/{name}")
	public void  deleteContact(@PathVariable String name) 
	{
		registerNumbers.deleteContact(name);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/me/feed")
	public  List<String> fbFeed() {
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
		
	

}
}
