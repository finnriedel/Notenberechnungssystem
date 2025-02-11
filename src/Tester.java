
public class Tester {

	public static void main(String[] args) {
		Dozent yetim = new Dozent("Fahri", "Yetim");
		
		Student riedel = new Student("Finn", "Riedel", 782557);
		Student barsch = new Student("Felix", "Barsch", 781593);
		Student hillebrand = new Student("Hendrik", "Hillebrand", 791002);
		Student baldus = new Student("Benedict", "Baldus", 767988);
		
		Modul java = new Modul("Konzepte der Programmierung", yetim);
		yetim.modulZuweisen(java);
		
		java.teilnehmerHinzufuegen(riedel);
		java.teilnehmerHinzufuegen(barsch);
		java.teilnehmerHinzufuegen(hillebrand);
		java.teilnehmerHinzufuegen(baldus);
		
		java.setNote(riedel, 1.0);
		java.getNote(riedel);
		
		java.getNotenListe();
	}

}
