

import java.time.LocalDateTime;
import java.util.EventObject;

public class IncendieEvent extends AlarmeEvent{

	

	public IncendieEvent(Object source, String localisation, int importance,LocalDateTime date, boolean traite){
		super(source,  localisation, importance, date, traite);
		
	}



	@Override
	public String toString() {
		return "Capteur incendie \nà la date "+ this.date + " \nlocalisée "+this.localisation +" \net est jugé d'importance "+this.importance;
		// TODO Auto-generated method stub
		
	}


	public String toInfo() {
		return "Detection d'un INCENDIE";
	}

	
	public boolean toTraite() {
		return this.traite;
	}
	

}
