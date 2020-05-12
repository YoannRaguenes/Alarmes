import java.time.LocalDateTime;

public class RadiationEvent extends AlarmeEvent{
	private int niveau;

	public RadiationEvent(Object source, LocalDateTime localDateTime, int importance, int niveau, String localisation) {
		super(source, localisation,importance, localDateTime);
		if(niveau<=100 & niveau>=0) {
			this.niveau = niveau;
			
		}
		else {
			System.out.println("erreur mauvais niveau de radiation");
		}
	}

	@Override
	public String toString() {
		return "Capteur radiation \n� la date "+ this.date + " \nlocalis�e "+this.localisation +" \net est jug� d'importance "+this.importance +"\nde niveau "+this.niveau;
		
	}
	

}
