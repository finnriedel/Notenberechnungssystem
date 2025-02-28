
public class Student extends Mensch{ //Klasse erbt alle Attribute und Methoden von der Klasse Mensch
	private int matrikelnummer;
	private double note;
	
	public Student(String vorname, String nachname, int matrikelnummer) {
		super(vorname, nachname);
		this.matrikelnummer = matrikelnummer;
	}
	
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	
	public void setNote(double note) {
		this.note = note;
	}
	
	public double getNote() {
		return note;
	}
}