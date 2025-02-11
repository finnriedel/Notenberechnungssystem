
public abstract class Notenberechnungssystem {
	
	public static void main(String[] args) {
		
	}
	
	public Notenberechnungssystem() {
		System.out.println("Was möchten Sie tun?");
		System.out.println("1 - Note eingeben");
		System.out.println("2 - Note ausgeben");
		System.out.println("3 - Notendurchschnitt berechnen");
		System.out.println("4 - Neues Modul anlegen");
		System.out.println("5 - Neuen Studenten anlegen");
		System.out.println("6 - Neuen Dozenten anlegen");
	}
	
	public void noteErfassen(Modul modul, Student student, double note) {
		modul.setNote(student, note);
	}
	
	public void noteAusgeben(Modul modul, Student student) {
		modul.getNote(student);
	}
	
	public void notenDurchschnitt(Modul modul) {
		modul.getNotenListe();
	}
	
}
