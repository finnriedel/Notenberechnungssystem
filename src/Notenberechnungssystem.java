import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Notenberechnungssystem {
	private List<Student> kursListe;
	
	
	/*
	 * In der Main-Methode wird eine neues Objekt erzeugt, an dem die Methoden aufgerufen werden.
	 * Das hat den Grund, dass die Main-Methode static ist und ansonsten nicht mit non-static Methoden arbeiten kann.
	 */
	public static void main(String[] args) throws IOException {
		Notenberechnungssystem nbs = new Notenberechnungssystem();
		nbs.dialog();
	}
	
	public Notenberechnungssystem() {
		kursListe = new ArrayList<>();
		
	}
	
	/*
	 * Die Methode Dialog steuert die weiteren Methoden dieser Klasse.
	 * Die Optionen werden auf der Konsole ausgegeben und können anhand der Nummer gestartet werden.
	 * Dafür ließt ein InputReader der Klasse Tools die Konsoleneingabe aus und überprüft den Wert.
	 * Durch die while(true) Methode, wird das Menü nach jedem Methodenaufruf automatisch wieder gestartet, solange bis man per Eingabe 99
	 * das Programm beendet.
	 * Switch-Case interpretiert den Int-Wert und startet die entsprechende Methode, der default-Wert deckt alle 
	 * anderen Fälle ab und weist einen auf den Fehler hin.
	 * 
	 */
	public void dialog() throws IOException {
		while(true) {
			System.out.println("");
			System.out.println("-------------------MENÜ-------------------");
			System.out.println("| Was möchtest du tun?                   |");
			System.out.println("| 1 - Student zu meinem Kurs hinzufügen  |");
			System.out.println("| 2 - Notendurchschnitt anzeigen         |");
			System.out.println("| 3 - Note verändern/eintragen           |");
			System.out.println("| 4 - Notenübersicht drucken             |");
			System.out.println("| 5 - Kursliste importieren (Datei)      |");
			System.out.println("| 99 - Programm schließen                |");
			System.out.println("------------------------------------------");
			System.out.println("");
	
			
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
				default: System.out.println("Diese Option ist nicht vorhanden.");
			}
		}
	}
	
	public void studentHinzufuegen() {
		System.out.println("Vornamen eingeben:");
		String vorname = Tools.stringEingabe();
		System.out.println("Nachnamen eingeben:");
		String nachname = Tools.stringEingabe();
		// ^^ hier wird die Eingabe in einer lokalen Variable zwischengespeichert
		System.out.println("Matrikelnummer eingeben:");
		int matrikelnr = Tools.intEingabe();
		while(matrikelnr == 0) {
			System.out.println("Bitte gib eine ganze Zahl ein, die ungleich 0 ist.");
			matrikelnr = Tools.intEingabe();
		}
		// ^^ Die while-Schleife ist notwendig, da die Tools-Klasse bei einer fehlerhaften Eingabe automatisch den Rückgabewert auf 0 setzt.
		Student tmpStudent = new Student(vorname, nachname, matrikelnr);
		kursListe.add(tmpStudent);
		System.out.println("Student erfolgreich hinzugefügt.");
		// ^^ Student wird erstellt, der Liste hinzugefügt und der Nutzer wird darüber informiert.
	}
	
	public void notendurchschnittBerechnen() {
		if(kursListe.isEmpty() == false) {
			double notenKummuliert = 0;
			for(int i = 0; i < kursListe.size(); i++) {
				notenKummuliert = notenKummuliert + kursListe.get(i).getNote();
			}
			System.out.println("Der Notendurchschnitt in diesem Kurs beträgt: " + notenKummuliert/kursListe.size());
			// ^^ Berechnung nur wenn Schülerliste gefüllt ist. 
			// For-Schleife durchläuft alle Studentenobjekte der Liste und führt die Methode getNote() an jedem Objekt aus
			// Dies wird in einer lokalen Variable zwischengespeichert und addiert mit jeder neuen Note und am Ende durch die Teilnehmeranzahl dividiert.
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
			//Studentenliste wird durchlaufen und jeder Nachname wird mit dem gesuchten Nachnamen abgeglichen.
		}
		if(tmpStudent != null) {
			System.out.println("Aktuell hat der Student " + tmpStudent.getVorname() + " " + tmpStudent.getNachname() + " die Note: " + tmpStudent.getNote());
			// Wenn ein Student gefunden wurde, dann wird die aktuell Note ausgegeben
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
					//^^ Nur bei eingabe einer Validen Note wird der Wert gespeichert.
				case "n":
				default: return;
			}
		}else {
			System.out.println("Dieser Student konnte nicht gefunden werden.");
		}
		
	}
	
	public void getKursliste() throws FileNotFoundException {
		System.out.println("Bitte geben Sie den vollständigen Dateipfad und die Datei an: (zum Beispiel: /Users/finn/Developer/Lesbar.txt)");
		String dateiPfad = Tools.stringEingabe();
		PrintStream drucker = new PrintStream(dateiPfad);
		for(int i = 0; i < kursListe.size(); i++) {
			System.out.println(kursListe.get(i).getVorname() + " " + kursListe.get(i).getNachname() + " " + kursListe.get(i).getNote());
			drucker.println(kursListe.get(i).getMatrikelnummer() + " " + kursListe.get(i).getVorname() + " " + kursListe.get(i).getNachname() + " " + kursListe.get(i).getNote());
		}
	}
		
	
	public void readFile() throws IOException {
		System.out.println("Bitte geben Sie den vollständigen Dateipfad und die Datei an: (zum Beispiel: /Users/finn/Developer/Lesbar.txt)");
		String dateiPfad = Tools.stringEingabe();
		BufferedReader reader = new BufferedReader(new FileReader(dateiPfad));
		String zeile = reader.readLine();
		while(zeile != null) {
			String array[] = zeile.split(" ");
			Student tmpStudent = new Student(array[1], array[2], Integer.parseInt(array[0]));
			tmpStudent.setNote(Double.parseDouble(array[3]));
			kursListe.add(tmpStudent);
			zeile = reader.readLine();
		}
		System.out.println("Datei wurde erfolgreich eingelesen.");
		reader.close();
	}

}
