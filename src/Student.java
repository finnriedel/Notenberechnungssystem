
public class Student extends Mensch{
	private int matrikelnummer;
	
	public Student(String vorname, String nachname, int matrikelnummer) {
		super(vorname, nachname);
		this.matrikelnummer = matrikelnummer;
	}
	
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
}
