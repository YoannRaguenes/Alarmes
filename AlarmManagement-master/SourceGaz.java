

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SourceGaz {
	private ArrayList<GazListener> listenerList = new ArrayList<GazListener>() ;
	
	public void addGazListener(GazListener listener) {
		if (listener == null) {
			return;
		}
		listenerList.add(listener);
	}
	

	public void removeGazListener(GazListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	public GazEvent generateGazEvent(LocalDateTime localDateTime, int importance, String type, String localisation) {
		GazEvent event = new GazEvent(this,localDateTime,importance,type, localisation);
		for(GazListener ie : listenerList) {
			ie.attentionGaz(event);
			
		}
		
		return event;
	}
	
	

}
