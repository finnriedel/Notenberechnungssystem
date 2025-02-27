import java.io.*;

public class Tools{

  public static int intEingabe(){
    String eingebs = "";
    InputStreamReader daten = new InputStreamReader(System.in);
    BufferedReader eingeb = new BufferedReader(daten);
    try{
      eingebs = eingeb.readLine();

    }catch (Exception e){
    	System.out.println("Falsche Eingabe. Bitte versuche es erneut:");
    }

    int eingebi;
    try {
    	eingebi = Integer.valueOf(eingebs).intValue();
    }catch (Exception e){
    	System.out.println("Eingabe Inkorrekt, die Eingabe muss eine ganze Zahl sein. Bitte versuche es erneut:");
    	eingebi = 0;
    }

    return eingebi;
  }
  
  
  public static String stringEingabe(){
    String eingebs = "";
    InputStreamReader daten = new InputStreamReader(System.in);
    BufferedReader eingeb = new BufferedReader(daten);
    try{
      eingebs = eingeb.readLine();

    }catch (Exception e){
    	System.out.println("Falsche Eingabe. Bitte versuche es erneut:");
    }

    return eingebs;
  }
  
  
  public static double doubleEingabe(){
	  String eingebs = "";
	  InputStreamReader daten = new InputStreamReader(System.in);
	  BufferedReader eingeb = new BufferedReader(daten);
	  try{
		  eingebs = eingeb.readLine();

	  }catch (Exception e){
		  System.out.println("Falsche Eingabe. Bitte versuche es erneut:");
	  }
	  
	  double eingebi=0;   
	  try {
		  eingebi = Double.parseDouble(eingebs);
	  }catch (Exception e){
		  System.out.println("Eingabe Inkorrekt, bitte gib eine Kommazahl (mit Punkt, nicht Komma) an. Bitte versuche es erneut:");
	  }
	  return eingebi;
  }
  

	public static boolean booleanEingabe(){

		System.out.print("Bitte 1=true oder 0=false eingeben: ");
		int eingabe = intEingabe();
		if(eingabe == 0){
			return false;
		}else {
			return true;
		}
	}


}
