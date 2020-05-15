

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SourceRadiation {
	private ArrayList<RadiationListener> listenerList = new ArrayList<RadiationListener>(); 
	
	public void addRadiationListener(RadiationListener listener) {
		if (listener == null) {
			return;
		}
		listenerList.add(listener);
	}
	

	 public void removeRadiationListener(RadiationListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	public RadiationEvent generateRadiationEvent( LocalDateTime localDateTime, int importance, int niveau, String localisation){
		RadiationEvent event = new RadiationEvent(this,localDateTime,importance, niveau, localisation, false);
		for(RadiationListener ie : listenerList) {
			ie.attentionRadiation(event);
		}
		return event;
		
	}
 


}

