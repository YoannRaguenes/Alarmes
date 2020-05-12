
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Moniteur implements IncendieListener,GazListener,RadiationListener {
	private String type;

	public Moniteur(String type) {
		super();
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}


	@Override
	public void attentionFume(IncendieEvent event) {
			System.out.println("Alarme FEU : " + event.toString());
			

	}
	public void attentionGaz(GazEvent event) {
		System.out.println("Alarme GAZ : " + event.toString());	
	}


	@Override
	public void attentionRadiation(RadiationEvent event) {
		System.out.println("Alarme RADIATION : " + event.toString());
		
	}
}

