
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
		if(event.isFume()) {
			System.out.println(" il a un feu ");
			
		}
		else {
			System.out.println("R.A.S");
		}
	}
	public void attentionGaz(GazEvent event) {
		if(event.getImportance()>=1) {
			System.out.println("Attention niv gaz ");
		}
		else {
			System.out.println("R.A.S");
		}
	}


	@Override
	public void attentionRadiation(RadiationEvent event) {
		// TODO Auto-generated method stub
		if(event.getImportance()>=1) {
			System.out.println("Attention niv radiation ");
		}
		else {
			System.out.println("R.A.S");
		}
	}
}
