package contacts.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
