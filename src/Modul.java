import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Modul {
	private String titel;
	private Dozent dozent;
	private int anzahlTeilnehmer;
	private List<Student> teilnehmer;
	private Map<Student, Double> notenListe;
	
	public Modul(String titel, Dozent dozent) {
		this.titel = titel;
		this.dozent = dozent;
		teilnehmer = new ArrayList<>();
		notenListe = new HashMap<>();
		
	}
	
	public String getTitel() {
		return titel;
	}
	
	public String getDozent() {
		return dozent.getVorname() + " " + dozent.getNachname();
	}
	
	public void teilnehmerHinzufuegen(Student student) {
		teilnehmer.add(student);
		anzahlTeilnehmer++;
	}
	
	public int getAnzahlTeilnehmer() {
		return anzahlTeilnehmer;
	}
	
	public void getTeilnehmer(){
		for(int i = 0; i < teilnehmer.size(); i++) {
			System.out.println(teilnehmer.get(i).getVorname() + " " + teilnehmer.get(i).getNachname());
		}
	}
	
	public void setNote(Student student, double note) {
		if(teilnehmer.contains(student)){
			notenListe.put(student, note);
		}
	}
	
	public void getNote(Student student) {
		System.out.println(student.getVorname() + " " + student.getNachname() + " " + notenListe.get(student));
	}
	
	public Map<Student, Double> getNotenListe(){
		return notenListe;
	}
}

