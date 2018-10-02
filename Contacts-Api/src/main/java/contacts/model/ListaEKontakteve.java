package contacts.model;


public class ListaEKontakteve {
	
	
private String name,surname;
private long phoneNr;

public ListaEKontakteve() {
	
}

public ListaEKontakteve(String name, String surname, long phoneNr) {
	super();
	this.name = name;
	this.surname = surname;
	this.phoneNr = phoneNr;
}

public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public long getPhoneNr() {
	return phoneNr;
}
public void setPhoneNr(long phoneNr) {
	this.phoneNr = phoneNr;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public  String contactName(String name)
{if(this.name.equals(name))
	return name;
else 
	return "Sorry!This Contact doesn't exist in your Contact List.";
	

}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}



}
