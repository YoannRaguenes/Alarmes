

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SourceIncendie{
	private ArrayList<IncendieListener> listenerList = new ArrayList<IncendieListener>(); 
	
		public void addIncendieListener(IncendieListener listener) {
			if (listener == null) {
				return;
			}
			listenerList.add(listener);
		}
		
	
	 public void removeIncendieListener(IncendieListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	public IncendieEvent generateIncendieEvent(String localisation, int importance,LocalDateTime date) {
		IncendieEvent event = new IncendieEvent(this, localisation,importance,date, false);
		for(IncendieListener ie : listenerList) {
			ie.attentionFume(event);
		}
		return event;
		
	}
	 


}
