import java.util.ArrayList;
import java.util.List;

public class Dozent extends Mensch{
	private List<Modul> module;
	
	public Dozent(String vorname, String nachname) {
		super(vorname, nachname);
		module = new ArrayList<>();
	}

	public void modulZuweisen(Modul modul) {
		module.add(modul);
	}
	
	public List<Modul> getModule(){
		return module;
	}
	
}
