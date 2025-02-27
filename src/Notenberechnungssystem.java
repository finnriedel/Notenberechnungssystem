import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Notenberechnungssystem {
	private List<Student> kursListe;
	
	public static void main(String[] args) throws IOException {
		Notenberechnungssystem nbs = new Notenberechnungssystem();
		nbs.dialog();
	}
	
	public Notenberechnungssystem() {
		kursListe = new ArrayList<>();
		
	}
	
	public void dialog() throws IOException {
		while(true) {
			System.out.println("-------------------MENÜ-------------------");
			System.out.println("| Was möchtest du tun?                   |");
			System.out.println("| 1 - Student zu meinem Kurs hinzufügen  |");
			System.out.println("| 2 - Notendurchschnitt anzeigen         |");
			System.out.println("| 3 - Note verändern/eintragen           |");
			System.out.println("| 4 - Notenübersicht drucken             |");
			System.out.println("| 5 - Kursliste importieren (Datei)      |");
			System.out.println("------------------------------------------");
	
			
			switch(Tools.intEingabe()){
				case 1: studentHinzufuegen();
				break;
				case 2: notendurchschnittBerechnen();
				break;
				case 3: noteAnpassen();
				break;
				case 4: getKursliste();
				break;
				case 5: readFile();
				break;
				case 99: return;
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
		while(matrikelnr == 0) {
			System.out.println("Bitte gib eine ganze Zahl ein, die ungleich 0 ist.");
			matrikelnr = Tools.intEingabe();
		}
		Student tmpStudent = new Student(vorname, nachname, matrikelnr);
		kursListe.add(tmpStudent);
		System.out.println("Student erfolgreich hinzugefügt.");
	}
	
	public void notendurchschnittBerechnen() {
		if(kursListe.isEmpty() == false) {
			double notenKummuliert = 0;
			for(int i = 0; i < kursListe.size(); i++) {
				notenKummuliert = notenKummuliert + kursListe.get(i).getNote();
			}
			System.out.println("Der Notendurchschnitt in diesem Kurs beträgt: " + notenKummuliert/kursListe.size());
		}else {
			System.out.println("Es sind noch keine Studenten in Ihrem Kurs, bitte fügen Sie zuerst welche hinzu.");
		}
	}
	
	public void noteAnpassen() {
		System.out.println("Nachnamen des Studenten eingeben");
		String nachname = Tools.stringEingabe();
		Student tmpStudent = null;
		for(int i = 0; i < kursListe.size(); i++) {
			if(kursListe.get(i).getNachname().equals(nachname)) {
				tmpStudent = kursListe.get(i);
			}
		}
		if(tmpStudent != null) {
			System.out.println("Aktuell hat der Student " + tmpStudent.getVorname() + tmpStudent.getNachname() + " die Note: " + tmpStudent.getNote());
			System.out.println("Soll diese Verändert werden? [J/N]");
			switch(Tools.stringEingabe()) {
			case "j":  
				System.out.println("Bitte geben Sie eine Note ein:");
				double tmpNote = Tools.doubleEingabe();
				if(tmpNote < 0.0 || tmpNote > 10.0) {
					System.out.println("Falsche eingabe, der Wert muss zwischen 0.0 und 10.0 liegen");
				}else {
					tmpStudent.setNote(tmpNote);
					System.out.println("Note wurde vergeben");
					}
			case "n":
				default:
			}
		}else {
			System.out.println("Dieser Student konnte nicht gefunden werden.");
		}
		
	}
	
	public void getKursliste() throws FileNotFoundException {
		PrintStream drucker = new PrintStream("/Users/finn/Developer/Lesbar.txt");
		for(int i = 0; i < kursListe.size(); i++) {
			System.out.println(kursListe.get(i).getVorname() + " £" + kursListe.get(i).getNachname() + " " + kursListe.get(i).getNote());
			drucker.println(kursListe.get(i).getMatrikelnummer() + " " + kursListe.get(i).getVorname() + " " + kursListe.get(i).getNachname() + " " + kursListe.get(i).getNote());
		}
	}
		
	
	public void readFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("/Users/finn/Developer/Lesbar.txt"));
		String zeile = reader.readLine();
		while(zeile != null) {
			String array[] = zeile.split(" ");
			Student tmpStudent = new Student(array[0], array[1], 1);
			tmpStudent.setNote(Double.parseDouble(array[2]));
			kursListe.add(tmpStudent);
			zeile = reader.readLine();
		}
		System.out.println("Datei wurde erfolgreich eingelesen.");
		reader.close();
	}

}
