package contacts.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import contacts.model.ListaEKontakteve;

@Service
public class RegisterNumbers {
	
   Scanner input = new Scanner(System.in);
   public static List<ListaEKontakteve> kontakte = new ArrayList<ListaEKontakteve>();
	
	 public  void AddContacts() throws FileNotFoundException {
	  // for(int i=0;i<5;i++) {

		 //kontakte=Arrays.asList(new ListaEKontakteve(input.next(),input.next(),input.nextLong()));
		/* ListaEKontakteve kontakt = new ListaEKontakteve();
		 kontakt.setName("Emri" + i);
		 kontakt.setSurname("Mbiemri" + i);
		 kontakt.setPhoneNr(1L);
		 kontakte.add(kontakt);
		 
	    }*/
		 
		 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		 InputStream input = classLoader.getResourceAsStream("phoneBook.csv");

		 //File file=new File(input);
		    Scanner br=new Scanner(input);

				String i;
				
				
				 while ((br.hasNextLine())) {
					 String[] split=br.nextLine().split(",");
					 kontakte.add(new ListaEKontakteve(split[0],split[1],Long.parseLong(split[2])));
				
					
				    }
			}
	
	 
	 
	 public List<ListaEKontakteve> getContact() throws FileNotFoundException
	 {
		 AddContacts();
		 System.out.println(kontakte.size());
		 return kontakte;
	 }
	 
	
	 public ListaEKontakteve getContact(String name) throws FileNotFoundException
	 { AddContacts();
		 return kontakte.stream().filter(t->t.getName().equals(name)).findFirst().get();
		 
	 }
	 public void  setContact(ListaEKontakteve kontakt) 
	 {
		
		 kontakte.add(kontakt);
		
		 
	 }



	public void updateContact(ListaEKontakteve kontakt,String name) {
		for(int i=0;i<kontakte.size();i++)
		{ListaEKontakteve lista=kontakte.get(i);
			if(lista.getName() .equals (kontakt.getName()))
			{kontakte.set(i, kontakt);
				
			}
			
		}
		
		
	}



	public void deleteContact( String name) {
		kontakte.removeIf(t->t.getName().equals(name));
		
		
		
	}
	 
	

}
