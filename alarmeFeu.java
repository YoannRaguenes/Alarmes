import java.util.Date;

public class alarmeFeu implements listenerFeu {
	


	@Override
	public String incendiePresent(Date dateAppa, String loca, int importance) {
		return "Incendie situ� � "+loca+" le "+dateAppa+" importance: "+importance+ "/3";
		
	}

}
