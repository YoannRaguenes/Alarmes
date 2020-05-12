import java.time.LocalDateTime;
import java.util.EventObject;

public class GazEvent extends AlarmeEvent{
	private String type;
	
	public GazEvent(Object source, LocalDateTime localDateTime, int importance,String localisation, String type) {
		super(source, localisation,importance,localDateTime);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		
		return "Capteur : "+this.type+" \n� la date "+ this.date + " \nlocalis�e "+this.localisation +" \net est jug� d'importance "+this.importance;
	}



	


}
