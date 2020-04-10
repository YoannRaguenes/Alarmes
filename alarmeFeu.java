import java.util.Date;

public class alarmeFeu implements listenerFeu {
	


	@Override
	public String incendiePresent(Date dateAppa, String loca, int importance) {
		return "Incendie situé à "+loca+" le "+dateAppa+" importance: "+importance+ "/3";
		
	}

}
