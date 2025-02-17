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
			System.out.println("4 - Notenübersicht drucken");
	
			
			switch(Tools.intEingabe()){
				case 1: studentHinzufuegen();
				break;
				case 2: notendurchschnittBerechnen();
				break;
				case 3: noteAnpassen();
				break;
				case 4: getKursliste();
				break;
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
	
	public void noteAnpassen() {
		System.out.println("Nachnamen des Studenten eingeben");
		String nachname = Tools.stringEingabe();
		Student tmpStudent = null;
		for(int i = 0; i < kursListe.size(); i++) {
			if(kursListe.get(i).getNachname() == nachname) {
				tmpStudent = kursListe.get(i);
			}
		}
		if(tmpStudent != null) {
			System.out.println("Aktuell hat der Student " + tmpStudent.getVorname() + tmpStudent.getNachname() + " die Note: " + tmpStudent.getNote());
			System.out.println("Soll diese Verändert werden? [J/N]");
			switch(Tools.stringEingabe()) {
			case "j":  
				System.out.println("Bitte geben Sie eine Note ein:");
				if(Tools.doubleEingabe() < 0.0 || Tools.doubleEingabe() > 10.0) {
					System.out.println("Falsche eingabe, der Wert muss zwischen 0.0 und 10.0 liegen");
				}else {
					tmpStudent.setNote(Tools.doubleEingabe());
					}
			case "n":
				default:
			}
		}else {
			System.out.println("Dieser Student konnte nicht gefunden werden.");
		}
		
	}
	
	public void getKursliste() {
		for(int i = 0; i < kursListe.size(); i++) {
			System.out.println(kursListe.get(i).getVorname() + " " + kursListe.get(i).getNachname() + " " + kursListe.get(i).getNote());
		}
	}
		

}
