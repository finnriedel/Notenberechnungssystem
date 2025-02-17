import java.util.ArrayList;
import java.util.List;

public class Notenberechnungssystem {
	private List<Student> kursListe;
	
	public static void main(String[] args) {
		Notenberechnungssystem nbs = new Notenberechnungssystem();
		nbs.dialog();
	}
	
	public Notenberechnungssystem() {
		kursListe = new ArrayList<>();
		
	}
	
	public void dialog() {
		while(true) {
			System.out.println("Was möchtest du tun?");
			System.out.println("1 - Student zu meinem Kurs hinzufügen");
			System.out.println("2 - Notendurchschnitt anzeigen");
			System.out.println("3 - Note verändern/eintragen");
	
			
			switch(Tools.intEingabe()){
				case 1: studentHinzufuegen();
				break;
				case 2: notendurchschnittBerechnen();
				break;
				case 3:
				case 4:
				case 5:
				case 0: return;
			}
		}
	}
	
	public void studentHinzufuegen() {
		System.out.println("Vornamen eingeben:");
		String vorname = Tools.stringEingabe();
		System.out.println("Nachnamen eingeben:");
		String nachname = Tools.stringEingabe();
		System.out.println("Matrikelnummer eingeben:");
		int matrikelnr = Tools.intEingabe();
		Student tmpStudent = new Student(vorname, nachname, matrikelnr);
		kursListe.add(tmpStudent);
		System.out.println("Student erfolgreich hinzugefügt.");
		System.out.println("--------------------------------");
	}
	
	public void notendurchschnittBerechnen() {
		if(kursListe.isEmpty() == false) {
			double notenKummuliert = 0;
			for(int i = 0; i < kursListe.size(); i++) {
				notenKummuliert = notenKummuliert + kursListe.get(i).getNote();
			}
			System.out.println("Der Notendurchschnitt in diesem Kurs beträgt: " + notenKummuliert/kursListe.size());
			System.out.println("--------------------------------");
		}else {
			System.out.println("Es sind noch keine Studenten in Ihrem Kurs, bitte fügen Sie zuerst welche hinzu.");
			System.out.println("--------------------------------");
		}
	}
	
	
		

}
