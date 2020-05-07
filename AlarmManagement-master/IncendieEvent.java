

import java.time.LocalDateTime;
import java.util.EventObject;

public class IncendieEvent extends AlarmeEvent{
	private boolean fume;
	

	public IncendieEvent(Object source, String localisation, int importance,LocalDateTime date){
		super(source,  localisation, importance, date );
		
	}


	public boolean isFume() {
		return fume;
	}


	public void setFume(boolean fume) {
		this.fume = fume;
	}


	@Override
	public String toString() {
		return "Capteur incendie \n� la date "+ this.date + " \nlocalis�e "+this.localisation +" \net est jug� d'importance "+this.importance;
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
