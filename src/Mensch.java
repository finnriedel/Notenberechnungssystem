
public class Mensch {
	private String vorname; //Privates Attribut namens "vorname" mit dem Datentyp String wird deklariert
	private String nachname;
	
	public Mensch(String vorname, String nachname) {
		this.vorname = vorname; //Attribut wird außerhalb des Konstrutors abgerufen und ihm wird der String-Wert des abgefragten Paramters zugewiesen
		this.nachname = nachname;
	}
	
	public String getVorname(){
		return vorname; //Öffentliche Methode um den Attributswert vorname an andere Klassen zu übergeben.
	}
	
	public String getNachname(){
		return nachname;
	}
}
